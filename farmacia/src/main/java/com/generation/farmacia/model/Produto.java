package com.generation.farmacia.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome é Obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo título deve conter no minimo 05 e no máximo 100 caracteres")
	private String nome;
	
	@NotBlank(message = "O atributo descrição é Obrigatório!")
	@Size(min = 10, max = 1000, message = "O atributo texto deve conter no minimo 10 e no máximo 1000 caracteres")
	private String descricao;
	
	@UpdateTimestamp
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;
	
	private Double preco;
	
	@NotNull
	@Size(min=5,max=20, message = "A quantidade deve conter no mínimo 5 e no máximo 100 caracteres")
	private String data_validade;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getData_validade() {
		return data_validade;
	}

	public void setData_validade(String data_validade) {
		this.data_validade = data_validade;
	}
	
}
