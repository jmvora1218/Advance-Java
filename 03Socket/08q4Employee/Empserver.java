import java.io.*;
import java.net.*;
import java.util.*;
import java.sql.*;

class Empserver
	{
		public static void main(String args[])
			{
				ServerSocket ss=null;
				Socket s=null;
				ObjectInputStream ois= null;
				ObjectOutputStream oos=null;
				Connection con=null;
				Statement stmt=null;
				String url="jdbc:mysql://localhost:3306/socket";
				String un="root";
				String up="java";
			String sql="";
				String username="",password="";
						
		
			try
				{	
					ss=new ServerSocket(1444);
					System.out.println("SERVER IS CREATED");
				}
			catch(IOException ioe)
				{
					System.out.println("PORT IS BUSY"+ioe.getMessage());
					return;
				}
				
			try
				{
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver iS Loaded");
		
					con = DriverManager.getConnection(url,un,up);
					System.out.println("Connected");
					stmt=con.createStatement();
					System.out.println("Wrapper Created");
				}
		
			catch (ClassNotFoundException cnfe)
		
				{	
					System.out.println("Driver can not be loaded"+cnfe.getMessage());
					return;
				}
			catch (SQLException sqle)

				{
					System.out.println("could not connected="+sqle.getMessage());
					return;
				}
					
				
			while(true)
				{
					System.out.println("Waiting for connection");
				try
					{
				
						
				
						s= ss.accept();
						System.out.println("CONNECTED");
						
						oos= new ObjectOutputStream(s.getOutputStream());
						oos.writeObject("ENTER YOUR Username");
						ois=new ObjectInputStream(s.getInputStream());
						username=((String)ois.readObject());
						
						
						oos.writeObject("Enter YOur Password");
						password=((String)ois.readObject());
						
						sql="insert into empimport values(' "+username+" ',' "+password+" ')";
						
					}
				
				catch(IOException ioe)
					{
						System.out.println(ioe.getMessage());
					}
					catch(ClassNotFoundException cnfe)
					{
						System.out.println(cnfe.getMessage());
					}
				
				try
					{
						int r= stmt.executeUpdate(sql);
						oos.writeObject("YOUR USERNAME & PASSWROD SAVED..!!");
					}
				catch (SQLException sqle)
					{
						System.out.println("Not Inserted="+sqle.getMessage());
					}
					catch(IOException ioe)
					{
						System.out.println(ioe.getMessage());
					}
				
				}
			}	
	}