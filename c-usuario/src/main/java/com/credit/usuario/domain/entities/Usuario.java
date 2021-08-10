package com.credit.usuario.domain.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank
	@Column(nullable = false)
	private String nome;
	
	@NotNull
	@Column(nullable = false)
	private Integer idade;
	
	@NotBlank
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@NotBlank
	@Column(nullable = false, unique = true)
	private String usuario;
	
	@NotBlank
	private String senha;
	
	private transient Set<Cartao> cartoes = new HashSet<Cartao>();
}
