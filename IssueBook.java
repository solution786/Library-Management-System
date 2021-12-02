import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.*;
class IssueBook extends JFrame implements ActionListener{
	JFrame frame;
	JLabel label, l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2;
	Connection con=null;
	IssueBook(){
		con=(Connection)DB.dbconnect();
		frame = new JFrame();
		label = new JLabel();
		l1 = new JLabel("ISSUE BOOK");
		l2 = new JLabel("Book Call No. : ");
		l3 = new JLabel("Student id : ");
		l4 = new JLabel("Student Name : ");
		l5 = new JLabel("Student Contact No. : ");
		l6 = new JLabel("*Note - Please check Student id carefully before Issuing Book!");
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		
		b1 = new JButton("Issue Book");
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String bookCallNo = t1.getText();
					int StudentId = Integer.valueOf(t2.getText());
					String StudentName = t3.getText();
					String StudentContactNo = t4.getText();
					PreparedStatement pst = con.prepareStatement("insert into issuebooks(bookCallNo,studentId,studentName,studentContact) values(?,?,?,?)");
					pst.setString(1, bookCallNo);
					pst.setInt(2, StudentId);
					pst.setString(3, StudentName);
					pst.setString(4, StudentContactNo);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Book issued successfully!!!");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
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
		l6.setBounds(50,230,550,10);

		t1.setBounds(250,70,150,20);
		t2.setBounds(250,110,150,20);
		t3.setBounds(250,150,150,20);
		t4.setBounds(250,190,150,20);
		
		
		b1.setBounds(200,260,200,40);
		b2.setBounds(220,330,150,40);
		
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
		frame.add(label);
		frame.setTitle("Issue Book-Library Management System");
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
