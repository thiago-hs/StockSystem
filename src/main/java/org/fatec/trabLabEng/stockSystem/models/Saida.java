package org.fatec.trabLabEng.stockSystem.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Saida implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codSaida;
	
	private double total;
	
	@OneToOne
	private Loja codLoja;
	
	@OneToOne
	private Transportadora codTransportadora;

	public long getCodSaida() {
		return codSaida;
	}

	public void setCodSaida(long codSaida) {
		this.codSaida = codSaida;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Loja getCodLoja() {
		return codLoja;
	}

	public void setCodLoja(Loja codLoja) {
		this.codLoja = codLoja;
	}

	public Transportadora getCodTransportadora() {
		return codTransportadora;
	}

	public void setCodTransportadora(Transportadora codTransportadora) {
		this.codTransportadora = codTransportadora;
	}
}
