import java.io.*;
import java.net.*;

class UDPServer
{
	public static void main(String args[]) throws Exception
	{
		DatagramPacket rp;
		DatagramPacket sp;
		byte rdata[]=new byte[1024];
		byte sdata[]=new byte[1024];
		String rs,ss;
		DatagramSocket ds;
		
		ds=new DatagramSocket(1444);
		while(true)
		{
			System.out.println("Waiting for packet: ");
			rp=new DatagramPacket(rdata,rdata.length);
			ds.receive(rp);
			rs=new String(rdata).trim();
			System.out.println("data receive from :" +rp.getAddress() + "Port no= " +rp.getPort()+ "data= "+rs);
			ss=rs.toUpperCase();
			sdata=ss.getBytes();
			sp=new DatagramPacket(sdata,sdata.length);
			rp.getAddress();
			rp.getPort();
			ds.send(sp);
		}
	}
}