package library;

import javax.swing.*;
import BreezySwing.*;

public class ReturnDlg extends GBDialog {
	
	JLabel titleLabel = addLabel("Title:", 1, 1, 1, 1);
	JTextField title = addTextField("", 1,2,1,1);
	
	JButton returnButton = addButton("Return", 4, 1, 1, 1);
	JButton cancelBtn = addButton("Cancel", 4, 2, 1, 1);
	
	JFrame parentClass= new JFrame();
	Catalog catalog;
	
	public ReturnDlg(JFrame parent,Catalog c) {
		super(parent);
		setTitle("Return");
		setDlgCloseIndicator("Cancel");
		setSize(300, 100);
		setLocationRelativeTo(null);
		catalog = c;
		parentClass=parent;
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj==returnButton) {
			try {
			errorCheck();
			}
			catch(ImproperFormatException e) { 
				errorMsg(e.getMessage());
			}
			int bLocation=catalog.findBook(title.getText(),false);
			if((bLocation!=-1)&&(!catalog.getBook(bLocation).isAvailable())) {
				try {
				catalog.returnbook(bLocation);
				}
				catch(ImproperFormatException e) { 
					//this will never occur as it gets set to Null during returnBook 
				}
				dispose();
			}
			else {
				if(catalog.getBook(bLocation).isAvailable()) {
					errorMsg("Book was not checked out");
				}
				else {
				errorMsg("Book not found");
				}
			}
				
		}
		else if(buttonObj==cancelBtn) {
			dispose();
		}
		
	}
	
	private void errorCheck() throws ImproperFormatException{
		if(title.getText().trim().isEmpty()) {
			throw new ImproperFormatException("MUST ENTER TITLE");
		}
	}
	
	private void errorMsg(String str) {
		ErrorDlg display = new ErrorDlg(parentClass,str);
		display.setVisible(true);
	}
}