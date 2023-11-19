package AttendenceManagement;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TeacherMainPage extends JFrame
{
    public void initialize()
    {
        setTitle("Teacher Main Page");

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(screenWidth / 2, screenHeight / 2);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        Container c = getContentPane();
        c.setLayout(null);

        JLabel welcomeLabel = new JLabel("TEACHER'S PAGE");
        welcomeLabel.setBounds(0, 10, getWidth() , 30);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBackground(new Color(70, 149, 239));
        welcomeLabel.setOpaque(true);
        welcomeLabel.setForeground(Color.WHITE);
        c.add(welcomeLabel);

        JButton viewButton = new JButton("View Student Attendence");
        JButton editButton = new JButton("Add/Edit Student Attendence");

        viewButton.setBounds(270, 150, 200, 30);
        viewButton.setBackground(new Color(98, 162, 235));
        viewButton.setBorder(null);

        editButton.setBounds(270, 200, 200, 30);
        editButton.setBackground(new Color(98, 162, 235));
        editButton.setBorder(null);

        c.add(viewButton);
        c.add(editButton);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                OpenEditAddAttendancePage openEditAddAttendancePage = new OpenEditAddAttendancePage();
                openEditAddAttendancePage.initialize();
                openEditAddAttendancePage.setVisible(true);
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewAttendencePage viewAttendencePage = new ViewAttendencePage();
                viewAttendencePage.initialize();
                viewAttendencePage.setVisible(true);

            }
        });







    }
    
}