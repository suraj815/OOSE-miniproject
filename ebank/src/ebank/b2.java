package ebank;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class b2 extends Applet implements ActionListener
{
	TextField id,pass;
	Button login;
	
	public b2()
	{
		//setLayout(new GridLayout(6, 8, 20, 50));  
		setBackground(Color.red);
		
		id=new TextField(10);
		pass=new TextField(10);
		login=new Button("LogIn");
		
		add(new Label("Username "));	
		add(id);
		add(new Label("Password"));		
		add(pass);
		//add(new Label("Click here"));	
		add(login);
		
		login.addActionListener(this);/*
			new ActionListener() 
			{	public void actionPerformed(ActionEvent e)
				{
					
				}
			}
		);*/
	}
	
	public void start()
	{
		
	}
	
	public void paint(Graphics g)
	{
		start();
		g.drawOval(10,20,30,40);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(id.getText().equals("vijay")&&pass.getText().equals("vijay"))
						add(new Label("You are logged in"));
					else
						add(new Label("Invalid login Id or password"));
		 repaint();
		return;
	}
}