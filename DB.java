import java.sql.*;


public class DB {
	Connection con=null;
	java.sql.PreparedStatement pst;
	public static Connection dbconnect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryManagementSystem","root","");
			return conn;
		}
		catch(Exception e2) {
			System.out.println(e2);
			return null;
		}
	}
	
}
