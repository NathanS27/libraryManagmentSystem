package library;

import javax.swing.*;
import BreezySwing.*;

public class AddDlg extends GBDialog {

	JLabel titleLabel = addLabel("Title:", 1, 1, 1, 1);
	JTextField title = addTextField("", 1,2,1,1);
	
	JLabel authorLabel = addLabel("Author:", 2, 1, 1, 1);
	JTextField author = addTextField("", 2,2,1,1);
	
	JButton addNewBook = addButton("Add Book", 4, 1, 1, 1);
	JButton cancelBtn = addButton("Cancel", 4, 2, 1, 1);
	JButton populate = addButton("Populate Library", 4, 3, 1, 1);
	
	static Integer populateButton = 0;
	
	JFrame parentClass;
	Catalog catalog;
	
	public AddDlg(JFrame parent, Catalog c) {
		super(parent);
		setTitle("Add Book");
		setDlgCloseIndicator("Cancel");
		setSize(400, 200);
		setLocationRelativeTo(null);
		catalog=c;
		parentClass=parent;
		if(populateButton>0) {
			populate.setVisible(false);
		}
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj==addNewBook) {
			try {
			errorCheck();
			catalog.addBook(title.getText(),author.getText());
			dispose();
			}
			catch(ImproperFormatException e) {
				errorMsg(e.getMessage());
			}
		}
		if(buttonObj==populate) {
			//only allows the user to populate the library once
			populate();
			populateButton++;
			dispose();
		}
		else {
			dispose();
		}
	}
	
	private void errorCheck() throws ImproperFormatException {
		if(title.getText().trim().isEmpty()) {
			throw new ImproperFormatException("MUST ENTER TITLE");
		}			
		if(author.getText().trim().isEmpty()) {
			throw new ImproperFormatException("MUST ENTER NAME");
		}
	}
	
	private void errorMsg(String str) {
		ErrorDlg display = new ErrorDlg(parentClass,str);
		display.setVisible(true);
	}
	
	private void populate() {
		catalog.addBook("Cat In The Hat","Dr. Seuss");
		catalog.addBook("Cat In The Hat","Dr. Seuss");
		catalog.addBook("The Grapes Of Wrath","John Steinbeck");
		catalog.addBook("To Kill A Mockingbird","Harper Lee");
		catalog.addBook("Webster�s Dictionary","Webster");
		try {
		catalog.checkOut(0, "Keefer", new Date().today().toString());
		catalog.checkOut(1, "Me","1/12/1999");
		catalog.checkOut(2, "Mr.Geary","2/27/2025");		
		}
		catch(ImproperFormatException e) {
			
		}
	}
}