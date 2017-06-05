package com.rifat.main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.GroupLayout.Alignment;

import com.rifat.components.Dataview;
import com.rifat.components.DocAppSetMenu;
import com.rifat.components.SnippetList;
import com.rifat.database.SqLiteJDBC;

import javax.swing.LayoutStyle.ComponentPlacement;



public class DocAPP extends JFrame {

	private JPanel contentPane;


	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public DocAPP() {
		setTitle("Documentation App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1200, 800);
		setResizable(false);
		
		
		
		 
		 Dataview panel = new Dataview(this);
		 // setting the layout
		 panel.setVisible(false);
		 JScrollPane jScrollPane1=new JScrollPane();
		 
		 SnippetList sl=new SnippetList(panel);
		 
		 
		 jScrollPane1.setViewportView(sl);

         
		
		 
		 

		 
		 GroupLayout layout = new GroupLayout(getContentPane());
		 layout.setHorizontalGroup(
		 	layout.createParallelGroup(Alignment.LEADING)
		 		.addGroup(layout.createSequentialGroup()
		 			.addGap(24)
		 			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
		 			.addPreferredGap(ComponentPlacement.UNRELATED)
		 			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 737, GroupLayout.PREFERRED_SIZE)
		 			.addContainerGap(13, Short.MAX_VALUE))
		 );
		 layout.setVerticalGroup(
		 	layout.createParallelGroup(Alignment.LEADING)
		 		.addGroup(layout.createSequentialGroup()
		 			.addContainerGap()
		 			.addGroup(layout.createParallelGroup(Alignment.LEADING)
		 				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 741, GroupLayout.PREFERRED_SIZE)
		 				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE))
		 			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		 );
		 
	        
	        getContentPane().setLayout(layout);
       
		 
	        
	      //Setting the menu
			 new DocAppSetMenu(this);
		
		
	}
}
