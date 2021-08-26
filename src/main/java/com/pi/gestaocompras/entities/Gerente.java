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
@Table(name = "tb_gerente")
public class Gerente implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String senha;
    private String email;
    private String telefone;
    
    @OneToMany(mappedBy = "gerente")
    private List<Funcionario> funcionarios = new ArrayList<>();
    @OneToMany(mappedBy = "gerente")
    private List<CotacaoCompraItem> cotacaocompraitem = new ArrayList<>();
	
    public Gerente() {}
    
    public Gerente(Long id, String nome, String senha, String email, String telefone) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public List<CotacaoCompraItem> getCotacaocompraitem() {
		return cotacaocompraitem;
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
		Gerente other = (Gerente) obj;
		return Objects.equals(id, other.id);
	}
    
}
