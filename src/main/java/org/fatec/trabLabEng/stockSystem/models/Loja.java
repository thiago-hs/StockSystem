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
public class Loja implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codLoja;
	
	private String nomeLoja;
	private String endereco;
	private String tel;
	
	@ManyToOne
	private Cidade codCidade;
	
	public long getCodLoja() {
		return codLoja;
	}

	public void setCodLoja(long codLoja) {
		this.codLoja = codLoja;
	}

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
