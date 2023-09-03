package com.haircut.book.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PRODOTTO")
@Data
public class ProductEntity implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="descrizione")
	private String descrizione;
	
	@Column(name="luogo")
	private String luogo;
	
	@Column(name="dataInizioRapporto")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dataInizioRapporto;
	
	
	@Column(name="dataFineRapporto")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataFineRapporto;
	
	

}
