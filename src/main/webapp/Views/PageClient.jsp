
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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

        <h2>Vous etes connecté ${customer.getName()}</h2>
        <input type="hidden" name="action" value="more">
	<input type="submit" value="En savoir plus">
        <%-- Oh Mofid je t'ai mis à disposition une expression EL qui s'appele products qui est une liste de tout les produits de la base
        tu peut t'en servir sous la forme ${products} en utilisant tout les paramètre present dans la classe product
dont ${product.name} et plein d'autres pour faire l'affichage de tout les produits tu n'as qu'a parcourir cette liste <--%>
        
    </body>
</html>
