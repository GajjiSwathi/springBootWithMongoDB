package com.mongo.db.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.db.model.Book;

public interface BookRepository extends MongoRepository<Book,Integer> {

}
