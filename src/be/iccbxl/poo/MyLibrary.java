package be.iccbxl.poo;

import java.util.ArrayList;

public class MyLibrary {
	
	private String name; 
	private ArrayList<Book> books; 
	private ArrayList<Person> people;
	
	public MyLibrary(String name, ArrayList<Book> books, ArrayList<Person> people) {
		super();
		this.name = name;
		this.books = books;
		this.people = people;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	public ArrayList<Person> getPeople() {
		return people;
	}
	public void setPeople(ArrayList<Person> people) {
		this.people = people;
	}
	@Override
	public String toString() {
		return "MyLibrary [name=" + name + ", books=" + books + ", people=" + people + "]";
	} 
	

}
