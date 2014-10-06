import java.sql.*;
import java.util.*;

public class lab1q9 {
public static void main(String args[]) throws Exception
    {
        Connection con=null;
        Statement stmt=null;
        String url="jdbc:mysql://localhost/lab";
        String un="root";
        String up="java";
        ResultSet rs=null;
        Scanner sc=new Scanner(System.in);
        String name,ect,edob;


        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded.");
        con=DriverManager.getConnection(url,un,up);
        System.out.println("Connection Created..");
        stmt=con.createStatement();
        System.out.println("Wraper created...");

      //  System.out.println("Enter user name: ");
       // name=sc.next();    
        
        rs=stmt.executeQuery("select * from employee9");
        while(rs.next())
        {
            String nm=rs.getString("ENAME");
            System.out.println(nm);
            System.out.println("Enter user name: ");
            name=sc.next();
            System.out.println("Enter city name: ");
            ect=sc.next();
            System.out.println("Enter dob name: ");
            edob=sc.next();
            
            stmt.executeUpdate("update employee9 set CITY='"+ect+"',DOB='"+edob+"' where ENAME='"+name+"'");
        }
    }
}
