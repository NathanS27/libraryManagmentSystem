package library;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import BreezySwing.*;

public class ErrorDlg extends GBDialog {
	
	JLabel display = addLabel("",1,1,1,1);
	
	public ErrorDlg(JFrame parent,String message) {
		super(parent);
		setTitle("ERROR");
		
		getContentPane().setBackground(Color.RED);
		setDlgCloseIndicator("Close");
		setSize(400, 100);
		setLocationRelativeTo(null);
		display.setText(message);
	}
}
