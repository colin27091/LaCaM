<%-- 
    Document   : PageClient
    Created on : 27 nov. 2018, 16:19:41
    Author     : leolo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- <jsp:forward page="/servlets/clientControl" /> --%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/PagesCss.css" media="screen" />
        <title>Catalogue</title>
    </head>
    <body>
        <h1>MaCaL</h1>
        
        <ul id="menu">
        <li>Mes Anciennes Commandes</li>
        <li>Mon Panier</li>
        </ul>
        <title>JSP Page</title>
        <h1>Vous etes connecté ${customer.getName()}</h1>
        <input type="hidden" name="action" value="more">
	<input type="submit" value="En savoir plus">
        
    </body>
</html>
