package com.pi.gestaocompras.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cotacaocompraitem")
public class CotacaoCompraItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer quantidade;

	private String marca;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	@ManyToOne
	@JoinColumn(name = "gerente_id")
	private Gerente gerente;
	@ManyToOne
	@JoinColumn(name = "cotacaocompra_id")
	private CotacaoCompra cotacaocompra;
	@OneToMany(mappedBy = "cotacaocompraitem")
	private List<FornecedorCotacaoCompraItem> fornecedorcotacaocompraitem = new ArrayList<FornecedorCotacaoCompraItem>();

	public CotacaoCompraItem() {
	}

	public CotacaoCompraItem(Long id, Integer quantidade, String marca, Produto produto, CotacaoCompra cotacaocompra) {
		this.id = id;
		this.quantidade = quantidade;
		this.marca = marca;
		this.produto = produto;
		this.cotacaocompra = cotacaocompra;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public CotacaoCompra getCotacaocompra() {
		return cotacaocompra;
	}

	public void setCotacaocompra(CotacaoCompra cotacaocompra) {
		this.cotacaocompra = cotacaocompra;
	}

	public List<FornecedorCotacaoCompraItem> getFornecedorcotacaocompraitem() {
		return fornecedorcotacaocompraitem;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	@Override
	public String toString() {
		return "CotacaoCompraItem [id=" + id + ", quantidade=" + quantidade + ", marca=" + marca + ", produto="
				+ produto + ", cotacaocompra=" + cotacaocompra + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cotacaocompra, id, marca, produto, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CotacaoCompraItem other = (CotacaoCompraItem) obj;
		return Objects.equals(cotacaocompra, other.cotacaocompra) && Objects.equals(id, other.id)
				&& Objects.equals(marca, other.marca) && Objects.equals(produto, other.produto)
				&& Objects.equals(quantidade, other.quantidade);
	}

}
