package com.pi.gestaocompras.entities;

import java.util.Objects;

import com.pi.gestaocompras.entities.pk.CotacaoCompraItemsPK;

public class CotacaoCompraItem {

	private CotacaoCompraItemsPK id;
	
	private Integer quantidade;
	
	private String marca;

	public CotacaoCompraItem() {}

	public CotacaoCompraItem(Produto produto,CotacaoCompra cotacaocompra, Integer quantidade, String marca) {
		this.quantidade = quantidade;
		this.marca = marca;
		id.setCotacaocompra(cotacaocompra);
		id.setProduto(produto);
	}

	public Produto getProduto() {
		return id.getProduto();
	}

	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}
	
	public CotacaoCompra getCotacaoCompra() {
		return id.getCotacaocompra();
	}
	
	public void setCotacaoCompra(CotacaoCompra cotacaocompra) {
		id.setCotacaocompra(cotacaocompra);;
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


	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}
}
