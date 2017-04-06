package secondPage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

public class Team extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Team frame = new Team();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Team() {
		setResizable(false);
		setBackground(new Color(218, 165, 32));
		setFont(new Font("Calibri", Font.BOLD, 14));
		setTitle("Developers");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 431, 262);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(218, 165, 32));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRohanSaraf = new JLabel("Rohan Saraf");
		lblRohanSaraf.setForeground(new Color(0, 0, 128));
		lblRohanSaraf.setFont(new Font("Calibri", Font.BOLD, 16));
		lblRohanSaraf.setBounds(145, 17, 120, 20);
		contentPane.add(lblRohanSaraf);
		
		JLabel lblRobinGaur = new JLabel("Robin Gaur");
		lblRobinGaur.setForeground(new Color(0, 0, 128));
		lblRobinGaur.setFont(new Font("Calibri", Font.BOLD, 16));
		lblRobinGaur.setBounds(145, 36, 120, 20);
		contentPane.add(lblRobinGaur);
		
		JLabel lblRohitPaliwal = new JLabel("Rohit Paliwal");
		lblRohitPaliwal.setForeground(new Color(0, 0, 128));
		lblRohitPaliwal.setFont(new Font("Calibri", Font.BOLD, 16));
		lblRohitPaliwal.setBounds(145, 56, 120, 20);
		contentPane.add(lblRohitPaliwal);
		
		JLabel lblAnkitaMuzalda = new JLabel("Ankita Muzalda");
		lblAnkitaMuzalda.setForeground(new Color(0, 0, 128));
		lblAnkitaMuzalda.setFont(new Font("Calibri", Font.BOLD, 16));
		lblAnkitaMuzalda.setBounds(145, 94, 120, 20);
		contentPane.add(lblAnkitaMuzalda);
		
		JLabel lblSunilChaudhary = new JLabel("Sunil Chaudhary");
		lblSunilChaudhary.setForeground(new Color(0, 0, 128));
		lblSunilChaudhary.setFont(new Font("Calibri", Font.BOLD, 16));
		lblSunilChaudhary.setBounds(145, 75, 120, 20);
		contentPane.add(lblSunilChaudhary);
		
		JLabel lblGuestHouseManagement = new JLabel("Guest House Management Software");
		lblGuestHouseManagement.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblGuestHouseManagement.setBounds(101, 126, 281, 20);
		contentPane.add(lblGuestHouseManagement);
		
		JLabel lblAllRightsReserved = new JLabel("All Rights Reserved 2016-2017");
		lblAllRightsReserved.setFont(new Font("Calibri", Font.ITALIC, 10));
		lblAllRightsReserved.setBounds(145, 143, 126, 20);
		contentPane.add(lblAllRightsReserved);
	}
}
