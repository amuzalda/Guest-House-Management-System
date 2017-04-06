package secondPage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * The class "AdministrationLoginPage" have a base class namely JPanel.
 * The class "AdministrationLoginPage" implements all the function of ActionListener.
 * This is the first page of administration login. It will verify the admin.
 */

public class AdministrationLoginPage extends JPanel implements ActionListener
{
    private JButton loginButton, cancelButton;
    public static Map<String, String> loginDetails;
    private JTextField userIDText;
    private JPasswordField passwordText;
    private int counter;
    public static String userName, masterUserName, masterPassword;
    public static JFrame loginPage;
    
    public static void main(String[] args)
    {
        loginPage = new JFrame("Administration Login Page");
        AdministrationLoginPage content = new AdministrationLoginPage();
        loginPage.setContentPane(content);
        loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginPage.setVisible(true);
        loginPage.setResizable(false);
        loginPage.setLocation(200, 100);
        loginPage.setSize(new Dimension(495, 460));
    }
    
    public AdministrationLoginPage()
    {
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        this.setBackground(GuestHouseManagementSystem.color);
        
        this.setLayout(new FlowLayout());
        
        this.heading(this);
        this.projectName(this);
        this.projectType(this);
        this.loginDetails(this);
        this.buttons(this);
        
        this.loginDetails = null;
        this.counter = 0;
    }
    
    private void heading(AdministrationLoginPage admin)
    {
        JPanel panel = new JPanel();
        panel.setBackground(GuestHouseManagementSystem.color);
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
        panel.setPreferredSize(new Dimension(480, 125));
        
        ImageIcon iitjLogo = null;
        try
        {
            iitjLogo = new ImageIcon(getClass().getResource("iitj.png"));
        }
        catch (NullPointerException ex)
        {
            System.out.println("IITJ Logo is not present at the given address.\n");
            //System.exit(0);
        }
        JLabel imageLabel = new JLabel(iitjLogo);
        imageLabel.setToolTipText("Indian Institute of Technology, Jodhpur");
        panel.add(imageLabel);
        
        JLabel label = new JLabel("<html><p style=\"font-size:35px\">IIT Jodhpur");
        label.setForeground(Color.WHITE);
        label.setToolTipText("Indian Institute of Technology, Jodhpur");
        panel.add(label);
        admin.add(panel);
    }
    
    private void projectName(AdministrationLoginPage admin)
    {
        JPanel panel = new JPanel();
        panel.setBackground(GuestHouseManagementSystem.color);
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setPreferredSize(new Dimension(480, 100));
        
        JLabel label1 = new JLabel("<html><p style=\"font-size:20px\">Guest House Management");
        label1.setForeground(Color.WHITE);
        panel.add(label1);
        
        JLabel label2 = new JLabel("<html><p style=\"font-size:18px\">Booking System");
        label2.setForeground(Color.WHITE);
        panel.add(label2);
        
        admin.add(panel);
    }
    
    private void projectType(AdministrationLoginPage admin)
    {
        JPanel panel = new JPanel();
        panel.setBackground(GuestHouseManagementSystem.color);
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setPreferredSize(new Dimension(480, 50));
        
        JLabel label1 = new JLabel("<html><p style=\"font-size:15px\">Administration Portal");
        label1.setForeground(Color.WHITE);
        panel.add(label1);
        
        admin.add(panel);
    }
    
    private void loginDetails(AdministrationLoginPage admin)
    {
        JPanel panel = new JPanel();
        panel.setBackground(GuestHouseManagementSystem.color);
        panel.setLayout(new GridLayout(2, 2, 5, 5));
        panel.setPreferredSize(new Dimension(450, 70));
        
        JLabel userID = new JLabel("<html><p style=\"font-size:15px\">User Login ID: ");
        userID.setForeground(Color.WHITE);
        
        panel.add(userID);
        
        userIDText = new JTextField(10);
        panel.add(userIDText);
        
        JLabel password = new JLabel("<html><p style=\"font-size:15px\">Password: ");
        password.setForeground(Color.WHITE);
        panel.add(password);
        
        passwordText = new JPasswordField(10);
        panel.add(passwordText);
        admin.add(panel);
    }
    
    private void buttons(AdministrationLoginPage admin)
    {
        JPanel panel = new JPanel();
        panel.setBackground(GuestHouseManagementSystem.color);
        panel.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.WHITE));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setPreferredSize(new Dimension(480, 50));
        
        loginButton = new JButton("<html><p style=\"font-size:13px\">Login");
        loginButton.setPreferredSize(new Dimension(230, 35));
        loginButton.setBackground(new Color(187, 231, 238));
        loginButton.addActionListener(admin);
        panel.add(loginButton);
        
        cancelButton = new JButton("<html><p style=\"font-size:13px\">Cancel");
        cancelButton.setPreferredSize(new Dimension(230, 35));
        cancelButton.setBackground(new Color(187, 231, 238));
        cancelButton.addActionListener(admin);
        panel.add(cancelButton);
        
        admin.add(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource(); //src stores the type of event occured.
        
        if (src == cancelButton)
        {
            System.exit(0);
        }
        else if(src == loginButton)
        {
            if (loginDetails == null)
            {
                loginDetails = new TreeMap<String,String>();
                File loginFile = new File("login.Details");
                if (!loginFile.exists())
                {
                    System.out.println("login.Details File not Found.");
                    //System.exit(2);
                }
                try
                {
                    Scanner scan = new Scanner(loginFile);
                    String str = scan.nextLine();
                    int sperator = str.indexOf('~');
                    masterUserName = str.substring(0, sperator);;
                    masterPassword = str.substring(sperator + 1);
                    while (scan.hasNextLine())
                    {
                        str = scan.nextLine();
                        sperator = str.indexOf('~');
                        String user_ID = str.substring(0, sperator);
                        String user_Password = str.substring(sperator + 1);
                        loginDetails.put(user_ID, user_Password);
                    }
                }
                catch (FileNotFoundException ex)
                {
                    System.out.println("login.Details file not found.");
                    loginDetails.clear();
                    loginDetails = null;
                }
            }
            
            String password = new String(passwordText.getPassword());
            if (userIDText.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please Enter your ID.", "Empty Field!!!", JOptionPane.ERROR_MESSAGE);
                passwordText.setText(null);
            }
            else if (password.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please Enter your Password.", "Empty Field!!!", JOptionPane.ERROR_MESSAGE);
                userIDText.setText(null);
            }
            else if (loginDetails.containsKey(userIDText.getText()))
            {
                if (password.equals(loginDetails.get(userIDText.getText())))
                {
                    userName = userIDText.getText();
                    loginPage.setVisible(false);
                    userIDText.setText(null);
                    passwordText.setText(null);
                    counter = 0;
                    AdministrationOptions.main(null);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Password is Incorrect", "Invalid Password", JOptionPane.ERROR_MESSAGE);
                    counter++;
                    userIDText.setText(null);
                    passwordText.setText(null);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "User does not exist.", "Invalid User", JOptionPane.ERROR_MESSAGE);
                counter++;
                userIDText.setText(null);
                passwordText.setText(null);
            }
            if (counter == 3)
            {
                JOptionPane.showMessageDialog(this, "<html>You have crossed limit of allowed attemps.<br>Sorry, System is existing.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                System.exit(5);
            }
        }
    }
    
}