
<%@page import="hu.combit.elsowebapp.Utility"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String a = request.getParameter("a");
    String b = request.getParameter("b");
    String c = request.getParameter("c");
    String d = request.getParameter("d");
    if(a != null && b != null && c != null && d != null){
        Utility.create(a, b, c, d);
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World második!</h1>
        
        <a href="/AdatWebKapcsolat/index.jsp">Vissza a listára</a>

        <form action="/AdatWebKapcsolat/create.jsp">
            a:<input type="number" name="a">
            <br>
            b:<input type="string" name="b">
            <br>
            c:<input type="string" name="c">
            <br>
            d:<input type="string" name="d" >
            <br>
            <input type="submit">
        </form>
    </body>
</html>