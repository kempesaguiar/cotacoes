package com.kempes.cotacoes.models;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tb_cotacao")
public class Cotacao {
	
	@Id
	@SequenceGenerator(name = "cotacao_seq", sequenceName = "cotacao_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cotacao_seq")
	private long id;
	
	@Column(nullable = false, length = 20)
	private Timestamp timestamp;
	
	@Column(nullable = false, length = 10)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data_cotacao;
	
	@Column(nullable = false)
	private BigDecimal cotacao_compra;
	
	@Column(nullable = false)
	private BigDecimal cotacao_venda;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String data_hora;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Date getData_cotacao() {
		return data_cotacao;
	}

	public void setData_cotacao(Date data_cotacao) {
		this.data_cotacao = data_cotacao;
	}

	public BigDecimal getCotacao_compra() {
		return cotacao_compra;
	}

	public void setCotacao_compra(BigDecimal cotacao_compra) {
		this.cotacao_compra = cotacao_compra;
	}

	public BigDecimal getCotacao_venda() {
		return cotacao_venda;
	}

	public void setCotacao_venda(BigDecimal cotacao_venda) {
		this.cotacao_venda = cotacao_venda;
	}

	public String getData_hora() {
		return data_hora;
	}

	public void setData_hora(String data_hora) {
		this.data_hora = data_hora;
	}
	
	
	
	
	
	
	
	

}
