package AttendenceManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewAttendencePage extends JFrame
{
    private JComboBox<String> yearComboBox;
    private JComboBox<String> courseComboBox;
    private JComboBox<String> semesterComboBox;
    private JButton viewRecordsButton;
    private JTable attendanceTable;

    public void initialize() 
    {
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


        yearComboBox = new JComboBox<>(new String[]{"Year I", "Year II", "Year III", "Year IV"});
        courseComboBox = new JComboBox<>(new String[]{"BE CSE", "BTECH IT", "BE EEE", "BE ECE", "BTECH AIDS", "BTECH AIML", "BE CIVIL", "BE MECHANICAL"});
        semesterComboBox = new JComboBox<>(new String[]{"Semester I", "Semester II", "Semester III", "Semester IV", "Semester V", "Semester VI", "Semester VII", "Semester VIII"});

        yearComboBox.setBounds(50, 50, 120, 30);
        courseComboBox.setBounds(200, 50, 120, 30);
        semesterComboBox.setBounds(350, 50, 120, 30);

        c.add(yearComboBox);
        c.add(courseComboBox);
        c.add(semesterComboBox);

        viewRecordsButton = new JButton("View Records");
        viewRecordsButton.setBounds(500, 50, 150, 30);
        c.add(viewRecordsButton);

        attendanceTable = new JTable();
        JScrollPane tableScrollPane = new JScrollPane(attendanceTable);
        tableScrollPane.setBounds(50, 100, 600, 300);
        c.add(tableScrollPane);

        viewRecordsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onViewRecordsClicked();
            }
        });

        displayAllRecords();
    }

    private void onViewRecordsClicked() {
        displayAllRecords();
    }

    private void displayAllRecords() 
    {
        String[] columnNames = {"Student ID", "Name","Year", "Course", "Attendance Percentage"};
        Object[][] data = 
        {
                {"1", "AAA","I","BE CSE", "85%"},
                {"2", "BBB","II","BTECH IT", "92%"},
                {"3", "CCC","III","BTECH AIDS", "78%"},

        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        attendanceTable.setModel(model);
    }

}









