package Hospital;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class View_Doctor extends JFrame implements ActionListener {
    String[] columnNames = {"Name", "Username", "DOB", "Address", "Phone", "Email", "City", "Gender", "Blood Group", "Age", "Clinic No", "Joining Date", "Specialization", "Availability"};
    JButton deleteButton, editButton;
    String[][] data = new String[20][14];
    int i = 0, j = 0;
    JTable table;
    JLabel usernameLabel, actionLabel;
    JTextField usernameField;
    JPanel panel1, panel2, panel3;
    Font font, font1;

    View_Doctor(int login_id) {
        super("Doctor Information");
        setSize(1500, 400);
        setLocation(1, 1);

        font = new Font("MS UI Gothic", Font.BOLD, 15);

        try {
            ConnectionClass obj = new ConnectionClass();
            String query = "SELECT * FROM doctor";
            ResultSet resultSet = obj.stm.executeQuery(query);
            while (resultSet.next()) {
                data[i][j++] = resultSet.getString("name");
                data[i][j++] = resultSet.getString("username");
                data[i][j++] = resultSet.getString("dob");
                data[i][j++] = resultSet.getString("address");
                data[i][j++] = resultSet.getString("phone");
                data[i][j++] = resultSet.getString("email");
                data[i][j++] = resultSet.getString("city");
                data[i][j++] = resultSet.getString("gender");
                data[i][j++] = resultSet.getString("blood");
                data[i][j++] = resultSet.getString("age");
                data[i][j++] = resultSet.getString("clinic");
                data[i][j++] = resultSet.getString("joining_date");
                data[i][j++] = resultSet.getString("specialization");
                data[i][j++] = resultSet.getString("availability");
                i++;
                j = 0;
            }
            table = new JTable(data, columnNames);
            table.setFont(font);
            table.setBackground(Color.BLACK);
            table.setForeground(Color.WHITE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }

        JScrollPane sp = new JScrollPane(table);
        add(sp);

        if (login_id == 4) {
            font1 = new Font("Lucida Fax", Font.BOLD, 25);
            usernameLabel = new JLabel("Doctor Username");
            actionLabel = new JLabel("Delete or Edit any Doctor?");
            actionLabel.setHorizontalAlignment(JLabel.CENTER);

            usernameLabel.setForeground(Color.GRAY);
            actionLabel.setForeground(Color.YELLOW);
            usernameLabel.setFont(font1);
            actionLabel.setFont(font1);

            deleteButton = new JButton("Delete Doctor");
            editButton = new JButton("Edit Doctor Record");

            deleteButton.addActionListener(this);
            editButton.addActionListener(this);

            deleteButton.setBackground(Color.BLACK);
            editButton.setBackground(Color.BLACK);

            deleteButton.setForeground(Color.RED);
            editButton.setForeground(Color.RED);

            usernameField = new JTextField();
            usernameField.setFont(font);

            panel1 = new JPanel();
            panel1.setLayout(new GridLayout(1, 1, 10, 10));
            panel1.add(actionLabel);

            panel2 = new JPanel();
            panel2.setLayout(new GridLayout(1, 4, 10, 10));
            panel2.add(usernameLabel);
            panel2.add(usernameField);
            panel2.add(deleteButton);
            panel2.add(editButton);

            panel3 = new JPanel();
            panel3.setLayout(new GridLayout(2, 1, 10, 10));
            panel3.add(panel1);
            panel3.add(panel2);

            panel1.setBackground(Color.BLACK);
            panel2.setBackground(Color.BLACK);
            panel3.setBackground(Color.BLACK);
            add(panel3, BorderLayout.SOUTH);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        String username = usernameField.getText();
        if (ae.getSource() == deleteButton) {
            try {
                ConnectionClass obj = new ConnectionClass();
                String q = "DELETE FROM doctor WHERE username='" + username + "'";
                obj.stm.executeUpdate(q);

                String q2 = "UPDATE appointment SET appointment_status='Cancel' WHERE doctor_username='" + username + "' AND appointment_status='open'";
                obj.stm.executeUpdate(q2);

                JOptionPane.showMessageDialog(null, "Doctor record deleted successfully.");
                setVisible(false);
                new View_Doctor(4).setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        } else if (ae.getSource() == editButton) {
            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in the Doctor Username!");
            } else {
                setVisible(false);
                new Edit_Doctor(username).setVisible(true);
            }
        }
    }

    // public static void main(String[] args) {
    //     new View_Doctor(4).setVisible(true);
    // }
}
