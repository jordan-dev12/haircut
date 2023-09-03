package com.haircut.book.vm;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsersRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "il nome non può essere null")
	private String nome;
	@NotNull(message = "il cognome non può essere null")
	private String Cognome;
	private String cellulare;
	@NotNull(message = "la password non deve essere null")
	private String password;
	@Email(message = "l'email non pò essere null")
	private String email;
}
