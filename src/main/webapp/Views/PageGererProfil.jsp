<%-- 
    Document   : PageGererProfil
    Created on : 27 nov. 2018, 16:22:28
    Author     : leolo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenu sur la page de gestion de votre profil</h1>
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
                <input name="action" value="Sauvegarder" type="SUBMIT">
            </form>
    </body>
</html>
