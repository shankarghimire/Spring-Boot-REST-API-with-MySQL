package com.examples.dao;

import org.springframework.data.repository.CrudRepository;


import com.examples.entity.Viewer;

public interface ViewerRepository extends CrudRepository<Viewer, Long> {
	
}
