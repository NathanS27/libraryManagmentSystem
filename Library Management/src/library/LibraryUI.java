package library;

import java.awt.Color;

import javax.swing.*;
import BreezySwing.*;

public class LibraryUI extends GBFrame{
	
	JLabel currentDate = addLabel("",1,1,1,1);
	JButton checkOut = addButton("Check Out", 2, 1, 1, 2);
	JButton returnBook = addButton("Return", 2, 2, 1, 2);
	JButton viewBooks = addButton("View Books", 2, 3, 1, 2);
	JButton viewOverdue = addButton("View Overdue", 2, 4, 1, 2);
	JButton addBook = addButton("Add Book", 2, 5, 1, 2);
	
	
	String[][] data;
	Catalog catalog = new Catalog();
	Date date = new Date();
	
	public LibraryUI() {
		currentDate.setText("Todays date: " + date.getCurrentDate());
	}
	
	public void buttonClicked(JButton buttonObj) {
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
		if(buttonObj == viewOverdue) {
			DisplayDlg dlg = new DisplayDlg(this,"Overdue", catalog.getOverdue());
			dlg.setVisible(true);
			catalog.getOverdue();
		}
		if(buttonObj == addBook) {
			AddDlg dlg = new AddDlg(this, catalog);
			dlg.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		JFrame frm = new LibraryUI();
		frm.setSize(600, 90);
		frm.setTitle("Nathan's Library");
		frm.getContentPane().setBackground(Color.ORANGE);
		frm.setResizable(true);
		frm.setVisible(true);
		frm.setLocationRelativeTo(null);
	}
}



