package secondPage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class ChangePassword extends JPanel implements ActionListener
{
    private JButton changeButton, cancelButton;
    private JPasswordField oldPassword, newPassword, conformPassword;
    private int counter;
    public static JFrame changeAdminPasswordPage;
    
    public static void main(String[] args)
    {
        changeAdminPasswordPage = new JFrame("Administration Login Page");
        ChangePassword content = new ChangePassword();
        changeAdminPasswordPage.setContentPane(content);
        changeAdminPasswordPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        changeAdminPasswordPage.setVisible(true);
        changeAdminPasswordPage.setResizable(false);
        changeAdminPasswordPage.setLocation(200, 100);
        changeAdminPasswordPage.setSize(new Dimension(495, 490));
    }
    
    public ChangePassword()
    {
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        this.setBackground(GuestHouseManagementSystem.color);
        
        this.setLayout(new FlowLayout());
        
        this.heading(this);
        this.projectName(this);
        this.projectType(this);
        this.loginDetails(this);
        this.buttons(this);
        
        this.counter = 0;
    }
    
    private void heading(ChangePassword admin)
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
            System.exit(0);
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
    
    private void projectName(ChangePassword admin)
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
    
    private void projectType(ChangePassword admin)
    {
        JPanel panel = new JPanel();
        panel.setBackground(GuestHouseManagementSystem.color);
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setPreferredSize(new Dimension(480, 50));
        
        String userID = AdministrationLoginPage.userName;
        JLabel label1 = new JLabel("<html><p style=\"font-size:15px\"> Change Password of userID: \"" + userID + "\"");
        label1.setForeground(Color.WHITE);
        panel.add(label1);
        
        admin.add(panel);
    }
    
    private void loginDetails(ChangePassword admin)
    {
        JPanel panel = new JPanel();
        panel.setBackground(GuestHouseManagementSystem.color);
        panel.setLayout(new GridLayout(3, 2, 5, 5));
        panel.setPreferredSize(new Dimension(450, 100));
        
        JLabel oldPasswordLabel = new JLabel("<html><p style=\"font-size:15px\">Old Password: ");
        oldPasswordLabel.setForeground(Color.WHITE);
        panel.add(oldPasswordLabel);
        
        oldPassword = new JPasswordField(10);
        panel.add(oldPassword);
        admin.add(panel);
        
        JLabel newPasswordLabel = new JLabel("<html><p style=\"font-size:15px\">New Password: ");
        newPasswordLabel.setForeground(Color.WHITE);
        panel.add(newPasswordLabel);
        
        newPassword = new JPasswordField(10);
        panel.add(newPassword);
        admin.add(panel);
        
        JLabel conformPasswordLabel = new JLabel("<html><p style=\"font-size:15px\">Conform Password: ");
        conformPasswordLabel.setForeground(Color.WHITE);
        panel.add(conformPasswordLabel);
        
        conformPassword = new JPasswordField(10);
        panel.add(conformPassword);
        admin.add(panel);
    }
    
    private void buttons(ChangePassword admin)
    {
        JPanel panel = new JPanel();
        panel.setBackground(GuestHouseManagementSystem.color);
        panel.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.WHITE));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setPreferredSize(new Dimension(480, 50));
        
        changeButton = new JButton("<html><p style=\"font-size:13px\">Change");
        changeButton.setPreferredSize(new Dimension(230, 35));
        changeButton.setBackground(new Color(187, 231, 238));
        changeButton.addActionListener(admin);
        panel.add(changeButton);
        
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
            changeAdminPasswordPage.setVisible(false);
            AdministrationOptions.options.setVisible(true);
            oldPassword.setText(null);
            newPassword.setText(null);
            conformPassword.setText(null);
            counter = 0;
        }
        else if (src == changeButton)
        {
            String oldPasswordString = new String(oldPassword.getPassword());
            String newPasswordString = new String(newPassword.getPassword());
            String conformPasswordString = new String(conformPassword.getPassword());
            if (oldPasswordString.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please Enter your old Password.", "Empty Field!!!", JOptionPane.ERROR_MESSAGE);
                this.newPassword.setText(null);
                this.conformPassword.setText(null);
            }
            else if (newPasswordString.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please Enter your new Password.", "Empty Field!!!", JOptionPane.ERROR_MESSAGE);
                this.oldPassword.setText(null);
                this.conformPassword.setText(null);
            }
            else if (conformPasswordString.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please Enter your conform Password.", "Empty Field!!!", JOptionPane.ERROR_MESSAGE);
                this.oldPassword.setText(null);
                this.newPassword.setText(null);
            }
            else if (!oldPasswordString.equals(AdministrationLoginPage.loginDetails.get(AdministrationLoginPage.userName)))
            {
                this.counter++;
                JOptionPane.showMessageDialog(this, "Password is Incorrect", "Invalid Password", JOptionPane.ERROR_MESSAGE);
                this.oldPassword.setText(null);
                this.newPassword.setText(null);
                this.conformPassword.setText(null);
            }
            else if (!conformPasswordString.equals(newPasswordString))
            {
                this.counter++;
                JOptionPane.showMessageDialog(this, "Conform Password does not equal to new Passwrod.", "Invalid Password", JOptionPane.ERROR_MESSAGE);
                this.oldPassword.setText(null);
                this.newPassword.setText(null);
                this.conformPassword.setText(null);
            }
            else
            {
                AdministrationLoginPage.loginDetails.put(AdministrationLoginPage.userName, newPasswordString);
                File file = new File("login.Details");
                PrintWriter out = null;
                try
                {
                    out = new PrintWriter(file);
                }
                catch (IOException exp)
                {
                    System.out.println("Login.Details file not found.");
                    System.exit(1000);
                }
                out.println(AdministrationLoginPage.masterUserName + "~" + AdministrationLoginPage.masterPassword);
                for (Map.Entry<String, String> data : AdministrationLoginPage.loginDetails.entrySet())
                {
                    out.println(data.getKey() + "~" + data.getValue());
                }
                out.flush();
                out.close();
                JOptionPane.showMessageDialog(this, "Password has been changed.", "Successful", JOptionPane.INFORMATION_MESSAGE);
                this.counter = 0;
                changeAdminPasswordPage.setVisible(false);
                AdministrationOptions.options.setVisible(true);
                this.oldPassword.setText(null);
                this.newPassword.setText(null);
                this.conformPassword.setText(null);
            }
            if (counter == 3)
            {
                JOptionPane.showMessageDialog(this, "<html>You have crossed limit of allowed attemps.<br>Sorry, System is logging out.", "Change Password Failed", JOptionPane.ERROR_MESSAGE);
                this.counter = 0;
                changeAdminPasswordPage.setVisible(false);
                AdministrationLoginPage.loginPage.setVisible(true);
                AdministrationLoginPage.userName = null;
                this.oldPassword.setText(null);
                this.newPassword.setText(null);
                this.conformPassword.setText(null);
            }
        }
    }
    
}