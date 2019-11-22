package library;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BreezySwing.*;

import java.awt.BorderLayout;
import java.util.*;

public class DisplayDlg extends GBDialog {

	private ArrayList<Book> arrayList;
	
	JPanel dataLayout = addPanel(1,2,1,1);
	JTable dataTable = null;
	DefaultTableModel dataModel = null;
	
	JButton close = addButton("Close", 4, 2, 1, 1);
	
	public DisplayDlg(JFrame parent,String type,ArrayList<Book> list) {
		super(parent);
		setTitle(type);
		setDlgCloseIndicator("Close");
		setSize(900, 400);
		setLocationRelativeTo(null);
		arrayList=list;
		createTable();
		printList(list);
	}
	
	private void printList(ArrayList<Book> list) {
		for(int i=0;i<list.size();i++) {
			displayBook(list.get(i));
			
		}
	}
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj==close) {
			dispose();
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
	
	private String statusCheck(Boolean b) {
		if(b) {
			return "<html> <font color='green'> AVAILABLE</font> </html>";
		}
		return "<html> <font color='red'> CHECKED OUT</font> </html>";
	}
	
	private void displayBook(Book b) {
		String[] dataRow = new String[6];
		dataRow[0] = b.getTitle();
		dataRow[1] = b.getAuthor();
		dataRow[2] = statusCheck(b.getStatus());
		if(!b.getStatus()) {
			dataRow[3] = b.getBorrower();
			dataRow[4] = b.getDate().getStartDate();
			dataRow[5] = b.getDate().getDueDate();
		}
		
		dataModel.addRow(dataRow);
	}
}


