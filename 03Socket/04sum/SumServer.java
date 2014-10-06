import java.io.*;
import java.net.*;

public class SumServer
{
	public static void main(String args[])
	{
		ServerSocket ss=null;
		Socket s=null;
		ObjectInputStream ois=null;
		ObjectOutputStream oos=null;
		
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
			
			oos.writeObject("Enter the Data 1: ");
			int x=Integer.parseInt((String)ois.readObject());
			
			oos.writeObject("Enter the Data 2: ");
			int y=Integer.parseInt((String)ois.readObject());
			
			oos.writeObject((String)ois.readObject());
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
}