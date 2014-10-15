<%-- 
    Document   : ShowData
    Created on : Oct 15, 2014, 11:15:21 AM
    Author     : SHREEJI
--%>
<%@page language="java" %>
<jsp:useBean id="p" scope="session" class="mypack.Person">
    
</jsp:useBean>

Name :  <jsp:getProperty name="p" property="name" /> <br> <br>
Password :  <jsp:getProperty name="p" property="password" />