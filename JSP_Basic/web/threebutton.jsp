<%-- 
    Document   : threebutton
    Created on : Oct 15, 2014, 7:17:13 PM
    Author     : SHREEJI
--%>

<%@ page language="java" %>
<%
    if(request.getParameter("btnone")!=null)
    {
        out.println(" B1 is clicked");
    }
    if(request.getParameter("btntwo")!=null)
    {
        out.println(" B2 is clicked");
    }
    if(request.getParameter("btnthree")!=null)
    {
        out.println(" B3 is clicked");
    }
%>
<html>
    <body>
        <form action="threebutton.jsp">
            <input type="submit" name="btnone" value="B1" > <br>
            <input type="submit" name="btntwo" value="B2" > <br>
            <input type="submit" name="btnthree" value="B3" > <br>
            
        </form>
    </body>
</html>
