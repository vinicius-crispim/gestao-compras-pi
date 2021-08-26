package com.pi.gestaocompras.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_ordemcompraitem")
public class OrdemCompraItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer quantidade;

	private Double precoitem;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	@ManyToOne
	@JoinColumn(name = "ordemcompra_id")
	private OrdemCompra ordemcompra;

	public OrdemCompraItem() {
	}

	public OrdemCompraItem(Long id, Integer quantidade, Double precoitem, Produto produto, OrdemCompra ordemcompra) {
		this.id = id;
		this.quantidade = quantidade;
		this.produto = produto;
		this.ordemcompra = ordemcompra;
		this.precoitem = precoitem;
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

	public Double getPreco() {
		return precoitem;
	}

	public void setPreco(Double precoitem) {
		this.precoitem = precoitem;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public OrdemCompra getOrdemcompra() {
		return ordemcompra;
	}

	public void setOrdemcompra(OrdemCompra ordemcompra) {
		this.ordemcompra = ordemcompra;
	}

	public Double getPrecoitem() {
		return precoitem;
	}

	public void setPrecoitem(Double precoitem) {
		this.precoitem = precoitem;
	}

	@Override
	public String toString() {
		return "CotacaoCompraItem [id=" + id + ", quantidade=" + quantidade + ", preço=" + precoitem + ", produto="
				+ produto + ", cotacaocompra=" + ordemcompra + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ordemcompra, id, precoitem, produto, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemCompraItem other = (OrdemCompraItem) obj;
		return Objects.equals(ordemcompra, other.ordemcompra) && Objects.equals(id, other.id)
				&& Objects.equals(precoitem, other.precoitem) && Objects.equals(produto, other.produto)
				&& Objects.equals(quantidade, other.quantidade);
	}
}
