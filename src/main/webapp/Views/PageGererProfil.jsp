<%-- 
    Document   : PageGererProfil
    Created on : 27 nov. 2018, 16:22:28
    Author     : Mofid Krim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/PagesCss.css" media="screen" />
        <title>Gérer Produits</title>
    </head>
    <body>
        <h1>Bienvenue sur la page de gestion de votre profil</h1>
            <form method="POST">
		<label>Prénom : <input name="prenom" value = ${customer.getName()}></label>
                </br>
                </br>
                <label>Adresse : <input name="adresse" value = ${customer.getAddressline1()}></label>
                </br>
                </br>
		<label>Complément d'adresse : <input name="complement" value = ${customer.getAddressline2()}></label>
                </br>
                </br>
                <label>Ville : <input name="ville" value = ${customer.getCity()}></label>
                </br>
                </br>
                <label>Etat : <input name="etat" value = ${customer.getState()}></label>
                </br>
                </br>
                <label>Téléphone : <input name="telephone" value = ${customer.getPhone()}></label>
                </br>
                </br>
                <label>Fax : <input name="fax" value = ${customer.getFax()}></label>
                </br>
                </br>
                <label>Email : <input name="email" ${customer.getEmail()}></label>
                </br>
                </br>
                <input name="action" value="Sauvegarder" type="SUBMIT">
                <input name="action" value="Annuler" type="SUBMIT">
                </br>

            </form>
    </body>
</html>
