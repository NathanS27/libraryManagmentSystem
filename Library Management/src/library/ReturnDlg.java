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
		setTitle("Check Out");
		setDlgCloseIndicator("Cancel");
		setSize(300, 100);
		setLocationRelativeTo(null);
		catalog = c;
		parentClass=parent;
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj==returnButton) {
			//TODO error check
			int bLocation=catalog.findBook(title.getText());
			if(bLocation!=-1) {
				try {
				catalog.returnbook(bLocation);
				}
				catch(ImproperFormatException e) { 
					//this will never occur as it gets set to Null during returnBook 
				}
			}
			else {
				errorMsg("Book not found");
			}
			dispose();	
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

