<%@page import="model.tables.Customer"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="model.tables.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Customer customer = (Customer) request.getAttribute( "customer" ); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/PagesCss.css" media="screen" />
        <title>Anciennes Commandes</title>
    </head>
    <body style="background-color: grey">
        <h1 style="text-align: center" style="background-color: grey">MaCaL</h1>
        <h2 style="text-align: left"  style="background-color: grey" >Commandes de <%=customer.getName()%></h2>
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
        <form>
        <input type="submit" name="action" value="Retour au Catalogue" class="btn btn-primary">           
        </form>
    </body>
</html>
