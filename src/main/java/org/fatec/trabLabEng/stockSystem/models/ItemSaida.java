package org.fatec.trabLabEng.stockSystem.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ItemSaida implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codItemSaida;
	
	private int quantidade;
	private double valor;
	
	@ManyToOne
	private Saida codSaida;
	
	@ManyToOne
	private Produto codProduto;

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

	public Saida getCodSaida() {
		return codSaida;
	}

	public void setCodSaida(Saida codSaida) {
		this.codSaida = codSaida;
	}

	public Produto getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Produto codProduto) {
		this.codProduto = codProduto;
	}
}
