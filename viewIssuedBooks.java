
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.*;
class viewIssuedBooks extends JFrame {
	JFrame frame;
	JPanel contentPane;
	JTable table;
	viewIssuedBooks() {
			frame = new JFrame();
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			
			String data[][]=null;
			String column[]=null;
			try{
				Connection con=DB.dbconnect();
				PreparedStatement pst=con.prepareStatement("select * from issuebooks",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs=pst.executeQuery();
				
				ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
				int cols=rsmd.getColumnCount();
				column=new String[cols];
				for(int i=1;i<=cols;i++){
					column[i-1]=rsmd.getColumnName(i);
				}
				
				rs.last();
				int rows=rs.getRow();
				rs.beforeFirst();

				data=new String[rows][cols];
				int count=0;
				while(rs.next()){
					for(int i=1;i<=cols;i++){
						data[count][i-1]=rs.getString(i);
					}
					count++;
				}
				con.close();
			}catch(Exception e){System.out.println(e);}
			
			table = new JTable(data,column);
			JScrollPane sp=new JScrollPane(table);
			
			contentPane.add(sp, BorderLayout.CENTER);
			frame.add(contentPane);
			frame.setTitle("View Issued Books-Library Management System");
			frame.setVisible(true);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame.setSize(900,600);
	}
}



