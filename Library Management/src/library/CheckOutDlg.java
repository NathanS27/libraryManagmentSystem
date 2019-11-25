package library;

import javax.swing.*;
import BreezySwing.*;

public class CheckOutDlg extends GBDialog {
	
	JLabel titleLabel = addLabel("Title:", 1, 1, 1, 1);
	JTextField title = addTextField("", 1,2,1,1);
	
	JLabel borrowerLabel = addLabel("Borrower:", 2, 1, 1, 1);
	JTextField borrower = addTextField("", 2,2,1,1);
	
	JLabel dateLabel = addLabel("Date:(mm/dd/yyyy)", 3, 1, 1, 1);
	JTextField date = addTextField("", 3,2,1,1);
	
	JButton checkOut = addButton("Check Out", 4, 1, 1, 1);
	JButton cancelBtn = addButton("Cancel", 4, 2, 1, 1);
	
	JFrame parentClass= new JFrame();
	
	Catalog catalog;
	Date dateClass= new Date();
	
	public CheckOutDlg(JFrame parent, Catalog c) {
		super(parent);
		setTitle("Check Out");
		setDlgCloseIndicator("Cancel");
		setSize(300, 150);
		setLocationRelativeTo(null);
		catalog=c;
		date.setText(dateClass.today().toString());
		parentClass=parent;
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj==checkOut) {
			//TODO error check
			int bLocation=catalog.findBook(title.getText());
			if(bLocation!=-1) {
				Book b = catalog.getBook(bLocation);
				try {
				catalog.checkOut(bLocation, borrower.getText(),date.getText());
				dispose();
				}
				catch(ImproperFormatException e) {
					errorMsg(e.getLocalizedMessage());
				}
			}
			else {
				errorMsg("Book not found");
			}
		}
		else if(buttonObj==cancelBtn) {
			dispose();
		}
	}
	
	private void errorMsg(String str) {
		ErrorDlg display = new ErrorDlg(parentClass,str);
		display.setVisible(true);
	}
}


