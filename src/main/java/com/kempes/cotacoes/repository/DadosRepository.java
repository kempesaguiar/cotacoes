package com.kempes.cotacoes.repository;

import org.springframework.data.repository.CrudRepository;

import com.kempes.cotacoes.models.Dados;

public interface DadosRepository extends CrudRepository<Dados, Long> {

}
