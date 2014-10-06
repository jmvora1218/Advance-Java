import java.io.*;
import java.net.*;
import java.util.*;
class Capitalserver
{
	public static void main(String args[])
	{
		Socket s=null;
		ServerSocket ss=null,ss1=null;
		ObjectOutputStream oos=null;
		ObjectInputStream ois=null;
		int temp=0;
		String a;
		try
		{
			ss=new ServerSocket(1444);
			System.out.println("Server is created");
		}
		catch(IOException e)
		{
			System.out.println("Port is busy"+e.getMessage());
		}
		while(true)
		{
			System.out.println("Waiting for connection");
			try
			{
				s=ss.accept();
				System.out.println("connected");
				oos=new ObjectOutputStream(s.getOutputStream());
				ois=new ObjectInputStream(s.getInputStream());
				oos.writeObject("Enter any string:");
				a=(String)ois.readObject();
				for(int i=0;i<a.length();i++)
				{
					if(a.charAt(i)>=65 && a.charAt(i)<=90)
						temp++;
				}
				oos.writeObject("Number of capital letter:"+temp);
				
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
			System.out.println("terminated");
		}	
		
	}
}