package com.rifat.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.rifat.database.SqLiteJDBC;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

public class login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setTitle("Documentation App - Login ");
		setResizable(false);
		setBounds(100, 100, 411, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 26));
		lblEnterPassword.setBounds(105, 70, 175, 42);
		contentPane.add(lblEnterPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(92, 123, 200, 26);
		contentPane.add(passwordField);
		SqLiteJDBC sql=new SqLiteJDBC();
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(136, 171, 115, 36);
		contentPane.add(btnNewButton);
		
		JLabel err = new JLabel("Wrong password");
		err.setForeground(Color.RED);
		err.setBounds(155, 234, 122, 14);
		contentPane.add(err);
		err.setVisible(false);
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String s=passwordField.getText()+"";
				if(sql.matchPass(s))
				{
					err.setVisible(false);
					dispose();
					DocAPP da=new DocAPP();
					da.setVisible(true);
					
				}
				else
				{
					err.setVisible(true);
				}
				
			}});
	}
}
