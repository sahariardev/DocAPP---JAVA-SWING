package com.rifat.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import com.rifat.database.Content;
import com.rifat.main.AddDoc;

public class DocAppSetMenu {
	
	private AddDoc adddoc;
	public  DocAppSetMenu(JFrame frame)
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu setting=new JMenu("Setting");
		JMenu file=new JMenu("File");
		JMenuItem help =new JMenuItem("<html><div style='padding:5px 15px;'>Help</div></html>");
		JMenuItem dev=new JMenuItem("<html><div style='padding:5px 15px;'>Developer</div></html>");
		JMenuItem configur=new JMenuItem("<html><div style='padding:5px 15px;'>Configur	</div></html>");
		JMenuItem addItem=new JMenuItem("<html><div style='padding:5px 15px;'>Add Item	</div></html>");
		JMenuItem refresh=new JMenuItem("<html><div style='padding:5px 15px;'>Close	</div></html>");
		
		addItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//addframe.setVisible(true);
				frame.dispose();
				adddoc=new AddDoc(-1,new Content(),frame);
				adddoc.setVisible(true);
				
				
			}
			
			
		});
		
		refresh.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
			}
			
			
		});
		
		dev.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(frame,
					     "  Sahariar Alam Khandoker \n Email:: rifatsahariar@gmail.com.",
					    "Developer",
					    JOptionPane.PLAIN_MESSAGE);
			}
			
			
		});
		
		
		file.add(addItem);
		file.add(dev);
		file.add(refresh);
		setting.add(configur);
		//setting.addSeparator();
		setting.add(help);
		//setting.addSeparator();
		//setting.add(dev);
		menuBar.add(file);
		//menuBar.add(setting);
		
		frame.setJMenuBar(menuBar);
	}

}
