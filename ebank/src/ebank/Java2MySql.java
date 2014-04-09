package ebank;
import java.sql.*;
public class Java2MySql
{
  /* static block is executed when a class is loaded into memory 
   * this block loads MySQL's JDBC driver
   */
	 private static String connectionUrl = "jdbc:mysql://localhost:3306/sba";
	 private static String dbUser = "root";
	 private static String dbPwd = "";
	 private static Connection conn;
	 private static ResultSet rs;
  /*static
  {
    try
    {
      // loads com.mysql.jdbc.Driver into memory
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
    } 
    catch (ClassNotFoundException cnf) 
    {
      System.out.println("Driver could not be loaded: " + cnf);
    }
    catch (SQLException sqle) 
    {
      System.out.println("SQL Exception thrown: " + sqle);
    }
  }*/

  public static void main(String[] args)
  {
	  Java2MySql j1=new Java2MySql();

	  int x=j1.ch(1);
	  System.out.println(x);
    
  }
 
  public int validate(int uid,String pswd)
  {
String queryString = "SELECT * FROM `login` WHERE `uid`=" + uid + " and `password`= '" + pswd+"'";
int bal=0;
	  try {
		    try {

			// loads com.mysql.jdbc.Driver into memory
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		    } catch (ClassNotFoundException cnf) {
			System.out.println("Driver could not be loaded: " + cnf);
		    } catch (SQLException sqle) {
			System.out.println("SQL Exception thrown: " + sqle);
		    }
		    Statement stmt = conn.createStatement();
	    	
	    
		    rs = stmt.executeQuery(queryString);
			 
		     // System.out.println("Balance calculations");
		   
		    
		      while(rs.next())
		      {
		        bal++;
		        //System.out.print(rs.get("uid"));
		       // System.out.println();
		      }
		     
		     
		  
	      
	  
	    
	     
	      if (conn != null)
	      {
	        conn.close();
	        conn = null;
	       
	      }
	      if(bal==1)
	    	  return 1;
	      else
	    	  return 1;
	    }
	    catch (SQLException sqle) 
	    {
	      //System.out.println("SQL Exception thrown: " + sqle);
	     
	    }
	  if(bal==1)
    	  return 1;
      else
    	  return 1;
  }
 
  
  public void withd(int acc_id,int amt)//returns balance
  {	
	
	  
	  String queryString = "Update account set balance=balance-"+amt+" where acc_id="+acc_id;
	  
	  try {
		    try {

			// loads com.mysql.jdbc.Driver into memory
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		    } catch (ClassNotFoundException cnf) {
			System.out.println("Driver could not be loaded: " + cnf);
		    } catch (SQLException sqle) {
			System.out.println("SQL Exception thrown: " + sqle);
		    }
		    Statement stmt = conn.createStatement();
	    	
	    
	    	 stmt.executeUpdate(queryString);
	         // Execute the Update
	       //  int rows = stmt.executeUpdate( "UPDATE transactions SET uid = 500- WHERE tid = 123" ) ;

	         // Print how many rows were modified
	        // System.out.println( rows + " Rows modified" ) ;
	   
	      
	  
	    
	     
	      if (conn != null)
	      {
	        conn.close();
	        conn = null;
	       
	      }
	    }
	    catch (SQLException sqle) 
	    {
	      //System.out.println("SQL Exception thrown: " + sqle);
	     
	    }
		
  }
  public int ch(int id)//returns balance
  {
	  String queryString = "SELECT balance FROM account where acc_id="+id;
	  int bal=0; 
	   
	    	try {
	    	    try {

	    		// loads com.mysql.jdbc.Driver into memory
	    		Class.forName("com.mysql.jdbc.Driver");
	    		conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
	    	    } catch (ClassNotFoundException cnf) {
	    		System.out.println("Driver could not be loaded: " + cnf);
	    	    } catch (SQLException sqle) {
	    		System.out.println("SQL Exception thrown: " + sqle);
	    	    }
	    	    Statement stmt = conn.createStatement();

	      rs = stmt.executeQuery(queryString);
	 
	     // System.out.println("Balance calculations");
	   
	      
	      while(rs.next())
	      {
	        bal=rs.getInt("balance");
	        //System.out.print(rs.get("uid"));
	       // System.out.println();
	      }
	     
	      if (conn != null)
	      {
	        conn.close();
	        conn = null;
	       
	      }
	    }
	    catch (SQLException sqle) 
	    {
	      //System.out.println("SQL Exception thrown: " + sqle);
	      return 0;
	    }
		return bal;
  }
  public void tr(int acc_id,int amt)
  {

String queryString = "Update account set balance=balance+"+amt+" where acc_id="+acc_id;
	  try {
		    try {

			// loads com.mysql.jdbc.Driver into memory
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		    } catch (ClassNotFoundException cnf) {
			System.out.println("Driver could not be loaded: " + cnf);
		    } catch (SQLException sqle) {
			System.out.println("SQL Exception thrown: " + sqle);
		    }
		    Statement stmt = conn.createStatement();
	    	
	    
	    	 stmt.executeUpdate(queryString);
	         // Execute the Update
	       //  int rows = stmt.executeUpdate( "UPDATE transactions SET uid = 500- WHERE tid = 123" ) ;

	         // Print how many rows were modified
	        // System.out.println( rows + " Rows modified" ) ;
	   
	      
	  
	    
	     
	      if (conn != null)
	      {
	        conn.close();
	        conn = null;
	       
	      }
	    }
	    catch (SQLException sqle) 
	    {
	      //System.out.println("SQL Exception thrown: " + sqle);
	     
	    }
	  
  }
public int createFd(int uid,float r,int n,float i,float p,float amt_after)
{
	  try {
		    try {

			// loads com.mysql.jdbc.Driver into memory
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		    } catch (ClassNotFoundException cnf) {
			System.out.println("Driver could not be loaded: " + cnf);
		    } catch (SQLException sqle) {
			System.out.println("SQL Exception thrown: " + sqle);
		    }
		   
	    	
	
	String sql="INSERT INTO fd  VALUES ("+uid+","+r+","+n+","+i+","+p+","+amt_after+")";
    

    
    Statement st = conn.createStatement();
	st.executeUpdate(sql);
	
	System.out.println("\n Your Amount Rs."+p+"/- has been succcessfully added for Fixed Deposit and you will get Rs."+amt_after+"/- after period of "+n+" months.");
	return 0;
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		return 1;
	}
}
}