import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;
class LibrarianSection extends JFrame implements ActionListener{
	JFrame frame;
	JLabel label, l1;
	JButton b1,b2,b3,b4,b5,b6;
	LibrarianSection(){
		frame = new JFrame();
		label = new JLabel();
		l1 = new JLabel("LIBRARIAN SECTION");
		b1 = new JButton("Add Book");
		b2 = new JButton("View Book");
		b3 = new JButton("Issue Book");
		b4 = new JButton("View Issued Books");
		b5 = new JButton("Return Book");
		b6 = new JButton("Logout");
		l1.setBounds(250,20,200,60);
		b1.setBounds(200,100,200,50);
		b2.setBounds(200,180,200,50);
		b3.setBounds(200,250,200,50);
		b4.setBounds(200,330,200,50);
		b5.setBounds(200,400,200,50);
		b6.setBounds(200,470,200,50);
		b1.addActionListener(this);
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new viewBooks();	
		}});
		

		b3.addActionListener(this);
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new viewIssuedBooks();	
		}});
		b5.addActionListener(this);
		b6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null,"Logout Successful!!!");
				frame.setVisible(false);
				new WelcomePage();
			}});
		label.add(l1);
		label.add(b1);
		label.add(b2);
		label.add(b3);
		label.add(b4);
		label.add(b5);
		label.add(b6);
		frame.add(label);
		frame.setTitle("Librarian Section-Library Management System");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == b1)
		{
			frame.dispose();
			new AddBooks();
		}
		
		if(e.getSource() == b3)
		{
			frame.dispose();
			new IssueBook();
		}
		if(e.getSource() == b5)
		{
			frame.dispose();
			new ReturnBook();
		}
	}
	

}
