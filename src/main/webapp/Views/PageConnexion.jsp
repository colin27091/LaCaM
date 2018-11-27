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
        <h1>Hello World!</h1>
                <form method="POST">
		<label>Email : <input name="email"></label>
                <label>Mot de passe : <input name="mdp"></label>
		<input name="action1" value="Connexion" type="SUBMIT">
                <input name="action2" value="Créer un compte" type="SUBMIT">
	</form>
    </body>
</html>
