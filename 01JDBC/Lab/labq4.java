import java.sql.*;
import java.util.*;

class labq4
{
	public static void main(String args[])
	{
		Connection con=null;
		Statement stmt=null,stmt1=null,stmt2=null;
		String url="jdbc:mysql://localhost/lab";
		String un="root",up="java";
		ResultSet rs=null,rs1=null,rs2=null;
		Scanner sc=new Scanner(System.in);
		String pn=null,enp;
		int PID=0,PRISE,QTY;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver connected...");
			con=DriverManager.getConnection(url,un,up);
			System.out.println("connection created...");
			stmt=con.createStatement();
			System.out.println("wrapper created...");
			stmt1=con.createStatement();
			stmt2=con.createStatement();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		try
		{
			rs=stmt.executeQuery("select * from productmaster");
			System.out.println("Product list: ");
		
			while(rs.next())
			{	
				//PID=rs.getInt("PID");
				pn=rs.getString("PNAME");
				System.out.println(pn);	
			}
			
			System.out.println("Enter the product name: ");
			enp=sc.next();
			
			rs1=stmt1.executeQuery("select * from productmaster where PNAME='"+enp+"'");
			while(rs1.next())
			{
				PID=rs1.getInt("PID");
				System.out.print(PID);
			}
			rs2=stmt2.executeQuery("select PRISE,QTY from productdetail where PID='"+PID+"'");
			while(rs2.next())
			{
				PRISE=rs2.getInt("PRISE");
				System.out.print("\t Prise is: "+PRISE);
				QTY=rs2.getInt("QTY");
				System.out.println("\tQTY is: "+QTY);
			}
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}