package com.pi.gestaocompras.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cotacaocompra")
public class CotacaoCompra implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "cotacaocompra")
	private List<CotacaoCompraItem> cotacaocompraitem = new ArrayList<>();

	public CotacaoCompra() {}
	
	public CotacaoCompra(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<CotacaoCompraItem> getCotacaocompraitem() {
		return cotacaocompraitem;
	}
}
