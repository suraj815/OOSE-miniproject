package ebank;


public class Convert 
{
	public Convert()
	{
		
	}
	
	public int toInt(String a)
	{
		int res=0;
		char b[]=a.toCharArray();
		int l=b.length;
		for(int i=0;i<l;i++)
		{
			switch(b[i])
			{
				case '0':
					res=res*10;
					continue;
		
				case '1':
					res=res*10+1;
					continue;
		
				case '2':
					res=res*10+2;
					continue;
		
				case '3':
					res=res*10+3;
					continue;
		
				case '4':
					res=res*10+4;
					continue;
		
				case '5':
					res=res*10+5;
					continue;
		
				case '6':
					res=res*10+6;
					continue;
		
				case '7':
					res=res*10+7;
					continue;
		
				case '8':
					res=res*10+8;
					continue;
		
				case '9':
					res=res*10+9;
					continue;
		
			}
		}
		return res;
	}
	public long toLong(String a)
	{
		long res=0;
		char b[]=a.toCharArray();
		int l=b.length;
		for(int i=0;i<l;i++)
		{
			switch(b[i])
			{
				case '0':
					res=res*10;
					continue;
		
				case '1':
					res=res*10+1;
					continue;
		
				case '2':
					res=res*10+2;
					continue;
		
				case '3':
					res=res*10+3;
					continue;
		
				case '4':
					res=res*10+4;
					continue;
		
				case '5':
					res=res*10+5;
					continue;
		
				case '6':
					res=res*10+6;
					continue;
		
				case '7':
					res=res*10+7;
					continue;
		
				case '8':
					res=res*10+8;
					continue;
		
				case '9':
					res=res*10+9;
					continue;
		
			}
		}
		return res;
	}
	
	/*public static void main(String args[])
	{
		String a="100";
		int b=toInt(a);
		int c=1000;
		c=c-b;
		System.out.println("\n"+c);
	}*/
}
