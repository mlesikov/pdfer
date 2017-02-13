package com.mlesikov.pdfer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
public class EncodingFilter implements Filter {

  public void init(FilterConfig filterConfig) throws ServletException {

  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    response.setCharacterEncoding("UTF-8");
    chain.doFilter(request, response);
  }

  public void destroy() {

  }
}
