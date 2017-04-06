package secondPage;
import java.sql.*;

import javax.swing.*;

public class SqlConn {
	String db_admin="rohan";
	String db_pass="rohansaraf";
    Connection conn=null;//global variable which can be needed in future
	public static Connection/*return type*/ dbConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/","rohan","rohansaraf");
		  //JOptionPane.showMessageDialog(null,"Connection successful");
			return conn;	
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}	
	}
	
}
