package library;

import java.awt.Color;

import javax.swing.*;
import BreezySwing.*;

public class LibraryUI extends GBFrame{
	
	JLabel currentDate = addLabel("",									1, 1, 4, 1);
	JButton checkOut = addButton("Check Out", 							2, 1, 1, 2);
	JButton returnBook = addButton("Return", 							2, 2, 1, 2);
	JButton viewBooks = addButton("View Books", 						2, 3, 1, 2);
	JButton viewCheckedOutBooks = addButton("View Checked Out Books", 	2, 4, 1, 2);
	JButton viewOverdue = addButton("View Overdue", 					4, 1, 1, 2);
	JButton addBook = addButton("Add Book", 							4, 2, 1, 2);
	JButton search = addButton("Search", 								4, 3, 1, 2);
	JButton extraCredit = addButton("Extra Credit", 					4, 4, 1, 2);
		
	String[][] data;
	Catalog catalog = new Catalog();
	Date date = new Date();
	
	public LibraryUI() {
		currentDate.setText("Todays date: " + date.today().toString());
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj!=addBook&&catalog.getInventory().size()>0) {
			if(buttonObj == checkOut) {
				CheckOutDlg dlg = new CheckOutDlg(this,catalog);
				dlg.setVisible(true);
			}
			if(buttonObj == returnBook) {
				ReturnDlg dlg = new ReturnDlg(this,catalog);
				dlg.setVisible(true);
			}
			if(buttonObj == viewBooks) {
				DisplayDlg dlg = new DisplayDlg(this,"All Books", catalog.getInventory());
				dlg.setVisible(true);
				catalog.getInventory();
			}
			if(buttonObj == viewCheckedOutBooks) {
				try {
				DisplayDlg dlg = new DisplayDlg(this,"Checked Out", catalog.getCheckedOut());
				dlg.setVisible(true);
				catalog.getInventory();
				}
				catch(ImproperFormatException e) {
					errorMsg(e.getMessage());
				}
			}
			if(buttonObj == viewOverdue) {
				try {
				DisplayDlg dlg = new DisplayDlg(this,"Overdue", catalog.getOverdue());
				dlg.setVisible(true);
				catalog.getOverdue();
				}
				catch(ImproperFormatException e) {
					errorMsg(e.getMessage());
				}
			}
			if(buttonObj == search) {
				SearchDlg dlg = new SearchDlg(this,catalog);
				dlg.setVisible(true);
			}
			if(buttonObj == extraCredit) {
				ExtraCreditListDlg dlg = new ExtraCreditListDlg(this,catalog);
				dlg.setVisible(true);
			}
		}
		else if(buttonObj == addBook) {
			AddDlg dlg = new AddDlg(this, catalog);
			dlg.setVisible(true);
		}
		else {
			errorMsg("Library is Empty");
		}
	}
	
	public void listItemSelected (JList listObj){
		System.out.println("selected");
	}
	
	private void errorMsg(String str) {
		ErrorDlg display = new ErrorDlg(this,str);
		display.setVisible(true);
	}
	
	public static void main(String[] args) {
		JFrame frm = new LibraryUI();
		frm.setSize(700, 120);
		frm.setTitle("Nathan's Library");
		frm.getContentPane().setBackground(Color.ORANGE);
		frm.setResizable(true);
		frm.setVisible(true);
		frm.setLocationRelativeTo(null);
	}
	
	
}