import java.rmi.*;
import java.rmi.server.*;

public class CArrayList
{
	public static void main(String args[])
	{
		String url="rmi://localhost:1099/object";
		IArrayList ia;
		String d=null;
		try
		{
			ia=(IArrayList)Naming.lookup(url);
			ia.adddata("a");
			ia.adddata("B");
			ia.adddata("C");
			String r=ia.searchdata(d);
			System.out.println(r);
		}catch(Exception e)
		{System.out.println(e.getMessage());
		}
	}
}