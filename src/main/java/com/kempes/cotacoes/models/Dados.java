package com.kempes.cotacoes.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_dados")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dados implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "dados_seq", sequenceName = "dados_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dados_seq")
	public long id;
	
	public BigDecimal cotacaoCompra;
	
	public BigDecimal cotacaoVenda;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public String dataHoraCotacao;

	public BigDecimal getCotacaoCompra() {
		return cotacaoCompra;
	}

	public void setCotacaoCompra(BigDecimal cotacaoCompra) {
		this.cotacaoCompra = cotacaoCompra;
	}

	public BigDecimal getCotacaoVenda() {
		return cotacaoVenda;
	}

	public void setCotacaoVenda(BigDecimal cotacaoVenda) {
		this.cotacaoVenda = cotacaoVenda;
	}

	public String getDataHoraCotacao() {
		return dataHoraCotacao;
	}

	public void setDataHoraCotacao(String dataHoraCotacao) {
		this.dataHoraCotacao = dataHoraCotacao;
	}
	
	@Override
	  public String toString() {
	    return "{\"@odata.context\":\"https://was-p.bcnet.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata$metadata#_CotacaoDolarDia\",\"value\":[{\"" +
	        "cotacaoCompra=" + cotacaoCompra +
	        ", cotacaoVenda='" + cotacaoVenda + '\'' +
	        ", dataHoraCotacao='" + dataHoraCotacao + '\'' +
	        '}';
	  }
	
	

}
