package com.mongo.db.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.db.dao.BookRepository;
import com.mongo.db.model.Book;

@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepo;

	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
		bookRepo.save(book);
		return "Added book with id:" + book.getId();

	}

	@GetMapping("/findAllBooks")
	public List<Book> getAllBook() {
		return bookRepo.findAll();

	}

	@GetMapping("/findById/{Id}")
	public Optional<Book> getBook(@PathVariable int id) {
		return bookRepo.findById(id);

	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteBook(@PathVariable int id) {

		bookRepo.deleteById(id);
		return "book deleted with the id:" + id;

	}
}