/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */

import java.sql.*;
public class utilities {
    
    static Connection con;
    static Statement stmt;
    
    public static void initialize() throws ClassNotFoundException, SQLException { 
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost.localdomain:3306/bank","root","root");
        stmt=con.createStatement();
    }
    
}
