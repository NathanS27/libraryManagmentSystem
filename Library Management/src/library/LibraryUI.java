package library;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;
import BreezySwing.*;

public class LibraryUI extends GBFrame{
	
	JButton checkOut = addButton("Check Out", 2, 1, 1, 2);
	JButton returnBook = addButton("Return", 2, 2, 1, 2);
	JButton viewBooks = addButton("View Books", 2, 3, 1, 2);
	JButton viewOverdue = addButton("View Overdue", 2, 4, 1, 2);
	
	String[][] data;
	Catalog catalog = new Catalog();
	
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
	}
	
	public static void main(String[] args) {
		JFrame frm = new LibraryUI();
		frm.setSize(500, 80);
		frm.setTitle("Nathan's Library");
		frm.getContentPane().setBackground(Color.ORANGE);
		frm.setResizable(true);
		frm.setVisible(true);
		frm.setLocationRelativeTo(null);
	}
}


