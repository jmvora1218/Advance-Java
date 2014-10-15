/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author root
 */
@WebServlet(urlPatterns = {"/welcome"})
public class welcome extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException { 
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.print("<html>\n" +
"\n" +
"<head>\n" +
"<title>Welcome to JD Bank!</title>\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"<div id='hello' align='center' style='float:left;margin: 2%;padding: 5%;border-style: dashed;'>\n" +
"<form method='post'>\n" +
"<table align='center' cellpadding='5%'> <tr> <td>\n" +
"Username : </td> <td> <input type='text' name='username'/> </td> <tr>\n" +
"<td> \n" +
"Password : </td> <td> <input type='password' name='password'/> </td> \n" +
"</tr> <tr> <td> <input type='submit' value='login'/> </td> </tr>\n" +
"<tr> <td colspan='2'> <a href='http://localhost:8080/bankApplication/newuser'> New User </a> </td> </tr> \n" +
"<tr> <td colspan='2'> <a href='#'> Forgot Password </a> </td> </tr> \n" +
"<tr> <td colspan='2'> <a href='#'> Change Password </a> </td> </tr> \n" +
"</table>\n" +
"</form>\n" +
"</div>\n" +
"</body>\n" +
"\n" +
"</html>");
        
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException { 
        String uname = req.getParameter("username");
        String pass = req.getParameter("password");
		
        ResultSet rs = null;
        
		res.setContentType("text/html");
        PrintWriter out = res.getWriter();
		
        try {
            utilities.initialize();
        } catch(Exception e) {
        out.print("<script type='text/javascript'> alert('Failed! Try Login Again');"
                            + "</script>");
                doGet(req,res);
        }
        String sql = "select * from login where userid='"+uname+"'";
        try {
            rs = utilities.stmt.executeQuery(sql);
            if(rs.next()) { 
                if(pass.equals(rs.getString(2))) { 
                    out.print("<script type='text/javascript'> alert('login success!');"
                            + "</script>");
                    HttpSession hs = req.getSession(true);
                    hs.setAttribute("username",uname);
                    res.sendRedirect("http://localhost:8080/bankApplication/operate");
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
        } catch (SQLException ex) {
            out.print("<script type='text/javascript'> alert('"+ex.getMessage()+"');"
                            + "</script>");
                doGet(req, res);
        }
        
    }

}
