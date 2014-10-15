/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SHREEJI
 */
@WebServlet(urlPatterns = {"/quiz"})
public class quiz extends HttpServlet  {
    static Connection con = null;
    static Statement stmt=null;
    int question=1;
    int ans=0;
    int score=0;
    Cookie m=null;
    ResultSet rs;
    public static void initialize() throws SQLException, ClassNotFoundException { 
        Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost.localdomain:3306/quiz","root","root");
                stmt = con.createStatement();     
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws FileNotFoundException, IOException { 
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
         m = new Cookie("score",String.valueOf(score));
        //right +5 | -2
        
        try {
            initialize();
        } catch (Exception e) {
            out.print("DB Connectivity error");
        }
        
        
        try { 
            String sql = "select * from questions where qid='" + question + "'";
        rs = stmt.executeQuery(sql);
        
        out.print("       <html> <head> <title> This is KHAJANA QUIZ </title> </head> <body> ");
        out.print(" <form method=post>" );
        rs.next();
        out.print("<br> Correct ans gives +5 and Wrong -2 | Your Current score is <b>" + score + " </b><br><hr><br>");
        out.print("<br> Question : "+rs.getString(2)+" <br> <hr> <br>");
        out.print("<input type=radio name=answers value=1> " + rs.getString(3) + " </radio><br>");
        out.print("<input type=radio name=answers value=2> " + rs.getString(4) + " </radio><br>");
        out.print("<input type=radio name=answers value=3> " + rs.getString(5) + " </radio><br>");
        out.print("<input type=radio name=answers value=4> " + rs.getString(6) + " </radio><br><br> <hr>");
 out.print("<input type=submit value=CommitAns />");
 out.print("</form></body> </html>");
        } 
        
        catch(Exception e) {
        out.print("error in query");
        }
            
        
        res.addCookie(m);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException { 
        int uans = Integer.parseInt(req.getParameter("answers"));
        PrintWriter out = res.getWriter();
        try {
            if(rs.getInt(7)==uans) {
                score+=5;
            } else { 
                score-=2;
            }
            m.setValue(String.valueOf(score));
        } catch (SQLException ex) {}
        res.setContentType("text/html");
        question++;
        if(question<=5) {
        try { 
            String sql = "select * from questions where qid='" + question + "'";
        rs = stmt.executeQuery(sql);
        
        out.print("       <html> <head> <title> This is KHAJANA QUIZ </title> </head> <body> ");
        out.print(" <form method=post>" );
        rs.next();
        out.print("<br> Correct ans gives +5 and Wrong -2 | Your Current score is <b>" + score + " </b><br><hr><br>");
        out.print("<br> Question : "+rs.getString(2)+" <br> <hr> <br>");
        out.print("<input type=radio name=answers value=1> " + rs.getString(3) + " </radio><br>");
        out.print("<input type=radio name=answers value=2> " + rs.getString(4) + " </radio><br>");
        out.print("<input type=radio name=answers value=3> " + rs.getString(5) + " </radio><br>");
        out.print("<input type=radio name=answers value=4> " + rs.getString(6) + " </radio><br><br> <hr>");
 out.print("<input type=submit value=CommitAns />");
 out.print("</form></body> </html>");
        } 
        
        catch(Exception e) {}
        
        } else { 
            out.print("<br><hr><br>Wow... You completed the quiz! Your percentage is " + String.valueOf(score*100/25) );
        }
        res.addCookie(m);
    }
}
