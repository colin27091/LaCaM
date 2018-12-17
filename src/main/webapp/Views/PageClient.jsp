
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
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/PagesCss.css" media="screen" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Catalogue</title>
        <script>
            function myFunction() {
                var popup = document.getElementById("myPopup");
                popup.style.visibility = "visible";
                setTimeout(popup.style.visibility = "hide",2000);
                console.log("hola");
            
            }
        </script>
    </head>
    <body style="background-color: grey" >
        <h1 style="text-align: center" style="background-color: grey">MaCaL</h1>
        <form>
        <ul>
            <input name="action" value="Mes commandes" type="submit" class="btn btn-primary">
            <input name="action" value="Gerer le profil" type="submit" class="btn btn-primary">
            <input name="action" value="Deconnexion" type="submit" class="btn btn-primary">
        </ul>
        </form>

        <h2 style="text-align: left"  style="background-color: grey" >Vous etes connecté <%=customer.getName()%></h2>
    <h3 id="list-item-2" >Gestion des produits</h3>
        <table class="table table-bordered table-light">
        <thead>
        <tr>
            <th scope="col">Description</th>
            <th scope="col">Prix Unitaire</th>
            <th scope="col">Quantité</th>
            <th scope="col">Total</th>
            <th scope="col">Achat</th>
        </tr>
        </thead>
        <tbody>
             <c:forEach var="product" items="${products}">
                <tr>
                <td>${product.getDescription()}</td>
                <td>${product.getPurchase_cost()} €</td>
                <td><input name="Quantité" class="form-control col-md-4">(Quantité Max: ${product.getQuantity_on_hand()})</td>
                <td>prix total €</td>
                <td><form><input href="/MaCaL/clientControl?product_id="${product_id.getProduct_id()} type="submit" name="action" value="Commander" class="btn btn-primary" onclick="myFunction()"></form></td>
                </tr>
             </c:forEach>
        </tbody>
        </table>        
          <span style="visibility: hidden" id="myPopup">La commande a bien été passé!</span>
    </body>
</html>
