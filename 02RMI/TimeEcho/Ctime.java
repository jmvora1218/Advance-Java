import java.rmi.*;
import java.rmi.server.*;
public class Ctime
{
	public static void main(String args[])
	{
	String url="rmi://localhost:1099/object is";
	Itime it=null;
	try
	{
	it=(Itime)Naming.lookup(url);
	String s=it.getTime();
	String a=it.getEcho("hello");
	System.out.println("Time is"+s);
	System.out.println("Ans is"+a);
	}
	catch(Exception e)
	{
	System.out.println(e.getMessage());
	}
	}
}
	