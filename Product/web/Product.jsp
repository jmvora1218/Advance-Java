<%-- 
    Document   : Product
    Created on : Oct 13, 2014, 9:46:32 PM
    Author     : SHREEJI
--%>


<%@ page language ="java" import="java.sql.*" %>

<%!
    Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;
    String id,name;
    public void jspInit(){
       try{
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver is loaded");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JSP","root","java");
        stmt =con.createStatement();
        
        rs=stmt.executeQuery("select * from product");
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
    }
%>
<% 
    if(request.getParameter("btnsubmit")!=null){
    String pid=request.getParameter("product");
    System.out.println("pid==="+pid);
%>
    <jsp:include page="ProductDetail.jsp">
        <jsp:param name="pid" value="<%=pid%>"/>
    </jsp:include>
<% 
    }
%>

<html>
    <body>
        <form action="Product.jsp">
            Product Name: <select name="product">
            <%
                try{
                    rs.beforeFirst();
                    while(rs.next())
                    {
                        id=rs.getString(1);
                        name=rs.getString(2);
            %>            
                        <option value="<%=id %>"><%=name%> </option>

            <%
                    }    
                }catch(Exception e){
                    System.out.print(e.getMessage());
                }
            %>
              </select>
            <input type="submit" name="btnsubmit" value="Submit">
        </form>
    </body>
</html>