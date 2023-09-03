package com.haircut.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haircut.book.entity.UsersEntity;

public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
	
	public UsersEntity findById(int id);
	public UsersEntity findByEmail(String email);

}
