package com.tthz.ad.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PreRequestFilter extends ZuulFilter {
    /*
     * 定义filter类型，zuul的四种Filter类型，PreFilter,RouterFilter,ErrorFilter,PostFilter
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
    /*
     * 定义Filter执行顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /*
     * 定义是否执行本过滤器的过滤逻辑，在满足某些条件时时执行
     * true表示执行
     * false表示不执行
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /*
     * 定义filter的具体执行逻辑
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        currentContext.set("start", System.currentTimeMillis());
        return null;
    }
}
