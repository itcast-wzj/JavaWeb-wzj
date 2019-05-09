package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName="FirstFilter",urlPatterns={"/*"},
initParams={@WebInitParam(name="encoding",value="UTF-8"),
		@WebInitParam(name="contentType",value="text/html;charset=UTF-8")})
public class FirstFilter implements Filter {

	private String encoding = "";
	private String contentType = "";
	
    /**
     * Default constructor. 
     */
    public FirstFilter() {
        // TODO Auto-generated constructor stub
    	System.out.println("FirstFilter()");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy()");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//设置请求编码为utf-8
		request.setCharacterEncoding(encoding);
		
		//设置响应编码为utf-8
		response.setContentType(contentType);
		
		//将HTTP请求放行
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		encoding = fConfig.getInitParameter("encoding");
		contentType = fConfig.getInitParameter("contentType");
		
		System.out.println("init()");
		
	}

}
