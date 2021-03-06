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
import com.pi.gestaocompras.entities.pk.NotaFiscalItemPK;

@Entity
@Table(name = "tb_notafiscalitem")
public class NotaFiscalItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NotaFiscalItemPK id = new NotaFiscalItemPK();

	private Integer quantidade;

	private Double precoitem;

	public NotaFiscalItem() {
	}

	public NotaFiscalItem(Integer quantidade, Double precoitem, Produto produto, NotaFiscal notafiscal) {
		this.quantidade = quantidade;
		this.precoitem = precoitem;
		id.setNotafiscal(notafiscal);
		id.setProduto(produto);
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
	public NotaFiscal getNotafiscal() {
		return id.getNotafiscal();
	}
	
	public void setNotaFiscal(NotaFiscal notafiscal) {
		id.setNotafiscal(notafiscal);
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
		NotaFiscalItem other = (NotaFiscalItem) obj;
		return Objects.equals(id, other.id) && Objects.equals(precoitem, other.precoitem)
				&& Objects.equals(quantidade, other.quantidade);
	}

	
}
