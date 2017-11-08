package br.com.biblioteca.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="projeto")
public class Projeto {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	
	@Column(name="nome")
	@Getter
	@Setter
	private String nome;
	
	@Column(name="data_inicio")
	@Getter
	@Setter
	private Date dataInicio;
	
	@Column(name="data_previsao_fim")
	@Getter
	@Setter
	private Date dataPrevisaoFim;

	@Column(name="data_fim")
	@Getter
	@Setter
	private Date dataFim;
	
	@Column(name="descricao")
	@Getter
	@Setter
	private String descricao;
	
	@Column(name="status")
	@Getter
	@Setter
	private String status;
	
	@Column(name="orcamento")
	@Getter
	@Setter
	private Double orcamento;
	
	@Column(name="risco")
	@Getter
	@Setter
	private String risco;
	
	@Column(name="idgerente")
	@Getter
	@Setter
	private Long idGerente;
}
