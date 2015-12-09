package com.sg.members.exception;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration 
	public class ErrorResolver implements EmbeddedServletContainerCustomizer { 

	@Override 
	public void customize(ConfigurableEmbeddedServletContainer factory) { 
	factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404")); 
	factory.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500")); 
	} 

}
