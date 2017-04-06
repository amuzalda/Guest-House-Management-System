package secondPage;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;




import net.proteanit.sql.DbUtils;
public class Connect{
	
	String db_admin="rohan";
	String db_pass="rohansaraf";
    Connection conn=null;//global variable which can be needed in future
	public static Connection/*return type*/ dbConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/","rohan","rohansaraf");
//			JOptionPane.showMessageDialog(null,"Connection successful");
			return conn;	
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	public  Connection allGuestConnection() throws SQLException
	{
		Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/allguests","rohan","rohansaraf");
		return conn;
	}

}
