<%-- 
    Document   : PageGererProfil
    Created on : 27 nov. 2018, 16:22:28
    Author     : Mofid Krim
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.tables.Customer"%>
<%Customer customer = (Customer) request.getAttribute( "customer" ); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Gérer Profil</title>
    </head>  
     <body style="background-color: gray">
        <h1 style="text-align: center">Gérer les informations du compte</h1>
        </br>
        </br>
        <form class="container">
            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="inputID">ID</label>
                    <input  name="customer_id"  class="form-control"  value=${customer.getCustomer_id()}>
                </div>
                <div class="form-group col-md-4">
                    <label for="inputPrenom">Prénom</label>
                    <input name="name"  class="form-control" value=${customer.getName()}>
                    <p><%=customer.getName()%></p>
                </div>
            </div>
            <div class="form-group">
                    <label for="inputAdresse">Adresse</label>
                    <input name="addressline1"  class="form-control" value=${customer.getAddressline1()}>
            </div>
            <div class="form-group">
                    <label for="inputAddresse2">Complément d'adresse</label>
                    <input name="addressline2"   class="form-control"  value=${customer.getAddressline2()}>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputCity">Ville</label>
                    <input name="city" class="form-control" value=${customer.getCity()}>
                </div>
                <div class="form-group col-md-4">
                    <label for="inputzip">Code Postal</label>
                        <select name="ZIP" class="form-control" >
                            <option value="cusomer_zip">${customer.getZip()}</option>
                            <c:forEach var="code" items="${codes}">
                                <option value=${code}>${code}</option>
                            </c:forEach>
                        </select>
                </div>
                <div class="form-group col-md-2">
                    <label for="inputEtat">Etat</label>
                    <input name="state" class="form-control" value=${customer.getState()}>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="inputPhone">Téléphone</label>
                    <input  name="phone" class="form-control" value=${customer.getPhone()}>
                </div>
                <div class="form-group col-md-2">
                    <label for="inputFAX">FAX</label>
                    <input name="fax" class="form-control" value=${customer.getFax()}>
                </div>
                <div class="form-group col-md-4">
                    <label for="inputEmail">Email</label>
                    <input name="email"  class="form-control" value=${customer.getEmail()}>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="inputClimit">Limite de crédit</label>
                    <input name="credit_limit" class="form-control" value=${customer.getCredit_limit()}>
                </div>
                <div class="form-group col-md-2">
                    <label for="inputDcode">Code Promo</label>
                    <input name="discount_code" class="form-control" value=${customer.getDiscount_code()}>
                </div>
            </div>
            <div>
                <input type="submit" name="action" value="Valider les modifications" class="btn btn-primary"/>
                <input type="submit" name="action" value="Annuler les modifications" class="btn btn-primary"/>
            </div>
                
                    <p>${error}</p>
        </form>
                
        <p style="color: red;text-align: center">${error}</p>
        
    </body>   

</html>
