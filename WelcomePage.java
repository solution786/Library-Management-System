import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;
class WelcomePage extends JFrame implements ActionListener 
{
	JFrame frame;
	JLabel label;
	JButton b1, b2;
	WelcomePage(){
		frame = new JFrame();
		label = new JLabel();
		b1 = new JButton("Admin Login");
		b2 = new JButton("Librarian Login");
		b1.setBounds(100,50,200,50);
		b2.setBounds(100,150,200,50);
		b1.addActionListener(this);
		b2.addActionListener(this);
		label.add(b1);
		label.add(b2);
		frame.add(label);
		frame.setResizable(false);
		frame.setTitle("Welcome-Library Management System");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
	
	}
	
	public WelcomePage(String s){
		super(s);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == b1)
		{
			frame.dispose();
			new AdminLoginPage();
		}
		if(e.getSource() == b2)
		{
			frame.dispose();
			new LibrarianLoginPage();
		}
	}	
}

