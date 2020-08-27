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
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name="tb_cotacao")
public class Cotacao {
	
	@Id
	@SequenceGenerator(name = "cotacao_seq", sequenceName = "cotacao_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cotacao_seq")
	private long id;
	
	//@Column(nullable = false)
	//@DateTimeFormat(pattern = "yy-MM-dd HH:mm:ss")
	private String timestamp;
	
	//@Column(nullable = false, length = 10)
	//@DateTimeFormat(pattern = "yy-MM-dd HH:mm:ss")
	private String data_cotacao;
	
	@Column(nullable = false)
	private String cotacao_compra;
	
	@Column(nullable = false)
	@NumberFormat(pattern = "###,###.00000")
	private String cotacao_venda;
	
	//@DateTimeFormat(pattern = "yy-MM-dd HH:mm:ss")
	private String data_hora;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getData_cotacao() {
		return data_cotacao;
	}

	public void setData_cotacao(String data_hora) {
		this.data_cotacao = data_hora;
	}

	public String getCotacao_compra() {
		return cotacao_compra;
	}

	public void setCotacao_compra(String cotacao_compra) {
		this.cotacao_compra = cotacao_compra;
	}

	public String getCotacao_venda() {
		return cotacao_venda;
	}

	public void setCotacao_venda(String cotacao_venda) {
		this.cotacao_venda = cotacao_venda;
	}

	public String getData_hora() {
		return data_hora;
	}

	public void setData_hora(String data_hora) {
		this.data_hora = data_hora;
	}
	
	
	
	
	
	
	
	

}
