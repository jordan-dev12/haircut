package com.haircut.book.services;

import com.haircut.book.exception.AnagrafePersonaException;
import com.haircut.book.vm.UsersRequest;

public interface UsersService {
	
	public void createUser(UsersRequest p) throws AnagrafePersonaException;
	public void deletePersonaById(int  id) throws AnagrafePersonaException;
	public UsersRequest getPersonaById(int id) throws AnagrafePersonaException, Exception;
	
	

}
