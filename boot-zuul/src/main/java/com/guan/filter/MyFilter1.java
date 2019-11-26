package com.guan.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @author Mr.Guan
 * @since 2019/11/26
 * 自定义过滤器demo
 */
@Component
public class MyFilter1 extends ZuulFilter {


    /**
     * 过滤器类型4种
     * pre：前置过滤器    功能：转发之前做的事，做权限验证等
     * route：路由过滤器  功能：转发，基本不会去自定义
     * post：后置过滤器   功能：转发完成后的工作，较少自定义
     * error：错误过滤器  功能：处理请求时发生错误的调用，前3个过滤器任何环节出错都会到这，这完成后继续走剩下的post过滤器
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 通过int值来定义过滤器执行顺序，值越小越线执行，例1先执行，2后执行
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 是否开启此过滤器
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑，自定义逻辑来拦截需求，例如做权限验证
     */
    @Override
    public Object run() throws ZuulException {
        System.out.println("这是MyFilter1");
        int a = 10/0;
        return null;
    }
}
