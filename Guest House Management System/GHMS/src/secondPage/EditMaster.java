package secondPage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class EditMaster extends JPanel implements ActionListener
{
    private JButton changeButton, cancelButton;
    private JTextField masterUserID, masterNewUserID;
    private JPasswordField masterPassword, masterNewPassword, masterConformPassword;
    private int counter;
    public static JFrame masterPage;
    
    public static void main(String[] args)
    {
        masterPage = new JFrame("Administration Login Page");
        EditMaster content = new EditMaster();
        masterPage.setContentPane(content);
        masterPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        masterPage.setVisible(true);
        masterPage.setResizable(false);
        masterPage.setLocation(200, 100);
        masterPage.setSize(new Dimension(495, 560));
    }
    
    public EditMaster()
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
    
    private void heading(EditMaster admin)
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
    
    private void projectName(EditMaster admin)
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
    
    private void projectType(EditMaster admin)
    {
        JPanel panel = new JPanel();
        panel.setBackground(GuestHouseManagementSystem.color);
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setPreferredSize(new Dimension(480, 50));
        
        JLabel label1 = new JLabel("<html><p style=\"font-size:15px\">Edit Master Administrator");
        label1.setForeground(Color.WHITE);
        panel.add(label1);
        
        admin.add(panel);
    }
    
    private void loginDetails(EditMaster admin)
    {
        JPanel panel = new JPanel();
        panel.setBackground(GuestHouseManagementSystem.color);
        panel.setLayout(new GridLayout(5, 2, 5, 5));
        panel.setPreferredSize(new Dimension(450, 170));
        
        JLabel masterUserIDLabel = new JLabel("<html><p style=\"font-size:15px\">Old Master User ID: ");
        masterUserIDLabel.setForeground(Color.WHITE);
        panel.add(masterUserIDLabel);
        
        masterUserID = new JTextField(10);
        panel.add(masterUserID);
        
        JLabel masterPasswordLabel = new JLabel("<html><p style=\"font-size:15px\">Old Master Password: ");
        masterPasswordLabel.setForeground(Color.WHITE);
        panel.add(masterPasswordLabel);
        
        masterPassword = new JPasswordField(10);
        panel.add(masterPassword);
        admin.add(panel);
        
        JLabel masterNewUserIDLabel = new JLabel("<html><p style=\"font-size:15px\">New Master User ID: ");
        masterNewUserIDLabel.setForeground(Color.WHITE);
        panel.add(masterNewUserIDLabel);
        
        masterNewUserID = new JTextField(10);
        panel.add(masterNewUserID);
        
        JLabel masterNewPasswordLabel = new JLabel("<html><p style=\"font-size:15px\">New Password: ");
        masterNewPasswordLabel.setForeground(Color.WHITE);
        panel.add(masterNewPasswordLabel);
        
        masterNewPassword = new JPasswordField(10);
        panel.add(masterNewPassword);
        admin.add(panel);
        
        JLabel masterConformPasswordLabel = new JLabel("<html><p style=\"font-size:15px\">Conform Password: ");
        masterConformPasswordLabel.setForeground(Color.WHITE);
        panel.add(masterConformPasswordLabel);
        
        masterConformPassword = new JPasswordField(10);
        panel.add(masterConformPassword);
        admin.add(panel);
    }
    
    private void buttons(EditMaster admin)
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
            masterPage.setVisible(false);
            AdministrationOptions.options.setVisible(true);
            masterUserID.setText(null);
            masterNewUserID.setText(null);
            masterPassword.setText(null);
            masterNewPassword.setText(null);
            masterConformPassword.setText(null);
            counter = 0;
        }
        else if (src == changeButton)
        {
            String masterPasswordString = new String(masterPassword.getPassword());
            String masterNewPasswordString = new String(masterNewPassword.getPassword());
            String masterConformPasswordString = new String(masterConformPassword.getPassword());
            if (masterUserID.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please Enter your Master UserID.", "Empty Field!!!", JOptionPane.ERROR_MESSAGE);
                masterNewUserID.setText(null);
                masterPassword.setText(null);
                masterNewPassword.setText(null);
                masterConformPassword.setText(null);
            }
            else if (masterPasswordString.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please Enter your old Master Password.", "Empty Field!!!", JOptionPane.ERROR_MESSAGE);
                masterUserID.setText(null);
                masterNewUserID.setText(null);
                masterNewPassword.setText(null);
                masterConformPassword.setText(null);
            }
            else if (masterNewUserID.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please Enter your new Master UserID.", "Empty Field!!!", JOptionPane.ERROR_MESSAGE);
                masterUserID.setText(null);
                masterPassword.setText(null);
                masterNewPassword.setText(null);
                masterConformPassword.setText(null);
            }
            
            else if (masterNewPasswordString.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please Enter your new Master Password.", "Empty Field!!!", JOptionPane.ERROR_MESSAGE);
                masterUserID.setText(null);
                masterNewUserID.setText(null);
                masterPassword.setText(null);
                masterConformPassword.setText(null);
            }
            else if (masterConformPasswordString.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please Enter your conform Master Password.", "Empty Field!!!", JOptionPane.ERROR_MESSAGE);
                masterUserID.setText(null);
                masterNewUserID.setText(null);
                masterPassword.setText(null);
                masterNewPassword.setText(null);
            }
            else if (!masterUserID.getText().equals(AdministrationLoginPage.masterUserName))
            {
                this.counter++;
                JOptionPane.showMessageDialog(this, "Master UserID is Incorrect", "Invalid Master UserID", JOptionPane.ERROR_MESSAGE);
                masterUserID.setText(null);
                masterNewUserID.setText(null);
                masterPassword.setText(null);
                masterNewPassword.setText(null);
                masterConformPassword.setText(null);
            }
            else if (!masterPasswordString.equals(AdministrationLoginPage.masterPassword))
            {
                this.counter++;
                JOptionPane.showMessageDialog(this, "Master Password is Incorrect", "Invalid Master Password", JOptionPane.ERROR_MESSAGE);
                masterUserID.setText(null);
                masterNewUserID.setText(null);
                masterPassword.setText(null);
                masterNewPassword.setText(null);
                masterConformPassword.setText(null);
            }
            else if (!masterNewPasswordString.equals(masterConformPasswordString))
            {
                this.counter++;
                JOptionPane.showMessageDialog(this, "Conform Mater Password does not equal to new Master Passwrod.", "Invalid Password", JOptionPane.ERROR_MESSAGE);
                masterUserID.setText(null);
                masterNewUserID.setText(null);
                masterPassword.setText(null);
                masterNewPassword.setText(null);
                masterConformPassword.setText(null);
            }
            else
            {
                AdministrationLoginPage.masterUserName = masterNewUserID.getText();
                AdministrationLoginPage.masterPassword = masterNewPasswordString;
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
                JOptionPane.showMessageDialog(this, "Master Password has been changed.", "Successful", JOptionPane.INFORMATION_MESSAGE);
                this.counter = 0;
                masterPage.setVisible(false);
                AdministrationOptions.options.setVisible(true);
                masterUserID.setText(null);
                masterNewUserID.setText(null);
                masterPassword.setText(null);
                masterNewPassword.setText(null);
                masterConformPassword.setText(null);
            }
            if (counter == 3)
            {
                JOptionPane.showMessageDialog(this, "<html>You have crossed limit of allowed attemps.<br>Sorry, System is logging out.", "Change Master Password Failed", JOptionPane.ERROR_MESSAGE);
                this.counter = 0;
                masterPage.setVisible(false);
                AdministrationLoginPage.loginPage.setVisible(true);
                AdministrationLoginPage.userName = null;
                masterUserID.setText(null);
                masterNewUserID.setText(null);
                masterPassword.setText(null);
                masterNewPassword.setText(null);
                masterConformPassword.setText(null);
            }
        }
        
    }
    
}