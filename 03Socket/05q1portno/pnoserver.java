import java.io.*;
import java.net.*;

public class pnoserver
{
	public static void main(String args[])
	{
		ServerSocket ss=null;
		Socket s=null;
		ObjectInputStream ois=null;
		ObjectOutputStream oos=null;
		int i=0;
		try
		{
			ss=new ServerSocket(1444);
			System.out.println("Server is Created");
		}catch(IOException ioe)
		{
			System.out.println("Port is busy" + ioe.getMessage());
			return ;
		}
		while(true)
		{
			System.out.println("waiting for connection");
			try
			{
				s=ss.accept();
				System.out.println("Connected");
				oos=new ObjectOutputStream(s.getOutputStream());
				oos.writeObject("Wel-Come");
				ois=new ObjectInputStream(s.getInputStream());
			}catch(IOException ioe)
			{
				System.out.println(ioe.getMessage());
			}
			
			try
			{
				oos.writeObject("Enter the lower port no. : ");
				int x=Integer.parseInt((String)ois.readObject());
				
				oos.writeObject("Enter the Higher port no. : ");
				int y=Integer.parseInt((String)ois.readObject());
				
				String msg="";
				String msg1="";
				for(i=x;i<=y;i++)
				{
					try
					{
						ss=new ServerSocket(i);
						msg=msg+i+"  ";
					}catch(Exception e)
					{
						msg1=msg1+i+" ";
						
					}
				}
				oos.writeObject(msg+" ");
				oos.writeObject(msg1+"");
			}catch(Exception e)
			{
				System.out.println("Exception is server: "+e.getMessage());
			}
		}
	}
}