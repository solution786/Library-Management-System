import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.*;
class ReturnBook extends JFrame implements ActionListener{
	JFrame frame;
	JLabel label, l1,l2,l3,l4;
	JTextField t1,t2;
	JButton b1,b2;
	Connection con=null;
	ReturnBook(){
		con=(Connection)DB.dbconnect();
		frame = new JFrame();
		label = new JLabel();
		l1 = new JLabel("RETURN BOOK");
		l2 = new JLabel("Book Call No. : ");
		l3 = new JLabel("Student id : ");
		l4 = new JLabel("*Note - Check the book properly!");
		t1 = new JTextField();
		t2 = new JTextField();
		
		b1 = new JButton("Return Book");
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String bookCallNo = t1.getText();
					int studentId = Integer.valueOf(t2.getText());
					PreparedStatement pst =(PreparedStatement)con.prepareStatement("select bookCallNo,studentId from issuebooks where bookCallNo=? and studentId=?");
					pst.setString(1, bookCallNo);
					pst.setInt(2, studentId);
					ResultSet r = pst.executeQuery();
					if(r.next())
					{
						JOptionPane.showMessageDialog(null,"Book return successfully!!!");
						t1.setText("");
						t2.setText("");
						
					}else {
						JOptionPane.showMessageDialog(null,"Sorry, Unable to return Book!!!");
					}
					
				}catch(Exception e1)
				{
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
		l4.setBounds(50,150,300,20);

		t1.setBounds(250,70,150,20);
		t2.setBounds(250,110,150,20);
		
		
		b1.setBounds(200,200,200,40);
		b2.setBounds(220,270,150,40);
		
		label.add(b1);
		label.add(b2);
		label.add(l1);
		label.add(l2);
		label.add(l3);
		label.add(l4);
		label.add(t1);
		label.add(t2);
		frame.add(label);
		frame.setTitle("Return Book-Library Management System");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,400);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
