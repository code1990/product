package com.jfreecms;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/*
*
* @author: s1332177151@gmail.com 
* @Date: 2019/1/10 0010 23:56
*/
public class InitServlet extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BlogApplication.class);
    }
}
