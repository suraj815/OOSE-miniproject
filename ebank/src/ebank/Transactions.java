package ebank;


import java.awt.*;
import java.sql.*;

import javax.swing.*;

import java.awt.event.*;
//import java.applet.*;
import java.awt.event.*;

import javax.swing.*;


public class Transactions 
{
	String result;
	Convert c=new Convert();
	int uid;
	
	
	public Transactions(int uid1)
	{
		uid=uid1;
	}
	
	public final String withdraw(String amt2)
	{
		  Java2MySql j1=new Java2MySql();

		  int x=j1.ch(uid);
		  
		int amt=c.toInt(amt2);
		int accbal=x;
		if(amt%100==0)
		{
			 if(amt<=accbal-500)
			 {
				 accbal=accbal-amt;
				 j1.withd(uid,amt);
				 
				 result="<html> <h2> Your Transaction was Successfull. <br> You have Rs. "+accbal+" /- account balance. <br> Thank you for Banking with us. </h2>  </html>";
				 addTr(uid, "Withd", x,accbal,0);
			 }
			 else
			 {
				 result="<html> <h2> You don't have Sufficient Balance </h2>  </html>";
				 
			 }
		}
		return result;
	}
	
	public final String transfer(String acc,String amt)
	{
		String res="";
		  Java2MySql j1=new Java2MySql();

		  int x=j1.ch(uid);
		  int amnt=c.toInt(amt);
		  int did=c.toInt(acc);
		if(amnt<x)
		{
			res="<html> <h2 align='center'> Your amount Rs."+amnt+" has been <br>Successfully debited to account number "+acc+"</h2> </html>";
			j1.withd(uid, amnt);
			j1.tr(did, amnt);
			int j=j1.ch(uid);
			addTr(uid, "Trans", x,j,did);
		}
		else
		{
			res="<html> <h2> Sorry you don't have enough balance to proceed with these transaction </h2> </html>";
		}
		return res;
	}
	
	public void perform_again()
	{
		
	}
	
	public String checkBalance()
	{
		Java2MySql j1=new Java2MySql();
		int amt=j1.ch(uid);
		String res="";
		res="<html> <h2>"
			+ "<br> Your account balance is "
			+ "<br>  Rs. "+amt+" /-"
			+ "</h2> </html>";
		addTr(uid, "Chk Bal", amt,amt,0);
		return res;
	}
	
	public final String fixedDeposit(String optno,String amt)
	{
		String res="";
		int choice=c.toInt(optno);
		Java2MySql j1=new Java2MySql();

		  int x=j1.ch(uid);
		float p=c.toInt(amt);
		
		if(p>=x)
		{
			res="<html> <h2> Low balance </h2> </html>";
			return res;
		}
		int n=0;
		float r=0.00f;
		//res="<html> <h1 align='center'> choice is  "+choice+" \t optnio "+optno+"\tamt is "+amt+" </h1> </html>";
		switch(choice)
		{
		case 1:
			n=9;
			r=1.33f;
			break;

		case 2:
			n=12;
			r=1.53f;
			break;

		case 3:
			n=20;
			r=2.10f;
			break;
		
		}
		if(choice>=1 && choice<=3)
		{
			//float i=p*n*r/100f;
			//float amt_after=p+i;
			
			try
			{
				float i=p*n*r/100f;
				float amt_after=p+i;
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SBA","root","");
				Statement st = conn.createStatement();
				String sql="INSERT INTO fd (uid,rate,period,interest,amt,amt_after) VALUES ("+uid+","+r+","+n+","+i+","+p+","+amt_after+")";
				st.executeUpdate(sql);
				System.out.println("\n Your Amount Rs."+p+"/- has been succcessfully added for Fixed Deposit and you will get Rs."+amt_after+"/- after period of "+n+" months.");
				res="<html> <h1 align='center'> "
						+ "<br> Your Amount Rs."+p+"/- "
						+ "<br> has been succcessfully added for"
						+ "<br>  Fixed Deposit and you will get "
						+ "<br> Rs."+amt_after+"/- after period "
						+ "<br> of "+n+" months. </h1> </html>";
				j1.withd(uid, (int)p);
				int j=j1.ch(uid);
				addTr(uid, "FD", x,j,0);
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		else res="<html> <h1 align='center'> Invalid transaction </h1> </html>";
		return res;
	}
	
	public void updateAccountDetails()
	{
		
	}

	public final boolean checkAcc(String acc)
	{
		int a1=c.toInt(acc);
		
		int bal=0;
	
		 try
		 {
			String sql = "SELECT * FROM `login` WHERE `uid`=" + a1;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sba","root","");
			Statement st = conn.createStatement();
			ResultSet rs=st.executeQuery(sql);;
			while(rs.next())
				bal++;
			 
		 }
		 catch(Exception r)
		 {
		 System.out.println(r);
		 }
		 if(bal==1)
			 return true;
		 else
			 return false;
	}

	public static void main(String args[])
	{
		
	}
	public void addTr(int uid,String type,int pre,int post,int did)//returns balance
	  {	
		
		  
		String sql="INSERT INTO `transactions` (`uid`, `type`, `pre_bal`, `post_bal`, `did`) VALUES ("+uid+", '"+type+"', "+pre+", "+post+", "+did+")";
		 
		  try {
			    try {

				// loads com.mysql.jdbc.Driver into memory
		    	Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SBA","root","");
				Statement st = conn.createStatement();
		    	st.executeUpdate(sql);
			    } catch (ClassNotFoundException cnf) {
				System.out.println("Driver could not be loaded: " + cnf);
			    } catch (SQLException sqle) {
				System.out.println("SQL Exception thrown: " + sqle);
			    }
	  }catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
}
}
