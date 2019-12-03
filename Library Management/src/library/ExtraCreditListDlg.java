package library;

import javax.swing.*;
import BreezySwing.*;

public class ExtraCreditListDlg extends GBDialog {
	
	private String[] bookInfo;
	
	JList bookList = addList(1,1,1,1);
	JButton close = addButton("Close",2,1,1,1);
	JFrame parentClass;
	Catalog catalog;
	
	
	public void listItemSelected (JList listObj){
		int index = bookList.getSelectedIndex();
		// if something is actually selected
		if (index >= 0){  
			dispose();
			ExtraCreditDlg dlg = new ExtraCreditDlg(parentClass,catalog.getBook(index),catalog);
			dlg.setVisible(true);
			
		}
	}
		
	public void listDoubleClicked(JList listObj,String itemClicked) {
		System.out.println("DOUBLE CLICKED");
	}

	public void buttonClicked(JButton buttonObj) {
			dispose();
		}
	
	public ExtraCreditListDlg(JFrame parent,Catalog b) {
		super(parent);
		setTitle("Nathan's Library");
		setDlgCloseIndicator("Close");
		setSize(500, 500);
		setLocationRelativeTo(null);
		parentClass=parent;
		catalog=b;
		bookInfo = new String[catalog.getInventory().size()];
		DefaultListModel model = (DefaultListModel) bookList.getModel();
		int i=0;
		for(Book temp: catalog.getInventory()) {
		model.addElement(temp.displayBook());
		}
		bookList.setSelectedIndex(bookList.getLastVisibleIndex());
		listItemSelected(bookList);
	}
}