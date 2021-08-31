package com.pi.gestaocompras.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.pi.gestaocompras.entities.CotacaoCompra;
import com.pi.gestaocompras.entities.Produto;

@Embeddable
public class CotacaoCompraItemsPK implements Serializable{
/*classe auxiliar para tabela notacaocompra*/
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "cotacaocompra_id")
	private CotacaoCompra cotacaocompra;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	public CotacaoCompra getCotacaocompra() {
		return cotacaocompra;
	}

	public void setCotacaocompra(CotacaoCompra cotacaocompra) {
		this.cotacaocompra = cotacaocompra;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cotacaocompra, produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CotacaoCompraItemsPK other = (CotacaoCompraItemsPK) obj;
		return Objects.equals(cotacaocompra, other.cotacaocompra) && Objects.equals(produto, other.produto);
	}

}
