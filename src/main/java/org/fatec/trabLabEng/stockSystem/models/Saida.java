package org.fatec.trabLabEng.stockSystem.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.Transient;

@Entity
public class Saida implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codSaida;
	
	private double total;
	
	@ManyToOne
	private Loja loja;
	
	@Transient
	private long codLoja;
	
	@ManyToOne
	private Transportadora Transportadora;
	
	@Transient
	private long codTransportadora;
	
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

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public long getCodLoja() {
		return codLoja;
	}

	public void setCodLoja(long codLoja) {
		this.codLoja = codLoja;
	}

	public Transportadora getTransportadora() {
		return Transportadora;
	}

	public void setTransportadora(Transportadora transportadora) {
		Transportadora = transportadora;
	}

	public long getCodTransportadora() {
		return codTransportadora;
	}

	public void setCodTransportadora(long codTransportadora) {
		this.codTransportadora = codTransportadora;
	}
	
}
