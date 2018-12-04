<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                <label>ID* : <input name="customer_id" value=${customer_id}></label>
                </br>
                </br>
		<label>Prénom* : <input name="name" value=${name}></label>
                </br>
                </br>
                <label>Adresse : <input name="addressline1" value=${addressline1}></label>
                </br>
                </br>
		<label>Complément d'adresse : <input name="addressline2" value=${addressline2}></label>
                </br>
                </br>
                <label>Ville : <input name="city" value=${city}></label>
                </br>
                </br>
                <label>Code postal* : <select name="zip">
                    <c:forEach var="code" items="${codes}">
                        <option value=${code}>${code}</option>
                    </c:forEach>
                    
                </select>
                </label>
                </br>
                </br>
                <label>Etat : <input name="state" value=${state}></label>
                </br>
                </br>
                <label>Téléphone : <input name="phone" value=${phone}></label>
                </br>
                </br>
                <label>Fax : <input name="fax" value=${fax}></label>
                </br>
                </br>
                <label>Email* : <input name="email" value=${email}></label>
                </br>
                </br>
                <label>Limite de crédit : <input name="credit_limit" value=${credit_limit}></label>
                </br>
                </br>
                <label>Code promo : <input name="discount_code" value=${discount_code}></label>
                </br>
                </br>
		<input type="submit" name="action" value="Valider"/>
		<input type="submit" name="action" value="Annuler"/>
                <p>${error}</p>
            </form>
    </body>
</html>
