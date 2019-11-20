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
	
	Catalog catalog;
	
	public AddDlg(JFrame parent, Catalog c) {
		super(parent);
		setTitle("Check Out");
		setDlgCloseIndicator("Cancel");
		setSize(300, 100);
		setLocationRelativeTo(null);
		catalog=c;
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj==addNewBook) {
			//TODO error check
			catalog.addBook(title.getText(), author.getText());
			}
			dispose();
		}
}


