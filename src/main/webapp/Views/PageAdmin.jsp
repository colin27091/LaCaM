<%-- 
    Document   : PageAdmin
    Created on : 27 nov. 2018, 16:19:21
    Author     : leolo
--%>

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
        
        function addData() {
            
            var produit = document.getElementById("nomProd").innerHTML;
            var L = [];
        }

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
    }
      </script>
    </head>

    <body>
        <h1>Macal</h1>
        
    
	<h2>Gérer Produits</h2>
            <label id="nomProd">Nom du produit que vous voulez ajouter, modifier ou supprimer : <input name="mdp"></label>
            <input type="hidden" name="action" value="create">
            <input type="submit" value="Valider">
        
	<h3>Statistiques</h3>
        
            <input type="hidden" name="action" value="create">
            <input type="submit" value="Afficher" onClick="AfficherMasquer()">
            <div id="piechart" style="width: 900px; height: 500px; display: none;"></div>
        

        
        
    

    </body>
</html>
