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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nouveau Client</h1>
                <form method="POST">
		<label>Prénom : <input name="prenom"></label>
                <label>Adresse : <input name="adresse"></label>
		<label>Complément d'adresse : <input name="complement"></label>
                <label>Ville : <input name="ville"></label>
                <label>Etat : <input name="etat"></label>
                <label>Téléphone : <input name="telephone"></label>
                <label>Fax : <input name="fax"></label>
                <label>Email : <input name="email"></label>
                <input name="action" value="Valider" type="SUBMIT">
    </body>
</html>
