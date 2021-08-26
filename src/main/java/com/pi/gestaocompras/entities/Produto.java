package com.pi.gestaocompras.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descrição;
    private Integer quantidade;
    private Integer estoque;
    private Double preço;

    @OneToMany(mappedBy = "produto")
    private List<CotacaoCompraItem> cotacaocompraitens = new ArrayList<>();

    @OneToMany(mappedBy = "produto")
    private List<OrdemCompraItem> ordemcompraitem = new ArrayList<>();
    
    @OneToMany(mappedBy = "produto")
    private List<NotaFiscalItem> notafiscalitem = new ArrayList<>();
    
    public Produto(Long id, String nome, String descrição, Integer quantidade, Integer estoque,Double preço) {
        this.id = id;
        this.nome = nome;
        this.descrição = descrição;
        this.quantidade = quantidade;
        this.estoque = estoque;
        this.preço = preço;
    }
    
    public Produto() {}
    
	public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEstoque() {
        return this.estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Double getPreço() {
        return this.preço;
    }

    public void setPreço(Double preço) {
        this.preço = preço;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrição() {
        return this.descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }


    public List<CotacaoCompraItem> getCotacaocompraitens() {
		return cotacaocompraitens;
	}

	public List<OrdemCompraItem> getOrdemcompraitem() {
		return ordemcompraitem;
	}

	public List<NotaFiscalItem> getNotafiscalitem() {
		return notafiscalitem;
	}

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", descrição='" + getDescrição() + "'" +
            ", quantidade='" + getQuantidade() + "'" +
            "}";
    }

	@Override
	public int hashCode() {
		return Objects.hash(descrição, id, estoque, nome, preço, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(descrição, other.descrição) && Objects.equals(id, other.id)
				&& Objects.equals(estoque, other.estoque) && Objects.equals(nome, other.nome)
				&& Objects.equals(preço, other.preço) && Objects.equals(quantidade, other.quantidade);
	}
    

}
