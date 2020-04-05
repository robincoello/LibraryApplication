package be.iccbxl.poo;

import java.util.ArrayList;
import java.util.UUID;

public class main {

	public static void main(String[] args) {
		
		ArrayList<Person> listP = new ArrayList<Person>(); 
		ArrayList<Book> listB = new ArrayList<Book>(); 
						
		Person p1 = new Person(UUID.randomUUID(), "robinson");
		listP.add(p1); 
		Person p2 = new Person(UUID.randomUUID(), "patricia");
		listP.add(p2); 
		
		
		Book b1 = new Book(UUID.randomUUID(), "viaje al centro de la tierra", "Julio verne", (short)183, "fr");
		listB.add(b1); 
		
		Book b2 = new Book(UUID.randomUUID(), "el secreto", "Desconocido", (short)783, "GB");
		listB.add(b2); 
		
		//System.out.println(b1);
		System.out.println("*** Liste de personnes");
		System.out.println(listP);
		System.out.println("--- Liste de books");
		System.out.println(listB);			
				
		MyLibrary l1 = new MyLibrary("icc", listB, listP); 
		System.out.println("-*-*-* My Library----------");
		System.out.println(l1);
		
		
		
		
		
		
	}

}
