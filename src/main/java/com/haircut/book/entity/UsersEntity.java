package com.haircut.book.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ANAGRAFE_PERSONA")
@Data
public class UsersEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cognome")
	private String cognome;
	
	@Column(name="email" ,unique = true, nullable = false)
	private String email;
	
	@JsonIgnore
	@Column(name="password")
	private String password;
	
	@Column(name="cellulare")
	private String cellulare;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name ="utente_ruolo" ,joinColumns = {
	@JoinColumn(name = "utente_id",updatable = true, insertable = false, referencedColumnName = "id") }, 
	inverseJoinColumns = { @JoinColumn(name = "ruolo_id", updatable = true, insertable = false, referencedColumnName = "id") })
	private Set<Ruolo> ruoli;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	@JoinTable(name = "cross_utente_prodotto", joinColumns = { @JoinColumn(name = "users_id", updatable = true, insertable = false, referencedColumnName = "ID") }, inverseJoinColumns = { @JoinColumn(name = "prodotto_id", updatable = true, insertable = false, referencedColumnName = "ID") })
	private List<ProductEntity> prodotti;


}
