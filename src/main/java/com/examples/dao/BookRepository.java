package com.examples.dao;

import org.springframework.data.repository.CrudRepository;

import com.examples.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	
}
