package com.kempes.cotacoes.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kempes.cotacoes.models.Cotacao;

public interface CotacaoRepository extends CrudRepository<Cotacao, Long> {
	
	@Query(value = "Select count(*) from tb_cotacao where data_cotacao like ?1", nativeQuery = true)
	long findTotalByData(String data_cotacao);

}
