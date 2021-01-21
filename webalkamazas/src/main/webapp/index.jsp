<%-- 
    Document   : index
    Created on : 2021.01.13., 13:47:22
    Author     : krisztianfarkas
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="hu.combit.elsowebapp.Utility"%>
        

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style> 
            td {
                width: 100px;
            }
            tbody tr > td > a {
                background-color: #990000;
                border: 1px black solid;
                color: white;
                text-decoration: none;
                
                padding: 10px;
                display: block;
            }
            a.letrehozasa {
                background-color: green;
            } 
            #szerkesztesa {
                 background-color: yellow;
            }
        </style>
    </head>
    <body>
        <%  
            List<String[]> lista = Utility.list();
        %> 
        <table border="1">
            <thead>
                <tr>
                    <th>A</th>
                    <th>B</th>
                    <th>C</th>
                    <th>D</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                    for(String[] sor: lista){
                %>
                        <tr>
                        <td><%=sor[0]%></td>
                        <td><%=sor[1]%></td>
                        <td><%=sor[2]%></td>
                        <td><%=sor[3]%></td>
                        <td><a id="szerkesztes" href="/AdatWebKapcsolat/edit.jsp?id=<%=sor[4]%>">Szerkesztés</a>
                            <a href="/AdatWebKapcsolat/delete.jsp?id=<%=sor[4]%>">Törlés</a></td>
                        </tr>
                <%
                    }
                %>
            </tbody>
            <tfoot><a class="letrehozas" href="/AdatWebKapcsolat/create.jsp">Létrehozás</a></tfoot>
        </table>
        <h1> Hello World első !</h1>
        <a class="letrehozas" href="/AdatWebKapcsolat/masodik.jsp">Kattints</a>
    </body>   

</html>