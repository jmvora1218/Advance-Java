import java.io.*;
import java.net.*;
import java.util.*;

public class DateTimeConcurrent extends Thread
{
	public static void main(String args[])
	{
		ObjectOutputStream oos=null;
		ObjectInputStream ois=null;
		Socket s=null;
		public DateTimeConcurrent(Socket s)
		{
			this.s=s;
			try
			{
				ois=new ObjectInputStream(s.getInputStream);
				oos=new ObjectOutputStream(s.getOutputStream);
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			start();
		}
		
		public void run()
		{
			try
			{
				Date d=new Date();
				String ds=d.ToString();
				oos.writeObject(ds);
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
}