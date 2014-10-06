import java.net.*;
class ipaddress
{
	public static void main(String args[])
	{
		InetAddress ia=null;
		try
		{
			ia=InetAddress.getByName("www.google.com");
			
			String add=ia.getHostAddress();
			System.out.println(add);
			byte ad[]=ia.getAddress();
			for(int i=0;i<ad.length;i++)
			{
				System.out.print(ad[i]);
			}
		}catch(UnknownHostException uhe)
		{
			System.out.println("Connection Err..."+uhe.getMessage());
		}
	}
}