import java.io.*;
import java.net.*;
import java.util.*;

class UDPClient
{
	public static void main(String args[]) throws Exception
	{
		DatagramPacket rp;
		DatagramPacket sp;
		byte sdata[]=new byte[1024];
		byte rdata[]=new byte[1024];
		DatagramSocket dr;
		String rs,ss;
		
		dr=new DatagramSocket();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter send data: ");
		ss=sc.next();
		sdata=ss.getBytes();
		sp=new DatagramPacket(sdata,sdata.length,InetAddress.getLocalHost(),1444);
		dr.send(sp);
		rp=new DatagramPacket(rdata,rdata.length);
		dr.receive(rp);
		rs=new String(rdata).trim();
		System.out.println("data receive from :" +rp.getAddress() + "Port no= " +rp.getPort()+ "data= "+rs);
	}
}	