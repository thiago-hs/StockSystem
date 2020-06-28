package org.fatec.trabLabEng.stockSystem.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codProduto;
	private String descricao;
	private double peso;
	private int qntMin;
	
	@ManyToOne
	private Fornecedor codFornecedor;
	
	@ManyToOne
	private Categoria codCategoria;
	
	public long getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(long codProduto) {
		this.codProduto = codProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getQntMin() {
		return qntMin;
	}

	public void setQntMin(int qntMin) {
		this.qntMin = qntMin;
	}

	public Fornecedor getCodFornecedor() {
		return codFornecedor;
	}

	public void setCodFornecedor(Fornecedor codFornecedor) {
		this.codFornecedor = codFornecedor;
	}

	public Categoria getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(Categoria codCategoria) {
		this.codCategoria = codCategoria;
	}
}
