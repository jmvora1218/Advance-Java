import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
 public class sessionlogin extends HttpServlet
 {
     Connection con=null;
     Statement stmt=null;
     ResultSet rs=null;
     Scanner sc=new Scanner(System.in);
     String url="jdbc:mysql://localhost:3306/db";
     String up="root";
     String un="root",n,p;
     boolean flag1=false;
     boolean flag2=false;

   /*  public void init(ServletConfig sc)throws ServletException
     {
        super.init(sc);
        try
        {
             Class.forName("com.mysql.jdbc.Driver");
             con=DriverManager.getConnection(url,un,up);
             stmt=con.createStatement();
             rs=stmt.executeQuery("select * from emp");
        }
        catch(Exception e)
        {
            out.println(e.getMessage());
        }


     }*/
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
     {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        doPost(req,res);
     }
     public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
     {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        try
        {
             Class.forName("com.mysql.jdbc.Driver");
             con=DriverManager.getConnection(url,un,up);
             stmt=con.createStatement();
             rs=stmt.executeQuery("select * from emp");
        }
        catch(Exception e)
        {
            out.println(e.getMessage());
        }
        if(req.getParameter("btnsub")!=null)
        {
        try
        {
          while(rs.next())
          {
            n=rs.getString("name");
            p=rs.getString("password");
            if(n.equals(req.getParameter("txtname")))
            {
                flag1=true;
                if(p.equals(req.getParameter("txtpass")))
                {
                flag2=true;
                break;
                }
            }
          }
          if(flag1 && flag2)
          {
            HttpSession hs=req.getSession(true);
            hs.setMaxInactiveInterval(30);
            hs.setAttribute("un", req.getParameter("txtname"));
            res.sendRedirect("productselection");
          }
          else
          {
          out.println("mismatch");
          }
        }
         catch(Exception e)
        {
            out.println(e.getMessage());
        }
      }
         out.println("<html><body><form method='post' action='sessionlogin'>");
        out.println("Name:<input type='text' name='txtname'>");
        out.println("Password:<input type='text' name='txtpass'>");
        out.println("<input type='submit' name='btnsub' value='Submit'>");
        out.println("</form></body></html>");


     }
 }