<%-- 
    Document   : empdata
    Created on : Oct 15, 2014, 7:29:35 PM
    Author     : SHREEJI
--%>

<%@ page language="java" import="java.sql.*;" %>

<%!
    Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;
    String un,up;
    public void jspInit(){
       try{
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver is loaded");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lab","root","java");
        stmt =con.createStatement();
        
        rs=stmt.executeQuery("select * from employee");
    }catch(Exception e){
        System.out.println("err in jdbc"+e.getMessage());
    }
    }

%>


<html>
    <body>
        <table border="1">
            <th> Name </th>
            <th> Password </th>
            <%
                try{
                    rs.beforeFirst();
                    while(rs.next()){
                        un=rs.getString("NAME");
                        up=rs.getString("PASSWORD");
            %>
            <tr>
                <td><%=un%></td>
                <td><%=up%></td>
            </tr>
            <%            
                    }
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            %>
        </table>   
    </body>
</html>