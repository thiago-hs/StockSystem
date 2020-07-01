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

import org.springframework.data.annotation.Transient;

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
	private Fornecedor fornecedor;
	
	@Transient
	private long codFornecedor;
	
	@ManyToOne
	private Categoria categoria;
	
	@Transient
	private long codCategoria;
	
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

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public long getCodFornecedor() {
		return codFornecedor;
	}

	public void setCodFornecedor(long codFornecedor) {
		this.codFornecedor = codFornecedor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public long getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(long codCategoria) {
		this.codCategoria = codCategoria;
	}

}
