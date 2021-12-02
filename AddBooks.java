import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.*;
class AddBooks extends JFrame implements ActionListener{

	JFrame frame;
	JLabel label, l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2;
	Connection con=null;
	
	AddBooks(){
		con=(Connection)DB.dbconnect();
		frame = new JFrame();
		label = new JLabel();
		l1 = new JLabel("ADD BOOKS");
		l2 = new JLabel("Call No. : ");
		l3 = new JLabel("Name : ");
		l4 = new JLabel("Author : ");
		l5 = new JLabel("Publisher : ");
		l6 = new JLabel("Quantity : ");
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();
		b1 = new JButton("Add Books");
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					String callNo = t1.getText();
					String name = t2.getText();
					String author = t3.getText();
					String publisher = t4.getText();
					int quantity = Integer.valueOf(t5.getText());
					
					
					PreparedStatement pst = con.prepareStatement("insert into addbooks(callNo,name,author,publisher,quantity) values(?,?,?,?,?)");
					pst.setString(1, callNo);
					pst.setString(2, name);
					pst.setString(3, author);
					pst.setString(4, publisher);
					pst.setInt(5, quantity);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Book added successfully!!!");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					
				
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
				new LibrarianSection();
		}});
		l1.setBounds(250,20,200,30);
		l2.setBounds(50,70,150,20);
		l3.setBounds(50,110,150,20);
		l4.setBounds(50,150,150,20);
		l5.setBounds(50,190,150,20);
		l6.setBounds(50,230,150,20);

		t1.setBounds(250,70,150,20);
		t2.setBounds(250,110,150,20);
		t3.setBounds(250,150,150,20);
		t4.setBounds(250,190,150,20);
		t5.setBounds(250,230,150,20);
		
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
	
		label.add(t1);
		label.add(t2);
		label.add(t3);
		label.add(t4);
		label.add(t5);
		
		
		frame.add(label);
		frame.setTitle("Add Books-Library Management System");
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
