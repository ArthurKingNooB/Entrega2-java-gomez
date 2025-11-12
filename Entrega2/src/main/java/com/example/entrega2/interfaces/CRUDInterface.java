package com.example.entrega2.interfaces;

import java.util.List;

public interface CRUDInterface <T, ID> {

	
	List<T> FindAll();
	
	T findById(ID id);
	
	T save(T entity);
	
	T update (ID id, T entity);
	
	void deleteById(ID id);
}
