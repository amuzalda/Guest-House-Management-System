package secondPage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class AddAdministrator extends JPanel implements ActionListener
{
    private JButton addButton, cancelButton;
    private JTextField masterUserID, newUserID;
    private JPasswordField masterPassword, newPassword, conformPassword;
    private int counter;
    public static JFrame addAdminPage;
    
    public static void main(String[] args)
    {
        addAdminPage = new JFrame("Administration Login Page");
        AddAdministrator content = new AddAdministrator();
        addAdminPage.setContentPane(content);
        addAdminPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addAdminPage.setVisible(true);
        addAdminPage.setResizable(false);
        addAdminPage.setLocation(200, 100);
        addAdminPage.setSize(new Dimension(495, 560));
    }
    
    public AddAdministrator()
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
    
    private void heading(AddAdministrator admin)
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
    
    private void projectName(AddAdministrator admin)
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
    
    private void projectType(AddAdministrator admin)
    {
        JPanel panel = new JPanel();
        panel.setBackground(GuestHouseManagementSystem.color);
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setPreferredSize(new Dimension(480, 50));
        
        JLabel label1 = new JLabel("<html><p style=\"font-size:15px\">Add New Administrator");
        label1.setForeground(Color.WHITE);
        panel.add(label1);
        
        admin.add(panel);
    }
    
    private void loginDetails(AddAdministrator admin)
    {
        JPanel panel = new JPanel();
        panel.setBackground(GuestHouseManagementSystem.color);
        panel.setLayout(new GridLayout(5, 2, 5, 5));
        panel.setPreferredSize(new Dimension(450, 170));
        
        JLabel masterUserIDLabel = new JLabel("<html><p style=\"font-size:15px\">Master User ID: ");
        masterUserIDLabel.setForeground(Color.WHITE);
        panel.add(masterUserIDLabel);
        
        masterUserID = new JTextField(10);
        panel.add(masterUserID);
        
        JLabel masterPasswordLabel = new JLabel("<html><p style=\"font-size:15px\">Master Password: ");
        masterPasswordLabel.setForeground(Color.WHITE);
        panel.add(masterPasswordLabel);
        
        masterPassword = new JPasswordField(10);
        panel.add(masterPassword);
        admin.add(panel);
        
        JLabel newUserIDLabel = new JLabel("<html><p style=\"font-size:15px\">New User ID: ");
        newUserIDLabel.setForeground(Color.WHITE);
        panel.add(newUserIDLabel);
        
        newUserID = new JTextField(10);
        panel.add(newUserID);
        
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
    
    private void buttons(AddAdministrator admin)
    {
        JPanel panel = new JPanel();
        panel.setBackground(GuestHouseManagementSystem.color);
        panel.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.WHITE));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setPreferredSize(new Dimension(480, 50));
        
        addButton = new JButton("<html><p style=\"font-size:13px\">Add");
        addButton.setPreferredSize(new Dimension(230, 35));
        addButton.setBackground(new Color(187, 231, 238));
        addButton.addActionListener(admin);
        panel.add(addButton);
        
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
            addAdminPage.setVisible(false);
            AdministrationOptions.options.setVisible(true);
            masterUserID.setText(null);
            masterPassword.setText(null);
            newUserID.setText(null);
            newPassword.setText(null);
            conformPassword.setText(null);
            counter = 0;
        }
        else if (src == addButton)
        {
            String masterPasswordString = new String(masterPassword.getPassword());
            String newPasswordString = new String(newPassword.getPassword());
            String conformPasswordString = new String(conformPassword.getPassword());
            if (masterUserID.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please Enter your Master UserID.", "Empty Field!!!", JOptionPane.ERROR_MESSAGE);
                masterPassword.setText(null);
                newUserID.setText(null);
                newPassword.setText(null);
                conformPassword.setText(null);
            }
            else if (masterPasswordString.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please Enter your Master Password.", "Empty Field!!!", JOptionPane.ERROR_MESSAGE);
                masterUserID.setText(null);
                newUserID.setText(null);
                newPassword.setText(null);
                conformPassword.setText(null);
            }
            else if (newUserID.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please Enter new UserID.", "Empty Field!!!", JOptionPane.ERROR_MESSAGE);
                masterUserID.setText(null);
                masterPassword.setText(null);
                newPassword.setText(null);
                conformPassword.setText(null);
            }
            
            else if (newPasswordString.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please Enter your new Password.", "Empty Field!!!", JOptionPane.ERROR_MESSAGE);
                masterUserID.setText(null);
                masterPassword.setText(null);
                newUserID.setText(null);
                conformPassword.setText(null);
            }
            else if (conformPasswordString.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please Enter your conform Password.", "Empty Field!!!", JOptionPane.ERROR_MESSAGE);
                masterUserID.setText(null);
                masterPassword.setText(null);
                newUserID.setText(null);
                newPassword.setText(null);
            }
            else if (!masterUserID.getText().equals(AdministrationLoginPage.masterUserName))
            {
                this.counter++;
                JOptionPane.showMessageDialog(this, "Master UserID is Incorrect", "Invalid Master UserID", JOptionPane.ERROR_MESSAGE);
                masterUserID.setText(null);
                masterPassword.setText(null);
                newUserID.setText(null);
                newPassword.setText(null);
                conformPassword.setText(null);
            }
            else if (!masterPasswordString.equals(AdministrationLoginPage.masterPassword))
            {
                this.counter++;
                JOptionPane.showMessageDialog(this, "Master Password is Incorrect", "Invalid Master Password", JOptionPane.ERROR_MESSAGE);
                masterUserID.setText(null);
                masterPassword.setText(null);
                newUserID.setText(null);
                newPassword.setText(null);
                conformPassword.setText(null);
            }
            else if (!newPasswordString.equals(conformPasswordString))
            {
                this.counter++;
                JOptionPane.showMessageDialog(this, "Conform Password does not equal to new Passwrod.", "Invalid Password", JOptionPane.ERROR_MESSAGE);
                masterUserID.setText(null);
                masterPassword.setText(null);
                newUserID.setText(null);
                newPassword.setText(null);
                conformPassword.setText(null);
            }
            else
            {
                AdministrationLoginPage.loginDetails.put(newUserID.getText(), newPasswordString);
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
                JOptionPane.showMessageDialog(this, "New Administrator user is added successfully.", "Successful", JOptionPane.INFORMATION_MESSAGE);
                this.counter = 0;
                addAdminPage.setVisible(false);
                AdministrationOptions.options.setVisible(true);
                masterUserID.setText(null);
                masterPassword.setText(null);
                newUserID.setText(null);
                newPassword.setText(null);
                conformPassword.setText(null);
            }
            if (counter == 3)
            {
                JOptionPane.showMessageDialog(this, "<html>You have crossed limit of allowed attemps.<br>Sorry, System is logging out.", "Change Master Password Failed", JOptionPane.ERROR_MESSAGE);
                this.counter = 0;
                addAdminPage.setVisible(false);
                AdministrationLoginPage.loginPage.setVisible(true);
                AdministrationLoginPage.userName = null;
                masterUserID.setText(null);
                masterPassword.setText(null);
                newUserID.setText(null);
                newPassword.setText(null);
                conformPassword.setText(null);
            }
        }
    }
    
}