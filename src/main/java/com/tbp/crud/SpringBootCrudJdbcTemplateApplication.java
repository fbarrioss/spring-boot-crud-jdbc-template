package com.tbp.crud;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class SpringBootCrudJdbcTemplateApplication extends SpringBootServletInitializer implements WebApplicationInitializer{

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootCrudJdbcTemplateApplication.class).bannerMode(Banner.Mode.OFF);
    }
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudJdbcTemplateApplication.class, args);
		
	}

}
