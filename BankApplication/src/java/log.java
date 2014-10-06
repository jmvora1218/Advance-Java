/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SHREEJI
 */
public class log extends HttpServlet {
    
    
    
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{

    res.setContentType("text/html");
    PrintWriter out=res.getWriter();

    out.println("<html><head><title>Wel-Come to Bank Application</title></head><body>");
    out.println("<form method='post' action='log'>");
    out.print("<table border=0 '>");
    out.println("<tr><td> Userid: </td><td>'"+req.getParameter("txtname")+"'  </td></tr>");
    out.println("<tr><td> Date:</td><td>  </td></tr>");
    out.print("<tr><td><select> <option value='seebalance'> See Balance </option> "
                            + "<option value='depositemoney'> Deposite money </option>"
                            + "<option value='whithdrawmoney'> Whithdraw wmoney </option>"
                            + "<option value='ststement'> see statement </option>"
                        + "</select>"
            + "</td></tr>");
    out.println("<tr><td> <input type='submit' name='btnsubmit' value='Submit'></td></tr>");
    out.println("</form></body></html>");
    } 
    
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    
    }
    
}