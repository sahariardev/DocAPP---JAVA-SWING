package com.rifat.components;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

import com.rifat.database.Content;
import com.rifat.database.SqLiteJDBC;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.Group;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JLabel;

public class SnippetList extends JPanel {
	public ListPanel jp[];

	
	public ListPanel  addOne(int c,Content cnt,Dataview d)
	{
		ListPanel l1=new ListPanel();
		l1.panelId=c;
		l1.contentId=cnt.id;
		JLabel jl=new JLabel(cnt.title);
		l1.setBackground(new Color(200, 255, 166));
        GroupLayout gl = new GroupLayout(l1);
        gl.setHorizontalGroup(
        	gl.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 380, Short.MAX_VALUE)
        		.addComponent(jl)
        		
        );
        gl.setVerticalGroup(
        	gl.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 100, Short.MAX_VALUE)
        		.addComponent(jl)
        	
        );
        l1.setLayout(gl);
        
        l1.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent l) {
				d.setVisible(true);
				
				ListPanel lp=(ListPanel) l.getSource();
				d.setTitleTex(cnt.title);
				d.setTagTex(cnt.tag);
				d.setContentTex(cnt.content);
				d.setContentId(lp.contentId);
				d.setOther(cnt.other);
				System.out.println(lp.panelId);
				
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
		
		return l1;
	}
	
	
	
	public SnippetList(Dataview d)
	{
		  
		 setBackground(new Color(179, 236, 255));
		
		
		 SqLiteJDBC sql=new SqLiteJDBC();
		 Content cnt[]=sql.show();
		 //System.out.println(cnt.length+" hey ");
		 
		jp=new ListPanel[cnt.length];
		final int l=0;
        for(int c=0;c<jp.length;c++)
        {
        	
          	jp[c]=addOne(c,cnt[c],d);
        	  
        	
        }
        
        
        
        GroupLayout mainLayout = new GroupLayout(this);
        setLayout(mainLayout);
        
        
        Group gph=mainLayout.createParallelGroup();
        for(int c=0;c<jp.length;c++)
        {
         gph.addGap(100); 
         gph.addComponent(jp[c],GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE);
         
        }
      	
   
        
        
        
           mainLayout.setHorizontalGroup(
        		mainLayout.createParallelGroup(Alignment.LEADING)
            		.addGroup(mainLayout.createSequentialGroup()
            			.addContainerGap()
            			.addGroup(gph)
            			.addContainerGap(0, Short.MAX_VALUE))
            );
        
        Group gpv=mainLayout.createSequentialGroup();
        ((SequentialGroup) gpv).addContainerGap(20, Short.MAX_VALUE);
        for(int c=0;c<jp.length;c++)
        {
         gpv.addGap(10);
         gpv.addComponent(jp[c],GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE);
        }
        ((SequentialGroup) gpv).addContainerGap(20, Short.MAX_VALUE);
        
        
        mainLayout.setVerticalGroup(
        		mainLayout.createParallelGroup(Alignment.LEADING)
            		.addGroup(gpv)
            );
        
       
		
	}
	
}
