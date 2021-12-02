import java.awt.*;

import javax.swing.*;
import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.*;
class AddLibrarian extends JFrame implements ActionListener
{
	JFrame frame;
	JLabel label, l1,l2,l3,l4,l5,l6,l7;
	JPasswordField t2;
	JButton b1,b2;
	JTextField t1,t3,t4,t5,t6;
	Connection con=null;
	AddLibrarian(){
		con=(Connection)DB.dbconnect();
		frame = new JFrame();
		label = new JLabel();
		l1 = new JLabel("ADD LIBRARIAN");
		l2 = new JLabel("Name : ");
		l3 = new JLabel("Password : ");
		l4 = new JLabel("E-mail : ");
		l5 = new JLabel("Address : ");
		l6 = new JLabel("City : ");
		l7 = new JLabel("Contact No. : ");
		t1 = new JTextField();
		t2 = new JPasswordField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();
		t6 = new JTextField();
		b1 = new JButton("Add Librarian");
		
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String name = t1.getText();
					String password = String.valueOf(t2.getPassword());
					String email = t3.getText();
					String address = t4.getText();
					String city = t5.getText();
					String contactNo = t6.getText();
					
					PreparedStatement pst = con.prepareStatement("insert into librarian(name,password,email,address,city,contactNo) values(?,?,?,?,?,?)");
					pst.setString(1, name);
					pst.setString(2, password);
					pst.setString(3, email);
					pst.setString(4, address);
					pst.setString(5, city);
					pst.setString(6, contactNo);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Librarian added successfully!!!");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					t6.setText("");
				
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			
			
			
		}});
		b2 = new JButton("Back");
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				new AdminSection();
			
			
		}});
		
		
		
		
		
		l1.setBounds(250,20,200,30);
		l2.setBounds(50,70,150,20);
		l3.setBounds(50,110,150,20);
		l4.setBounds(50,150,150,20);
		l5.setBounds(50,190,150,20);
		l6.setBounds(50,230,150,20);
		l7.setBounds(50,270,150,20);
		t1.setBounds(250,70,150,20);
		t2.setBounds(250,110,150,20);
		t3.setBounds(250,150,150,20);
		t4.setBounds(250,190,150,20);
		t5.setBounds(250,230,150,20);
		t6.setBounds(250,270,150,20);
		b1.setBounds(200,330,200,40);
		b2.setBounds(220,400,150,40);
		
		label.add(b1);
		label.add(b2);
		label.add(l1);
		label.add(l2);
		label.add(l3);
		label.add(l4);
		label.add(l5);
		label.add(l6);
		label.add(l7);
		label.add(t1);
		label.add(t2);
		label.add(t3);
		label.add(t4);
		label.add(t5);
		label.add(t6);
		
		frame.add(label);
		frame.setTitle("Add Librarian-Library Management System");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	
}