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
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
         <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/mustache.js/0.8.1/mustache.min.js"></script>
         <script type="text/javascript" src="https://www.google.com/jsapi"></script>
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
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    // Chiffres d'affaires par produit           
        google.load("visualization", "1", {packages: ["corechart"]});
        
        $(document).ready(// Exécuté à la fin du chargement de la page
            function () {
                // On montre la liste des codes
                showCodes();
            }
        );

        function drawChart(dataArray) {
                var data = google.visualization.arrayToDataTable(dataArray);
                var options = {
                        title: 'Chiffre d`affaires par catégories de produit',
                        is3D: true
                };
                var chart = new google.visualization.PieChart(document.getElementById('piechart'));
                chart.draw(data, options);
        }
                function doGeoAjax() {
                $.ajax({
                        url: "ChiffreAffairesGeo",
                        data: $("#codeForm").serialize(),
                        dataType: "json",
                        success: // La fonction qui traite les résultats
                                function (result) {
                                        // On reformate le résultat comme un tableau
                                        var chartData = [];
                                        // On met le descriptif des données
                                        chartData.push(["Etat", "chiffre d'affaires"]);
                                        for(var client in result.records) {
                                                chartData.push([client, result.records[client]]);
                                        }
                                        // On dessine le graphique
                                        drawRegionsMap(chartData);
                                },
                        error: showError
                });
        }
    // Chiffres d'affaires par client


        function drawChartClient(dataClient) {
                var data = google.visualization.arrayToDataTable(dataClient);
                var options = {
                        title: 'Chiffre d`affaires par Clients',
                        is3D: true
                };
                var Clientchart = new google.visualization.PieChart(document.getElementById('piechart'));
                Clientchart.draw(data, options);
        }

        // Afficher les ventes par client
        function doClientAjax() {
                $.ajax({
                        url: "ChiffreAffairesClients",
                        data: $("#codeForm").serialize(),
                        dataType: "json",
                        success: // La fonction qui traite les résultats
                                function (result) {
                                        // On reformate le résultat comme un tableau
                                        var chartData = [];
                                        // On met le descriptif des données
                                        chartData.push(["Client", "chiffre d'affaires"]);
                                        for(var client in result.records) {
                                                chartData.push([client, result.records[client]]);
                                        }
                                        // On dessine le graphique
                                        drawChartClient(chartData);
                                },
                        error: showError
                });
        }
        // Afficher les ventes par client
        function showCodes() {
        // On fait un appel AJAX pour chercher les codes
        $.ajax({
            url: "allProduit",
            dataType: "json",
            error: showError,
            success: // La fonction qui traite les résultats
                    function (result) {
                        console.log(result);
                        var chartData = [];
                        var h = {};
                        // Le code source du template est dans la page
                        var template = $('#codesTemplate2').html();
                        for(var client in result.records) {
                        chartData.push(result.records[client]);

                    }
                        h.records=chartData;


                        var processedTemplate = Mustache.to_html(template, h);
                        // On combine le template avec le résultat de la requête
                        $('#piechart').html(processedTemplate);


                    }
            });
        }

    function ModifProduct(id) {
        var cost = $('#Cost-'+id).val();
        var quantity = $('#Quantity-'+id).val();
        var markup = $('#Markup-'+id).val();
        var description = $('#Description-'+id).val();
        console.log(cost);


        $.ajax({
            url: "modifProducts",
            data: {"ID": id, "Cost" : cost, "Quantity" : quantity , "Markup" : markup, "Description" : description},
            dataType: "json",
            success: // La fonction qui traite les résultats
                    function (result) {
                        $('#message').html(result.message);
                        showCodes();
                        console.log(result);
                    },
            error: showError
        });
        return false;
    }

    function deleteProduct(code) {
    $.ajax({
        url: "deleteProduct",
        data: {"code": code},
        dataType: "json",
        success: 
                function (result) {
                    $('#message').html(result.message);
                    showCodes();
                },
        error: showError
    });
    return false;
    }

    function addProduct() {
        $.ajax({
            url: "AddProduct",
            data: $("#ajouter").serialize(),
            // serialize() renvoie tous les paramètres saisis dans le formulaire
            dataType: "json",
            success: // La fonction qui traite les résultats
                    function (result) {
                        $('#message').html(result.message);
                        showCodes();
                        console.log(result.message);
                    },
            error: showError
        });
        return false;
    }


            // Fonction qui traite les erreurs de la requête
    function showError(xhr, status, message) {
            alert("Erreur: " + status + " : " + message);
    }

    function ChoixChart(){
        var radios = document.getElementsByName('g');
        var valeur;
        for(var i = 0; i < radios.length; i++){
            if(radios[i].checked){
               valeur = i;
            }
        }
        
        switch(valeur){
            case 0: doAjax();break;
            case 1: doGeoAjax();break;
            case 2: doClientAjax();break;
        }
    }

    function afficherGraphiques(){
        $('#message').empty();
        $('#graphique').show();
        $('#table').hide();
        $('#piechart').empty();
    }

    function afficherProduits(){
        $('#message').empty();
        $('#graphique').hide();
        $('#table').show();
        $('#piechart').empty();
        showCodes();
    }

    function disconnect(){
        $.ajax({
            data: {"action": "deconnexion"},
            success: function(){
                        window.location.href = "LoginController";
                        console.log("Déconnexion...");
                    }
        });

        return false;
    }
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
        <fieldset id="graphique" title="Graphiques" style="color:white;font-family:Arial;">
        <legend>Graphiques de chiffre d'affaires</legend>
        <div>
            <label><input name="g" type="radio" onclick="doAjax()"/>Par Produit</label>
            <br/>
            <label><input name="g" type="radio" onclick="doGeoAjax()"/>Par Zone Géographique</label>
            <br/>
            <label><input name="g" type="radio" onclick="doClientAjax()"/>Par Client</label>
        </div>
        <br/>
        <div>
            <form id='codeForm' style="text-align:center;">
                <label for="start">Date debut :<input name="dateDebut" type="date" id="start"></label>
                <label for="fin">Date fin :<input name="dateFin" type="date" id="fin"></label>
                <button type="button" onclick="ChoixChart()" >Valider</button>
            </form>

            <script>
            var today = new Date();
            var formattedToday = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
            $('#start').val(formattedToday);
            $('#fin').val(formattedToday);
            $('#graphique').hide();
            </script>
        </div>
    </fieldset>

  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
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

        <form>
            <input type="submit" name="action" value="Créer Nouveau Produit" class="btn btn-primary"> 
        </form>

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
       </br>
    </p>

    </body>
</html>
