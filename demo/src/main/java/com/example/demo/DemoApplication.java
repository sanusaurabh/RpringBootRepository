package com.example.demo;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
//	@Bean
//	EmbeddedServletContainerCustomizer containerCustomizer() throws Exception {
//	    return (ConfigurableEmbeddedServletContainer container) -> {
//	        if (container instanceof TomcatEmbeddedServletContainerFactory) {
//	            TomcatEmbeddedServletContainerFactory tomcat = (TomcatEmbeddedServletContainerFactory) container;
//	            tomcat.addConnectorCustomizers(
//	                (connector) -> {
//	                    connector.setMaxPostSize(10000000); // 10 MB
//	                }
//	            );
//	        }
//	    };
//	}
//	
	
	@Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("124MB");
        factory.setMaxRequestSize("124MB");
        return factory.createMultipartConfig();
    }
}
