 <%@page import="model.tables.Customer"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="model.tables.Product"%>
<%List<Product> products = (List<Product>) request.getAttribute ( "products" ); %>
<%Customer customer = (Customer) request.getAttribute( "customer" ); %>   
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Espace Admin</title>
    </head>
    <body>
        <h1>Macal</h1>

        <div id="list-example" class="list-group">
  <a class="list-group-item" href="#list-item-1">Statistiques</a>
  <a class="list-group-item" href="#list-item-2">Gérer Produits</a>
  <a class="list-group-item" href="#list-item-3">Item 3</a>
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
  <h4 id="list-item-3">Item 3</h4>
  <p>...</p>
  <h4 id="list-item-4">Item 4</h4>
  <p>...</p>
</div>
        
        
        

        <br></br>

            <input type="submit" value="Afficher" onClick="AfficherMasquer()">
            <div id="piechart" style="width: 900px; height: 500px; display: none;"></div>
            <br></br>
            <input type="hidden" name="action" value="create">
            <input type="submit" value="Se Deconnecter">    
  </div>
    <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
        <p>deofkpefkozepdokzdpozk</p>

    </div>
  <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
          <p>deofkpefkozepdokzdpozk</p>
      </div>
</div>
       <input type="submit" name="action" value="Page Creation Produit"> 

    </body>
</html>
