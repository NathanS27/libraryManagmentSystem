package library;

import java.util.*;
import BreezySwing.*;

public class Catalog {
	
	private ArrayList<Book> inventory;
	
	public Catalog() {
		inventory = new ArrayList<Book>();
		inventory.add(new Book("Cat In The Hat","Dr. Seuss"));
		inventory.add(new Book("TEST","TESTER"));
		inventory.add(new Book("The Grapes Of Wrath","John Steinbeck"));
		inventory.add(new Book("To Kill A Mockingbird","Harper Lee"));
		inventory.add(new Book("Webster’s Dictionary","Webster"));
	}
	
	public ArrayList<Book> getInventory() {
		return inventory;	
	}
	
	public ArrayList<Book> getOverdue() throws ImproperFormatException{
		ArrayList<Book> overdue = new ArrayList<Book>();;
		for(int i=0;i<inventory.size();i++) {
			if(inventory.get(i).isOverdue()) {
				overdue.add(inventory.get(i));
			}
		}
		return overdue;
	}
	
	public void addBook(String title, String author) {
		inventory.add(new Book(title,author));
	}
	
	public int findBook(String title) {
		for(int i=0;i<inventory.size();i++) { 
			if(title.equals(inventory.get(i).getTitle())) {
				return i;
			}
		}
		return -1;
	}
	
	public Book getBook(int i) {
		return inventory.get(i);
	}
	
	public void checkOut(int i, String borrower,String inputDate)throws ImproperFormatException{
		inventory.get(i).setStatus(false);
		inventory.get(i).setBorrower(borrower);
		System.out.println(inputDate);
		inventory.get(i).setCheckOutDate(new Date(inputDate));
	}
	
	public void returnbook(int i)throws ImproperFormatException {
		inventory.get(i).setStatus(true);
		inventory.get(i).setBorrower(null);
	}

//	private boolean isOverdue(Book b) {
//		int[] start = b.
//	}
}


