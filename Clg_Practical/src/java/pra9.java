/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.clg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author SHREEJI
 */
public class pra3 {
    static Connection con;
    static PreparedStatement pstmt;
    static Statement stmt;
    
    public static void connectdb() throws ClassNotFoundException, SQLException { 
        String url="jdbc:mysql://localhost/lab";
        String un="root";
        String up="java";
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded.");
        con=DriverManager.getConnection(url,un,up);
        System.out.println("Connection Created..");
        pstmt=con.prepareStatement("insert into employee values(?,?);" );
        stmt=con.createStatement();
    }
    
    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        connectdb();
        System.out.println("Enter 3 records in  username password format : ");
        for(int i=1;i<=3;i++) { 
            pstmt.setString(1, scan.next());
            pstmt.setString(2, scan.next());
            pstmt.executeUpdate();
        }
        ResultSet rs = stmt.executeQuery("select * from employee");
        System.out.println("The records inserted are  : ");
        while(rs.next()) { 
            System.out.println("The user name is : " + rs.getString(1)+ " and password is : " + rs.getString(2)+ "..!");
        }        
        
    }
}
