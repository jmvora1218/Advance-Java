import java.rmi.*;
import java.rmi.server.*;
import java.net.*;
public class TimeClient
	{
	public static void main(String args[])
	{
	String Url="rmi://localhost:1099/object";
	Itime it=null;
	try
	{
	it=(Itime)Naming.lookup(Url);
	String ss=it.getTime();
	String sss=it.getEcho("hi");
	System.out.println("Time is"+ss);
	System.out.println("You enters"+sss);
	}
	catch(Exception e)
	{
	System.out.println(e.getMessage());
	}
}
}