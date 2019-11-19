package library;

import java.util.*;

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
	
	public ArrayList<Book> getOverdue(){
		ArrayList<Book> overdue = new ArrayList<Book>();;
		for(int i=0;i<inventory.size();i++) {
			if(!inventory.get(i).getStatus()) {
				overdue.add(inventory.get(i));
			}
		}
		return overdue;
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
	
	public void checkOut(int i, String borrower,String inputDate) {
		inventory.get(i).setStatus(false);
		inventory.get(i).setBorrower(borrower);
		inventory.get(i).setCheckOutDate(inputDate);
		//TODO: set due date
	}
	
	public void returnbook(int i) {
		inventory.get(i).setStatus(true);
		inventory.get(i).setBorrower(null);
		inventory.get(i).setDueDate(null);;
	}
}

