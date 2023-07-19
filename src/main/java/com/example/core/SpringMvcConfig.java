package com.example.core;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan("com.example.controller")
@ComponentScan("com.example.api")
@Configuration
public class SpringMvcConfig {


    @Bean
    public ViewResolver viewResolver() {
        var viewResolver = new InternalResourceViewResolver();

        viewResolver.setSuffix("");
        viewResolver.setSuffix("");

        return viewResolver;
    }
}
