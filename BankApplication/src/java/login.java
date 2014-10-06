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
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SHREEJI
 */
public class login extends HttpServlet {
    ServletContext ctx;
    String un,up,driver,url,name,pass;
    Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;
    
     public void init(ServletConfig sc)throws ServletException
    {
        super.init(sc);
        ctx=getServletContext();
        driver=(String)ctx.getInitParameter("driver");
        url=(String)ctx.getInitParameter("url");
        un=(String)ctx.getInitParameter("un");
        up=(String)ctx.getInitParameter("up");
 
       try
       {
        Class.forName(driver);
        con=DriverManager.getConnection(url,un,up);
           System.out.println("driver loaded");
        stmt=con.createStatement();
           System.out.println("connection establish");
        rs=stmt.executeQuery("select * from login");
       }
       catch(Exception e)
       {
       System.out.println(e.getMessage());
       }
    }
    
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        out.println("<html><head><title>Wel-Come to Bank Application</title></head><body>");
        out.println("<form method='post'>");
        out.print("<table border=0 '>");
        out.println("<tr><td> Enter Name:    </td><td><input type='text' name='txtname'></td></tr>");
        out.println("<tr><td> Enter Password:</td><td><input type='text' name='txtpass'></td></tr>");
        out.println("<tr><td> <input type='submit' name='btnsubmit' value='Submit'></td></tr>");
        out.println("<tr><td> <a href ='NewUser'>New User</a></td></tr>");
        out.print("<tr><td><a href ='ForgotPass'>Forgot Password</a></td></tr>");
        out.print("<tr><td><a href ='ChangePass'>Change Password</a></td></tr>");
        out.println("</form></body></html>");

    }

public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    if(req.getParameter("btnsubmit")!=null)
        {
            try
            {
                name=req.getParameter("txtname");
                pass=req.getParameter("txtpass");
                
                System.out.println(name+pass);
                while(rs.next())
                {
                     String n=rs.getString("NAME");
                     String p=rs.getString("PASSWORD");
                     System.out.println(" "+n+p);
                     if(name.equals(n)&&pass.equals(p)){
                         res.sendRedirect("/log");
                     }
                }
            }catch(Exception e){
                out.print("err in query...");
            }
        }
    
}
}
