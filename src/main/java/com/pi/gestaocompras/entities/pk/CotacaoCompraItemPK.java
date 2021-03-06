package com.pi.gestaocompras.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.pi.gestaocompras.entities.CotacaoCompra;
import com.pi.gestaocompras.entities.Funcionario;
import com.pi.gestaocompras.entities.Gerente;
import com.pi.gestaocompras.entities.Produto;

@Embeddable
public class CotacaoCompraItemPK implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "cotacaocompra_id")
	private CotacaoCompra cotacaocompra;
	
	@ManyToOne
	@JoinColumn(name = "gerente_id")
	private Gerente gerente;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;

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

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cotacaocompra, funcionario, gerente, produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CotacaoCompraItemPK other = (CotacaoCompraItemPK) obj;
		return Objects.equals(cotacaocompra, other.cotacaocompra)
				&& Objects.equals(funcionario, other.funcionario) && Objects.equals(gerente, other.gerente)
				&& Objects.equals(produto, other.produto);
	}


}
