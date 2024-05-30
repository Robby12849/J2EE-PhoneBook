<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ecco la rubrica</title>
    <link rel="stylesheet" type="text/css" href="styleselect.css">
</head>
<body>
<form action="inseriscinumero.jsp"> 
<button value="inserisci" type="submit"> INSERISCI NUMERO</button>
</form>
<h1> ECCO LA TUA RUBRICA TELEFONICA! </h1>
<div class="rubrica-container">
    <div>
        <h3>Nominativi</h3>
        <table class="rubrica-table">
            <thead>
                <tr>                 
                    <th>Numero Di Telefono</th>
                    <th>Nome</th>
                    <th>Cognome</th>
                    <th>E-Mail</th>
                    <th>AZIONI</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="nome" items="${nomi}">
                    <tr>
                        <td>${nome.ntel}</td>
                        <td>${nome.nome}</td>
                        <td>${nome.cognome}</td>
                        <td>${nome.email}</td>
                    	<td><a href="deletenumber?id=${nome.id}"> elimina</a> <br>
                    	</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
