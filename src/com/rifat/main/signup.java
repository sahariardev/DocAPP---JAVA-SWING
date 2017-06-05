package com.rifat.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.rifat.database.SqLiteJDBC;

import java.awt.Color;

public class signup extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public signup() {
		setTitle("Documentation App "); 
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterPassword = new JLabel("Set Password");
		lblEnterPassword.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 26));
		lblEnterPassword.setBounds(116, 40, 175, 42);
		contentPane.add(lblEnterPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(91, 93, 200, 26);
		contentPane.add(passwordField);
		
		JButton submit = new JButton("Submit");
		submit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		submit.setBounds(140, 240, 115, 36);
		contentPane.add(submit);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(91, 187, 200, 26);
		contentPane.add(passwordField_1);
		
		JLabel lblConfirmIt = new JLabel("Confirm it");
		lblConfirmIt.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 26));
		lblConfirmIt.setBounds(140, 130, 121, 42);
		contentPane.add(lblConfirmIt);
		
		JLabel lblNewLabel = new JLabel("* Do not forget the password. You can not log in without it");
		lblNewLabel.setBounds(27, 306, 340, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Keep it safe");
		lblNewLabel_1.setBounds(152, 322, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel error = new JLabel("password did not match");
		error.setForeground(Color.RED);
		error.setBounds(118, 15, 137, 14);
		contentPane.add(error);
		error.setVisible(false);
		submit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String s1=passwordField_1.getText()+"";
				String s2=passwordField.getText()+"";
				if(s1.equals(s2))
				{
					error.setVisible(false);
					// access
					
					if(!s1.equals(""))
					{
						SqLiteJDBC sql=new SqLiteJDBC();
						if(sql.insertUser(s1))
						{
							dispose();
							DocAPP da=new DocAPP();
							da.setVisible(true);
							//System.out.println("Database added ");
						}
					}
				}
				else
				{
					error.setVisible(true);
					//access denied 
				}
				
				
			}});
	}
}
