package library;

import java.util.ArrayList;

import javax.swing.*;
import BreezySwing.*;

public class SearchDlg extends GBDialog {

	JLabel titleLabel = addLabel("Title:", 1, 1, 1, 1);
	JTextField search = addTextField("", 1,2,2,1);
	
	JButton searchBtn = addButton("Search", 4, 1, 1, 1);
	JButton closeBtn = addButton("Close", 4, 3, 1, 1);
	
	private ArrayList<Book> displayBook = new ArrayList<Book>();
	
	JFrame main;
	Catalog catalog;
	
	public SearchDlg(JFrame parent, Catalog c) {
		super(parent);
		setTitle("Search");
		setDlgCloseIndicator("Cancel");
		setSize(300, 100);
		setLocationRelativeTo(null);
		catalog=c;
		main = parent;
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj==searchBtn) {
			if(catalog.search(search.getText()).size()>0) {
				displayBook.clear();
				for(Book temp : catalog.search(search.getText())) {
					displayBook.add(temp);
				}
				displayBook();
				search.setText("");
			}
			else {
				errorMsg("Book not found");
			}
		}
		if(buttonObj==closeBtn) {
			dispose();
		}	
	}
	
	private void displayBook() {
		try {
		DisplayDlg dlg = new DisplayDlg(main,"All Books", displayBook);
		dlg.setVisible(true);
		}
		catch(ImproperFormatException e) {
			//will never get here so he's ignored
		}
	}
	
	private void errorMsg(String str) {
		ErrorDlg display = new ErrorDlg(main,str);
		display.setVisible(true);
	}
}