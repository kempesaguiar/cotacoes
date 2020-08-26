package com.kempes.cotacoes.repository;

import org.springframework.data.repository.CrudRepository;

import com.kempes.cotacoes.models.Cotacao;

public interface CotacaoRepository extends CrudRepository<Cotacao, Long> {

}
