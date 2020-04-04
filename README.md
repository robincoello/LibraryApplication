# LibraryApplication
Application de gestion bibliothécaire

Introduction au langage Java et à l'écosystème Spring au travers d'une étude de cas



## Cédryc Ruth - mars 2020

### Présentation du projet
Application de gestion bibliothécaire (Library Application)
*f
*f
    * Application qui gère des livres, des membres et les emprunts de livres par les membres.
    * Modèle de données : l’application présentera les classes principales suivantes :
        * Person : name, maxBooks (nombre maximum de livres physiques que cette personne peut emprunter en même temps), registrationDate (date d’inscription)
        * Book : title, author, totalPages, person (personne qui a emprunté le document), loanPeriod (durée d’emprunt), rentalPrice (prix de location), borrowingDate (date d’emprunt), language (langue)
            * OnlineBook : maxPeople (nombre maximum de personnes qui peuvent emprunter ce livre en même temps), content (contenu du livre)
            * GraphicNovel : cartoonist (dessinateur), color (couleur ou noir et blanc)
        * MyLibrary : name, books (liste de livres), people (liste de personnes)
    * L’application devra permettre les fonctionnalités suivantes :
        * Ajouter/ Retirer un membre (Person) dans la bibliothèque (MyLibrary) ;
        * Ajouter/ Retirer un livre (Book) dans la bibliothèque (MyLibrary) ;
        ◦ Modifier les détails d’un membre / d’un livre
        ◦ Afficher la liste des membres / des livres
        ◦ Rechercher des membres / des livres selon certains critères
        ◦ Emprunter/ Restituer un livre par un membre
        ◦ Afficher tous les livres empruntés par un membre donné
        ◦ Calculer le coût d’un emprunt de plusieurs livres par un membre
        ◦ Calculer l’amende en cas de retard lors de la restitution
        ◦ Calculer le nombre de jours restants avant restitution d’un livre emprunté
        ◦ Importer / Exporter les données dans un fichier texte
Nota bene :
    • Un livre virtuel (OnlineBook) n’entre pas dans le compte du nombre maximum de livres empruntés par le membre (maxBooks) mais il ne peut pas être emprunté par plus de maxPeople à la fois.
    • Un livre virtuel est automatiquement restitué si sa durée d’emprunt a expirée. Cette vérification se fera lors de la lecture du livre (affichage du contenu).
Contraintes de développement
    • Application de type « Console » avec stockage de données dans un fichier XML ou JSON.
    • Développement au moyen du framework Spring et de librairies professionnelles.

Partie 1 – Description et montage de l’algorithme
Dans un premier temps, on voudrait un simple programme qui permet d’ajout un membre et un livre, de réaliser un emprunt et d’afficher des informations statistiques.
On écrira une application Java de type console, c’est-à-dire sans interface graphique ni page Web. Elle devra présenter le menu suivant à l’utilisateur :
    1. Ajouter un membre
    2. Ajouter un livre
    3. Emprunter un livre
    4. Afficher les statistiques
    1. Quitter
L’utilisateur entrera son choix au clavier, puis l’application lui demandera éventuellement des informations supplémentaires (nom du membre, titre du livre,…). À la fin du traitement, l’application affichera à nouveau le menu.

Afin de mieux comprendre le déroulement des séquences d’interaction entre l’application (système) et l’utilisateur, il convient de décrire ses interactions sous forme de scénarios. Ceci correspond à une étape de l’analyse UML.
Scénarios
Ajouter un membre
Scénario nominal
    1. Le système affiche le menu principal.
    2. L’utilisateur entre au clavier la valeur "1" pour l’option « Ajouter un membre ».
    3. Le système demande à l’utilisateur le nom du membre.
    4. L’utilisateur entre au clavier le nom du membre.
    5. Le système demande à l’utilisateur le nombre de livres maximum que le membre peut emprunter.
    6. L’utilisateur entre au clavier ce nombre de livres maximum.
    7. Le système crée le membre en générant son id et sa date d’inscription.
    8. Le système affiche le membre créé pour confirmation.
