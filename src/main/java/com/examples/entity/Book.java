package com.examples.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Book")
@Table(name="book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="book_id")
	private Long id;
	
	@Column(name="book_title")
	private String title;
	
	@Column(name="book_author")
	private String author;
	
	public Book() {

	}
	
	public Book(Long id, String title, String author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
	
	
}
