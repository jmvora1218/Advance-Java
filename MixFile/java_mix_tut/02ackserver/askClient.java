import java.io.*;
import java.net.*;

public class askClient
{
	public static void main(String args[])
	{
		Socket s=null;
		ObjectInputStream ois=null;
		String data;
		try
		{
			s=new Socket("localhost",1444);
			System.out.println("Connected");
			ois=new ObjectInputStream(s.getInputStream());
		}catch(IOException ios)
		{
			System.out.println("I/O Error " + ios.getMessage());
			return;
		}
		try
		{
			data=(String)ois.readObject();
			System.out.println(data);
		}
		catch(IOException ios)
		{
			System.out.println("I/O Error(2) " + ios.getMessage());
			return;
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println(cnfe.getMessage());
		}
	}
}