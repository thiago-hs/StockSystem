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

@Entity
public class Transportadora implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codTransportadora;
	
	private String nome;
	private String endereco;
	private String Contato;
	private String tel;
	
	@ManyToOne
	private Cidade codCidade;
	
	public long getCodTransportadora() {
		return codTransportadora;
	}

	public void setCodTransportadora(long codTransportadora) {
		this.codTransportadora = codTransportadora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getContato() {
		return Contato;
	}

	public void setContato(String contato) {
		Contato = contato;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Cidade getCodCidade() {
		return codCidade;
	}

	public void setCodCidade(Cidade codCidade) {
		this.codCidade = codCidade;
	}
}
