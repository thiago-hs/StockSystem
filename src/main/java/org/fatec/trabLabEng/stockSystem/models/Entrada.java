package org.fatec.trabLabEng.stockSystem.models;

import java.io.Serializable;

import java.util.Date;
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
public class Entrada implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codEntrada;
	
	private Date dataPedido;
	private Date dataEntrada;
	private double total;
	private long numNota;

	@ManyToOne
	private Transportadora Transportadora;
	
	@Transient
	private long codTransportadora;
	
	public long getCodEntrada() {
		return codEntrada;
	}

	public void setCodEntrada(long codEntrada) {
		this.codEntrada = codEntrada;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public long getNumNota() {
		return numNota;
	}

	public void setNumNota(long numNota) {
		this.numNota = numNota;
	}

	public long getCodTransportadora() {
		return codTransportadora;
	}

	public void setCodTransportadora(long codTransportadora) {
		this.codTransportadora = codTransportadora;
	}

	public Transportadora getTransportadora() {
		return Transportadora;
	}

	public void setTransportadora(Transportadora transportadora) {
		Transportadora = transportadora;
	}
}