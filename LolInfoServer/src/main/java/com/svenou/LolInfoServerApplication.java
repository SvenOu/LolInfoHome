package com.svenou;

import com.svenou.myapp.ServerProfileLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
//@Configuration
@EnableAutoConfiguration
@ComponentScan( basePackages = {"com.svenou.myapp.configs"})
public class LolInfoServerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LolInfoServerApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(LolInfoServerApplication.class);
	}
}
