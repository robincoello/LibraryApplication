package be.iccbxl.poo;

import java.util.UUID;

public class main {

	public static void main(String[] args) {
		
		
		
		
		
		
		
		Person p1 = new Person(UUID.randomUUID(), "robinson"); 
		Person p2 = new Person(UUID.randomUUID(), "patricia");
		
		System.out.println(p1);
		System.out.println(p2);
		
		
		Book b1 = new Book(UUID.randomUUID(), "viaje al centro de la tierra", "Julio verne", (short)183, "fr"); 

		System.out.println(b1);
	}

}
