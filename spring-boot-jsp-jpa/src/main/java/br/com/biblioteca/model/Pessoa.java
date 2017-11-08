package br.com.biblioteca.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	
	@Column(name="nome")
	@Getter
	@Setter
	private String nome; 
	
	@Column(name="datanascimento")
	@Getter
	@Setter
	private Date dtNascimento; 
	
	@Column(name="cpf")
	@Getter
	@Setter
	private String cpf;
	
	@Column(name="funcionario")
	@Getter
	@Setter
	private Boolean funcionario;
		
}
