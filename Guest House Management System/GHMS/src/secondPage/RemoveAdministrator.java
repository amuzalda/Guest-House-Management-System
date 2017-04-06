package secondPage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class RemoveAdministrator extends JPanel implements ActionListener
{
    private JButton removeButton, cancelButton;
    private JTextField masterUserID, removeUserID;
    private JPasswordField masterPassword;
    private int counter;
    public static JFrame removeAdminPage;
    
    public static void main(String[] args)
    {
        removeAdminPage = new JFrame("Administration Login Page");
        RemoveAdministrator content = new RemoveAdministrator();
        removeAdminPage.setContentPane(content);
        removeAdminPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        removeAdminPage.setVisible(true);
        removeAdminPage.setResizable(false);
        removeAdminPage.setLocation(200, 100);
        removeAdminPage.setSize(new Dimension(495, 490));
    }
    
    public RemoveAdministrator()
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
    
    private void heading(RemoveAdministrator admin)
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
    
    private void projectName(RemoveAdministrator admin)
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
    
    private void projectType(RemoveAdministrator admin)
    {
        JPanel panel = new JPanel();
        panel.setBackground(GuestHouseManagementSystem.color);
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setPreferredSize(new Dimension(480, 50));
        
        JLabel label1 = new JLabel("<html><p style=\"font-size:15px\">Remove Administrator");
        label1.setForeground(Color.WHITE);
        panel.add(label1);
        
        admin.add(panel);
    }
    
    private void loginDetails(RemoveAdministrator admin)
    {
        JPanel panel = new JPanel();
        panel.setBackground(GuestHouseManagementSystem.color);
        panel.setLayout(new GridLayout(3, 2, 5, 5));
        panel.setPreferredSize(new Dimension(450, 100));
        
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
        
        JLabel removeUserIDLabel = new JLabel("<html><p style=\"font-size:15px\">Remove User ID: ");
        removeUserIDLabel.setForeground(Color.WHITE);
        panel.add(removeUserIDLabel);
        
        removeUserID = new JTextField(10);
        panel.add(removeUserID);
    }
    
    private void buttons(RemoveAdministrator admin)
    {
        JPanel panel = new JPanel();
        panel.setBackground(GuestHouseManagementSystem.color);
        panel.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.WHITE));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setPreferredSize(new Dimension(480, 50));
        
        removeButton = new JButton("<html><p style=\"font-size:13px\">Remove");
        removeButton.setPreferredSize(new Dimension(230, 35));
        removeButton.setBackground(new Color(187, 231, 238));
        removeButton.addActionListener(admin);
        panel.add(removeButton);
        
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
            removeAdminPage.setVisible(false);
            AdministrationOptions.options.setVisible(true);
            masterUserID.setText(null);
            masterPassword.setText(null);
            removeUserID.setText(null);
            counter = 0;
        }
        else if (src == removeButton)
        {
            String masterPasswordString = new String(masterPassword.getPassword());
            if (masterUserID.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please Enter your Master UserID.", "Empty Field!!!", JOptionPane.ERROR_MESSAGE);
                masterPassword.setText(null);
                removeUserID.setText(null);
            }
            else if (masterPasswordString.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please Enter your old Master Password.", "Empty Field!!!", JOptionPane.ERROR_MESSAGE);
                masterUserID.setText(null);
                removeUserID.setText(null);
            }
            else if (removeUserID.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please Enter your new Master UserID.", "Empty Field!!!", JOptionPane.ERROR_MESSAGE);
                masterUserID.setText(null);
                masterPassword.setText(null);
            }
            else if (!masterUserID.getText().equals(AdministrationLoginPage.masterUserName))
            {
                this.counter++;
                JOptionPane.showMessageDialog(this, "Master UserID is Incorrect", "Invalid Master UserID", JOptionPane.ERROR_MESSAGE);
                masterUserID.setText(null);
                masterPassword.setText(null);
                removeUserID.setText(null);
            }
            else if (!masterPasswordString.equals(AdministrationLoginPage.masterPassword))
            {
                this.counter++;
                JOptionPane.showMessageDialog(this, "Master Password is Incorrect", "Invalid Master Password", JOptionPane.ERROR_MESSAGE);
                masterUserID.setText(null);
                masterPassword.setText(null);
                removeUserID.setText(null);
            }
            else if (!AdministrationLoginPage.loginDetails.containsKey(removeUserID.getText()))
            {
                this.counter++;
                JOptionPane.showMessageDialog(this, "Administrator does not exist.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                masterUserID.setText(null);
                masterPassword.setText(null);
                removeUserID.setText(null);
            }
            else if (removeUserID.getText().equals(AdministrationLoginPage.userName))
            {
                this.counter++;
                JOptionPane.showMessageDialog(this, "Administrator does not remove itself.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                masterUserID.setText(null);
                masterPassword.setText(null);
                removeUserID.setText(null);
            }
            else
            {
                AdministrationLoginPage.loginDetails.remove(removeUserID.getText());
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
                JOptionPane.showMessageDialog(this, "Administrator has been removed.", "Successful", JOptionPane.INFORMATION_MESSAGE);
                this.counter = 0;
                removeAdminPage.setVisible(false);
                AdministrationOptions.options.setVisible(true);
                masterUserID.setText(null);
                masterPassword.setText(null);
                removeUserID.setText(null);
            }
            if (counter == 3)
            {
                JOptionPane.showMessageDialog(this, "<html>You have crossed limit of allowed attemps.<br>Sorry, System is logging out.", "Change Master Password Failed", JOptionPane.ERROR_MESSAGE);
                this.counter = 0;
                removeAdminPage.setVisible(false);
                AdministrationLoginPage.loginPage.setVisible(true);
                AdministrationLoginPage.userName = null;
                masterUserID.setText(null);
                masterPassword.setText(null);
                removeUserID.setText(null);
            }
        }
        
      
    }
    
}