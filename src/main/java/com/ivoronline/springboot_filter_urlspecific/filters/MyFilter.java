package com.ivoronline.springboot_filter_urlspecific.filters;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

//@Order(1)  //Ignored when using FilterRegistrationBean
@Component
public class MyFilter extends OncePerRequestFilter {

  //@Autowired MyService myservice; //@Autowired only works if you inject Filter into Constructor

  //===================================================================
  // DO FILTER
  //===================================================================
  @Override
  public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
    throws IOException, ServletException {
    System.out.println("FILTER1");
    chain.doFilter(request, response);
  }

  //===================================================================
  // FILTER REGISTRATION BEAN
  //===================================================================
  @Bean
  public FilterRegistrationBean<MyFilter> myFilter1Bean(MyFilter myFilter) { //Inject Filter into Constructor

    //CREATE REGISTRATION BEAN
    FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
                                     registrationBean.setFilter(myFilter);
                                     registrationBean.addUrlPatterns("/Filtered");
                                     registrationBean.setOrder(1);              //Use this to order Filters


    //RETURN REGISTRATION BEAN
    return registrationBean;

  }

}



