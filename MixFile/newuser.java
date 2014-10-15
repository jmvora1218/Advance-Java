/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@WebServlet(urlPatterns = {"/newuser"})
public class newuser extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException { 
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.print("<html>\n" +
"\n" +
"<head>\n" +
"<title>Welcome new user </title>\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"<div id='hello' align='center' style='float:left;margin: 2%;padding: 5%;border-style: dashed;'>\n" +
"<form method='post'>\n" +
"<table align='center' cellpadding='5%'> \n" +
"<tr> <td> User ID : </td> <td> <input type=\"text\" name=\"username\"/> </td> </tr> \n" +
"<tr> <td> Password : </td> <td> <input type=\"password\" name=\"password\"/> </td> </tr>\n" +
"<tr> <td> Email-ID :  </td> <td> <input type=\"email\" name=\"email\" /> </td> </tr>\n" +
"<tr> <td> Contact Number :  </td> <td> <input type=\"number\" name=\"contactnum\" /> </td> </tr>\n" +
"<tr><td>Name : </td><td> <input type=\"text\" name=\"name\" /></td></tr>\n" +
"<tr><td>Account number : </td><td> <input type=\"number\" name=\"accountno\"/></td></tr>\n" +
"<tr><td>Initial Amount : </td><td><input type=\"number\" name=\"initamt\" style=\"editable:false;\" value=\"1000\"/></td></tr>\n" +
"<tr><td colspan=\"2\"><input type=\"submit\" value=\"Register\"/></td></tr>\n" +
"</table>\n" +
"</form>\n" +
"</div>\n" +
"</body>\n" +
"\n" +
"</html>");
        
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException { 
        String userid = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String contactnum = req.getParameter("contactnum");
        String name = req.getParameter("name");
        String accountnum = req.getParameter("accountno");
        String initialmoney = req.getParameter("initamt");
        ResultSet rs=null;
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String sql;
        try {
            utilities.initialize();
        
        sql = "select * from login where userid="+userid;
        rs = utilities.stmt.executeQuery(sql);
        if(rs.next()){
            out.print("<script type='text/javascript'> alert('User Already Exist! Login!');"
                            + "</script>");
            res.sendRedirect("http://localhost:8080/bankApplication/welcome");
        }
        } catch(Exception e) {
            try {
            sql="insert into login values('"+userid+"','"+password+"')";
            utilities.stmt.executeUpdate(sql);
            sql="insert into customer values('"+accountnum+"','"+name+"','"+ email+"','"+ contactnum+"','"+userid+"')";
            utilities.stmt.executeUpdate(sql);
            sql="insert into balance values('"+accountnum+"','"+initialmoney+"')";
            utilities.stmt.executeUpdate(sql);
            out.print("<script type='text/javascript'> alert('User created! You can Login!');"
                            + "</script>");
            res.sendRedirect("http://localhost:8080/bankApplication/welcome");
            } catch(Exception ex) {}
        }
        
    }
    
}
