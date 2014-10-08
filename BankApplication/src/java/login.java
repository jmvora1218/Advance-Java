/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author SHREEJI
 */
public class login extends HttpServlet {
    
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
    
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        out.println("<html><head><title>Wel-Come to Bank Application</title></head><body>");
        out.println("<form method='post'>");
        out.print("<table border=0 '>");
        out.println("<tr><td> Enter Name:    </td><td><input type='text' name='username'></td></tr>");
        out.println("<tr><td> Enter Password:</td><td><input type='text' name='password'></td></tr>");
        out.println("<tr><td> <input type='submit' name='btnsubmit' value='Submit'></td></tr>");
        out.println("<tr><td> <a href ='NewUser'>New User</a></td></tr>");
        out.print("<tr><td><a href ='ForgotPass'>Forgot Password</a></td></tr>");
        out.print("<tr><td><a href ='ChangePass'>Change Password</a></td></tr>");
        out.println("</form></body></html>");

    }

 
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException { 
        String uname = req.getParameter("username");
        String pass = req.getParameter("password");
        ResultSet rs = null;
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
            
         
        try{ 
            connection();
        }catch(Exception e) {
        out.print("Error connect to db");
        }
        String sql = "select * from login where userid='"+uname+"'";
        try {
            rs=stmt.executeQuery(sql);
            if(rs.next()) { 
                if(pass.equals(rs.getString(2))) { 
                    out.print("<script type='text/javascript'> alert('login success!');"
                            + "</script>");
                    HttpSession hs = req.getSession(true);
                    hs.setAttribute("username",uname);
                    res.sendRedirect("http://localhost:8084/BankApplication/log");
                } else { 
                    out.print("<script type='text/javascript'> alert('Invalid Password!');"
                            + "</script>");
                    doGet(req, res);
                }
            } else { 
                out.print("<script type='text/javascript'> alert('Invalid Password!');"
                            + "</script>");
                doGet(req, res);
            }
        } catch (Exception ex) {
            out.print(ex.getMessage());
                doGet(req, res);
        }
        
    }


/*
public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    
            name=req.getParameter("txtname");
            pass=req.getParameter("txtpass");
                
            String sql = "select * from login where userid='"+name+"'";
        try {
            rs=stmt.executeQuery(sql);
        } catch (SQLException ex) {
            out.print("err in driver");
        }
                
    if(req.getParameter("btnsubmit")!=null)
        {
            try
            {
                if(rs.next())
                {
                    if(pass.equals(rs.getString(2))){
                        HttpSession hs=req.getSession(true);
                        hs.setAttribute("txtname", name);
                        res.sendRedirect("http://localhost:8080/bankApplication/log");
                     }else{
                        out.print("Enter valid Password.");
                        doGet(req, res);
                    }
                }else{
                    out.print("Enter valid Password..");
                        doGet(req, res);
                }
            }catch(Exception e){
                out.print("err in query...");
                doGet(req, res);
            }
        }
    
}*/

}