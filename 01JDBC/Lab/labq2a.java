import java.sql.*;
import java.util.*;

class labq2a
{
	public static void main(String args[])
	{
		Connection con=null;
		Statement stmt=null,stmt1=null;
		String url="jdbc:mysql://localhost/lab";
		String un="root",up="java",sql;
		ResultSet rs=null,rs1=null,rs2=null;
		Scanner sc=new Scanner(System.in);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded...");
			System.out.println("Driver connected...");
			con=DriverManager.getConnection(url,un,up);
			System.out.println("connection created...");
			stmt=con.createStatement();
			System.out.println("wrapper created...");
			stmt1=con.createStatement();
			//stmt2=con.createStatement();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		try
		{
			int mrk1,mrk2,mrk3,ans,per,rn;
			String nm;
			
			rs=stmt.executeQuery("select * from student where ROLLNO");
			// This quary is data fatch frm table...
			while(rs.next())
			{
				rn=rs.getInt("ROLLNO");
				nm=rs.getString("NAME");
				mrk1=rs.getInt("M1");
				mrk2=rs.getInt("M2");
				mrk3=rs.getInt("M3");
				ans=mrk1+mrk2+mrk3;
				per=ans/3;
				System.out.println("\t Rollno is: "+rn+"\t Name is :- " +nm+ "\taverage is: " +per);
				
				if(per>=70)
				{
					System.out.println("\t******Distinction**********\n");
				}else if(per>=60 && per<=70)
				{
					System.out.println("/t*********First Class*********\n");
				}else if(per>=50 && per<=60)
				{
					System.out.println("Second Class");
				}
				else
				{
					System.out.println("Pass class");
				}
			}
		}catch(SQLException sqle)
		{
			System.out.println("\n \t Exception is: " +sqle.getMessage());
		}
	}
}