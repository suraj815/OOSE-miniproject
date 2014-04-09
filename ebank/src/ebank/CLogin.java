package ebank;


import java.awt.*;
import java.sql.*;

import javax.swing.*;

import java.awt.event.*;
//import java.applet.*;
import java.awt.event.*;

import javax.swing.*;

public class CLogin extends JFrame implements ActionListener
{
	JFrame jf;
	//JTextField uid,pswd;
	JButton loginbtn,uidb;
	TextField uid,pswd;
	//JPasswordField pswd;;
	JPanel p0,p1,p2,p3;
	int tw=100,th=20;
	int time=3;
	JLabel error;
	Convert c=new Convert();
	public CLogin()
	{
		
		jf=new JFrame();
		jf.setSize(500,300);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel title=new  JLabel("Welcome to \n Easy Banking Application");
		//title.setFont("Sans serif");
		title.setForeground(Color.WHITE);
		title.setSize(100,200);
		jf.add(title,BorderLayout.LINE_START);
		
		uid=new TextField(20);
		uid.setText("Enter username");
		
		
		pswd=new TextField(15);//JPasswordField(20);
		loginbtn=new JButton("login");
		
		p0=new JPanel();
		p0.add(title);
		p0.setSize(100,20);
		p0.setBackground(Color.black);
		p0.setVisible(true);
		jf.add(p0,BorderLayout.NORTH);

		
		p1=new JPanel();
		p1.setSize(100,20);
		//p1.setSize(100,50);
		p1.add(uid);
		p1.add(pswd);
		
		
		uidb=new JButton("Username");
		uidb.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				uid.setText("");
			}
		});
		
		p1.setBackground(Color.yellow);
		p1.setVisible(true);
		jf.add(p1,BorderLayout.CENTER);

		
	/*	p2=new JPanel();
		p2.add(pswd);
		p2.setBackground(Color.BLUE);
		p2.setVisible(true);
		jf.add(p2,BorderLayout.WEST);
*/
		
		p3=new JPanel();
		p3.add(loginbtn);
		p3.add(uidb);
		p3.setBackground(Color.BLUE);
		p3.setVisible(true);
		jf.add(p3,BorderLayout.SOUTH);
		
		
		
		loginbtn.addActionListener(
				new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				close();
				if(time>0)
				{
					 // Java2MySql j1=new Java2MySql();
					  int ud=c.toInt(uid.getText());
					  //String ps=pswd.getText();
						//	 int ret=j1.validate(ud,pswd.getText());
					      //System.out.println(" hello "+ret);
					 // j1.ch(1)
					  int bal=0;
					  String passw=pswd.getText();
					 try
					 {
						String sql = "SELECT * FROM `login` WHERE `uid`=" + ud + " and `password`= '" + passw+"'";
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
					{
						jf.setVisible(false);
						login(ud);
					}
					else
					{
						time--;
						jf.setVisible(false);
						if(time<2)
						{
							p1.remove(error);
						}
						error=new JLabel("Only "+time+" tries are left ");//return  id "+ud+" pass ="+passw);
						p1.add(error).setVisible(true);
						jf.setSize(500,300);
						jf.add(p1,BorderLayout.CENTER);
						jf.setVisible(true);
					}
				}
			}
			
		} );

		jf.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
	}
	
	public void login(int uid)
	{
		LoggedIn li=new LoggedIn(500,300,uid);
		
	}
	
	public void close()
	{
		
		WindowEvent wc=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wc);
	}
	
		public static void main(String args[])throws NullPointerException
	{
		CLogin cl=new CLogin();
		//cl.setVisible(true);
	}
}
