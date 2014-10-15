/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SHREEJI
 */
public class NewUser extends HttpServlet {
    ServletContext ctx;
    String un,up,driver,url,name,pass;
    Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;
    public void connection() throws SQLException, ClassNotFoundException    {

        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdata","root","java");
        System.out.println("driver loaded");
        stmt=con.createStatement();
        System.out.println("connection establish");
       
    }
    
    
public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    try { 
        connection();
    } catch(Exception e) {}
    out.print("<html><head><title>New User</title><head><body>");
    out.print("<form name='new user' method='post'>");
    out.print("<table border=0 align='left'>");
    out.print("<tr><td> User Id: </td> <td> <input type='text' name='username'> </td></tr>");
    out.print("<tr><td> Password: </td> <td> <input type='text' name='password'></td></tr>");
    out.print("<tr><td> Email-ID: </td> <td> <input type='email' name='email'></td></tr>");
    out.print("<tr><td> Contact Number: </td> <td> <input type='number' name='contactnum'></td></tr>");
    out.print("<tr><td> Name: </td> <td> <input type='text' name='name'></td></tr>");
    out.print("<tr><td> Account Number: </td><td> <input type='number' name='accountno'></td></tr>");
    out.print("<tr><td> Initial Amount: </td><td> <input type='number' name='initamt'></td></tr>");
    out.print("<tr><td>  </td><td> <input type='submit' value='Submit'></td></tr>");
    out.print("</table></form></body></html>");
    }
public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    String userid=req.getParameter("username");
    String password=req.getParameter("password");
    String email=req.getParameter("email");
    String contactnum=req.getParameter("contactnum");
    String name=req.getParameter("name");
    String accountnum=req.getParameter("accountno");
    String initialmoney = req.getParameter("initamt");
    
    ResultSet rs=null;
    String sql;
     try {
            connection();
        sql = "select * from login where userid='"+userid+"'";
        rs = stmt.executeQuery(sql);
        if(rs.next()){
            out.print("<script type='text/javascript'> alert('User Already Exist! Login!');"
                            + "</script>");
            res.sendRedirect("http://localhost:8080/BankApplication/login");
        }
        } catch(Exception e) {
            try {
            sql="insert into login values('"+userid+"','"+password+"')";
            stmt.executeUpdate(sql);
            sql="insert into customer values('"+accountnum+"','"+name+"','"+ email+"','"+ contactnum+"','"+userid+"')";
            stmt.executeUpdate(sql);
            sql="insert into balance values('"+accountnum+"','"+initialmoney+"')";
            stmt.executeUpdate(sql);
            out.print("<script type='text/javascript'> alert('User created! You can Login!');"
                            + "</script>");
            res.sendRedirect("http://localhost:8080/BankApplication/login");
            } catch(Exception ex) {
            
            out.print(e.getMessage());
            }
        }    
}
}