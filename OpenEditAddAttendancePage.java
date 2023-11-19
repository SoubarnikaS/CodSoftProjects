package AttendenceManagement;
// import org.jdatepicker.JDatePicker;
// import org.jdatepicker.UtilDateModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class OpenEditAddAttendancePage extends JFrame {

    private JTextField studentIdField;
    private JComboBox<String> subjectComboBox;
    // private JDatePicker datePicker;
    private JTextField hoursAttendedField;
    private JTable attendanceTable;

    public void initialize() {
        setTitle("Edit/Add Attendance");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(null);

        // Student ID
        JLabel studentIdLabel = new JLabel("Student ID:");
        studentIdField = new JTextField(10);
        studentIdLabel.setBounds(25,10,170,20);
        studentIdField.setBounds(130,10,170,20);
        container.add(studentIdLabel);
        container.add(studentIdField);

        // Subject Dropdown
        JLabel subjectLabel = new JLabel("Subject:");
        subjectComboBox = new JComboBox<>(new String[]{"Math", "English", "Science"});
        subjectLabel.setBounds(25,40,170,20);
        subjectComboBox.setBounds(130,40,170,20);
        container.add(subjectLabel);
        container.add(subjectComboBox);

        // Date Picker
        // JLabel dateLabel = new JLabel("Date:");
        // UtilDateModel model = new UtilDateModel();
        // Properties properties = new Properties();
        // properties.put("text.today", "Today");
        // properties.put("text.month", "Month");
        // properties.put("text.year", "Year");
        // datePicker = new JDatePicker(model, properties);
        // container.add(dateLabel);
        // container.add(datePicker);

        // Hours Attended
        JLabel hoursAttendedLabel = new JLabel("Hours Attended");
        hoursAttendedField = new JTextField(10);
        hoursAttendedLabel.setBounds(25,80,170,20);
        hoursAttendedField.setBounds(130,80,170,20);
        container.add(hoursAttendedLabel);
        container.add(hoursAttendedField);

        // Save Button
        JButton saveButton = new JButton("Save");
        saveButton.setBounds(25,120,270,20);
        container.add(saveButton);

        // Table for displaying attendance records
        attendanceTable = new JTable();
        JScrollPane tableScrollPane = new JScrollPane(attendanceTable);
        // container.add(tableScrollPane);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAttendance();
            }
        });

        setVisible(true);
    }

    private void saveAttendance() {
        
        refreshTable();
    }

    private void refreshTable() {
        
        String[] columnNames = {"Date", "Hours Attended"};
        Object[][] data = {
                {"2023-11-01", "4"},
                {"2023-11-02", "3"},
                {"2023-11-03", "5"}
                // Add more rows as needed
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        attendanceTable.setModel(model);
    }

   
}

