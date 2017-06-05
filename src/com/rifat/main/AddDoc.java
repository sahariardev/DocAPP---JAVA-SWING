package com.rifat.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.rifat.database.Content;
import com.rifat.database.SqLiteJDBC;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.GroupLayout;
import javax.swing.JButton;

public class AddDoc extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField tags;
	private JTextField others;
	private JFileChooser filechooser;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AddDoc(int id,Content dataCnt,JFrame  frame) {
		setTitle("Add Doc");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(38, 27, 179, 14);
		contentPane.add(lblNewLabel);
		
		filechooser=new JFileChooser();
		
		textField = new JTextField();
		textField.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
		textField.setBounds(38, 52, 604, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContent = new JLabel("Content");
		lblContent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContent.setBounds(38, 90, 179, 14);
		contentPane.add(lblContent);
		
		JScrollPane js=new JScrollPane();
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(38, 115, 598, 364);
		
		js.setViewportView(textArea);
		
		
		
		contentPane.add(js);
		
		JLabel lblTags = new JLabel("Tags");
		lblTags.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTags.setBounds(38, 490, 179, 27);
		contentPane.add(lblTags);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(509, 518, 89, 35);
		
		
		
		
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 115, 604, 369);
		contentPane.add(scrollPane);
		
		JTextArea content = new JTextArea();
		scrollPane.setViewportView(content);
		
		tags = new JTextField();
		tags.setBounds(38, 521, 401, 32);
		contentPane.add(tags);
		tags.setColumns(10);
		
		others = new JTextField();
		others.setColumns(10);
		others.setBounds(38, 600, 401, 32);
		contentPane.add(others);
		
		JLabel lblOthers = new JLabel("Others");
		lblOthers.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOthers.setBounds(38, 569, 179, 27);
		contentPane.add(lblOthers);
		
		JLabel lblseparteWithComma = new JLabel("* Separte with comma");
		lblseparteWithComma.setBounds(299, 555, 140, 14);
		contentPane.add(lblseparteWithComma);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(509, 565, 89, 31);
		contentPane.add(btnDelete);
		
		JButton exportBtn = new JButton("Export");
		exportBtn.setBounds(509, 605, 89, 31);
		contentPane.add(exportBtn);
		JFrame jframe=this;
		
		if(id!=-1)
		{
			textField.setText(dataCnt.title);
			content.setText(dataCnt.content);
			tags.setText(dataCnt.tag);
			System.out.println(dataCnt.other);
			others.setText(dataCnt.other);
			
			
		}
		this.addWindowListener(new WindowListener (){

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				DocAPP f=new DocAPP();
				f.setVisible(true);
				
				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
		SqLiteJDBC sql=new SqLiteJDBC();
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				Content cnt=new Content();
				cnt.title=textField.getText();
				cnt.content=content.getText().replace("'", "RifatSq");
				cnt.content=cnt.content.replace("\"", "RifatDq");
				cnt.content=cnt.content.replace(";", "RifatSc");
				cnt.tag=tags.getText();
				cnt.other=others.getText();
				
				
				if(id==-1)
				{
				if(sql.insert(cnt))
					{
					JOptionPane.showMessageDialog(jframe,
						    "One Doc Successfully added ",
						    "Message",
						    JOptionPane.PLAIN_MESSAGE);
					}
				
				}
				else
				{
					if(sql.update(cnt, id))
					{
						JOptionPane.showMessageDialog(jframe,
							    "One Doc Successfully Updated ",
							    "Message",
							    JOptionPane.PLAIN_MESSAGE);
					}
					
				}
				
			}});
		
		exportBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(filechooser.showSaveDialog(AddDoc.this) == JFileChooser.APPROVE_OPTION)
				{
					System.out.println(filechooser.getSelectedFile());
					String filename=filechooser.getSelectedFile()+"";
					createFile( filename,content.getText());
				}
				
			}});
		btnDelete.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				int n = JOptionPane.showConfirmDialog(
					    frame,
					    "Do you want to delete it?",
					    "Delete",
					    JOptionPane.YES_NO_OPTION);
				if(n==JOptionPane.YES_NO_OPTION)
				{
					sql.delete(id);
					dispose();
				}
			}});
	}
	
	public void createFile(String FILENAME,String content)
	{
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			

			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(content);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
	   }
	}
}
