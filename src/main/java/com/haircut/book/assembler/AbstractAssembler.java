package com.haircut.book.assembler;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAssembler<E,DTO> {
	
	public abstract E toEntity(DTO dto);
	public abstract DTO toRequest(E dto);
	
	
	public final List<E> toEntities(List<DTO> list) {
		List<E> result = new ArrayList<E>();
		for (DTO dto : list) {
			result.add(toEntity(dto));
		}

		return result;
	}

	public final List<DTO> toRequest(List<E> entities) {
		List<DTO> result = new ArrayList<>();
		for (E e : entities) {
			result.add(toRequest(e));
		}

		return result;
	}

}
