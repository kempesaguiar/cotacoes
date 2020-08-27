package com.kempes.cotacoes.controllers;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Map;

import javax.xml.bind.helpers.ParseConversionEventImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.core.convert.converter.ConditionalConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.kempes.cotacoes.models.Cotacao;
import com.kempes.cotacoes.models.Dados;
import com.kempes.cotacoes.repository.CotacaoRepository;
import com.kempes.cotacoes.repository.DadosRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/cotacao")
@Api(value="API Rest Busca Cotacao")
@CrossOrigin(origins = "*")
public class CotacaoController {
	
	@Autowired
	CotacaoRepository cr;
	
	@Autowired
	DadosRepository dr;
	
	private static final Logger log = LoggerFactory.getLogger(CotacaoController.class);
	
	@GetMapping("/")
	@ApiOperation(value="Get Hello World")
	public String index() {
		return "Hello World";
	}
	
	@GetMapping("/listatodos")
	@ApiOperation(value="Retorna uma lista de todas cotações")
	public Iterable<Cotacao> listatodos(){
		return cr.findAll();
	}
	
	@GetMapping("/busca")
	@ApiOperation(value="Retorna a cotação do dólar do dia")
	public Cotacao Busca() {
		
		
		String url = "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/CotacaoDolarDia(dataCotacao=@dataCotacao)?@dataCotacao='08-25-2020'&$top=100&$format=json";
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<String> dados = rt.getForEntity(url, String.class);

		String cc = dados.getBody().substring(139, 146);
		String cd = dados.getBody().substring(162, 169);
		String hc = dados.getBody().substring(191, 208);
		
		Cotacao cotacao = new Cotacao();
		
		cotacao.setCotacao_compra(cc);
		
		cotacao.setCotacao_venda(cd);
		
		cotacao.setData_cotacao(hc);
		
		cotacao.setData_hora(hc);
		
		//cotacao.setTimestamp(hc);
		
		System.out.println(cc);
		System.out.println(cd);
		System.out.println(new BigDecimal(cd));
		System.out.println(hc);
		cr.save(cotacao);
		return cotacao;
	}

}
