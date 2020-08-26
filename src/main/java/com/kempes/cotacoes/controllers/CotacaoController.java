package com.kempes.cotacoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kempes.cotacoes.models.Cotacao;
import com.kempes.cotacoes.repository.CotacaoRepository;

@RestController
@RequestMapping(value="/cotacao")
public class CotacaoController {
	
	@Autowired
	CotacaoRepository cr;
	
	@GetMapping("/")
	public String index() {
		return "Hello World";
	}
	
	@GetMapping("/listatodos")
	public Iterable<Cotacao> listatodos(){
		return cr.findAll();
	}

}
