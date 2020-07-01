package org.fatec.trabLabEng.stockSystem.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.Transient;

@Entity
public class ItemEntrada implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codItemEntrada;
	
	private int quantidade;
	private double valor;

	@ManyToOne
	private Produto produto;
	
	@Transient
	private long codProduto;
	
	@ManyToOne
	private Entrada entrada;
	
	@Transient
	private long codEntrada;

	public long getCodItemEntrada() {
		return codItemEntrada;
	}

	public void setCodItemEntrada(long codItemEntrada) {
		this.codItemEntrada = codItemEntrada;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public long getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(long codProduto) {
		this.codProduto = codProduto;
	}

	public Entrada getEntrada() {
		return entrada;
	}

	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}

	public long getCodEntrada() {
		return codEntrada;
	}

	public void setCodEntrada(long codEntrada) {
		this.codEntrada = codEntrada;
	}
	
}
