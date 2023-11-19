package AttendenceManagement;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class LoginFrame extends JFrame
{
    private JTextField usernameField;
    private JPasswordField passwordField;
    public void initialize() 
    {
        setTitle("Login Page");


        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(screenWidth / 3, screenHeight / 2);
        setResizable(false);
        setLocation(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(null);

        JLabel welcomeLabel = new JLabel("ATTENDENCE RECORD");
        welcomeLabel.setBounds(0, 10, getWidth() , 30);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBackground(new Color(70, 149, 239));
        welcomeLabel.setOpaque(true);
        welcomeLabel.setForeground(Color.WHITE);
        c.add(welcomeLabel);



        JLabel usernameLabel = new JLabel("Username");
        JLabel passwordLabel = new JLabel("Password");

        usernameLabel.setBounds(150, 80, 100, 20);
        passwordLabel.setBounds(150, 120, 100, 20);

        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);

        usernameField.setBounds(220, 80, 120, 20);
        passwordField.setBounds(220, 120, 120, 20);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 170, 200, 30);
        loginButton.setBackground(new Color(98, 162, 235));
        loginButton.setBorder(null);

        Border roundedBorder = new LineBorder(Color.BLUE,1, true); // Adjust the color and thickness as needed
        loginButton.setBorder(roundedBorder);

        c.add(usernameLabel);
        c.add(usernameField);
        c.add(passwordLabel);
        c.add(passwordField);
        c.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });
    }

    private void performLogin() 
    {
        String username = usernameField.getText();
        char[] password = passwordField.getPassword();

        String teacherUsername = "teacher";
        char[] teacherPassword = "password".toCharArray();

        String studentUsername = "student";
        char[] studentPassword = "pass".toCharArray();

        if (username.equals(teacherUsername) && Arrays.equals(password, teacherPassword))
        {
            JOptionPane.showMessageDialog(this, "Welcome, Teacher!", "Success", JOptionPane.INFORMATION_MESSAGE);
            SwingUtilities.invokeLater(new Runnable() 
            {
                @Override
                public void run() {
                    TeacherMainPage teacherMainPage = new TeacherMainPage();
                    teacherMainPage.initialize();
                    teacherMainPage.setVisible(true);
                }
            });
        }
            
        else if (username.equals(studentUsername) && Arrays.equals(password, studentPassword))
        {
            JOptionPane.showMessageDialog(this, "Welcome, Student!", "Success", JOptionPane.INFORMATION_MESSAGE);
        
            SwingUtilities.invokeLater(new Runnable() 
            {
                @Override
                public void run() {
                    StudentPage studentPage = new  StudentPage();
                    studentPage.initialize();
                    studentPage.setVisible(true);
                }
            });
        }
            
        else
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);

        usernameField.setText("");
        passwordField.setText("");
    }
}
