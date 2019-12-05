package library;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.*;

import BreezySwing.*;

public class ExtraCreditDlg extends GBDialog {
	
	JPanel dataLayout = addPanel(1,1,3,2);
	JTable dataTable = null;
	DefaultTableModel dataModel = null;
	
	JButton checkOut = addButton("Check Out",3,2,1,1);
	JButton returnBtn = addButton("Return",3,2,1,1);
	JButton back = addButton("Back",3,3,1,1);
	
	Catalog catalog;
	Book book;
	JFrame parentFrame;
	
	public ExtraCreditDlg(JFrame parent,Book b,Catalog c) {
		super(parent);
		setTitle(b.getTitle());
		setDlgCloseIndicator("Close");
		setSize(800, 120);
		setLocationRelativeTo(null);
		catalog=c;
		book = b;
		parentFrame=parent;
		createTable();
		displayBook(b);
		if(b.isAvailable()) {
			returnBtn.setVisible(false);
		}
		else {
			checkOut.setVisible(false);
		}
	}
	
	private void createTable() {
		String[] columnNames = {"Title", "Author", "Status","Borrower", "Checked Out","Due Date"};
		String[][] data = {{"","","","","",""}};

		// Set the layout mode of the data panel
		dataLayout.setLayout(new BorderLayout());
		
		// Create the placeholder table and put it in a scroll pane
		dataTable = new JTable (data,columnNames);
		dataModel = new DefaultTableModel();
		dataModel.setColumnIdentifiers(columnNames);
        dataTable.setModel(dataModel);
        
        //sets the alignment
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        dataTable.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        dataTable.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        dataTable.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        dataTable.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        dataTable.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
     

		// Add the scrollPane to the panel and put it in the center so it uses the full panel
		JScrollPane scrollPane = new JScrollPane(dataTable);
		dataLayout.add(scrollPane,BorderLayout.CENTER);
		dataTable.disable();
	}
	
	private void displayBook(Book b) {
		String[] dataRow = new String[6];
		dataRow[0] = b.getTitle();
		dataRow[1] = b.getAuthor();
		dataRow[2] = statusCheck(b.isAvailable());
		if(!b.isAvailable()) {
			dataRow[3] = b.getBorrower();
			dataRow[4] = b.getCheckOutDate().toString();
			dataRow[5] = overdueFormat(b.isOverdue(),b);
		}
		
		dataModel.addRow(dataRow);
	}
	
	private String statusCheck(Boolean b) {
		if(b) {
			return "<html> <font color='green'> AVAILABLE</font> </html>";
		}
		else if(book.getCheckOutDate().today().isLessThan(book.getCheckOutDate())) {
			return "<html> <font color='red'> ON HOLD </font> </html>";
		}
		else if(book.isOverdue()) {
			return "<html> <font color='red'> OVERDUE</font> </html>";
		}
		else {
			return "<html> <font color='red'> CHECKED OUT</font> </html>";
		}
	}
	
	private String overdueFormat(Boolean b, Book inputBook) {
		if(b) {
			return String.format("<html> <font color='red'> %s</font> </html>",inputBook.getDueDate().toString());
		}
		return inputBook.getDueDate().toString();
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == checkOut) {
			dispose();
			CheckOutDlg dlg = new CheckOutDlg(parentFrame,catalog,book);
			dlg.setVisible(true);
		}
		if(buttonObj == returnBtn) {
			book.setBorrower(null);
			dispose();
			ExtraCreditListDlg dlg = new ExtraCreditListDlg(parentFrame,catalog);
			dlg.setVisible(true);
			
		}
		if(buttonObj==back) {
			dispose();
			ExtraCreditListDlg dlg = new ExtraCreditListDlg(parentFrame,catalog);
			dlg.setVisible(true);
		}
	}
}