Emprunter un livre
Scénario nominal
    1. Le système affiche le menu principal.
    2. L’utilisateur entre au clavier la valeur "3" pour l’option « Emprunter un livre ».
    3. Le système demande à l’utilisateur le titre du livre (ou une partie du titre).
    4. L’utilisateur entre au clavier le titre ou une partie du titre du livre.
    5. Le système affiche une liste numérotée des livres disponibles dont le titre contient ces mots. (Les livres non disponibles sont aussi affichés mais pas numérotés).
    6. L’utilisateur entre au clavier le numéro du livre qui correspond à son choix.
    7. Le système demande à l’utilisateur le nom du membre qui emprunte.
    8. L’utilisateur entre au clavier le nom du membre.
    9. Le système affiche une liste numérotée des membres dont le nom correspond. (Sauf dans le cas d’un e-book, les membres ne pouvant plus emprunter sont aussi affichés mais pas numérotés).
    10. L’utilisateur entre au clavier le numéro du membre qui correspond à son choix.
    11. Le système réalise l’emprunt en définissant la date d’emprunt.
    12. Le système calcule la date de retour.
    13. Le système affiche une synthèse (Emprunteur, livre, date de retour).
Scénario alternatif
3a. 5a. 7a. 9a. L’utilisateur peut abandonner la séquence en entrant la valeur « 0 » au clavier. Cette possibilité lui est affichée dans chaque menu.
Afficher les statistiques
Scénario nominal
    1. Le système affiche le menu principal.
    2. L’utilisateur entre au clavier la valeur "A" pour l’option « Afficher les statistiques ».
    3. Le système affiche les statistiques suivantes :
        a. nombre total de livres et de membres,
        b. nombre de livres électroniques et de romans graphiques, 
        c. nombres de membres qui ont un livre en emprunt, 
        d. nombre de livres empruntés, 
        e. nombre de livres en retard.
    4. Le système affiche, sous forme de graphique, le nombre de membres inscrits chaque mois depuis janvier de l’année en cours.
Travaux pratiques
    Q1. Écrire l’algorithme de cette application mais en ne traitant que l’affichage des statistiques. Les données (membres, livres) seront prédéfinies dans des tableaux. Les erreurs de saisie seront signalées à l’utilisateur qui devra alors ressaisir la donnée erronée. L’application se termine quand l’utilisateur choisit la commande « 0 » dans le menu principal.

    Q2. Traduire l’algorithme en Java. On utilisera la méthode statique 	[main] d’une classe [MainApplication1] pour faire le traitement demandé.

Partie 2 – Définition des classes
La classe Person
Comme indiqué dans le diagramme de classe UML, une personne se caractérise par un nom (name), le nombre de livres maximum qu’il peut emprunter en même temps (maxBooks) et sa date d’inscription (registrationDate). Libre à vous d’ajouter d’autres attributs. La classe Person est associée à la classe Book, à savoir qu’un membre peut emprunter plusieurs livres. Cela implique la présence d’un attribut books qui sera la liste des livres empruntés par le membre.
package be.iccbxl.poo.data;

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
		this.id = id;
		this.name = name;
		this.maxBooks = 3;
		this.registrationDate = LocalDate.now();
		this.books = new ArrayList<Book>();
	}

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

	public UUID getId() {
		return id;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	@Override
	public String toString() {
		final int maxLen = 3;
		return "Person [" + id + ": " + name + " (maxBooks=" + maxBooks + ", inscrit le "
				+ registrationDate + ")\n books="
				+ (books != null ? books.subList(0, Math.min(books.size(), maxLen)) : null) + "]";
	}


Après avoir définit les attributs (id, name, maxBooks, registrationDate et books), vous pouvez facilement générer le constructeur, les getters & setters et la méthode toString grâce à votre IDE Eclipse. Notez que pour le constructeur seul l’id et le name sont des paramètres requis, les autres attributs sont définis dans le corps de la méthode.
Nous pouvons aussi implémenter les deux méthodes « métier » qui consiste à emprunter (borrows) et à restituer (returns) un livre.
	
	public void borrows(Book book) {
		this.books.add(book);
		book.setBorrower(this);
		book.borrowingDate = LocalDate.now();
	}

	public void returns(Book book) {
		this.books.remove(book);
		book.setBorrower(null);
		book.borrowingDate = null;
	}
	
}

Travaux pratiques
    Q1. Compléter la documentation JavaDoc de la classe Person.
    Q2. Définissez la classe Book, sans oublier d’ajouter la méthode métier computeRemainingDays, qui calcule le nombre de jours restants avant restitution du livre.
