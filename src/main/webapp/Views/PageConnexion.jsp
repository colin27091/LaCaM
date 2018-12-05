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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/PagesCss.css" media="screen" />
        <title>MaCaL</title>

    </head>
    <body style="background-color: gray">
        <h1 style="text-align: center">Bienvenue sur MaCaL !</h1>
        <div style="position: relative; left: 75%; transform: translate(-50%, 20%) ">
            <form  class="container">
            <div class="form-group" >
                <div class="form-group col-md-4">
                <label for="InputEmai1">Email</label>
                <input name="email" class="form-control" placeholder="Entrer email">
                </div>
            </div>
            <div class="form-group">
                <div class="form-group col-md-4">
                <label for="InputPassword">Mot de Passe</label>
                <input name="mdp" class="form-control"  placeholder="Mot de Passe">
                </div>
            </div>
            <div class="form-group">
                <div class="form-group col-md-4">
                <input type="submit" name="action" value="Se connecter" class="btn btn-primary btn-lg btn-block">
                <input type="submit" name="action" value="Creer un compte" class="btn btn-secondary btn-lg btn-block">
                </div>
            </div>
            <div>${error_message}</div>
        </form>
        </div>

    </body>
</html>