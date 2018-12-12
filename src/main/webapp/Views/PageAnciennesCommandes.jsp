<%-- 
    Document   : PageAnciennesCommandes
    Created on : 27 nov. 2018, 16:23:22
    Author     : leolo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/PagesCss.css" media="screen" />
        <title>Anciennes Commandes</title>
    </head>
    <body style="background-color: grey">
        <h1>MaCaL</h1>
        <h2>Commandes de ${customer.getName()}</h2>
                <table class="table table-bordered table-light">
        <thead>
        <tr>
            <th scope="col">Description</th>
            <th scope="col">Quantité</th>
            <th scope="col">Montant</th>
        </tr>
        </thead>
        <tbody>
             <c:forEach var="product" items="${purchases}">
                <tr>
                <td>${purchase.getDescription()}</td>
                <td>${purchase.getPurchase_cost()} €</td>
                <td>${purchase.getQuantity_on_hand()}</td>
                </tr>
             </c:forEach>
        </tbody>
        </table>
        
        <input type="submit" name="action" value="Retour au Catalogue" class="btn btn-primary">

    </body>
</html>
