package library;

import javax.swing.*;
import BreezySwing.*;

public class CheckOutDlg extends GBDialog {
	
	JLabel titleLabel = addLabel("Title:", 1, 1, 1, 1);
	JTextField title = addTextField("", 1,2,1,1);
	
	JLabel borrowerLabel = addLabel("Borrower:", 2, 1, 1, 1);
	JTextField borrower = addTextField("", 2,2,1,1);
	
	JLabel dateLabel = addLabel("Date:", 3, 1, 1, 1);
	JTextField date = addTextField("", 3,2,1,1);
	
	JButton checkOut = addButton("Check Out", 4, 1, 1, 1);
	JButton cancelBtn = addButton("Cancel", 4, 2, 1, 1);
	
	Catalog catalog;
	
	public CheckOutDlg(JFrame parent, Catalog c) {
		super(parent);
		setTitle("Check Out");
		setDlgCloseIndicator("Cancel");
		setSize(300, 150);
		setLocationRelativeTo(null);
		catalog=c;
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj==checkOut) {
			//TODO error check
			int bLocation=catalog.findBook(title.getText());
			if(bLocation!=-1) {
				Book b = catalog.getBook(bLocation);
				catalog.checkOut(bLocation, borrower.getText(),date.getText());
			}
			else {
				//TODO throw error
				System.out.println("ERROR");
			}
			dispose();
		}
	}
}
