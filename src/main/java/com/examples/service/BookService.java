package com.examples.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.examples.dao.BookRepository;
import com.examples.entity.Book;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
//	private static List<com.examples.entity.Book>listBook = new ArrayList<>();
//	static {
////		listBook.add(new Book(101L, "Java Complete Guide","Mr. Harry"));
////		listBook.add(new Book(102L, "Spring Boot Complete Guide","Mr. ABC"));
////		listBook.add(new Book(103L, "Spring Web MVC","XYZ"));
//	}
	
	//Methods to extract all books
	public List<Book>getAllBooks(){
		List<Book>listBookTemp =  (List<Book>)this.bookRepository.findAll();
		return listBookTemp;
	}
	
	//Method to extract a single Book
	public Book getBookById(Long id) {
		Book book = null;
		try {
			Optional<Book> optionalBook = this.bookRepository.findById(id);
			book = optionalBook.get();
		}
		catch(Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return book;
	}
	
	
	//Method to add new Book to API
	public Book addBook(Book book) {
		Book book2 = this.bookRepository.save(book);
		System.out.println("The Book Record has been saved to database : " + book);
		return book2;
	}
	
	//Method to delete book 
	public void deleteBook(Long bookId) {
		this.bookRepository.deleteById(bookId);
	}
	
	//Method to update the book record
	public Book updateBook(Book book, Long id) {
		book.setId(id);
		this.bookRepository.save(book);
		System.out.println("The book record has been updated in database: " + book);
		return book;
	}
	
}
 