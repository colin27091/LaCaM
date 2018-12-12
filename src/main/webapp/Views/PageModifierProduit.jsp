<%-- 
    Document   : PageGererProduitsAdmin
    Created on : 27 nov. 2018, 16:51:07
    Author     : leolo
--%>
<%@page import="model.tables.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Gérer Produits</title>

        <link rel="stylesheet" type="text/css" href="css/PagesCss.css" media="screen" />

    </head>
    <body>
        <h1>MaCal</h1>
        
        <ul id="menu">
        <li>Clients</li>
	<li>Statistiques</li>
	</ul>
                
    
	<h2>Gérer Produits</h2>
        
        <br></br> 
        <c:forEach var="product" items="${products}">
            <p >${product.getDescription()} <a href="/MaCaL/modifControl?product_id=${product.getProduct_id()}">Modifier</a>    <a href="/MaCaL/modifControl?product_id=${product.getProduct_id()}">Supprimer</a>
            </p>
        </c:forEach>
        <br></br>
        <input type="submit" name="action" value="Se déconnecter"/>
        
    </body>
</html>
