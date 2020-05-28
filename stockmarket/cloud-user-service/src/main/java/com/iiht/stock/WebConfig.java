package com.iiht.stock;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public abstract class WebConfig implements WebMvcConfigurer {

	@Resource
	private CorsInterceptor corsInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(corsInterceptor).addPathPatterns("/**");
	}
}