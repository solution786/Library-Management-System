import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.*;
class DeleteLibrarian extends JFrame implements ActionListener{
	JFrame frame;
	JLabel label,l1,l2;
	JButton b1,b2;
	JTextField t1;
	Connection con=null;
	DeleteLibrarian(){
		con=(Connection)DB.dbconnect();
		frame = new JFrame();
		label = new JLabel();
		l1 = new JLabel("DELETE LIBRARIAN");
		l2 = new JLabel("Enter Id : ");
		t1 = new JTextField();
		b1 = new JButton("Delete");
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			try {
				int id = Integer.valueOf(t1.getText());
				PreparedStatement pst = con.prepareStatement("delete from librarian where id=?");
				pst.setInt(1,id);
				int r = pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"Record deleted Successfully!!!");
				t1.setText("");
				
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
				new AdminSection();	
			
		}});

		l1.setBounds(120,20,150,40);
		l2.setBounds(50,100,150,20);
		t1.setBounds(130,100,150,30);
		b1.setBounds(100,160,150,50);
		b2.setBounds(120,240,100,40);
		label.add(l1);
		label.add(l2);
		label.add(b1);
		label.add(b2);
		label.add(t1);
		frame.add(label);
		frame.setTitle("Delete Librarian-Library Management System");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
