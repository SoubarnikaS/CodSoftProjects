package AttendenceManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentPage extends JFrame {

    private JComboBox<String> yearComboBox;
    private JComboBox<String> semesterComboBox;
    private JTable attendanceTable;

    public void initialize() {
        setTitle("Attendance Page");

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(screenWidth / 2, screenHeight / 2);
        // setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(null);

        JLabel titleLabel = new JLabel("Attendance Records");
        titleLabel.setBounds(0, 10, getWidth(), 30);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBackground(new Color(70, 149, 239));
        titleLabel.setOpaque(true);
        titleLabel.setForeground(Color.WHITE);
        c.add(titleLabel);

        yearComboBox = new JComboBox<>(new String[] { "Year I", "Year II", "Year III", "Year IV" });
        semesterComboBox = new JComboBox<>(new String[] { "Semester I", "Semester II", "Semester III",
                "Semester IV", "Semester V", "Semester VI", "Semester VII", "Semester VIII" });

        yearComboBox.setBounds(50, 50, 120, 30);
        semesterComboBox.setBounds(250, 50, 120, 30);

        JButton viewButton = new JButton("View Records");
        viewButton.setBounds(450,50,120,30);

        c.add(yearComboBox);
        c.add(semesterComboBox);
        c.add(viewButton);

        String[] columnNames = { "Subject", "Total Hours", "Hours Attended", "Percentage" };

        
        Object[][] data = {
                { "Math", 20, 15, 75.0 },
                { "English", 18, 12, 66.7 },
                { "Science", 22, 18, 81.8 },
                
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        attendanceTable = new JTable(model);

        JScrollPane tableScrollPane = new JScrollPane(attendanceTable);
        tableScrollPane.setBounds(50, 100, 600, 300);
        c.add(tableScrollPane);
    }

}
