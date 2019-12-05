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
	
	public ReturnDlg(JFrame parent,Catalog c) throws ImproperFormatException {
		super(parent);
		setTitle("Return");
		setDlgCloseIndicator("Cancel");
		setSize(300, 100);
		setLocationRelativeTo(null);
		catalog = c;
		parentClass=parent;
		if(catalog.getCheckedOut().size()<1) {
			throw new ImproperFormatException("No checked out books");
		}
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj==returnButton) {
			try {
			errorCheck();
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
				
				errorMsg("Book not found/checked out");
			}
			}
			catch(ImproperFormatException e) { 
				errorMsg(e.getMessage());
			}
			catch(Why w) {
				dispose();
				messageBox(w.getMessage());
				
			}
			
			
				
		}
		else if(buttonObj==cancelBtn) {
			dispose();
		}
		
	}
	
	private void errorCheck() throws ImproperFormatException,Why{
		if(title.getText().trim().isEmpty()) {
			throw new ImproperFormatException("MUST ENTER TITLE");
		}
		if(catalog.search(title.getText()).size()>1) {
			throw new Why("There is another copy of this book signed out. \n"
					+ "Please use the extra credit button for optimal results"
					+ "\nThanks :)");
		}
	}
	
	private void errorMsg(String str) {
		ErrorDlg display = new ErrorDlg(parentClass,str);
		display.setVisible(true);
	}
}