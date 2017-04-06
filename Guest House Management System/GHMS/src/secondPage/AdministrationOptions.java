package secondPage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdministrationOptions extends JPanel implements ActionListener
{
    private JRadioButton goToPortal, changePassword, addAdmin, removeAdmin, editMaster;
    private JButton conformButton, logoutButton;
    public static JFrame options;
    
    public static void main(String[] args)
    {
        options = new JFrame("Administration Options");
        AdministrationOptions content = new AdministrationOptions();
        options.setContentPane(content);
        options.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        options.setVisible(true);
        options.setResizable(false);
        options.setLocation(200, 100);
        options.setSize(new Dimension(350, 295));
    }
    
    public AdministrationOptions()
    {
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        this.setBackground(GuestHouseManagementSystem.color);
        
        this.setLayout(new FlowLayout());
        
        this.chooseOptions(this);
        this.buttons(this);
    }
    
    private void chooseOptions(AdministrationOptions options)
    {
        JPanel panel = new JPanel();
        panel.setBackground(GuestHouseManagementSystem.color);
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 3));
        panel.setPreferredSize(new Dimension(325, 190));
        
        
        ButtonGroup chooseGroup = new ButtonGroup();
        
        goToPortal = new JRadioButton("<html><p style=\"font-size:15px\">Go To Portal");
        goToPortal.setBackground(GuestHouseManagementSystem.color);
        goToPortal.setForeground(Color.WHITE);
        goToPortal.setSelected(true);
        goToPortal.addActionListener(this);
        chooseGroup.add(goToPortal);
        panel.add(goToPortal);
        
        changePassword = new JRadioButton("<html><p style=\"font-size:15px\">Change Password");
        changePassword.setBackground(GuestHouseManagementSystem.color);
        changePassword.setForeground(Color.WHITE);
        changePassword.addActionListener(this);
        chooseGroup.add(changePassword);
        panel.add(changePassword);
        
        addAdmin = new JRadioButton("<html><p style=\"font-size:15px\">Add Administrator");
        addAdmin.setBackground(GuestHouseManagementSystem.color);
        addAdmin.setForeground(Color.WHITE);
        addAdmin.addActionListener(this);
        chooseGroup.add(addAdmin);
        panel.add(addAdmin);
        
        removeAdmin = new JRadioButton("<html><p style=\"font-size:15px\">Remove Administrator");
        removeAdmin.setBackground(GuestHouseManagementSystem.color);
        removeAdmin.setForeground(Color.WHITE);
        removeAdmin.addActionListener(this);
        chooseGroup.add(removeAdmin);
        panel.add(removeAdmin);
        
        editMaster = new JRadioButton("<html><p style=\"font-size:15px\">Edit Master Administrator");
        editMaster.setBackground(GuestHouseManagementSystem.color);
        editMaster.setForeground(Color.WHITE);
        editMaster.addActionListener(this);
        chooseGroup.add(editMaster);
        panel.add(editMaster);
        
        options.add(panel);
    }
    
    private void buttons(AdministrationOptions admin)
    {
        JPanel panel = new JPanel();
        panel.setBackground(GuestHouseManagementSystem.color);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panel.setPreferredSize(new Dimension(325, 50));
        
        conformButton = new JButton("<html><p style=\"font-size:13px\">OK");
        conformButton.setPreferredSize(new Dimension(150, 35));
        conformButton.setBackground(new Color(187, 231, 238));
        conformButton.addActionListener(admin);
        panel.add(conformButton);
        
        logoutButton = new JButton("<html><p style=\"font-size:13px\">Logout");
        logoutButton.setPreferredSize(new Dimension(150, 35));
        logoutButton.setBackground(new Color(187, 231, 238));
        logoutButton.addActionListener(admin);
        panel.add(logoutButton);
        
        admin.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        
        if (src == logoutButton)
        {
            options.setVisible(false);
            AdministrationLoginPage.userName = null;
            AdministrationLoginPage.loginPage.setVisible(true);
        }
        else if (src == conformButton)
        {
            if (goToPortal.isSelected())
            {
            	options.dispose();
            	SP1.main1(null);
                //System.exit(109);
            }
            else if (changePassword.isSelected())
            {
                options.setVisible(false);
                ChangePassword.main(null);
            }
            else if (addAdmin.isSelected())
            {
                options.setVisible(false);
                AddAdministrator.main(null);
            }
            else if (removeAdmin.isSelected())
            {
                options.setVisible(false);
                RemoveAdministrator.main(null);
            }
            else if (editMaster.isSelected())
            {
                options.setVisible(false);
                EditMaster.main(null);
            }
        }
    }
}