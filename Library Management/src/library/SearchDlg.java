package library;

import java.util.ArrayList;

import javax.swing.*;
import BreezySwing.*;

public class SearchDlg extends GBDialog {

	JLabel titleLabel = addLabel("Title:", 1, 1, 1, 1);
	JTextField title = addTextField("", 1,2,1,1);
	
	JButton search = addButton("Search", 4, 1, 1, 1);
	JButton cancelBtn = addButton("Cancel", 4, 2, 1, 1);
	
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
		if(buttonObj==search) {
			if(catalog.search(title.getText()).size()>0) {
				for(Book temp : catalog.search(title.getText())) {
					displayBook.add(temp);
				}
				displayBook();
				dispose();
			}
			else {
				errorMsg("Book not found");
			}
		}
		if(buttonObj==cancelBtn) {
			dispose();
		}	
	}
	
	private void displayBook() {
		DisplayDlg dlg = new DisplayDlg(main,"All Books", displayBook);
		dlg.setVisible(true);
	}
	
	private void errorMsg(String str) {
		ErrorDlg display = new ErrorDlg(main,str);
		display.setVisible(true);
	}
}