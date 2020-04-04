package be.iccbxl.poo;

import java.time.LocalDate;
import java.util.UUID;

public class Book {
	
	protected UUID id; 
	protected String title; 
	protected String author; 
	protected short totalPages; 	
	protected byte loanPeriod; // (durée d’emprunt); 
	protected double rentalPrice;  // (prix de location); 
	protected LocalDate borrowingDate; //(date d’emprunt); 
	protected String language; // (langue)
	protected Person borrower;
	public Book(UUID id, String title, String author, short totalPages, String language) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.totalPages = totalPages;
		this.loanPeriod = 14;
		this.rentalPrice = 1.25;
		this.borrowingDate = null;
		this.language = language;
		this.borrower = null;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
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
	public short getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(short totalPages) {
		this.totalPages = totalPages;
	}
	public byte getLoanPeriod() {
		return loanPeriod;
	}
	public void setLoanPeriod(byte loanPeriod) {
		this.loanPeriod = loanPeriod;
	}
	public double getRentalPrice() {
		return rentalPrice;
	}
	public void setRentalPrice(double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}
	public LocalDate getBorrowingDate() {
		return borrowingDate;
	}
	public void setBorrowingDate(LocalDate borrowingDate) {
		this.borrowingDate = borrowingDate;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Person getBorrower() {
		return borrower;
	}
	public void setBorrower(Person borrower) {
		this.borrower = borrower;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", \ntitle=" + title + ", \nauthor=" + author + ", \ntotalPages=" + totalPages
				+ ", \nloanPeriod=" + loanPeriod + ", \nrentalPrice=" + rentalPrice + ", \nborrowingDate=" + borrowingDate
				+ ", \nlanguage=" + language + ", \nborrower=" + borrower + "]";
	} 
	
	

}
