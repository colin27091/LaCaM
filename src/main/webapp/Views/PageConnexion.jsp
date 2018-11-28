<%-- 
    Document   : PageConnexion
    Created on : 27 nov. 2018, 16:18:38
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
        <h1>Bienvenue sur MaCaL !</h1>
                <form method="POST" name="log">
		<label>Email : <input name="email"></label>
                </br>
                </br>
                <label>Mot de passe : <input name="mdp"></label>
                </br>
		<input name="connexion" value="Connexion" type="SUBMIT">
                <input name="creation" value="Créer un compte" type="SUBMIT">
	</form>
    </body>
</html>
