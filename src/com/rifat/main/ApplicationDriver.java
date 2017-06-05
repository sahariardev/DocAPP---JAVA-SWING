package com.rifat.main;

import java.awt.EventQueue;

import com.rifat.database.SqLiteJDBC;

public class ApplicationDriver {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					SqLiteJDBC sql=new SqLiteJDBC();
					if(sql.hasUser())
					{
						login lg=new login();
						lg.setVisible(true);
						
					}
					else
					{
						signup sgn=new signup();
						sgn.setVisible(true);
					}
					
					/*
					DocAPP frame = new DocAPP();
					frame.setTitle("Documentation Application ");
					frame.setResizable(false);
					frame.setVisible(true);
					*/
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
