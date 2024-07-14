package Hospital;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Index extends JFrame implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3;
    JButton b1, b2, b3, b4;
    public int loginId;
    
    Index() {
        setTitle("Index Page");
        setBackground(Color.WHITE);
        setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0, 0, 800, 570);
        l1.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Hospital/Icons/First page.jpg"));
        Image il = img.getImage().getScaledInstance(800, 570, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(il);
        l1.setIcon(img1);

        l2 = new JLabel("IIIT MEDICAL GROUP");
        l2.setBounds(70, 315, 500, 30);
        l2.setFont(new Font("Arial", Font.BOLD, 30));
        l2.setForeground(Color.WHITE);
        l1.add(l2);
        add(l1);

        l3 = new JLabel("Provides best quality healthcare for you");
        l3.setBounds(86, 340, 500, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 13));
        l3.setForeground(Color.WHITE);
        l1.add(l3);

        b1 = new JButton("Doctor");
        b1.setBounds(50, 390, 150, 40);
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        l1.add(b1);

        b2 = new JButton("Patient");
        b2.setBounds(220, 390, 150, 40);
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);
        l1.add(b2);

        b3 = new JButton("Receptionist");
        b3.setBounds(50, 450, 150, 40);
        b3.setBackground(Color.WHITE);
        b3.setForeground(Color.BLACK);
        l1.add(b3);

        b4 = new JButton("Admin");
        b4.setBounds(220, 450, 150, 40);
        b4.setBackground(Color.WHITE);
        b4.setForeground(Color.BLACK);
        l1.add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        setSize(800, 570);
        setLocation(300, 100);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            loginId=1;
            dispose();
            new LoginPage(loginId);
        }
        if (ae.getSource() == b2) {
            loginId=2;
            dispose();
            new LoginPage(loginId);
        }
        if (ae.getSource() == b3) {
            loginId=3;
            dispose();
            new LoginPage(loginId);
        }
        if (ae.getSource() == b4) {
            loginId=4;
            dispose();
            new LoginPage(loginId);
        }
    }

    public static void main(String[] args) {
        new Index();
    }
}
