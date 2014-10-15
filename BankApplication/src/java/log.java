/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
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

    out.println("<html>\n" +
"<head>\n" +
"\n" +
"<title>Account Detail</title>\n" +
"</head>\n" +
"<body>\n" +
"<div style='float:left; clear:none;margin-left:10%;margin-top:2%;'>\n" +
"<table align='center' style='border:0;'>\n" +
"<tr><td> User ID : </td> <td> '\"+req.getParameter(\"txtname\")+\"' </td> </tr>\n" +
"<tr> <td> Name : </td> <td> #name </td> </tr>\n" +
"<tr> <td> Date: </td> <td> #date </td> </tr>\n" +
"<tr> <td> Amount: </td> <td> <input type='number' name='amount'> </td> </tr>\n" +
"<tr> <td> Operate </td><td> <select> <option value='1'> Withdraw </option> <option value='2'> Deposite </option> </select></td></tr>\n" +
"<tr> <td height='33'> <input type='submit' name='Submit' value='Submit'> </td></tr>\n" +
"</table>\n" +
"</div> \n" +
"<div style='float:right; clear:none;margin-right:10%;margin-top:3%;' >\n" +
"Balance is: #balance <br>\n" +
"Transection Details are: <br><hr><br>\n" +
"</div></body></html>");
    } 
    
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    
    }
}