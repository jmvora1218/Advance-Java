import java.io.*;
import java.net.*;
import java.util.*;
class Capitalclient
{
	public static void main(String args[])
	{
		Socket s=null;
		ObjectInputStream ois=null;
		ObjectOutputStream oos=null;
		Scanner sc=new Scanner(System.in);
		try
		{
			s=new Socket("localhost",1444);
			System.out.println("Connected");
			ois=new ObjectInputStream(s.getInputStream());
			oos=new ObjectOutputStream(s.getOutputStream());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		try
		{
			
			System.out.println((String)ois.readObject());
			oos.writeObject(sc.nextLine());
			System.out.println((String)ois.readObject());
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
	}
}