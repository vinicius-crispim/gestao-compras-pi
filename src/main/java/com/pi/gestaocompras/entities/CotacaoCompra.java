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
@Table(name = "tb_cotacaocompra")
public class CotacaoCompra implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "id.cotacaocompra")
	private List<CotacaoCompraItem> cotacaocompraitens = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
	private Fornecedor fornecedor;

	public CotacaoCompra() {
	}

	public CotacaoCompra(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<CotacaoCompraItem> getCotacaocompraitem() {
		return cotacaocompraitens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cotacaocompraitens, fornecedor, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CotacaoCompra other = (CotacaoCompra) obj;
		return Objects.equals(cotacaocompraitens, other.cotacaocompraitens)
				&& Objects.equals(fornecedor, other.fornecedor) && Objects.equals(id, other.id);
	}

}
