package be.iccbxl.poo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class Person {
	protected UUID id; 
	private String name;  
	private byte maxBooks; 
	private LocalDate registrationDate; 
	private ArrayList<Book> books;
	
	public Person(UUID id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.maxBooks = 3;
		this.registrationDate = LocalDate.now();
		this.books = new ArrayList<Book>();
	}

	
	
	public UUID getId() {
		return id;
	}
/*
	public void setId(UUID id) {
		this.id = id;
	}
*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getMaxBooks() {
		return maxBooks;
	}

	public void setMaxBooks(byte maxBooks) {
		this.maxBooks = maxBooks;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", maxBooks=" + maxBooks + ", registrationDate="
				+ registrationDate + ", books=" + books + "]";
	} 
	
	
	public void borrows(Book book) {
		this.books.add(book);
		book.setBorrower(this); 
		book.borrowingDate = LocalDate.now();
		
	}
	
	public void returns(Book book){
		this.books.remove(book); 
		book.setBorrower(null);
		book.setBorrowingDate(null);
	}
	

}



































