package com.edi.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * Created by Edison Xu on 2016/12/24.
 */
public class AuthenticationFilter extends ZuulFilter{

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        /*return !RequestContext.getCurrentContext().getZuulResponseHeaders().isEmpty() ||
                RequestContext.getCurrentContext().getResponseDataStream() != null ||
                RequestContext.getCurrentContext().responseBody != null*/
        return false;
    }

    @Override
    public Object run() {
        return null;
    }
}
