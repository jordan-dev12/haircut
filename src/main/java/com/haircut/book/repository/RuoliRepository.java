package com.haircut.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haircut.book.entity.Ruolo;

public interface RuoliRepository extends JpaRepository<Ruolo, Integer> {
	
	Ruolo findByNome(String nome);

}
