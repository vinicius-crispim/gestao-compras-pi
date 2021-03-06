package com.pi.gestaocompras.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pi.gestaocompras.entities.pk.OrdemCompraItemPK;

@Entity
@Table(name = "tb_ordemcompraitem")
public class OrdemCompraItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrdemCompraItemPK id = new OrdemCompraItemPK();

	private Integer quantidade;

	private Double precoitem;

	public OrdemCompraItem() {
	}

	public OrdemCompraItem(Integer quantidade, Double precoitem, Produto produto, OrdemCompra ordemcompra) {
		this.quantidade = quantidade;
		this.precoitem = precoitem;
		id.setOrdemcompra(ordemcompra);
		id.setProduto(produto);
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoitem() {
		return precoitem;
	}

	public void setPrecoitem(Double precoitem) {
		this.precoitem = precoitem;
	}

	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}
	@JsonIgnore
	public OrdemCompra getOrdemCompra() {
		return id.getOrdemcompra();
	}
	
	public void setOrdemCompra(OrdemCompra ordemcompra) {
		id.setOrdemcompra(ordemcompra);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, precoitem, quantidade);
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
		return Objects.equals(id, other.id) && Objects.equals(precoitem, other.precoitem)
				&& Objects.equals(quantidade, other.quantidade);
	}
}
