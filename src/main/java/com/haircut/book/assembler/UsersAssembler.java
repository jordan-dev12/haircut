package com.haircut.book.assembler;

import org.springframework.stereotype.Component;

import com.haircut.book.entity.UsersEntity;
import com.haircut.book.vm.UsersRequest;

@Component
public class UsersAssembler extends AbstractAssembler<UsersEntity, UsersRequest>{

	@Override
	public UsersEntity toEntity(UsersRequest dto) {
		UsersEntity entity = new UsersEntity();
		entity.setNome(dto.getNome());
		entity.setCognome(dto.getCognome());
		entity.setCellulare(dto.getCellulare());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		return entity;
	}

	@Override
	public UsersRequest toRequest(UsersEntity entity) {
		UsersRequest request = new UsersRequest();
		request.setNome(entity.getNome());
		request.setCognome(entity.getCognome());
		request.setCellulare(entity.getCellulare());
		request.setEmail(entity.getEmail());
		
		return request;
	}
	
	public <T> boolean getMano(T e) {
		return false;
	}

}
