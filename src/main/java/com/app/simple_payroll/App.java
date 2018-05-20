package com.app.simple_payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class App  {
/*    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }*/

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}