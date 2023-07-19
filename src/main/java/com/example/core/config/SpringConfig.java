package com.example.core.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@ComponentScan("com.example.service")
@Import({
        SpringDataConfig.class,
        SpringMvcConfig.class,
        SpringOrmConfig.class
})

@Configuration
public class SpringConfig {
}
