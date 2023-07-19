package com.example.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@ComponentScan("com.example.dao")
@ComponentScan("com.example.service")
@ComponentScan("com.example.controller")
@ComponentScan("com.example.api")
@ImportResource({
        "classpath:spring/application-context-mvc.xml",
        "classpath:spring/application-context-data.xml",
        "classpath:spring/application-context-orm.xml"
})

@Configuration
public class SpringConfig {
}
