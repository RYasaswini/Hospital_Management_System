package Hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class Add_Appointment extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18;
    JButton bt1, bt2, bt3;
    JPanel p1, p2, p3;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12;
    Font f, f1;
    Choice ch, ch1, ch2;

    Add_Appointment() {
        super("Add Appointment");
        setLocation(450, 10);
        setSize(740, 730);

        f = new Font("Arial", Font.BOLD, 25);
        f1 = new Font("Arial", Font.BOLD, 18);

        ch = new Choice();
        ch1 = new Choice();
        ch2 = new Choice();

        ch2.add("10AM");
        ch2.add("11AM");
        ch2.add("12PM");
        ch2.add("2PM");
        ch2.add("3PM");
        ch2.add("4PM");
        ch2.add("5PM");

        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "SELECT Username FROM patient";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                ch.add(rest.getString("Username")); 
            }
            rest.close(); 
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        l1 = new JLabel("Add Appointment");
        l2 = new JLabel("Username");
        l3 = new JLabel("Name");
        l4 = new JLabel("Email");
        l5 = new JLabel("Father Name");
        l6 = new JLabel("Phone");
        l7 = new JLabel("Material Status");
        l8 = new JLabel("City");
        l9 = new JLabel("Gender");
        l10 = new JLabel("Blood");
        l11 = new JLabel("Age");
        l12 = new JLabel("Date of Birth");
        l13 = new JLabel("Deceased");
        l14 = new JLabel("Check Doctor Availability");
        l15 = new JLabel("Select Doctor");
        l16 = new JLabel("Appointment Date");
        l17 = new JLabel("Appointment Time");
        l18 = new JLabel("Book Appointment");

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        tf8 = new JTextField();
        tf9 = new JTextField();
        tf10 = new JTextField();
        tf11 = new JTextField();
        tf12 = new JTextField();

        // Making certain fields non-editable
        tf1.setEditable(false);
        tf2.setEditable(false);
        tf3.setEditable(false);
        tf4.setEditable(false);
        tf5.setEditable(false);
        tf6.setEditable(false);
        tf7.setEditable(false);
        tf8.setEditable(false);
        tf9.setEditable(false);
        tf10.setEditable(false);

        bt1 = new JButton("Book Appointment");
        bt2 = new JButton("Back");
        bt3 = new JButton("Check");

        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);

        bt1.setBackground(Color.BLUE);
        bt2.setBackground(Color.RED);
        bt3.setBackground(Color.BLACK);

        bt1.setForeground(Color.WHITE);
        bt2.setForeground(Color.WHITE);
        bt3.setForeground(Color.WHITE);
        l1.setHorizontalAlignment(JLabel.CENTER);

        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        l10.setFont(f1);
        l11.setFont(f1);
        l12.setFont(f1);
        l13.setFont(f1);
        l14.setFont(f1);
        l15.setFont(f1);
        l16.setFont(f1);
        l17.setFont(f1);
        l18.setFont(f1);
        ch.setFont(f1);
        ch1.setFont(f1);
        ch2.setFont(f1);

        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);
        tf6.setFont(f1);
        tf7.setFont(f1);
        tf8.setFont(f1);
        tf9.setFont(f1);
        tf10.setFont(f1);
        tf11.setFont(f1);
        tf12.setFont(f1);

        bt1.setFont(f1);
        bt2.setFont(f1);
        bt3.setFont(f1);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(17, 2, 10, 10));

        p2.add(l2);
        p2.add(ch);
        p2.add(l3);
        p2.add(tf1);
        p2.add(l4);
        p2.add(tf2);
        p2.add(l5);
        p2.add(tf3);
        p2.add(l6);
        p2.add(tf4);
        p2.add(l7);
        p2.add(tf5);
        p2.add(l8);
        p2.add(tf6);
        p2.add(l9);
        p2.add(tf7);
        p2.add(l10);
        p2.add(tf8);
        p2.add(l11);
        p2.add(tf9);
        p2.add(l12);
        p2.add(tf10);
        p2.add(l13);
        p2.add(tf11);
        p2.add(l14);
        p2.add(bt3);
        p2.add(l15);
        p2.add(ch1);
        p2.add(l16);
        p2.add(tf12);
        p2.add(l17);
        p2.add(ch2);
        p2.add(bt1);
        p2.add(bt2);

        p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 1, 10, 10));

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Hospital/Icons/admin login2.jpg"));
        Image img1 = img.getImage().getScaledInstance(300, 500, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img1);
        l18 = new JLabel(ic1);

        p3.add(l18);

        setLayout(new BorderLayout(10, 10));
        add(p1, "North");
        add(p2, "Center");
        add(p3, "West");

        ch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                loadPatientDetails(ch.getSelectedItem());
            }
        });
    }

    private void loadPatientDetails(String username) {
        try {
            ConnectionClass obj2 = new ConnectionClass();
            String q1 = "SELECT * FROM patient WHERE Username='" + username + "'";
            ResultSet rest1 = obj2.stm.executeQuery(q1);
            while (rest1.next()) {
                tf1.setText(rest1.getString("name"));
                tf2.setText(rest1.getString("email"));
                tf3.setText(rest1.getString("father_name"));
                tf4.setText(rest1.getString("phone"));
                tf5.setText(rest1.getString("material_status")); 
                tf6.setText(rest1.getString("city"));
                tf7.setText(rest1.getString("gender"));
                tf8.setText(rest1.getString("blood"));
                tf9.setText(rest1.getString("age"));
                tf10.setText(rest1.getString("dob"));
                tf11.setText(rest1.getString("deceased"));
            }
            rest1.close();
        } catch (SQLException exx) {
            if (exx.getMessage().contains("Column 'material_status' not found")) {
                JOptionPane.showMessageDialog(null, "The column 'material_status' does not exist in the database.");
            } else {
                exx.printStackTrace();
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt3) {
            loadDoctorSpecialization(tf11.getText());
        }
        if (e.getSource() == bt1) {
            bookAppointment();
        }
        if (e.getSource() == bt2) {
            this.setVisible(false);
        }
    }

    private void loadDoctorSpecialization(String specialization) {
        ch1.removeAll();
        try {
            ConnectionClass obj3 = new ConnectionClass();
            String q1 = "SELECT * FROM doctor WHERE specialization='" + specialization + "' AND availability='Yes'";
            ResultSet rest4 = obj3.stm.executeQuery(q1);
            while (rest4.next()) {
                ch1.add(rest4.getString("Username"));
            }
            rest4.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    private void bookAppointment() {
        String Username = ch.getSelectedItem();
        String name = tf1.getText();
        String email = tf2.getText();
        String fname = tf3.getText();
        String phone = tf4.getText();
        String mstatus = tf5.getText();
        String city = tf6.getText();
        String gender = tf7.getText();
        String blood = tf8.getText();
        String age = tf9.getText();
        String dob = tf10.getText();
        String deceased = tf11.getText();
        String doctor = ch1.getSelectedItem();
        String app_date = tf12.getText();
        String app_time = ch2.getSelectedItem();
        String app_status = "Open";
        Random r = new Random();
        String app_id = "" + Math.abs(r.nextInt() % 100000);

        try {
            ConnectionClass obj3 = new ConnectionClass();
            String q1 = "INSERT INTO appointment VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = obj3.con.prepareStatement(q1);
            pstmt.setString(1, app_id);
            pstmt.setString(2, Username);
            pstmt.setString(3, name);
            pstmt.setString(4, email);
            pstmt.setString(5, fname);
            pstmt.setString(6, phone);
            pstmt.setString(7, mstatus);
            pstmt.setString(8, city);
            pstmt.setString(9, gender);
            pstmt.setString(10, blood);
            pstmt.setString(11, age);
            pstmt.setString(12, dob);
            pstmt.setString(13, deceased);
            pstmt.setString(14, doctor);
            pstmt.setString(15, app_date);
            pstmt.setString(16, app_time);
            pstmt.setString(17, app_status);

            int aa = pstmt.executeUpdate();
            if (aa == 1) {
                JOptionPane.showMessageDialog(null, "Your Appointment Successfully Booked");
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Please fill all details carefully");
            }
            pstmt.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Add_Appointment().setVisible(true));
    }
}

