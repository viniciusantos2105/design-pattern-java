package com.desing.pattern.padraoprojeto;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "Swagger OpenApi", version = "1", description = "API desenvolvida para utilizar padrões de projeto"))
@SpringBootApplication
public class PadraoProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadraoProjetoApplication.class, args);
	}

}
