<%-- 
    Document   : ProductDetail
    Created on : Oct 13, 2014, 11:21:07 PM
    Author     : SHREEJI
--%>

<%@ page language ="java" import="java.sql.*" %>
<%!
    Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;
    String id,name,pqty,prise;

    public void jspInit()throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver is loaded");
        con=DriverManager.getConnection("jdbc:mysql://localhost/jsp","root","java");
        stmt =con.createStatement();
    }
%>
<%
    id=request.getParameter("pid");
    String sql="select * from productdertail where pid='+pid'";
    try{
        rs=stmt.executeQuery(sql);
        rs.next();
        id=rs.getString(1);
        pqty=rs.getString(2);
        prise=rs.getString(3);
    }catch(Exception e){
        System.out.print(e.getMessage());
    }
%>
<html>
    <body>
        <h1>Hello World!</h1>
        <form>
            <th> id=<%=id%> </th>
            <th> pqty=<%=pqty%> </th>
            <th> prise=<%=prise%> </th>
        </form>
    </body>
</html>
