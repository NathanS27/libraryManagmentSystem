package library;

import java.awt.Color;
import javax.swing.*;
import BreezySwing.*;

//this class allows me to have a pop up error message box that centers itself

public class ErrorDlg extends GBDialog {
	
	JLabel display = addLabel("",1,1,1,1);
	JButton close = addButton("CLOSE",2,1,1,1);
	
	public ErrorDlg(JFrame parent,String message) {
		super(parent);
		setTitle("ERROR");
		getContentPane().setBackground(Color.RED.brighter().brighter());
		setDlgCloseIndicator("Close");
		setSize(400, 100);
		setLocationRelativeTo(null);
		display.setText(String.format("<html><font color='white'>%s</font></html>", message));
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj==close) {
			dispose();
		}
	}
}
