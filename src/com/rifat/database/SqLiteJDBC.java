package com.rifat.database;
import java.sql.*;

public class SqLiteJDBC {
	private Connection c;
	private Statement stmt;
	public SqLiteJDBC()
	{
		Connection c=null;
		Statement stmt=null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:DocumentationApp.db");
	         
	         
	         
	         
	         
	         stmt = c.createStatement();
	         String sql = "CREATE TABLE IF NOT EXISTS DOCS " +
	                        " (  ID             INTEGER PRIMARY KEY      AUTOINCREMENT," +
	                        "   Title           TEXT    NOT NULL, " + 
	                        "   Content            TEXT     NOT NULL, " +
	                        "Others           TEXT      ,"+
	                        "Tags             TEXT    ,"+
	                        " TIME NOT NULL DEFAULT CURRENT_TIMESTAMP );"; 
	        
	         stmt.executeUpdate(sql);
	                 sql = "CREATE TABLE IF NOT EXISTS USER " +
                     " (  Password             TEXT," +
                     
                     " TIME NOT NULL DEFAULT CURRENT_TIMESTAMP );"; 
	                 
	                
	                 stmt.executeUpdate(sql);
	         
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	         
	      }
	      
	       
	      
	
	
	
	}
	
	public boolean hasUser()
	{
		boolean flag=false;
		ResultSet rs2;
		try
		{
			 Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:DocumentationApp.db");
	         c.setAutoCommit(false);
	         stmt = c.createStatement();
	         String sql="SELECT * From USER";
	         
	        
		      
		      rs2 = stmt.executeQuery(sql );
		      int size=0;
		      if(rs2.next())
		      {
		    	  System.out.println(rs2.getString("Password"));
		    	  flag=true;
		      }
		      
		      rs2.close();
		      stmt.close();
		      c.close();
	         
	         
		}catch(Exception e)
		{
			
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
			return false;
		}
		
		return flag;
	}
	
	public boolean matchPass(String s)
	{
		boolean flag=false;
		ResultSet rs2;
		try
		{
			 Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:DocumentationApp.db");
	         c.setAutoCommit(false);
	         stmt = c.createStatement();
	         String sql="SELECT * From USER";
	      
	        
		      
		      rs2 = stmt.executeQuery(sql );
		      int size=0;
		      if(rs2.next())
		      {
		    	  if(rs2.getString("Password").equals(s) )
		    	  {
		    		  flag=true;
		    	  }
		    	  else
		    	  {
		    		  flag =false;
		    	  }
		      }
		      
		      rs2.close();
		      stmt.close();
		      c.close();
	         
	         
		}catch(Exception e)
		{
			
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
			return false;
		}
		
		return flag;
	}
	
	public boolean insertUser(String s)
	{
		
		try
		{
			 Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:DocumentationApp.db");
	         c.setAutoCommit(false);
	         stmt = c.createStatement();
	         String sql="Insert into USER (password) "+" VALUES ( '"+s+"' );";
	         
	         stmt.executeUpdate(sql);

	         stmt.close();
	         c.commit();
	         c.close();
	         
	         
	         
	         
		}catch(Exception e)
		{
			
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
			return false;
		}
		
		return true;
	}
	
	public boolean insert(Content cnt)
	{
		try
		{
			 Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:DocumentationApp.db");
	         c.setAutoCommit(false);
	         stmt = c.createStatement();
	         String sql="Insert into DOCS (Title,Content,Tags,Others) "+" VALUES ( '"+cnt.title+"' , '" +cnt.content+"' , '"+cnt.tag+"' , '"+cnt.other+"' );";
	         
	         stmt.executeUpdate(sql);

	         stmt.close();
	         c.commit();
	         c.close();
	         
	         System.out.println(cnt);
	         
	         
		}catch(Exception e)
		{
			
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
			return false;
		}
		
		return true;
	}
	public boolean update(Content cnt,int id)
	{
		try
		{
			 Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:DocumentationApp.db");
	         c.setAutoCommit(false);
	         stmt = c.createStatement();
	         String sql="UPDATE DOCS SET"+ " Title = '"+cnt.title+"' , Content = '"+cnt.content+"' , Tags = '"+cnt.tag+"' , Others = '"+cnt.other +"' where id = "+id+" ;";
	         
	         stmt.executeUpdate(sql);

	         stmt.close();
	         c.commit();
	         c.close();
			return true;
	         
	         
	         
		}catch(Exception e)
		{
			
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
			return false;
		}
		
		
	}
	public boolean delete(int id)
	
	{
		 
	      
	      try
			{
				 Class.forName("org.sqlite.JDBC");
		         c = DriverManager.getConnection("jdbc:sqlite:DocumentationApp.db");
		         c.setAutoCommit(false);
		         stmt = c.createStatement();
		         String sql = "DELETE from Docs where ID="+id +";";
			      stmt.executeUpdate(sql);
			      c.commit();
			      stmt.close();
			      c.close();
			      return true;
		         
		         
		         
			}catch(Exception e)
			{
				
				System.err.println( e.getClass().getName() + ": " + e.getMessage() );
				return false;
			}
	      
	      
		
	}
	public Content[] show()
	{
		

		Content [] cnt;
		
	      try
			{
				 Class.forName("org.sqlite.JDBC");
		         c = DriverManager.getConnection("jdbc:sqlite:DocumentationApp.db");
		         c.setAutoCommit(false);
		         
		         String sql = "SELECT * From DOCS";
			      stmt=c.createStatement();
			      
			      ResultSet rs2 = stmt.executeQuery(sql );
			      int size=0;
			      while(rs2.next())
			      {
			    	 size++; 
			      }
			      
			      rs2.close();
			      
			      ResultSet rs = stmt.executeQuery(sql );
			      cnt=new Content[size];
			      int i=0;
			      while(rs.next())
			      {
			    	  System.out.println(rs.getString("ID"));
			    	  cnt[i]=new Content(rs.getString("Title"),rs.getString("Content"),rs.getString("Tags"),rs.getInt("ID"),rs.getString("Others"));
			    	  	    	  
			    	  i++;
			      }
			      
			      rs.close();
			      stmt.close();
			      c.close();
			      return cnt;
		         
		         
		         
			}catch(Exception e)
			{
				
				System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		         System.exit(0);
				return null;
			}
		
	}
	
	
	
}
