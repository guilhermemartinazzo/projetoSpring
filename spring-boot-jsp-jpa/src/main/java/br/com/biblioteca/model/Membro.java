package br.com.biblioteca.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;


//@Entity
//@Table(name="Membros")
public class Membro implements Serializable{

	private static final long serialVersionUID = 1L;
//	@Id
	@Getter
	@Setter
	private BigDecimal idMembro;
}
