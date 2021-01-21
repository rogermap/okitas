<%@page import="hu.combit.elsowebapp.Utility"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
    String id = request.getParameter("id");
    if( id != null){
        Utility.delete(id);
    }
    response.sendRedirect("index.jsp");
    
%>