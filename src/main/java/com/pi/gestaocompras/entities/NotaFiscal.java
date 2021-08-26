package com.pi.gestaocompras.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_notafiscal")
public class NotaFiscal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date data;

	private Double valorTotal;

	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
	private Fornecedor fornecedor;

//	private List<ItemDaNota> itensDaNota;

	public Long getId() {
		return id;
	}

	/**
	 * Este metodo inclui o item da nota na lista de itens (
	 * <code>itensDaNota</code>) e recalcula o valor total da nota. Atribui um
	 * número de item ao item incluido (sequencial).
	 *
	 * @param item
	 */
//	public void addItem(ItemDaNota item) {
//
//	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

//	public List<ItemDaNota> getItensDaNota() {
//		return itensDaNota;
//	}
//
//	public void setItensDaNota(List<ItemDaNota> itensDaNota) {
//		this.itensDaNota = itensDaNota;
//	}

}
