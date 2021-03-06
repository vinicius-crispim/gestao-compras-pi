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

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "tb_funcionario")
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String senha;
    private String email;
    private String login;
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "gerente_id")
    private Gerente gerente;

	@OneToMany(mappedBy = "id.funcionario")
	private List<CotacaoCompraItem> cotacaocompraitens = new ArrayList<>();
	
    public Funcionario() {}
    
    public Funcionario(Long id, String nome, String senha, String email, String telefone, Gerente gerente, String login) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.telefone = telefone;
		this.gerente = gerente;
		this.login=login;
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
	@JsonIgnore
	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	@JsonIgnore
	public List<CotacaoCompraItem> getCotacaocompraitens() {
		return cotacaocompraitens;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cotacaocompraitens, email, gerente, id, login, nome, senha, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(cotacaocompraitens, other.cotacaocompraitens) && Objects.equals(email, other.email)
				&& Objects.equals(gerente, other.gerente) && Objects.equals(id, other.id)
				&& Objects.equals(login, other.login) && Objects.equals(nome, other.nome)
				&& Objects.equals(senha, other.senha) && Objects.equals(telefone, other.telefone);
	}

}
