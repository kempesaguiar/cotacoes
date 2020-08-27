package com.kempes.cotacoes.controllers;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kempes.cotacoes.models.Cotacao;
import com.kempes.cotacoes.repository.CotacaoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/cotacao")
@Api(value="API Rest Busca Cotacao")
@CrossOrigin(origins = "*")
public class CotacaoController {
	
	@Autowired
	CotacaoRepository cr;
	
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
		
		// Quebra a String em posições específicas
		// Busca Cotacao de compra
		String cc = dados.getBody().substring(139, 146);
		// Busca cotacao de venda
		String cd = dados.getBody().substring(162, 169);
		// Busca data e hora da cotacao
		String hc = dados.getBody().substring(191, 208);
		// Pega data e hora atual
		Date tm = new Date();
		
		String timestamp = tm.toString();
		
		Cotacao cotacao = new Cotacao();
		
		cotacao.setTimestamp(timestamp);
		
		cotacao.setCotacao_compra(cc);
		
		cotacao.setCotacao_venda(cd);
		
		cotacao.setData_cotacao(hc);
		
		cotacao.setData_hora(hc);
		
		cr.save(cotacao);
		return cotacao;
	}
	
	@GetMapping("/busca/{id}")
	@ApiOperation(value="Retorna Cotação pelo ID")
	public Optional<Cotacao> buscaCotacaoPorData(@PathVariable("id") long id) {
		Optional<Cotacao> cotacao = cr.findById(id);
		return cotacao;
		
	}
	
	@PutMapping("/atualiza")
	@ApiOperation(value="Atualiza dados da cotação manualmente")
	public Cotacao atualizaCotacao(@RequestBody Cotacao cotacao) {
		return cr.save(cotacao);
	}
	
	@DeleteMapping("/deleta")
	@ApiOperation(value="Deleta cotação existente")
	public void deletaCotacao(@RequestBody Cotacao cotacao) {
		cr.delete(cotacao);
	}

}
