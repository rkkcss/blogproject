package com.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConf implements WebMvcConfigurer{
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/settings").setViewName("settings");
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/login").setViewName("login");
	}
}
