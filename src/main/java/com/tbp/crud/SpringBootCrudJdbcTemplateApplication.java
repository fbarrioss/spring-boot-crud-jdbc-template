package com.tbp.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCrudJdbcTemplateApplication extends SpringBootServletInitializer implements WebApplicationInitializer{

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootCrudJdbcTemplateApplication.class);
    }
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudJdbcTemplateApplication.class, args);
	}

}
