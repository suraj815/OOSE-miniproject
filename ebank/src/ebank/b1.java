package ebank;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;

public class b1 extends JFrame //implements ActionListener 
{
	JButton jb;
	JTextField jtf;
	
	 int x=0,y=0,xinc=10,yinc=5;
	
	public b1() 
	{
		
		JFrame jf=new JFrame();
		jf.setSize(800,600);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel name = new JLabel("Enter Your Name Here:\n");
		
		jb=new JButton("Enter");
		jtf=new JTextField("Enter Login ID");
		jtf.setSize(1400,200);
		
		JPanel panel1=new JPanel();
		panel1.add(name);
		panel1.addNotify();
		panel1.add(jtf);
		panel1.setBackground(Color.GREEN);
		
		JPanel jp3=new JPanel();
		jp3.add(name);
		jp3.setBackground(Color.orange);
		
		
		JPanel panel2 = new JPanel();
		panel2.add(jb);
		panel2.setBackground(Color.cyan);
		jb.addActionListener(
					new ActionListener(){
						
						public void actionPerformed(ActionEvent e)
						{

							close();
							
							//b1 tb2=new b1();
							//tb2.setVisible(true);
							JLabel name2 = new JLabel("welcome");
							
							JPanel j4=new JPanel();
							j4.add(name2);
							j4.setBackground(Color.YELLOW);
							x+=xinc;
							y+=yinc;
							//JImage ji=new JImage();
							setVisible(true);
							
							add(j4,BorderLayout.CENTER);
							setSize(400+x,250+y);
							setLocationRelativeTo(null);
							//name2.add(name2);
							
						}
					}
				);
		
		panel2.addMouseListener(new  MouseAdapter()
		{
			public void mouseClicked(MouseEvent me)
			{
				//boolean test = ;
				if (me.MOUSE_PRESSED>0)//test == true)
				{
					JLabel name2 = new JLabel("welcome");
				//	name2.add(name2);
				//	this.close();
					setVisible(false);
					b1 tb2=new b1();
					//tb2.addInputMethodListener(null);
					
					tb2.setVisible(true); 

					/*ImageIcon image = new ImageIcon("1.png");
					JLabel jl5 = new JLabel(image);
					jl5.getGraphicsConfiguration(image);*/

				}
			}

					
		});
		
		add(panel1, BorderLayout.NORTH);
		add(panel2,BorderLayout.AFTER_LAST_LINE);
		
		setTitle("Easy bank");
		setSize(300,150);
		setLocationRelativeTo(null);
		
		
		
	}
	
	public void close()
	{
		
		WindowEvent wc=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wc);;
	}
	
	public void login()
	{
		if(jtf.equals("vijay"))
		{
			JLabel name = new JLabel("Welcome vijay");
			JPanel p3=new JPanel();
			p3.add(name);
			add(p3,BorderLayout.AFTER_LAST_LINE);
			
		}
		else
		{
			JLabel name = new JLabel("Invalid login");
			JPanel p3=new JPanel();
			p3.add(name);
			add(p3,BorderLayout.AFTER_LAST_LINE);
		}
		
		
		
			
	}
	
	public static void main(String args[])
	{
		b1 tb=new b1();
		tb.setVisible(true);
		
		//tb.setBackground(null);
	}
}
