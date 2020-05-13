package com.zy.zuul.config;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.zy.zuul.base.utils.ReturnResult;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Zuul过滤器，必须继承ZuulFilter父类。
 * 当前类型的对象必须交由Spring容器管理。使用@Component注解描述。
 * 继承父类后，必须实现父类中定义的4个抽象方法。
 * shouldFilter、 run、 filterType、 filterOrder
 */
@Component
public class MyFilter extends ZuulFilter {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 放行地址
     */
    private List<String> paths;

    public MyFilter() {
        super();
        paths = new ArrayList<>();
        paths.add("/spring-cloud-common-login/sso/login/into");
        paths.add("/spring-cloud-common-thirdparty/**");

    }

    /**
     * 返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     *
     * @return
     */
    @Override
    public String filterType() {
//        System.err.println("1");
        return "pre";//路由前调用
    }

    /**
     * 过滤的顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
//        System.err.println("2");
        return 0;
    }

    /**
     * 这里可以写逻辑判断，是否要过滤，本文true,永远过滤
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String uri = request.getRequestURI().toString();
        PathMatcher matcher = new AntPathMatcher();
        /**匹配当前路径是否在放行地址中，
         * 如果在，则最后optional有数据，optional.isPresent()==true,就不用拦截*/
        Optional<String> optional = paths.stream().filter(t -> matcher.match(t, uri)).findFirst();
        return !optional.isPresent();
    }

    public static void main(String[] args) {
        PathMatcher matcher = new AntPathMatcher();
        System.out.println(matcher.match("/login/**", "/xxx/login"));

    }

    /**
     * 过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        log.info("——————————————开始拦截——————————————");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURI()));
        String accessToken = request.getHeader("accessToken");
//        accessToken=null;
        if (accessToken == null || "".equals(accessToken) || "null".equals(accessToken)) {
//          if (StringUtils.isBlank(accessToken)) {
            log.warn("token is empty");
            try {
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(200);
                ctx.getResponse().setHeader("Content-type", "text/html;charset=UTF-8");
                ctx.getResponse().getWriter().write(JSON.toJSONString(ReturnResult.build(401, "未授权")));
                return null;
            } catch (Exception e) {
            }
            return null;
        }

//        Integer userId = (Integer)redisTemplate.opsForValue().get(token);
//        if(userId!=null){
//            redisTemplate.expire(token, 60 * 60 * 2, TimeUnit.SECONDS);
//            setCookie(response, token);
//            return true;
//        }else{
//            redisTemplate.delete(token);
//            response.setHeader("Content-type", "text/html;charset=UTF-8");
//            response.getWriter().write(JsonUtils.marshalToString(ReturnResult.build(401, "登录信息已过期")));
//            return false;
//        }

        return null;
    }


    /**
     * 写入客服端cookie
     * @param response
     * @param token
     */
    private void setCookie(HttpServletResponse response, String token){
        // 生成cookie
        Cookie cookie = new Cookie("USER_TOKEN", token);
        cookie.setPath("/");
        //(24*60*60); 一天
        cookie.setMaxAge(60 * 60 * 2);
        response.addCookie(cookie);
    }
}
