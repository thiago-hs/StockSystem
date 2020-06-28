package org.fatec.trabLabEng.stockSystem.models;

import java.io.Serializable;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
	
	@OneToOne
	private Transportadora codTransportadora;

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

	public Transportadora getCodTransportadora() {
		return codTransportadora;
	}

	public void setCodTransportadora(Transportadora codTransportadora) {
		this.codTransportadora = codTransportadora;
	}
}
