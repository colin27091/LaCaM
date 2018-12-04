<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/PagesCss.css" media="screen" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>MaCaL</title>
    </head>
    <body style="background-color: gray">
        <h1 style="text-align: center">Création de compte</h1>
        </br>
        </br>
        <form class="container">
            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="inputID">ID</label>
                    <input  name="customer_id"  class="form-control" id="inputID" placeholder="ID" value=${customer_id}>
                </div>
                <div class="form-group col-md-4">
                    <label for="inputPrenom">Prénom</label>
                    <input name="name"  class="form-control" id="inputPrenom" placeholder="Prénom" value=${name}>
                </div>
            </div>
            <div class="form-group">
                    <label for="inputAdresse">Adresse</label>
                    <input name="addressline1"  class="form-control" id="inputAdresse" placeholder="106 rue des prats issou" value=${addressline1}>
            </div>
            <div class="form-group">
                    <label for="inputAddresse2">Complément d'adresse</label>
                    <input name="addressline2"   class="form-control" id="inputAdresse2" placeholder="Appartement, maison, cave à vin" value=${addressline2}>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputCity">Ville</label>
                    <input name="city" class="form-control" id="inputCity" placeholder="Ouarzazate" value=${city}>
                </div>
                <div class="form-group col-md-4">
                    <label for="inputzip">Code Postal</label>
                        <select name="ZIP"  id="inputVille" class="form-control" >
                            <c:forEach var="code" items="${codes}">
                                <option value=${code}>${code}</option>
                            </c:forEach>
                        </select>
                </div>
                <div class="form-group col-md-2">
                    <label for="inputEtat">Etat</label>
                    <input name="state" class="form-control" id="inputEtat" placeholder="Cambodge" value=${state}>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="inputPhone">Téléphone</label>
                    <input  name="phone" class="form-control" id="inputPhone" placeholder="06.01.02.03.04" value=${phone}>
                </div>
                <div class="form-group col-md-2">
                    <label for="inputFAX">FAX</label>
                    <input name="fax" class="form-control" id="inputFAX" placeholder="03.88.92.07.01" value=${fax}>
                </div>
                <div class="form-group col-md-4">
                    <label for="inputEmail">Email</label>
                    <input name="email"  class="form-control" id="inputEmail" placeholder="montaut.thierry@yahoo.fr" value=${email}>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="inputClimit">Limite de crédit</label>
                    <input name="credit_limit" class="form-control" id="inputClimit" value=${credit_limit}>
                </div>
                <div class="form-group col-md-2">
                    <label for="inputDcode">Code Promo</label>
                    <input name="discount_code" class="form-control" id="inputDcode" value=${discount_code}>
                </div>
            </div>
            <div>
                <input type="submit" name="action" value="Valider" class="btn btn-primary"/>
                <input type="submit" name="action" value="Annuler" class="btn btn-primary"/>
            </div>
        </form>
                
        <p>${error}</p>
        
    </body>
</html>
