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

public class SP1 {

	private JFrame frame;
	private JTextField textField_3;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main1(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SP1 window = new SP1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection conn=null;
	private JTable table;
	private JTable guestTable;
	public SP1() {
		conn=SqlConn.dbConnection();//connection is established with the SQLDatabase
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	    ResultSet rs_search=null;
		
		
		frame = new JFrame("Guest House Management System");
		frame.getContentPane().setBackground(new Color(0, 255, 255));
		frame.setFont(new Font("Calibri", Font.PLAIN, 12));
		frame.setBackground(new Color(184, 134, 11));
		frame.setResizable(false);
		frame.setBounds(100, 100, 973, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 725, 387);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setFont(new Font("Calibri", Font.BOLD, 14));
		tabbedPane.setForeground(new Color(0, 0, 128));
		tabbedPane.setBackground(Color.WHITE);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("New Guests who have not been assigned any room.");
		panel.setBackground(new Color(176, 224, 230));
		tabbedPane.addTab("All Guests", null, panel, null);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(287, 10, 167, 25);
		panel.add(textField);
		
		JButton button_1 = new JButton("Show All Guest Details");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hostel","rohan","rohansaraf");
					
					String sql="select * from allguests";
					Statement s=conn.createStatement();
					ResultSet rs_search=s.executeQuery(sql);
					
					guestTable.setModel(DbUtils.resultSetToTableModel(rs_search));
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				 }
				
			}
		});
		button_1.setForeground(new Color(0, 0, 0));
		button_1.setFont(new Font("Calibri", Font.BOLD, 14));
		button_1.setBounds(10, 10, 197, 25);
		panel.add(button_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 53, 686, 292);
		panel.add(scrollPane_1);
		
		guestTable = new JTable();
		guestTable.setForeground(new Color(0, 0, 128));
		guestTable.setFont(new Font("Calibri", Font.BOLD, 12));
		guestTable.setEnabled(false);
		guestTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"URId", "Room", "Name", "Surname", "Mail Id", "Contact", "Designation", "Status", "In Date", "Out Date", "Password"
			}
		));
		guestTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		guestTable.getColumnModel().getColumn(0).setMaxWidth(50);
		guestTable.getColumnModel().getColumn(1).setMaxWidth(75);
		guestTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		guestTable.getColumnModel().getColumn(2).setMaxWidth(100);
		guestTable.getColumnModel().getColumn(3).setPreferredWidth(100);
		guestTable.getColumnModel().getColumn(3).setMaxWidth(100);
		guestTable.getColumnModel().getColumn(7).setPreferredWidth(60);
		guestTable.getColumnModel().getColumn(7).setMaxWidth(65);
		guestTable.getColumnModel().getColumn(8).setPreferredWidth(85);
		guestTable.getColumnModel().getColumn(9).setPreferredWidth(90);
		guestTable.getColumnModel().getColumn(10).setPreferredWidth(15);
		guestTable.getColumnModel().getColumn(10).setMinWidth(0);
		guestTable.getColumnModel().getColumn(10).setMaxWidth(0);
		scrollPane_1.setViewportView(guestTable);
		
		JButton btnAllotRoom = new JButton("Allot Room");
		btnAllotRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int flag=0;
				String value=textField.getText(); 
				if(value.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Name not entered");
					flag=1;
				}
				if(flag==0){
				try {
					int allot_room = 0;
					Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hostel","rohan","rohansaraf");
				    Connection room_conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hostel","rohan","rohansaraf");
				    
					String sql="select * from allguests where Name like '"+value+"%'";
					String room_sql="select * from rooms where status='Vacant'";
				    Statement s=conn.createStatement();
				    Statement room_sql_st=room_conn.createStatement();
				    
				    ResultSet room_rs=room_sql_st.executeQuery(room_sql);
				    ResultSet rs=s.executeQuery(sql);
					
				    	
				    while(room_rs.next())
				    {
				    	allot_room=room_rs.getInt("room");
				    	break;
				    }
				    System.out.println(""+allot_room);
				    while(rs.next())
				    {
				    	String cnf="Confirmed";
				    	int id=rs.getInt("URId");
				    	System.out.println(""+id);
//				    	if(rs.getString("status").equals(cnf))
//				    	{
//				    		JOptionPane.showMessageDialog(null,"Already Booked");
//				    	}
				    	
				    	String sql1="update allguests set room="+allot_room+",status= '"+cnf+"' where URId="+id;
				        Statement s1=conn.createStatement();
				        s1.executeUpdate(sql1);
			
				        room_sql_st.executeUpdate("update rooms set status='Booked' where room="+allot_room);
				        rs=s.executeQuery(sql);
				        rs.next();
				        if(rs.getString("status").equals(cnf))
				        {
				        	
				        	JOptionPane.showMessageDialog(null,"Room Booked Successfully");
				        }
				    	
				    }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		});
		
		btnAllotRoom.setForeground(Color.BLACK);
		btnAllotRoom.setFont(new Font("Calibri", Font.BOLD, 14));
		btnAllotRoom.setBounds(464, 10, 107, 25);
		panel.add(btnAllotRoom);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setFont(new Font("Calibri", Font.BOLD, 16));
		lblName.setBounds(235, 11, 65, 23);
		panel.add(lblName);
		
		JButton button_3 = new JButton("Cancel Room");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int flag=0;
				String value=textField.getText(); 
				if(value.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Name not entered");
					flag=1;
				}
				if(flag==0){
				try {
					Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hostel","rohan","rohansaraf");
				    Connection room_conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hostel","rohan","rohansaraf");
					String sql="select * from allguests where Name like '"+value+"%'";
				    Statement s=conn.createStatement();
				    ResultSet rs=s.executeQuery(sql);
				    ResultSet temp_rs=s.executeQuery(sql);
				    
				    temp_rs.next();
					String name=temp_rs.getString("name");
					String surname=temp_rs.getString("surname");
				    temp_rs.close();
				    rs=s.executeQuery(sql);
				    String status[]={"Booked","Vacant"};
				    String message = "Cancel the booking of "+name+" "+surname+" ?";
				    String title = "Cancel?";
				    // display the JOptionPane showConfirmDialog
				    int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
				    if (reply == JOptionPane.YES_OPTION)
				    {
				    	while(rs.next())
					    {
				    		String cncl="Cancelled";
					    	int id=rs.getInt("URId");
					    	int room_num=rs.getInt("room");
//					    	System.out.println(""+id);
					    	String sql1="update allguests set status= '"+cncl+"' where URId="+id;
					    	String sql2="update rooms set status='"+status[1]+"' where room="+room_num;
					        Statement s1=conn.createStatement();
					        Statement room_st=room_conn.createStatement();
					        room_st.executeUpdate(sql2);
					        s1.executeUpdate(sql1);
					         
					        
					        if(rs.getString("status").equals("Cancelled"))
					        {
					        	
					        	JOptionPane.showMessageDialog(null,"Room Cancelled Successfully");
					        }
					    } 
				    }
				    
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
			}
		});
		button_3.setForeground(Color.BLACK);
		button_3.setFont(new Font("Calibri", Font.BOLD, 14));
		button_3.setBounds(579, 11, 117, 25);
		panel.add(button_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(176, 224, 230));
		tabbedPane.addTab("Room Information", null, panel_3, null);
		panel_3.setLayout(null);
		
		JButton button_2 = new JButton("Search");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String roomNum=textField_3.getText();
				
				Connection conn;
				try {
					conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hostel","rohan","rohansaraf");
					String sql="SELECT * from rooms where room="+roomNum;
			     	Statement s=conn.createStatement();
					ResultSet rs=s.executeQuery(sql);
					
					if(rs.absolute(1))
					{
						//System.out.println("Data Exists");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid Room Nummber Entered");
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				if(roomNum.equals(""))
				{
				try {
					JOptionPane.showMessageDialog(null,"Search Box is Empty");
				    conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hostel","rohan","rohansaraf");
//					
//					String sql="SELECT * from rooms";
//					Statement s=conn.createStatement();
//					ResultSet rs=s.executeQuery(sql);
//					
//					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,"Database Error");
					// TODO Auto-generated catch block
					e.printStackTrace();
				 }
				}
				else
				{
					try {
					    conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hostel","rohan","rohansaraf");
						
						String sql1="SELECT * from rooms where room="+roomNum;//prepared statement query required here
						Statement s1=conn.createStatement();
						ResultSet rs1=s1.executeQuery(sql1);
						
						table.setModel(DbUtils.resultSetToTableModel(rs1));
						if(rs1==null)
						{
						   JOptionPane.showMessageDialog(null,"Connection unsuccessful");
						}
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null,"Room Doesnt Exist");
						// TODO Auto-generated catch block
						e.printStackTrace();
					 }
				}
			}
		});
		button_2.setForeground(new Color(0, 0, 0));
		button_2.setFont(new Font("Calibri", Font.BOLD, 14));
		button_2.setBounds(435, 14, 83, 26);
		panel_3.add(button_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(330, 14, 95, 26);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 508, 287);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 0, 128));
		table.setEnabled(false);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Calibri", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Room", "Status", "Guest Id", "Duration"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("Show all Rooms");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
                Connection conn;
				try {
					conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hostel","rohan","rohansaraf");
					String query="Select * from rooms";
					Statement s=conn.createStatement();
					
					ResultSet rs=s.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Calibri", Font.BOLD, 14));
		button.setBounds(10, 14, 171, 26);
		panel_3.add(button);
		
		JButton btnPaymentPorttal = new JButton("Payment Portal");
		btnPaymentPorttal.setForeground(new Color(0, 0, 128));
		btnPaymentPorttal.setFont(new Font("Calibri", Font.BOLD, 14));
		btnPaymentPorttal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnPaymentPorttal.setBounds(764, 37, 159, 23);
		frame.getContentPane().add(btnPaymentPorttal);
		
		final int totalr=0;
		JButton btnTotalGuest = new JButton("Total Guest:"+totalr);
		btnTotalGuest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn;
				try {
					conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hostel","rohan","rohansaraf");
					String query="Select * from rooms";
					Statement s=conn.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnTotalGuest.setHorizontalAlignment(SwingConstants.LEFT);
		btnTotalGuest.setToolTipText("Click to refresh the Count");
		btnTotalGuest.setForeground(new Color(0, 0, 128));
		btnTotalGuest.setFont(new Font("Calibri", Font.BOLD, 14));
		btnTotalGuest.setBounds(764, 172, 166, 23);
		frame.getContentPane().add(btnTotalGuest);
		int n=0;
		 try {
				
				Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hostel","rohan","rohansaraf");
				
				String query="Select * from rooms";
				Statement s=conn.createStatement();
				
				ResultSet rs=s.executeQuery(query);
				while(rs.next())
				{
					n++;
				}
		 }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		
		final JButton btnRoomsAvailable = new JButton("Rooms Available:"+n);
		btnRoomsAvailable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  try {
				String status[]={"Booked","Vacant"};
				int n=0,total_rooms=0;
				Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hostel","rohan","rohansaraf");
				
				String query="Select * from rooms";
				Statement s=conn.createStatement();
				
				ResultSet rs=s.executeQuery(query);
				while(rs.next())
				{
					if(rs.getString("status").equals(status[1]))
					{
					n++;
					}
					total_rooms++;
				}
				btnRoomsAvailable.setText("Rooms Available:"+n+"/"+total_rooms);
				//JOptionPane.showMessageDialog(null,"Connection successful");//just using it as debugger
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		btnRoomsAvailable.setToolTipText("Click to refresh the Count");
		btnRoomsAvailable.setHorizontalAlignment(SwingConstants.LEFT);
		btnRoomsAvailable.setForeground(new Color(0, 0, 128));
		btnRoomsAvailable.setFont(new Font("Calibri", Font.BOLD, 14));
		btnRoomsAvailable.setBounds(764, 200, 166, 23);
		frame.getContentPane().add(btnRoomsAvailable);
		
		JLabel lblCurrentStats = new JLabel("Current Statistics");
		lblCurrentStats.setForeground(new Color(255, 0, 0));
		lblCurrentStats.setFont(new Font("Calibri", Font.BOLD, 14));
		lblCurrentStats.setBounds(764, 141, 142, 23);
		frame.getContentPane().add(lblCurrentStats);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(169, 169, 169));
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setFont(new Font("Calibri", Font.PLAIN, 12));
		frame.setJMenuBar(menuBar);
		
		JMenu mnAbout = new JMenu("About");
		mnAbout.setForeground(new Color(0, 0, 128));
		menuBar.add(mnAbout);
		
		JMenuItem mntmGuestHouse = new JMenuItem("Guest House");
		mntmGuestHouse.setForeground(new Color(128, 0, 0));
		mnAbout.add(mntmGuestHouse);
		
		JSeparator separator_1 = new JSeparator();
		mnAbout.add(separator_1);
		
		JMenuItem mntmTeam = new JMenuItem("Team");
		mntmTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Team tm = null;
				tm = new Team();
                tm.setVisible(true);
			}
		});
		mntmTeam.setForeground(new Color(128, 0, 0));
		mnAbout.add(mntmTeam);
		
		JMenu mnExit = new JMenu("Exit");
		mnExit.setForeground(new Color(0, 0, 128));
		menuBar.add(mnExit);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				GuestHouseManagementSystem.main(null);
			}
		});
		mntmLogout.setForeground(new Color(128, 0, 0));
		mnExit.add(mntmLogout);
		
		JSeparator separator = new JSeparator();
		mnExit.add(separator);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		mntmClose.setForeground(new Color(128, 0, 0));
		mnExit.add(mntmClose);
	}
}
