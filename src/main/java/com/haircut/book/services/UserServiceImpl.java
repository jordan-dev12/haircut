package com.haircut.book.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haircut.book.assembler.UsersAssembler;
import com.haircut.book.common.CommonVariabile;
import com.haircut.book.entity.UsersEntity;
import com.haircut.book.entity.Ruolo;
import com.haircut.book.exception.AnagrafePersonaException;
import com.haircut.book.repository.UsersRepository;
import com.haircut.book.repository.RuoliRepository;
import com.haircut.book.vm.UsersRequest;


@Service
public class UserServiceImpl implements UsersService{
	
	
	@Autowired
	private UsersRepository anagrafePersonaRepository;
	
	@Autowired
	private RuoliRepository ruoli;
	
	@Autowired
	private UsersAssembler assemblerPersona;

	@Override
	public void createUser(UsersRequest persona) throws AnagrafePersonaException {

		UsersEntity entity = assemblerPersona.toEntity(persona);
		assegnaRuolo(entity, CommonVariabile.RUOLO_UTENTE);
		anagrafePersonaRepository.save(entity);

	}
	
	
	@Override
	public UsersRequest getPersonaById(int id)  throws Exception{
		UsersEntity entity = anagrafePersonaRepository.findById(id);

		if (entity != null) {
			return assemblerPersona.toRequest(entity);
		}
		return null;
	}

	@Override
	public void deletePersonaById(int id) {
		
		anagrafePersonaRepository.deleteById(id);
	}


	private void assegnaRuolo(UsersEntity persona, String nameRuolo) {

		Ruolo ruolo = ruoli.findByNome(nameRuolo);
		if(ruolo != null) {
			Set<Ruolo> ruoli = new HashSet<>();
			persona.setRuoli(ruoli);
			persona.getRuoli().add(ruolo);
		}

	}



}
