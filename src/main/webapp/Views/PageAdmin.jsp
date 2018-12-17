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
         <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Espace Admin</title>
    </head>
    <body style="background-color: gray">
        <h1 style="text-align: center">Macal</h1>

  <div id="list-example" style="align-content: center">
  <a class="btn btn-primary btn-lg " href="#list-item-1">Statistiques</a>
  <a class="btn btn-primary btn-lg " href="#list-item-2">Gérer Produits</a>
  <a class="btn btn-primary btn-lg " href="#list-item-3">Clients</a>
  </div>
  </br>
  </br>
  </br>
<div data-spy="scroll" data-target="#list-example" data-offset="0" class="scrollspy-example">
  <h2 id="list-item-1">Statistiques</h2>
        <p>Chiffre d'affaire de MaCaL Entreprise selon  
           <select name="choixGraph" id="choix">
                <option value="zoneGeo">La zone géographique</option>
                <option value="cateArticle">La catégorie d'articles</option>
                <option value="clients">Les clients</option>      
           </select>
             de <input name="dateDebut"> à <input name="dateFin">
            <input type="submit" name="action" value="Valider" id='bouton' onClick=Afficher>
        </p>
        
        </div>

        
            
  <div id='graphe'>
      <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['Work',     11],
          ['Eat',      2],
          ['Watch TV', 2],
          ['Sleep',    7]
        ]);

        var options = {
          title: 'My Daily Activities',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
      window.onload = function() {

         var b = document.getElementById('bouton');
            b.onclick = function() {
            var e = document.getElementById('graphe');
            if(e.style.display=='block') {
            e.style.display = 'none';
             }
            else {
             e.style.display = 'block';
             }
             }

          }
    </script>
  </head>
  <body>
    <div id="piechart_3d" style="width: 900px; height: 500px;"></div>
  </body>
                
                    
        </div>
        </br>
        </br>
        </br>
        
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
                <td><form>
                    <input type="submit" name="action" value="Modifier" class="btn btn-primary">
                    <input type="submit" name="action" value="Supprimer" class="btn btn-primary">                      
                    </form>
                </td>
                </tr>
             </c:forEach>
        </tbody>
        </table>
<<<<<<< Updated upstream
        <form>
            <input type="submit" name="action" value="Créer Nouveau Produit" class="btn btn-primary"> 
        </form>
=======
        <input type="submit" name="action" value="Créer Nouveau Produit" class="btn btn-primary">
>>>>>>> Stashed changes
        </br>
        </br>
        </br>
        
        
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
                <c:forEach var="customer" items="${customers}">
                    <tr>
                    <td>${customer.getCustomer_id()}</td>
                    <td>${customer.getName()}</td>
                    <td>${customer.getEmail()}</td>
                    <td>${customer.getSommeTotale()}</td>
                    </tr>
                </c:forEach>
        </tbody>
        </table>
    </br>
    <p>
    <form>
       <input type="submit" name="action" value="Se Deconnecter" class="btn btn-primary">
<<<<<<< Updated upstream
       </br>
    </form>
=======
    </form>   
       </br>        
>>>>>>> Stashed changes
    </p>

    </body>
</html>
