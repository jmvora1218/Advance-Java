/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
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
@WebServlet(urlPatterns = {"/operate"})
public class operate extends HttpServlet {
    
    HttpSession hs=null;
        String user = "";
        String sql="";
        String name="";
        String acno="";
        ResultSet rs =null;
        Date dt = null;
        int balance=0;
        String statement="";
        int amount=0;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException { 
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        hs = req.getSession();
        dt = new Date();
        user = (String) hs.getAttribute("username");
        try { 
        utilities.initialize();
        sql = "select * from customer where userid='"+user+"'";
        rs = utilities.stmt.executeQuery(sql);
        rs.next();
        name=rs.getString(2);
        acno=rs.getString(1);
        sql = "select * from balance where acno='"+acno+"'";
            rs = utilities.stmt.executeQuery(sql);
            rs.next();
            balance = Integer.parseInt(rs.getString(2));
            sql = "select * from transaction where acno='"+acno+"'";
            rs = utilities.stmt.executeQuery(sql);
            statement="";
            try { 
              while(rs.next()) { 
                statement += "Date : "+rs.getString(2)+ "Mode : " + 
                        rs.getString(3) + " Amount : " + rs.getString(4) + "<br>";
                }
            }catch(Exception e) { 
                    statement = "No Transcations to display!!";
                    }
        } catch(Exception e) {
            out.print(e.getMessage());
        }
        
        out.print("<html>\n" +
"\n" +
"<head>\n" +
"<title>Perform Transaction </title>\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"<div id='hello' align='center' style='float:left;margin: 2%;clear:none; padding: 5%;border-style: dashed;'>\n" +
"<form method='post'>\n" +
"<table align='center' cellpadding='5%'> \n" +
"<tr> <td> User ID : </td> <td> "+user+" </td> </tr> \n" +
"<tr><td>Name : </td><td> "+name+" </td></tr>\n" +
"<tr><td>Date : </td><td> "+dt+" </td></tr>\n" +
"<tr><td>Amount : </td><td><input type=\"number\" name=\"amt\" style=\"editable:false;\" value=\"1000\"/></td></tr>\n" +
"<tr><td>Operation : </td><td><select name='act'><option value='1'>Withdraw</option><option value='2'>Deposit</option>\n" +
"<option value='3'>See Balance</option> <option value='4'>Statement</option></select>\n" +
"</td></tr>\n" +
"<tr><td colspan=\"2\"><input type=\"submit\" value=\"Operate\"/></td></tr>\n" +
"</table>\n" +
"</form>\n" +
"</div>\n" +
"<div id='hello2' align='center' style=' height:230px;float:right;margin-right: 12%;margin-top:2%;clear:none;padding: 5%;border-style: dashed;'>\n" +
"Your Balance is : "+balance+"<br><br>\n" +
" Your Transactions are as follows : <br> <hr> <br> " + statement +
"</div>\n" +
"</body>\n" +
"\n" +
"</html>");
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException { 
        PrintWriter out=null;
        
        try {
        amount = Integer.parseInt(req.getParameter("amt"));
        out = res.getWriter();
        int choice = Integer.parseInt(req.getParameter("act"));
        String sqldate="" + dt.getYear()+"//"+dt.getMonth()+"//"+dt.getDate();
        
        if(choice==1) { 
            balance-=amount;
            String mode="withdraw";
            sql = "insert into transaction values ('"+acno+"' ,'"+sqldate+"' ,'"+ mode +"' ,'"+amount+"')";
            utilities.stmt.executeUpdate(sql);
            sql="update balance set balance='"+balance+"' where acno='"+acno+"'";
            utilities.stmt.executeUpdate(sql);
        } else if(choice==2) { 
            balance+=amount;
            String mode="deposit";
            sql = "insert into transaction values ('"+acno+"' ,'"+sqldate+"' ,'"+ mode +"' ,'"+amount+"')";
            utilities.stmt.executeUpdate(sql);
            sql="update balance set balance='"+balance+"' where acno='"+acno+"'";
            utilities.stmt.executeUpdate(sql);
        }
        res.setContentType("text/html");
        } catch(Exception e) {
        
        out.print(e.getMessage());
        }
        res.sendRedirect("http://localhost:8080/bankApplication/operate");
        
    }

}
