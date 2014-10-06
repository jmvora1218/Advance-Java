import java.io.*;
import java.net.*;
import java.util.*;

class FileClient
{
	public static void main(String args[])
	{
		Socket s=null;
		ObjectInputStream ois=null;
		ObjectOutputStream oos=null;
		String data;
		Scanner sc=new Scanner(System.in);
		
		try
		{
			s=new Socket("localhost",1444);
			System.out.println("Connected Susccessfully");
			ois=new ObjectInputStream(s.getInputStream());
			oos=new ObjectOutputStream(s.getOutputStream());
			data=(String)ois.readObject();
			System.out.println(data);
			System.out.println((String)ois.readObject());
			oos.writeObject(sc.next());
			System.out.println((String)ois.readObject());
			
			
		}
		catch(Exception e)
		{
			System.out.println("IO Error"+e.getMessage());
			return;
		}
		try
		{
			System.out.println((String)ois.readObject());
			oos.writeObject(sc.next());
			
		}
		catch(Exception e)
		{
			System.out.println("Error "+e.getMessage());
		}
	}
}	


