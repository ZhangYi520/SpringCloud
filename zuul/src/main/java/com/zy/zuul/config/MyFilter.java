package com.zy.zuul.config;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.zy.zuul.base.utils.ReturnResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

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
        Optional<String> optional =paths.stream().filter(t->matcher.match(t,uri)).findFirst();
        return !optional.isPresent();
    }

    public static void main(String[] args) {
        PathMatcher matcher = new AntPathMatcher();
        System.out.println(matcher.match("/login/**", "/xxx/login"));

    }
    /**
     * 过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     *
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
        Object accessToken = request.getHeader("accessToken");
//        accessToken=null;
        if (accessToken == null || "".equals(accessToken) || "null".equals(accessToken)) {
            log.warn("token is empty");
            try {
//            HttpServletResponse response = ctx.getResponse();
//            response.reset();
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(200);
            ctx.getResponse().setHeader("Content-type", "text/html;charset=UTF-8");
//            response.getWriter().write(JSON.toJSONString(ReturnResult.build(401, "未授权")));
          ctx.getResponse().getWriter().write(JSON.toJSONString(ReturnResult.build(401, "未授权")));
//                ctx.getResponse().getWriter().write("未授权");

            } catch (Exception e) {
            }
            return null;
//            return ReturnResult.build(401, "未授权");
        }else{
            log.info("token:"+accessToken);
            return null;
        }

    }
}
