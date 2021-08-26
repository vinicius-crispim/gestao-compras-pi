package com.pi.gestaocompras.entities;

import javax.persistence.OneToMany;

public class CotacaoCompra {

	private Long id;
	
	@OneToMany(mappedBy = "cotacaocompra")
	private CotacaoCompraItem cotacaocompraitem;
}
