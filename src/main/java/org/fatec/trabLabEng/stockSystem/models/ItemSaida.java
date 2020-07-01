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
public class ItemSaida implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codItemSaida;
	
	private int quantidade;
	private double valor;
	
	@ManyToOne
	private Produto produto;
	
	@Transient
	private long codProduto;
	
	@ManyToOne
	private Saida saida;
	
	@Transient
	private long codSaida;

	public long getCodItemSaida() {
		return codItemSaida;
	}

	public void setCodItemSaida(long codItemSaida) {
		this.codItemSaida = codItemSaida;
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

	public Saida getSaida() {
		return saida;
	}

	public void setSaida(Saida saida) {
		this.saida = saida;
	}

	public void setCodProduto(long codProduto) {
		this.codProduto = codProduto;
	}

	public void setCodSaida(long codSaida) {
		this.codSaida = codSaida;
	}

	public long getCodProduto() {
		return codProduto;
	}

	public long getCodSaida() {
		return codSaida;
	}
}
