
<%@page import="model.tables.Customer"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="model.tables.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%List<Product> products = (List<Product>) request.getAttribute ( "products" ); %>
<%Customer customer = (Customer) request.getAttribute( "customer" ); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/PagesCss.css" media="screen" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Catalogue</title>
    </head>
    <body style="background-color: gray">
        <h1 style="text-align: center; background-color: #4169E1">MaCaL</h1>
        
        <ul>
            <input name="action" value="Mes commandes" type="SUBMIT" class="btn btn-primary">
            <input name="action" value="Gérer le profil" type="SUBMIT" class="btn btn-primary">
            <input name="action" value="Déconnexion" type="SUBMIT" class="btn btn-primary">
        </ul>

        <h2 style="text-align: left">Vous etes connecté <%=customer.getName()%></h2
        

        <c:forEach var="product" items="${products}">
            <form class="container">  
                <div class="form-group col-md-6">
                    <div>
                        <p>Produit: ${product.getDescription()}</p>
                    </div>
                    <div>
                        <p>Prix unitaire: ${product.getPurchase_cost()}€</p>
                    </div>
                    <div>
                        <p>Quantité disponible: ${product.getQuantity_on_hand()} Pcs</p>
                    </div>
                </div>
            </form>
        </c:forEach>
        

       
        <%-- Oh Mofid je t'ai mis à disposition une expression EL qui s'appele products qui est une liste de tout les produits de la base
        tu peut t'en servir sous la forme ${products} en utilisant tout les paramètre present dans la classe product
dont ${product.name} et plein d'autres pour faire l'affichage de tout les produits tu n'as qu'a parcourir cette liste <--%>
        
    </body>
</html>
