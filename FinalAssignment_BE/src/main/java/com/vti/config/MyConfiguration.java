package com.vti.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfiguration {
    @Bean
    public ModelMapper initModelMapper(){
        return new ModelMapper();
    }

//    @Bean
//    public WebMvcConfigurer corsConig() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry){
//                registry.addMapping(("/**")).allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
//            }
//        };
//    }
}
