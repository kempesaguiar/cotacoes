package com.kempes.cotacoes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.kempes.cotacoes.controllers.CotacaoController;
import com.kempes.cotacoes.models.Dados;

@SpringBootApplication
public class CotacoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CotacoesApplication.class, args);
	}
	
	private static final Logger log = LoggerFactory.getLogger(CotacaoController.class);
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Dados quote = restTemplate.getForObject(
					"https://gturnquist-quoters.cfapps.io/api/random", Dados.class);
			log.info(quote.toString());
		};
	}
}
