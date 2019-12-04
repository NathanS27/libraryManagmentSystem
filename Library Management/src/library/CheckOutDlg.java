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
	
	private int type;
	
	Catalog catalog;
	Book book;
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
		type=0;
	}
	
	public CheckOutDlg(JFrame parent, Catalog c,Book b) {
		super(parent);
		setTitle("Check Out");
		setDlgCloseIndicator("Cancel");
		setSize(300, 150);
		setLocationRelativeTo(null);
		catalog=c;
		book=b;
		date.setText(dateClass.today().toString());
		parentClass=parent;
		title.setText(b.getTitle());
		title.disable();
		borrower.requestFocus();
		type=1;
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj==checkOut) {
			try {
				errorCheck();
				if(type==0) {
					int bLocation=catalog.findBook(title.getText().trim(),true);
					//if the book is not found
					if((bLocation!=-1)) {
						if(catalog.getInventory().get(bLocation).isAvailable()) {
							catalog.checkOut(bLocation, borrower.getText(),date.getText());
							dispose();
						}
						else {
							errorMsg("Book is already checked out");
							resetInputs();
						}	
					}
					else {
						resetInputs();
						errorMsg("Book not found");
					}
				}
				else {
					book.setBorrower(borrower.getText());
					book.setCheckOutDate(new Date(date.getText()));
					dispose();
					ExtraCreditListDlg dlg = new ExtraCreditListDlg(parentClass,catalog);
					dlg.setVisible(true);
				}
			}
			catch(ImproperFormatException e) {
					date.setText(dateClass.today().toString());
					errorMsg(e.getLocalizedMessage());
			}
		}
		else if(buttonObj==cancelBtn) {
			dispose();
			if(type ==1) {
				ExtraCreditListDlg dlg = new ExtraCreditListDlg(parentClass,catalog);
				dlg.setVisible(true);
			}
		}
	}
	
	private void errorCheck() throws ImproperFormatException{
		if(title.getText().trim().isEmpty()) {
			throw new ImproperFormatException("MUST ENTER TITLE");
		}
		if(borrower.getText().trim().isEmpty()) {
			throw new ImproperFormatException("MUST ENTER NAME");
		}
		if(date.getText().trim().isEmpty()) {
			date.setText(dateClass.today().toString());
			throw new ImproperFormatException("MUST ENTER DATE");
		}
	}
	
	private void errorMsg(String str) {
		ErrorDlg display = new ErrorDlg(parentClass,str);
		display.setVisible(true);
	}
	
	private void resetInputs() {
		title.setText("");
		borrower.setText("");
		date.setText(dateClass.today().toString());
	}
}