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
	
	public ArrayList<Book> getCheckedOut() throws ImproperFormatException{
		ArrayList<Book> checkedOut = new ArrayList<Book>();;
		for(int i=0;i<inventory.size();i++) {
			//if it is checked out
			if(!inventory.get(i).isAvailable()) {
					checkedOut.add(inventory.get(i));
			}
		}
		return checkedOut;
	}
	
	public void addBook(String title, String author) {
		inventory.add(new Book(title,author));
	}
	
	public int findBook(String title) {
		for(int i=0;i<inventory.size();i++) { 
			if(title.toLowerCase().equals(inventory.get(i).getTitle().toLowerCase())) {
				return i;
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