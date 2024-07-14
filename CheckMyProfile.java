package Hospital;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class CheckMyProfile implements ActionListener {
    JFrame f;
    JLabel id, id1, id2, id3, id4, id5, id6, id7, id8, id9;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8;
    JButton b, b1;
    ResultSet rest0, rest;
    public int login__id;
    String q2;

    CheckMyProfile(String admin_id, int login_id) {
        login__id = login_id;

        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "";
            if (login__id == 1) {
                q = "select * from doctor where doc_id='" + admin_id + "'";
            } else if (login__id == 2) {
                q = "select * from patient where pat_id='" + admin_id + "'";
            } else if (login__id == 3) {
                q = "select * from receptionist where res_id='" + admin_id + "'";
            } else if (login__id == 4) {
                q = "select * from admin where admin_id='" + admin_id + "'";
            }
            rest0 = obj.stm.executeQuery(q);

            if (rest0.next()) {
                f = new JFrame("My Profile");
                f.setBackground(Color.WHITE);
                f.setLayout(null);

                id = new JLabel();
                id.setBounds(0, 0, 900, 450);
                id.setLayout(null);

                ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Hospital/Icons/admin login2.jpg"));
                Image i1 = img.getImage().getScaledInstance(900, 450, Image.SCALE_SMOOTH);
                ImageIcon img1 = new ImageIcon(i1);
                id.setIcon(img1);

                id1 = new JLabel("Edit My Details");
                id1.setBounds(280, 30, 500, 50);
                id1.setFont(new Font("Arial", Font.BOLD, 30));
                id1.setForeground(Color.black);
                id.add(id1);
                f.add(id);

                id2 = new JLabel("My Id");
                id2.setBounds(50, 150, 150, 30);
                id2.setFont(new Font("Arial", Font.BOLD, 20));
                id2.setForeground(Color.BLACK);
                id.add(id2);

                t1 = new JTextField();
                t1.setBounds(200, 150, 150, 30);
                t1.setEditable(false);
                id.add(t1);

                id3 = new JLabel("Username");
                id3.setBounds(450, 150, 200, 30);
                id3.setFont(new Font("Arial", Font.BOLD, 20));
                id3.setForeground(Color.BLACK);
                id.add(id3);

                t2 = new JTextField();
                t2.setBounds(600, 150, 150, 30);
                t2.setEditable(false);
                id.add(t2);

                id4 = new JLabel("Name");
                id4.setBounds(50, 200, 100, 30);
                id4.setFont(new Font("Arial", Font.BOLD, 20));
                id4.setForeground(Color.BLACK);
                id.add(id4);

                t3 = new JTextField();
                t3.setBounds(200, 200, 150, 30);
                t3.setEditable(false);
                id.add(t3);

                id5 = new JLabel("Age");
                id5.setBounds(450, 200, 200, 30);
                id5.setFont(new Font("Arial", Font.BOLD, 20));
                id5.setForeground(Color.BLACK);
                id.add(id5);

                t4 = new JTextField();
                t4.setBounds(600, 200, 150, 30);
                id.add(t4);

                id6 = new JLabel("Phone");
                id6.setBounds(50, 250, 100, 30);
                id6.setFont(new Font("Arial", Font.BOLD, 20));
                id6.setForeground(Color.BLACK);
                id.add(id6);

                t5 = new JTextField();
                t5.setBounds(200, 250, 150, 30);
                id.add(t5);

                id7 = new JLabel("City");
                id7.setBounds(450, 250, 100, 30);
                id7.setFont(new Font("Arial", Font.BOLD, 20));
                id7.setForeground(Color.BLACK);
                id.add(id7);

                t6 = new JTextField();
                t6.setBounds(600, 250, 150, 30);
                id.add(t6);

                id8 = new JLabel("Email");
                id8.setBounds(50, 300, 100, 30);
                id8.setFont(new Font("Arial", Font.BOLD, 20));
                id8.setForeground(Color.BLACK);
                id.add(id8);

                t7 = new JTextField();
                t7.setBounds(200, 300, 150, 30);
                id.add(t7);

                id9 = new JLabel("Gender");
                id9.setBounds(450, 300, 100, 30);
                id9.setFont(new Font("Arial", Font.BOLD, 20));
                id9.setForeground(Color.BLACK);
                id.add(id9);

                t8 = new JTextField();
                t8.setBounds(600, 300, 150, 30);
                t8.setEditable(false);
                id.add(t8);

                while (rest0.next()) {
                    t1.setText(rest0.getString(login__id == 1 ? "doc_id" : login__id == 2 ? "pat_id" : login__id == 3 ? "res_id" : "admin_id"));
                    t2.setText(rest0.getString("username"));
                    t3.setText(rest0.getString("name"));
                    t4.setText(rest0.getString("age"));
                    t5.setText(rest0.getString("phone"));
                    t6.setText(rest0.getString("city"));
                    t7.setText(rest0.getString("email"));
                    t8.setText(rest0.getString("gender"));
                }

                b = new JButton("Update");
                b.setBackground(Color.BLACK);
                b.setForeground(Color.WHITE);
                b.setBounds(250, 350, 150, 40);
                id.add(b);

                b1 = new JButton("Cancel");
                b1.setBackground(Color.RED);
                b1.setForeground(Color.WHITE);
                b1.setBounds(450, 350, 150, 40);
                id.add(b1);

                b.addActionListener(this);
                b1.addActionListener(this);

                f.setVisible(true);
                f.setSize(900, 450);
                f.setLocation(300, 100);
            } else {
                JOptionPane.showMessageDialog(null, "Record not found, please fill the right admin id!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) {
            String ad_id = t1.getText();
            String age = t4.getText();
            String phone = t5.getText();
            String city = t6.getText();
            String email = t7.getText();
            String gender = t8.getText();

            try {
                ConnectionClass obj2 = new ConnectionClass();
                if (login__id == 4) {
                    q2 = "Update admin set age='" + age + "', phone='" + phone + "', city='" + city + "', email='" + email + "' where admin_id='" + ad_id + "'";
                } else if (login__id == 3) {
                    q2 = "Update receptionist set age='" + age + "', phone='" + phone + "', city='" + city + "', email='" + email + "' where res_id='" + ad_id + "'";
                } else if (login__id == 2) {
                    q2 = "Update patient set age='" + age + "', phone='" + phone + "', city='" + city + "', email='" + email + "' where pat_id='" + ad_id + "'";
                } else if (login__id == 1) {
                    q2 = "Update doctor set age='" + age + "', phone='" + phone + "', city='" + city + "', email='" + email + "' where doc_id='" + ad_id + "'";
                }
                obj2.stm.executeUpdate(q2);
                JOptionPane.showMessageDialog(null, "Your Details Successfully Updated");
                f.setVisible(false);
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        if (e.getSource() == b1) {
            f.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new CheckMyProfile("SS8574",1);  
    }
}
