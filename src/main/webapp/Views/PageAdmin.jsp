 <%@page import="model.tables.Customer"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="model.tables.Product"%>
<%@page import="model.tables.Customer"%>
<%List<Product> products = (List<Product>) request.getAttribute ( "products" ); %>
<%Customer customer = (Customer) request.getAttribute( "customer" ); %>   
<%List<Customer> customers = (List<Customer>) request.getAttribute("customers"); %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Espace Admin</title>
    </head>
    <body style="background-color: gray">
        <h1>Macal</h1>

        <div id="list-example" class="list-group">
  <a class="list-group-item" href="#list-item-1">Statistiques</a>
  <a class="list-group-item" href="#list-item-2">Gérer Produits</a>
  <a class="list-group-item" href="#list-item-3">Clients</a>
</div>
<div data-spy="scroll" data-target="#list-example" data-offset="0" class="scrollspy-example">
  <h2 id="list-item-1">Statistiques</h2>
        <p>Chiffre d'affaire de MaCaL Entreprise selon  
           <select name="choixGraph" id="choix">
                <option value="zoneGeo">La zone géographique</option>
                <option value="cateArticle">La catégorie d'articles</option>
                <option value="clients">Les clients</option>      
           </select>
             de <input name="dateDebut"> à <input name="dateFin">
            <input type="submit" name="action" value="Valider">
        </p>
        
        </div>
                <input type="submit" value="Afficher" onClick="AfficherMasquer()" class="btn btn-primary">
                <div id="piechart" style="width: 900px; height: 500px; display: none;"></div>
                    
        </div>
        
    <h3 id="list-item-2">Gérer Produits</h3>
        <table class="table table-bordered table-dark">
        <thead>
        <tr>
            <th scope="col">Description</th>
            <th scope="col">Prix Unitaire</th>
            <th scope="col">Quantité</th>
            <th scope="col">Modifications</th>
        </tr>
        </thead>
        <tbody>
             <c:forEach var="product" items="${products}">
                <tr>
                <td>${product.getDescription()}</td>
                <td>${product.getPurchase_cost()} €</td>
                <td>${product.getQuantity_on_hand()}</td>
                <td><input type="submit" name="action" value="Modifier" class="btn btn-primary">
                    <input type="submit" name="action" value="Supprimer" class="btn btn-primary"></td>
                </tr>
             </c:forEach>
        </tbody>
        </table>
        <input type="submit" name="action" value="Créer Nouveau Produit" class="btn btn-primary"> 
        
    <h4 id="list-item-3">Clients</h4>
        <table class="table table-bordered table-dark">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Prénom</th>
            <th scope="col">Email</th>
            <th scope="col">Montant Dépensé</th>
        </tr>
        </thead>
        <tbody>
                <c:forEach var="product" items="${customers}">
                    <tr>
                    <td>${customer.getCustomer_id()}</td>
                    <td>${customer.getName()}</td>
                    <td>${customer.getEmail()}</td>
                    <td>${customer}</td>
                    </tr>
                </c:forEach>
        </tbody>
        </table>


       <input type="submit" value="Se Deconnecter" class="btn btn-primary">
    </body>
</html>
