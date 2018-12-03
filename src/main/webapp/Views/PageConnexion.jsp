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
        <link rel="stylesheet" type="text/css" href="css/PagesCss.css" media="screen" />
        <title>MaCaL</title>

    </head>
    <body>
        <h1>Bienvenue sur MaCaL !</h1>
            <form method="POST" name="log">
		<label>Email : <input name="email"></label>
                </br>
                </br>
                <label>Mot de passe : <input type="password" name="mdp"></label>
                </br>
                <input type="hidden" name="action" value="connect">
		<input type="submit" value="Se connecter">
                <input type="hidden" name="action" value="create">
                <input type="submit" value="Creer un compte">
                
                <div><h4>${error_message}</h4></div>
         
            </form>
    </body>
</html>