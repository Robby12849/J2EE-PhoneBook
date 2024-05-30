<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserisci</title>
<link rel="stylesheet" type="text/css" href="styleinserisci.css">
</head>
<body>
    <div class="titolocentrale"> 
        <h3>Aggiungi a rubrica telefonica</h3> 
        <br> 
    </div> 
    <form action="inseriscinumero" method="post">
        <div class="scritte"> 
            <label for="numerotelefono">Inserisci numero di telefono</label>
            <input type="number" name="numerotelefono" id="numerotelefono" required> 
            <label for="nome">Inserisci nome</label>
            <input type="text" name="nome" id="nome" required> 
            <label for="cognome">Inserisci cognome</label>
            <input type="text" name="cognome" id="cognome" required> 
            <label for="email">Inserisci email</label>
            <input type="email" name="email" id="email"> 
        </div> 
        <input id="submit" name="submit" type="button" onclick="inserisci()" value="Invia" />      
    </form>
    <script>
    async function inserisci(){
        var numero = document.getElementById("numerotelefono").value;
        var nome = document.getElementById("nome").value;
        var cognome = document.getElementById("cognome").value;
        var email = document.getElementById("email").value;
        var risp = await fetch("inseriscinumero?nome=" + nome + "&cognome=" + cognome + "&email=" + email + "&numerotelefono=" + numero, {
            method : "POST"
        });
        if (risp.ok)
            alert("UTENTE INSERITO CORRETTAMENTE");
        window.location="selectallnumber";
    }
    </script>
</body>
</html>
