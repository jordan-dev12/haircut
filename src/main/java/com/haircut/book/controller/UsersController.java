package com.haircut.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haircut.book.exception.AnagrafePersonaException;
import com.haircut.book.services.UsersService;
import com.haircut.book.vm.UsersRequest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/anagrafica")
@Validated
@Slf4j
public class UsersController {
	
	@Autowired
	private UsersService personaService;
	
	
	@PostMapping("/add")
	public void createUser(@Valid @RequestBody UsersRequest anagrafePersona) throws Exception  {

		try {
			personaService.createUser(anagrafePersona);
		} catch (Exception e) {
			log.error("Error while AnagrafePersonaController.addAnagrafePersona", e);
			throw new  AnagrafePersonaException("Errore durante il salvataggio del l'utente" , e);
		}

	}
	@GetMapping("/get")
	public UsersRequest getDatiAnagrafica( @RequestParam("id") @NotNull @Positive Integer id) throws AnagrafePersonaException  {
		
		try {
			return personaService.getPersonaById(id);
		} catch (Exception e) {
			log.error("Error while AnagrafePersonaController.addAnagrafePersona", e);
			throw new  AnagrafePersonaException("Errore durante il recupero dei dati del utente" , e);
		}
		
		
	}

}
