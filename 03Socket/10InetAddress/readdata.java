import java.net.*;
import java.io.*;

class readdata
{
	public static void main(String args[]) throws Exception
	{
		InputStream is=null;
		char x;
		int d;
		URL url=null;
		URLConnection uc=null;
		url= new URL("http://www.parul.ac.in");
		uc=url.openConnection();
		is=uc.getInputStream();
		while(true)
		{
			d=is.read();
			if(d==-1)
			{break;
			}
			x=(char)d;
			System.out.print(x);
		}
	}
}