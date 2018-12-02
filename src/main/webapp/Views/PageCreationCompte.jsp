<%-- 
    Document   : PageCreationCompte
    Created on : 27 nov. 2018, 16:19:01
    Author     : Mofid Krim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/PagesCss.css" media="screen" />
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenue sur la page de création de votre compte client</h1>
            <form method="POST">
		<label>Prénom : <input name="prenom"></label>
                </br>
                </br>
                <label>Adresse : <input name="adresse"></label>
                </br>
                </br>
		<label>Complément d'adresse : <input name="complement"></label>
                </br>
                </br>
                <label>Ville : <input name="ville"></label>
                </br>
                </br>
                <label>Etat : <input name="etat"></label>
                </br>
                </br>
                <label>Téléphone : <input name="telephone"></label>
                </br>
                </br>
                <label>Fax : <input name="fax"></label>
                </br>
                </br>
                <label>Email : <input name="email"></label>
                </br>
                </br>
                <input type="hidden" name="action" value="create">
		<input type="submit" value="Valider">
                <input type="hidden" name="action" value="cancel">
		<input type="submit" value="Annuler">
            </form>
    </body>
</html>
