package com.github.knastasov.securingweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(
      ResourceHandlerRegistry registry) {
 
        registry.addResourceHandler("/static/**")
          .addResourceLocations("/WEB-INF/view/react/build/static/");
        registry.addResourceHandler("/*.js")
          .addResourceLocations("/WEB-INF/view/react/build/");
        registry.addResourceHandler("/*.json")
          .addResourceLocations("/WEB-INF/view/react/build/");
        registry.addResourceHandler("/*.ico")
          .addResourceLocations("/WEB-INF/view/react/build/");
        registry.addResourceHandler("/index.html")
          .addResourceLocations("/WEB-INF/view/react/build/index.html");
    }
	
	
   
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/api/login").setViewName("apilogin");
		registry.addViewController("/api/products ").setViewName("products");
	}

}