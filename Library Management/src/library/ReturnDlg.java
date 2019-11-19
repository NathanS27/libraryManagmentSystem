package library;

import javax.swing.*;
import BreezySwing.*;

public class ReturnDlg extends GBDialog {
	
	JLabel titleLabel = addLabel("Title:", 1, 1, 1, 1);
	JTextField title = addTextField("", 1,2,1,1);
	
	JButton returnButton = addButton("Return", 4, 1, 1, 1);
	JButton cancelBtn = addButton("Cancel", 4, 2, 1, 1);
	
	Catalog catalog;
	
	public ReturnDlg(JFrame parent,Catalog c) {
		super(parent);
		setTitle("Check Out");
		setDlgCloseIndicator("Cancel");
		setSize(300, 100);
		setLocationRelativeTo(null);
		catalog = c;
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj==returnButton) {
			//TODO error check
			int bLocation=catalog.findBook(title.getText());
			if(bLocation!=-1) {
				Book b = catalog.getBook(bLocation);
				catalog.returnbook(bLocation);
			}
			else {
				//TODO throw error
				System.out.println("ERROR");
			}
			dispose();
		}
	}
}