package library;

import java.awt.Color;
import javax.swing.*;
import BreezySwing.*;

public class SearchDlg extends GBDialog {
	
	private Catalog Books;
	private JList<Book> bookArrayList;
	
	JList bookList = addList(1,1,1,1);
	
	public SearchDlg(JFrame parent,Catalog b) {
		super(parent);
		setTitle("Search");
		setDlgCloseIndicator("Close");
		setSize(400, 100);
		setLocationRelativeTo(null);
		Books=b;
	}
}