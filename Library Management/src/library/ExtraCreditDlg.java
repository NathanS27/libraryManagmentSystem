package library;

import javax.swing.*;
import BreezySwing.*;

public class ExtraCreditDlg extends GBDialog {
	
	private String[] bookInfo;
	
	JList bookList = addList(1,1,1,1);
	
	

	public ExtraCreditDlg(JFrame parent,Catalog b) {
		super(parent);
		setTitle("Search");
		setDlgCloseIndicator("Close");
		setSize(500, 500);
		setLocationRelativeTo(null);
		bookInfo = new String[b.getInventory().size()];
		int i=0;
		for(Book temp: b.getInventory()) {
			bookInfo[i++]=temp.displayBook();
		}
		bookList.setListData(bookInfo);
	}
}