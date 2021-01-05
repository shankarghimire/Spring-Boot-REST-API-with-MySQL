package com.examples.dao;

import org.springframework.data.repository.CrudRepository;

import com.examples.entity.Stream;

public interface StreamRepository extends CrudRepository<Stream, Long> {

}
