import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.*;
class LibrarianLoginPage extends JFrame implements ActionListener 
{
	JFrame frame;
	JLabel label,l1,l2,l3;
	JButton button,back;
	JTextField t1;
	JPasswordField p1;
	Connection con=null;
	LibrarianLoginPage()
	{
		con=(Connection)DB.dbconnect();
		frame = new JFrame();
		label = new JLabel();
		l1 = new JLabel("LIBRARIAN LOGIN");
		l2 = new JLabel("Enter Name : ");
		l3 = new JLabel("Enter Password : ");
		t1 = new JTextField();
		p1 = new JPasswordField();
		button = new JButton("LOGIN");
		back = new JButton("Back");
		l1.setBounds(250,20,200,60);
		l2.setBounds(50,100,150,20);
		l3.setBounds(50,150,150,20);
		t1.setBounds(250,100,200,30);
		p1.setBounds(250,150,200,30);
		button.setBounds(200,200,150,50);
		back.setBounds(220,300,100,40);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String name = t1.getText();
					String pass = String.valueOf(p1.getPassword());
					PreparedStatement pst =(PreparedStatement)con.prepareStatement("select * from librarian where name=? and password=?");
					pst.setString(1, name);
					pst.setString(2, pass);
					ResultSet r = pst.executeQuery();
					if(r.next())
					{
						JOptionPane.showMessageDialog(null,"Login Successful!!!");
						frame.setVisible(false);
						new LibrarianSection();
					}else {
						JOptionPane.showMessageDialog(null,"Please! enter correct details.");
					}
					
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
		}});
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				new WelcomePage();
		}});
		
		label.add(l1);
		label.add(l2);
		label.add(l3);
		label.add(t1);
		label.add(p1);
		label.add(button);
		label.add(back);
		frame.add(label);
		frame.setTitle("Librarian Login-Library Management System");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,400);
	}
	public LibrarianLoginPage(String s){
		super(s);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}