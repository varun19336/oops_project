package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class login {
	JFrame log;
	JPanel p;
	JLabel welcome,lusername,lpassword,rights;
	JTextField tusername;
	JPasswordField tpassword;
	JButton reset,login;
	JCheckBox showPassword;
	Font f1 = new Font("SansSerif", Font.BOLD, 15);
    Font f2 = new Font("SansSerif", Font.PLAIN, 15);
    Font f3 = new Font("SansSerif", Font.BOLD, 20);
	login() throws SQLException{
		log=new JFrame("Login");
		p= new JPanel();p.setBounds(0,0,400,400);p.setBackground(Color.cyan);
		welcome = new JLabel("Welcome To E-Hub");welcome.setBounds(100, 30, 300, 40);welcome.setFont(f3);
		lusername = new JLabel("Username: ");lusername.setBounds(50, 90, 150, 30);lusername.setFont(f1);
		lpassword = new JLabel("Password: ");lpassword.setBounds(50, 130, 150, 30);lpassword.setFont(f1);
		rights = new JLabel("Copyrights belongs to @team3");rights.setBounds(50,250,300,40);
		tusername = new JTextField();tusername.setBounds(200, 90, 150, 30);tusername.setFont(f2);
		tpassword = new JPasswordField();tpassword.setBounds(200, 130, 150, 30);tpassword.setFont(f2);
		reset = new JButton("Reset");reset.setBounds(50, 210, 100, 30);reset.setFont(f1);reset.setBackground(Color.orange);
		login = new JButton("Login");login.setBounds(200,210, 100, 30);login.setFont(f1);login.setBackground(Color.orange);
		showPassword = new JCheckBox("Show Password");showPassword.setBounds(200, 170, 150, 30);showPassword.setFont(f2);showPassword.setBackground(Color.cyan);
		p.add(welcome);p.add(lusername);p.add(tusername);p.add(lpassword);p.add(tpassword);p.add(showPassword);p.add(reset);p.add(login);p.add(rights);
		log.add(p);
		p.setLayout(null);
		p.setVisible(true);
		log.setVisible(true);
        log.setSize(400,400);log.setBounds(550, 230, 400, 400);
        log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        log.setResizable(false);
        ActionListener x=new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
            	if(e.getSource()==login) {
            		String userText;
                    String pwdText;
                    userText = tusername.getText();
                    pwdText = String.valueOf(tpassword.getPassword());
                    if (userText.equalsIgnoreCase("admin") && pwdText.equalsIgnoreCase("12345")) {
                        JOptionPane.showMessageDialog(log, "Login Successful");
                    	try {
							new admin();
						} catch (SQLException e1) {
							e1.printStackTrace();
						} finally {log.setVisible(false);}
                    } else if(userText.equalsIgnoreCase("client") && pwdText.equalsIgnoreCase("12345")){
                    	JOptionPane.showMessageDialog(log, "Login Successful");
                    	try {
							new client();
						} catch (SQLException e1) {
							e1.printStackTrace();
						} finally {log.setVisible(false);}
                    } else if(userText.equalsIgnoreCase("programmer") && pwdText.equalsIgnoreCase("12345")){
                    	JOptionPane.showMessageDialog(log, "Login Successful");
                    	try {
							new programmer();
						} catch (SQLException e1) {
							e1.printStackTrace();
						} finally {log.setVisible(false);}
                    }else {
                        JOptionPane.showMessageDialog(log, "Invalid Username or Password");
                    }
            	}
            	if(e.getSource() == reset) {
            		tusername.setText("");
            		tpassword.setText("");
            	}
            	if (e.getSource() == showPassword) {
                    if (showPassword.isSelected()) {
                        tpassword.setEchoChar((char) 0);
                    } else {
                        tpassword.setEchoChar('*');
                    }
                }
            }
        };
        login.addActionListener(x);
        reset.addActionListener(x);
        showPassword.addActionListener(x);
	}
}
public class main {
	public static void main(String[] args) throws SQLException {
		new login();
	}
}
