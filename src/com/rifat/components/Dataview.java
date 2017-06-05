package com.rifat.components;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.rifat.database.Content;
import com.rifat.main.AddDoc;
import com.rifat.main.DocAPP;

public class Dataview extends JPanel {

	private JLabel title;
	private JLabel tags;
	private JTextArea jt;
	private int contentId=-1;
	private String other;
	
	
	public void setOther(String s)
	{
		other=s;
	}
	
	public void setContentId(int id)
	{
		contentId=id;
	}
	public void setTitleTex(String s)
	{
		title.setText(s);
	}
	public void setTagTex(String s)
	{
		tags.setText(s);
	}
	public void setContentTex(String s)
	{
		s=s.replace( "RifatSq","'");
		s=s.replace("RifatDq","\"");
		s=s.replace("RifatSc",";");
		jt.setText(s);
	}
	
	
	public Dataview(JFrame frame)
	{
		title=new JLabel("Wordpress Plugin for Rifat");
		tags=new JLabel("Wordpress");
		JScrollPane js=new JScrollPane();
		jt=new JTextArea();
		
		
		
		JButton  edit=new JButton("Edit");
		
		title.setFont(new java.awt.Font("Perpetua Titling MT", 3, 18));
		title.setForeground(new Color(255,102,102));
		jt.setColumns(20);
		jt.setRows(5);
		jt.setEditable(false);
		js.setViewportView(jt);
		
		edit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(contentId!=-1)
				{
					Content cnt=new Content(title.getText(),jt.getText(),tags.getText(),contentId,other);
					
					frame.dispose();
					AddDoc a=new AddDoc(contentId,cnt,frame);
					a.setVisible(true);
				}
			}
			
			
			
		});
		
		GroupLayout mainLayout = new GroupLayout(this);
		
		
		mainLayout.setHorizontalGroup(
				mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(mainLayout.createSequentialGroup()
	                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(mainLayout.createSequentialGroup()
	                        .addGap(20)
	                        .addComponent(edit)
	                        .addGap(10)
	                        )
	                    .addGroup(mainLayout.createSequentialGroup()
	                        .addGap(20)
	                        .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addComponent(js, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
	                            .addComponent(title, GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(tags, GroupLayout.PREFERRED_SIZE, 491, GroupLayout.PREFERRED_SIZE))))
	                .addContainerGap(41, Short.MAX_VALUE))
	        );
		    mainLayout.setVerticalGroup(
		    		mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(mainLayout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(title, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(tags, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
	                .addGap(30, 30, 30)
	                .addComponent(js, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
	                .addGap(18, 18, 18)
	                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(edit)
	                    )
	                .addContainerGap(15, Short.MAX_VALUE))
	        );

		
		
		
		
	    setLayout(mainLayout);
	}
	
	
	
	
	
	
	
	
}
