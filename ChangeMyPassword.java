package Hospital;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ChangeMyPassword extends JFrame implements ActionListener
{
    JFrame f;
    JPanel panel;
    JLabel l1,l2,l3,l4;
    JTextField tf;
    JPasswordField pf;
    JButton bt1,bt2;
    public String admin_id2;
    
    ChangeMyPassword(String admin_id)
    {
       f=new JFrame("Change My Password");
       f.setBackground(Color.WHITE);
       f.setLayout(null);
       
       admin_id2=admin_id;
       
       l1=new JLabel();
       l1.setBounds(0,0,580,350);
       l1.setLayout(null);
       
       ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Hospital/Icons/admin login.jpg"));
       Image i=img.getImage().getScaledInstance(580,350,Image.SCALE_SMOOTH);
       ImageIcon img1=new ImageIcon(i);
       l1.setIcon(img1);
       
       l2=new JLabel("Change My Password");
       l2.setBounds(198,30,500,50);
       l2.setFont(new Font("Arial",Font.BOLD,30));
       l2.setForeground(Color.WHITE);
       l1.add(l2);
       f.add(l1);
       
       l3=new JLabel("Old Password : ");
       l3.setBounds(130,120,150,30);
       l3.setFont(new Font("Arial",Font.BOLD,20));
       l3.setForeground(Color.WHITE);
       l1.add(l3);
       
       l4=new JLabel("New Password : ");
       l4.setBounds(130,170,150,30);
       l4.setFont(new Font("Arial",Font.BOLD,20));
       l4.setForeground(Color.WHITE);
       l1.add(l4);
       
       tf=new JTextField();
       tf.setBounds(310,120,150,30);
       l1.add(tf);
       
       pf=new JPasswordField();
       pf.setBounds(310,170,150,30);
       l1.add(pf);
       
       bt1=new JButton("Change Password");
       bt1.setBackground(Color.BLACK);
       bt1.setForeground(Color.WHITE);
       bt1.setBounds(130,220,150,40);
       l1.add(bt1);
               
       bt2=new JButton("Close");
       bt2.setBackground(Color.BLACK);
       bt2.setForeground(Color.WHITE);
       bt2.setBounds(310,220,150,40);
       l1.add(bt2);
       
       bt1.addActionListener(this);
       bt2.addActionListener(this);
       
       f.setVisible(true);
       f.setSize(580,350);
       f.setLocation(300,100);
       f.setResizable(false);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bt1)
        {
            String old_pass=tf.getText();
            String new_pass=pf.getText();
            // Replace 'ad_id' with your admin ID retrieval logic
           // String ad_id = "YourAdminIDHere";
            
            try { 
                ConnectionClass obj=new ConnectionClass();
                String q="update admin set password='"+new_pass+"' where admin_id='"+admin_id2+"' and password='"+old_pass+"'";
                int ss=obj.stm.executeUpdate(q);
                if(ss==1)
                {
                    JOptionPane.showMessageDialog(null,"Your Password Successfully Updated");
                    f.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"You have entered wrong old password !");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                //JOptionPane.showMessageDialog(null,"Error occurred while updating password.");
            }
        }
        if(ae.getSource()==bt2)
        {
            this.f.setVisible(false);
        }
    }
}

