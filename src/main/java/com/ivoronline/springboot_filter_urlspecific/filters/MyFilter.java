package com.ivoronline.springboot_filter_urlspecific.filters;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

//@Order(0)  //Don't use this when using FilterRegistrationBean
@Component
public class MyFilter extends OncePerRequestFilter {

  //===================================================================
  // DO FILTER
  //===================================================================
  @Override
  public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
    throws IOException, ServletException {
    System.out.println("FILTER    : Hello from Filter");
    chain.doFilter(request, response);
  }

  //===================================================================
  // FILTER REGISTRATION BEAN
  //===================================================================
  @Bean
  public FilterRegistrationBean<MyFilter> loggingFilter(){

    //CREATE REGISTRATION BEAN
    FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
                                     registrationBean.setFilter(new MyFilter());
                                     registrationBean.addUrlPatterns("/Filtered");
                                     registrationBean.setOrder(0);  //Use this to order Filters


    //RETURN REGISTRATION BEAN
    return registrationBean;

  }

}



