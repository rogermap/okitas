
<%@page import="hu.combit.elsowebapp.Utility"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
    String a = request.getParameter("a");
    String b = request.getParameter("b");
    String c = request.getParameter("c");
    String d = request.getParameter("d");
    String id = request.getParameter("id");
    if(a != null && b != null && c != null && d != null && id != null){
        Utility.update(id, a, b, c, d);
    }
    String[] values = Utility.findById(id);
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World második!</h1>
        
        <a href="/AdatWebKapcsolat/index.jsp">Vissza a listára</a>

        <form action="/AdatWebKapcsolat/edit.jsp">
            a:<input type="number" name="a" value="<%=values[0]%>">
            <br>
            b:<input type="string" name="b" value="<%=values[1]%>">
            <br>
            c:<input type="string" name="c" value="<%=values[2]%>">
            <br>
            d:<input type="date" name="d" value="<%=values[3]%>">
            <br>
            <input type="hidden" name="id" value="<%=id%>">
            <input type="submit">
        </form>
    </body>
</html>