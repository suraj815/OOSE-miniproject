package ebank;


import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
//import java.applet.*;
import java.awt.event.*;

import javax.swing.*;


public class LoggedIn  extends JFrame implements ActionListener
{
	JFrame jf,af,tf;	//jframe, account frame, transactions frame
	JButton sb,cb;	//saving button , current button
	JPanel hh,bh,ah;	//Header holder, button holder, activity holder
	JLabel title,title2,title3;
	int w,h,uid;
	
	public LoggedIn(int w1, int h1,int uid1)
	{
		w=w1;
		h=h1+30;
		uid=uid1;
		
		jf=new JFrame();
		jf.setSize(w,h);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		sb=new JButton(" Saving ");
		
		cb=new JButton("Current");
		
		title=new  JLabel("<html><h1 align='center'>Welcome to <br> Easy Banking Application</h1></html>");
		title.setForeground(Color.WHITE);
		title.setSize(w,100);
		
		title2=new  JLabel("<html><h1 align='center'>Please Select your<br> account type</h1></html>");
		title2.setForeground(Color.WHITE);
		title2.setSize(w-100,h-100);
		
		title3=new  JLabel("<html> <br> </html>");
		title3.setForeground(Color.WHITE);
		title3.setSize(w-100,h-100);
		
		
		hh=new JPanel();
		hh.add(title);
		hh.setSize(100,20);
		hh.setBackground(Color.BLUE);
		hh.setVisible(true);
		jf.add(hh,BorderLayout.NORTH);
		
		ah=new JPanel();
		ah.add(title2);
		ah.setSize(200,20);
		ah.setBackground(Color.DARK_GRAY);
		ah.setVisible(true);
		jf.add(ah,BorderLayout.CENTER);

		bh=new JPanel();
		bh.setLayout(new BoxLayout(bh, BoxLayout.Y_AXIS));
		bh.add(new Label("")).setBackground(Color.yellow);
		bh.add(sb,BorderLayout.NORTH);
		bh.add(title3);
		bh.add(cb);
		bh.add(new Label("")).setBackground(Color.yellow);
		bh.setBackground(Color.yellow);
		bh.setVisible(true);
		jf.add(bh,BorderLayout.EAST);

		sb.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					accountType(1);//saving()
				}
		}  );

		cb.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					accountType(2);//saving()
				}
		}  );
		
		jf.setVisible(true);
		//setVisible(true);
	}
	
	public void accountType(int actype)
	{
		jf.setVisible(false);
		af=new JFrame();	//af--> saving account frame
		af.setSize(w,h+55);
		af.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton wfund,tfund,fd,updet,chkbal;	//withdraw fund, transfer fund, fixed deposit, update details, check balance
		
		if(actype==1)
		{
			
			wfund=new JButton("   Withdraw   ");
			tfund=new JButton("Transfer Funds");
			   fd=new JButton("Fixed Deposit ");
			updet=new JButton("Update Details");
		   chkbal=new JButton("Check Balance ");
			
			
			JLabel st=new JLabel("<html><h2 align='center'>Welcome to <br> Easy Banking Application</h2></html>");	//st--> saving window's title
			st.setForeground(Color.white);
			//JPanel stra=new JPanel();	//stra --> transactions for saving acc.
			
			title2=new JLabel("<html><h2 align='center'>Please Select <br> What Transaction you want to perform </h2></html>");
			title2.setForeground(Color.white);
			
			title3=new  JLabel("<html> <br> <br> </html>");
			title3.setForeground(Color.WHITE);

			hh=new JPanel();
			hh.add(st);
			hh.setSize(100,20);
			hh.setBackground(Color.BLUE);
			hh.setVisible(true);
			af.add(hh,BorderLayout.NORTH);

			ah=new JPanel();
			ah.add(title2);
			ah.setSize(200,20);
			ah.setBackground(Color.DARK_GRAY);
			ah.setVisible(true);
			af.add(ah,BorderLayout.CENTER);

			bh=new JPanel();
			bh.setLayout(new BoxLayout(bh, BoxLayout.Y_AXIS));
			bh.add(new Label("")).setBackground(Color.yellow);
			bh.add(wfund);
			bh.add(new Label("")).setBackground(Color.yellow);
			bh.add(tfund);
			bh.add(new Label("")).setBackground(Color.yellow);
			bh.add(fd);
			bh.add(new Label("")).setBackground(Color.yellow);
			bh.add(updet);
			bh.add(new Label("")).setBackground(Color.yellow);
			bh.add(chkbal);
			bh.add(new Label("")).setBackground(Color.yellow);
			bh.setBackground(Color.yellow);
			bh.setVisible(true);
			af.add(bh,BorderLayout.EAST);
			
			

			wfund.addActionListener	(	new ActionListener() { public void actionPerformed(ActionEvent e){ 	act(1);} }  );
			tfund.addActionListener	(	new ActionListener() { public void actionPerformed(ActionEvent e){	act(2);} }  );
			fd.addActionListener	(	new ActionListener() { public void actionPerformed(ActionEvent e){	act(3);} }  );
			chkbal.addActionListener(	new ActionListener() { public void actionPerformed(ActionEvent e){	act(4);} }  );
			updet.addActionListener	(	new ActionListener() { public void actionPerformed(ActionEvent e){	act(5);} }  );
		}
		else
		{
			wfund=new JButton("   Withdraw   ");
		   chkbal=new JButton("Check Balance ");
			updet=new JButton("Update Details");
			
			
			JLabel st=new JLabel("<html><h2 align='center'>Welcome to <br> Easy Banking Application</h2></html>");	//st--> saving window's title
			st.setForeground(Color.white);
			//JPanel stra=new JPanel();	//stra --> transactions for saving acc.
			
			title2=new JLabel("<html><h2 align='center'>Please Select <br> What Transaction you want to perform </h2></html>");
			title2.setForeground(Color.white);
			
			title3=new  JLabel("<html> <br> <br> </html>");
			title3.setForeground(Color.WHITE);

			hh=new JPanel();
			hh.add(st);
			hh.setSize(100,20);
			hh.setBackground(Color.BLUE);
			hh.setVisible(true);
			af.add(hh,BorderLayout.NORTH);

			ah=new JPanel();
			ah.add(title2);
			ah.setSize(200,20);
			ah.setBackground(Color.DARK_GRAY);
			ah.setVisible(true);
			af.add(ah,BorderLayout.CENTER);

			bh=new JPanel();
			bh.setLayout(new BoxLayout(bh, BoxLayout.Y_AXIS));
			bh.add(new Label("")).setBackground(Color.yellow);
			bh.add(wfund);
			bh.add(new Label("")).setBackground(Color.yellow);
			bh.add(updet);
			bh.add(new Label("")).setBackground(Color.yellow);
			bh.add(chkbal);
			bh.add(new Label("")).setBackground(Color.yellow);
			bh.setBackground(Color.yellow);
			bh.setVisible(true);
			af.add(bh,BorderLayout.EAST);
			
			

			wfund.addActionListener	(	new ActionListener() { public void actionPerformed(ActionEvent e){ 	act(1);} }  );
			chkbal.addActionListener(	new ActionListener() { public void actionPerformed(ActionEvent e){	act(4);} }  );
			updet.addActionListener	(	new ActionListener() { public void actionPerformed(ActionEvent e){	act(5);} }  );
		}
		
		af.setVisible(true);
		
	}
	TextField amt,acc;
	String tfres="";
	public void act(int opt)
	{
		af.setVisible(false);
		tf=new JFrame();	//af--> saving account frame
		tf.setSize(w,h+55);
		tf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		final JButton butn;
		
		final Transactions t=new Transactions(uid);
		switch(opt)
		{
		case 1:
			title2=new JLabel("<html><h1 align='center'>Enter Amount to withdraw <br> <br> <br> <br></h1></html>");
			ah=new JPanel();
			ah.add(title2);
			
			amt=new TextField(15);
			butn=new JButton("Withdraw");		
			ah.add(amt,BorderLayout.CENTER);
			ah.add(butn);
			//t3.setVisible(true);
			
			butn.addActionListener	(	new ActionListener() { public void actionPerformed(ActionEvent e){ 	

				String amt2=amt.getText();	
				JLabel t3=new JLabel(t.withdraw(amt2));
				t3.setForeground(Color.white);
				tf.setVisible(false);
				ah.remove(amt);
				ah.remove(butn);
				ah.add(t3).setVisible(true);
				tf.add(ah,BorderLayout.CENTER);
				tf.setVisible(true);
			} }  );
			break;
			
			
			
		case 2:
			title2=new JLabel("<html><h2 align='center'> Enter your destination account number </h2></html>");
			ah=new JPanel();
			ah.add(title2);
			acc=new TextField(15);
			butn=new JButton("Proceed");		
			ah.add(acc,BorderLayout.CENTER);
			ah.add(butn);
			
			
			
			butn.addActionListener	(	new ActionListener() { public void actionPerformed(ActionEvent e){ 	

				String acc2=acc.getText();
				if(t.checkAcc(acc2))
				{
					tf.setVisible(false);
					ah.removeAll();
					title2=new JLabel("<html><h2 align='center'> Enter amount to transfer </h2></html>");
					title2.setForeground(Color.white);
					ah.add(title2);
					amt=new TextField(15);
					ah.add(amt);//,BorderLayout.CENTER);
					
					JButton send=new JButton("Send");
					ah.add(send).setVisible(true);
					tf.add(ah);//,BorderLayout.LINE_END);
					tf.setVisible(true);
					send.addActionListener	(	new ActionListener() { public void actionPerformed(ActionEvent e){ 
						String amt2=amt.getText();
						tfres=t.transfer(acc.getText(),amt2);
						
						tf.setVisible(false);
						ah.removeAll();
						JLabel tfres2=new JLabel(tfres);
						tfres2.setForeground(Color.white);
						ah.add(tfres2).setVisible(true);
						tf.add(ah);
						tf.setVisible(true);
						
						
					} }  );
				}
				else
				{
					tfres="<html> <h2> Please enter valid account number </h2> </html>";

					tf.setVisible(false);
					ah.removeAll();
					JLabel tfres2=new JLabel(tfres);
					tfres2.setForeground(Color.white);
					ah.add(tfres2).setVisible(true);
					tf.add(ah);
					tf.setVisible(true);
					
				}
			} }  );
			
			break;
			
		case 3:
			title2=new JLabel("<html><h2 align='center'> Select category in which you want to deposit </h2></html>");
			String scheme="<html> "
						+ "<table border='1'>"
						+ "<tr>"
						+ "<th> opt no </th>"
						+ "<th> Period(month) </th>"
						+ "<th> Interest rate </th>"
						+ "</tr>"
						+ "<tr>"
						+ "<td> 1 </td>"
						+ "<td> 9 </td>"
						+ "<td> 1.33 </td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td> 2 </td>"
						+ "<td> 12 </td>"
						+ "<td> 1.53 </td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td> 3 </td>"
						+ "<td> 20 </td>"
						+ "<td> 2.01 </td>"
						+ "</tr>"
						+ " </table>"
						+" </html>";
			
			tf.setVisible(false);
			ah.removeAll();
			
			final JLabel fds=new JLabel(scheme);
			fds.setForeground(Color.white);
			ah.add(fds).setVisible(true);
			
			final TextField fdc=new TextField(15);
			ah.add(fdc).setVisible(true);
			
			butn=new JButton("Proceed");
			ah.add(butn);
			
			butn.addActionListener	(	new ActionListener() { public void actionPerformed(ActionEvent e){ 	
				final String optno=fdc.getText();
				tf.setVisible(false);
				
				ah.removeAll();
				Convert c=new Convert();
				int choice=c.toInt(fdc.getText());
				JLabel fdinfo;
				final TextField fdamt;
				final JButton subamt;
				if(choice>=1 && choice<=3)
				{
				fdinfo=new JLabel("<html><h2> Enter amount to deposit:</h2></html> ");

				fdamt=new TextField(10);
				subamt=new JButton("Submit");
				ah.add(fdamt).setVisible(true);
			    ah.add(subamt).setVisible(true);
			    
			    subamt.addActionListener	(	new ActionListener() { public void actionPerformed(ActionEvent e){ 	
			    	String fdamt2=fdamt.getText();
			    	JLabel res=new JLabel(t.fixedDeposit(optno,fdamt2));
			    	tf.setVisible(false);
			    	ah.removeAll();
			    	res.setForeground(Color.white);
			    	ah.add(res).setVisible(true);
			    	tf.add(ah);
				    tf.setVisible(true);
			    	
			    	
			    } }  );
				
				}
				else
				{
					fdinfo=new JLabel("<html><h2> Invalid input </h2></html> ");
				}
				fdinfo.setForeground(Color.white);
				ah.add(fdinfo).setVisible(true);
				
			    
			    
			    
			    tf.add(ah);
			    tf.setVisible(true);
			    
			   
				
			} }  );

			tf.add(ah);
			
			tf.setVisible(true);
			//t.fixedDeposit();
			break;

		case 4:
			ah.removeAll();
			JLabel res=new JLabel(t.checkBalance());
	    	res.setForeground(Color.white);
	    	ah.add(res).setVisible(true);
	    	tf.add(ah);
		    tf.setVisible(true);
			//t.checkBalance();
			break;

		case 5:
			title2=new JLabel("<html><h2 align='center'> Select what you want to update </h2></html>");
			  
			t.updateAccountDetails();
			break;
		}
		
		title2.setForeground(Color.white);

		hh=new JPanel();
		hh.add(title);
		hh.setSize(100,20);
		hh.setBackground(Color.BLUE);
		hh.setVisible(true);
		tf.add(hh,BorderLayout.NORTH);
		
		ah.setSize(200,20);
		ah.setBackground(Color.DARK_GRAY);
		tf.add(ah,BorderLayout.CENTER);
		ah.setVisible(true);


		
		tf.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){	}
	
	public static void main(String args[])
	{
		LoggedIn li=new LoggedIn(500,300,3);
		//li.setVisible(true);
	}
}
