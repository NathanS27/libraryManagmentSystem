  package library;

import java.util.*;
import BreezySwing.*;

public class Catalog {
	
	private ArrayList<Book> inventory;
	
	public Catalog() {
		inventory = new ArrayList<Book>();
	}
	
	public ArrayList<Book> getInventory() {
		return inventory;	
	}
	
	public ArrayList<Book> getOverdue() throws ImproperFormatException{
		ArrayList<Book> overdue = new ArrayList<Book>();;
		for(int i=0;i<inventory.size();i++) {
			//if it is checked out
			if(!inventory.get(i).isAvailable()) {
				//if it is overdue
				if(inventory.get(i).isOverdue()) {
					overdue.add(inventory.get(i));
				}
			}
		}
		return overdue;
	}
	
	public ArrayList<Book> getCheckedOut() {
		ArrayList<Book> checkedOut = new ArrayList<Book>();;
		for(int i=0;i<inventory.size();i++) {
			//if it is checked out
			if(!inventory.get(i).isAvailable()) {
					checkedOut.add(inventory.get(i));
			}
		}
		return checkedOut;
	}
	
	public ArrayList<Book> search(String str){
		ArrayList<Book> searchResults = new ArrayList<Book>();;
		for(int i=0;i<inventory.size();i++) {
			if(inventory.get(i).getTitle().toLowerCase().contains(str.toLowerCase())) {
				searchResults.add(inventory.get(i));
			}
		}
		return searchResults;
	}
	
	
	
	public void addBook(String title, String author) {
		inventory.add(new Book(title,author));
	}
	
	public int findBook(String title,boolean type) {
		//Availability defines if it wants a checked out book or not
		if(type) {
			for(int i=0;i<inventory.size();i++) { 
				if((title.toLowerCase().equals(inventory.get(i).getTitle().toLowerCase()))&&(inventory.get(i).isAvailable())) {
					return i;
				}
			}
		}
		else {
			for(int i=0;i<inventory.size();i++) { 
				if((title.toLowerCase().equals(inventory.get(i).getTitle().toLowerCase()))&&(!inventory.get(i).isAvailable())) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public Book getBook(int i) {
		return inventory.get(i);
	}
	
	public void checkOut(int i, String borrower,String inputDate) throws ImproperFormatException{
		inventory.get(i).setBorrower(borrower);
		inventory.get(i).setCheckOutDate(new Date(inputDate));
	}
	
	public void returnbook(int i)throws ImproperFormatException {
		inventory.get(i).setBorrower(null);
	}
}