<%-- 
    Document   : Usebean
    Created on : Oct 15, 2014, 10:50:55 AM
    Author     : SHREEJI
--%>

<%@page language="java" %>
<jsp:useBean id="p" scope="session" class="mypack.Person">
    <jsp:setProperty name="p" property="*" />
</jsp:useBean>

<h1> Your Data has been Stored </h1>

<a href="ShowData.jsp"> ShowData </a>