package br.com.ecoenergy.ecoenergy.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "O atributo usuário é obrigatório")
	@NotBlank(message = "O atributo usuário não pode ser vazio")
	@ApiModelProperty(example = "email@email.com.br")
	@Size(min = 2, max = 150, message = "O usuário deve conter entre 2 e 150 caracteres.")
	private String email;

	@NotNull
	@Size(min = 6, message = "Insira no mínimo 6 caracteres para a senha")
	private String senha;

	@NotNull
	@Column(name = "nome_completo")
	private String nomeCompleto;

	@NotNull
	private String adm;

	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Produto> produto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getAdm() {
		return adm;
	}

	public void setAdm(String adm) {
		this.adm = adm;
	}


	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

}