La classe MyLibrary
La classe MyLibrary se définit par un nom (name) et regroupe les livres (books) et les membres (people). Nous pouvons envisager aussi les méthodes de recherche getAllLateBooks, pour récupérer les livres en retard, et findMemberByName, pour trouver un membre au moyen de son nom.
package be.iccbxl.poo.data;

import java.util.ArrayList;

/**
 * Représente la bibliothèque
 * Définie par son nom, la liste des membres et la liste des livres.
 *  
 * @author C. Ruth
 * @version 0.1
 * @see Book
 * @see Person
 */
public class MyLibrary {
	/**
	 * Nom de la bibliothèque
	 */
	private String name;
	
	/**
	 * Liste des livres
	 */
	private ArrayList<Book> books;
	
	/**
	 * Liste des membres
	 */
	private ArrayList<Person> people;
	
	/**
	 * Crée une bibliothèque en spécifiant son nom
	 * 
	 * @param name Nom de la bibliothèque
	 */
	public MyLibrary(String name) {
		this.name = name;
		this.books = new ArrayList<Book>();
		this.people = new ArrayList<Person>();
	}

	/**
	 * Renvoie le nom de la bibliothèque
	 * 
	 * @return Le nom de la bibliothèque
	 */
	public String getName() {
		return name;
	}

	/**
	 * Modifie le nom de la bibliothèque
	 * 
	 * @param name Nouveau nom de la bibliothèque
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Renvoie la liste des livres
	 * 
	 * @return la liste des livres
	 */
	public ArrayList<Book> getBooks() {
		return books;
	}

	/**
	 * Renvoie la liste des membres
	 * 
	 * @return la liste des membres
	 */
	public ArrayList<Person> getPeople() {
		return people;
	}

	@Override
	public String toString() {
		final int maxLen = 3;
		return "MyLibrary " + name + ": books="
				+ (books != null ? books.subList(0, Math.min(books.size(), maxLen)) : null) + ", people="
				+ (people != null ? people.subList(0, Math.min(people.size(), maxLen)) : null);
	}


Profitons-en pour définir les methods qui permettront d’ajouter des livres et des membres : addBook et addPerson, ainsi que les méthodes d’affichages : printBooks et printMembers.
package be.iccbxl.poo.data;

import java.util.ArrayList;
import java.util.Iterator;


	public void addBook(Book book) {
		this.books.add(book);
	}

	public void addPerson(Person person) {
		this.people.add(person);
	}
	
	public int printBooks() {
		int cpt = 0;

		Iterator<Book> it = this.getBooks().iterator();
		
		while(it.hasNext()) {
			Book b = it.next();
								
			System.out.println(++cpt + ": " 
					+b.getTitle() + " - "
					+b.getAuthor());
		}
		return cpt;
	}



	public int printMembers() {
		int cpt = 0;

		Iterator<Person> itp = this.getPeople().iterator();
		
		while(itp.hasNext()) {
			Person p = itp.next();
			
			System.out.println(++cpt + ": " + p.getName());
		}
		return cpt;
	}


Nous pouvons charger des livres et des membres à partir de fichiers de sauvegarde au format CSV.
package be.iccbxl.poo.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.StringTokenizer;

	
	public int loadMembers(String filename) {
		int cpt = 0;
		
		File f = new File(filename);
		
		if(f.exists()) {
			FileReader fr = null;
			BufferedReader br = null;
			String[] data = null;
			
			try {
				try {
					fr = new FileReader(f);
					br = new BufferedReader(fr);

					//Convertir en objet Person
					//StringTokenizer st = new StringTokenizer(ligne, ";");
					String ligne = br.readLine();
					
					//Lire une ligne du fichier					
					while ((ligne = br.readLine()) != null) {
						//"a7aa0ae7-9ce3-44bc-a72a-894edb9a4653;Bob Smith;2;01-03-20"
						data = ligne.split(";");
						Person p = new Person(UUID.fromString(data[0]), data[1]);
						
						//ajouter cette Person dans people
						this.people.add(p);
						cpt++;
					}
				} finally {
					br.close();
				}
			} catch (IOException e) {
				
			}
			
			System.out.println(people);
		} 
		
		return cpt;
	}
}


Travaux pratiques
    Q1. Écrivez la méthode loadBooks() qui charge les livres à partir d’un fichier CSV, tel que members.csv.
    Q2. Écrivez les méthodes saveMembers() et saveBooks() qui enregistre la liste des membres et des livres, respectivement dans les fichiers members.csv et books.csv.
