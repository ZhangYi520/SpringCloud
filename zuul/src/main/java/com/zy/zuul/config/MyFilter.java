package com.zy.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter {
    private Logger log = LoggerFactory.getLogger(this.getClass());

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
//        System.err.println("3");
        return true;
    }

    /**
     * 过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        System.err.println("4");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getHeader("accessToken");
        if (accessToken == null || "".equals(accessToken)) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {
            }
            return null;
        }else{
            log.info("token:"+accessToken);
            return null;
        }

    }
}
