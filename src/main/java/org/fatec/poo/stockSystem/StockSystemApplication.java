package org.fatec.poo.stockSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class StockSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockSystemApplication.class, args);
	}
	
}
