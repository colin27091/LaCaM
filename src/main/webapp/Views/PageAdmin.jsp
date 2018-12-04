<%-- 
    Document   : PageAdmin
    Created on : 27 nov. 2018, 16:19:21
    Author     : leolo
--%>

<%@page import="model.tables.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/PagesCss.css" media="screen" />
        <title>Espace Admin</title>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawChart);
        

        function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['Work',     11],
          ['Eat',      2],
          ['Commute',  2],
          ['Watch TV', 2],
          ['Sleep',    7]
        ]);

        var options = {
          title: 'My Daily Activities'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
      
      function AfficherMasquer(){
        divInfo = document.getElementById('piechart');
 
        if (divInfo.style.display == 'none')
            divInfo.style.display = 'block';
        else{
            divInfo.style.display = 'none';
        }
    }
      </script>
    </head>

    <body>
        <h1>Macal</h1>
        
    <ul id="menu">
        <li>Gérer Produits</li>
        <li>Clients</li>
    </ul>

    
	<h2>Statistiques</h2>
        <p>Chiffre d'affaire de MaCaL Entreprise selon  
           <select name="choixGraph" id="choix">
           <option value="zoneGeo">La zone géographique</option>
           <option value="cateArticle">La catégorie d'articles</option>
           <option value="clients">Les clients</option>      
           </select>
             de <input name="dateDebut"> à <input name="dateFin">
            <input type="hidden" name="action" value="create">
            <input type="submit" name="action" value="Valider">
        </p>
        <br></br>
            <input type="hidden" name="action" value="create">
            <input type="submit" value="Afficher" onClick="AfficherMasquer()">
            <div id="piechart" style="width: 900px; height: 500px; display: none;"></div>
            <br></br>
            <input type="hidden" name="action" value="create">
            <input type="submit" value="Se Deconnecter">
        

        
        
    

    </body>
</html>
