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
@Table(name = "tb_fornecedor")
public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cnpj;
    
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
    
    @OneToMany(mappedBy = "fornecedor")
    private List<NotaFiscal> notasfiscais = new ArrayList<>();

    @OneToMany(mappedBy = "fornecedor")
    private List<OrdemCompra> ordenscompra = new ArrayList<OrdemCompra>();
    @OneToMany(mappedBy = "fornecedor")
	private List<FornecedorCotacaoCompraItem> fornecedorcotacaocompraitem = new ArrayList<FornecedorCotacaoCompraItem>();
    @OneToMany(mappedBy = "fornecedor")
	private List<CotacaoCompra> cotacaocompra = new ArrayList<CotacaoCompra>();

    public Fornecedor() {
    }
    
    public Fornecedor(Long id, String nome, String cnpj, Cidade cidade) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.cidade = cidade;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public List<NotaFiscal> getNotasfiscais() {
		return notasfiscais;
	}

	public List<OrdemCompra> getOrdenscompra() {
		return ordenscompra;
	}

	public List<FornecedorCotacaoCompraItem> getFornecedorcotacaocompraitem() {
		return fornecedorcotacaocompraitem;
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
		Fornecedor other = (Fornecedor) obj;
		return Objects.equals(id, other.id);
	}
	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", cnpj='" + getCnpj() + "'" +
            "}";
    }
    
}
