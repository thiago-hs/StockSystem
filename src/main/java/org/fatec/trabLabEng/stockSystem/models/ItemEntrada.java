package org.fatec.trabLabEng.stockSystem.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ItemEntrada implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codItemEntrada;
	
	private int quantidade;
	private double valor;

	@OneToMany
	private Produto codProduto;
	
	@OneToOne
	private Entrada codEntrada;

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

	public Produto getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Produto codProduto) {
		this.codProduto = codProduto;
	}

	public Entrada getCodEntrada() {
		return codEntrada;
	}

	public void setCodEntrada(Entrada codEntrada) {
		this.codEntrada = codEntrada;
	}
	
	
}
