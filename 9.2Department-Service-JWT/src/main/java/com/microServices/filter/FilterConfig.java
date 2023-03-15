package com.microServices.filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microServices.entity.Department;
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean jwtFilter() {
        FilterRegistrationBean filter= new FilterRegistrationBean();
        filter.setFilter(new JwtFilter());
        // provide endpoints which needs to be restricted.
        // All Endpoints would be restricted if unspecified
       String s1="/api/v1/blog/restricted";
       String s2="/api/departments/getAll";
//       String s3="/api/departments/1";
     
       filter.addUrlPatterns(s1,s2);
    return filter;
    }
}