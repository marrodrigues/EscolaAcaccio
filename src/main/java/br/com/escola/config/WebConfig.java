package br.com.escola.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	private final String CORS_ORIGINS = "*";

	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**").allowedOrigins(CORS_ORIGINS)
		.allowedMethods("PUT", "POST", "GET", "OPTIONS", "DELETE")
		.exposedHeaders("Authorization", "Content-Type");
    }

}
