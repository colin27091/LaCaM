<%@page import="model.tables.Product"%>
<%Product product = (Product) request.getAttribute( "product" ); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>MaCaL</title>
    </head>
 <body style="background-color: gray">
        <h1 style="text-align: center">Modification d'un produit</h1>
        </br>
        </br>
        <form class="container">
            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="inputIDP">ID du produit</label>
                    <input  name="product_id"  class="form-control " placeholder="ID produit" value=${product.getProduct_id()}>
                </div>
                <div class="form-group col-md-4">
                <label for="ZIP">ID de Manufacture</label>
                        <select name="manufacturer" class="form-control" >
                            <c:forEach var="code" items="${manufacturers}">
                                <option value=${manufacturer}>${manufacturer}</option>
                            </c:forEach>
                        </select>
                </div>
                <div class="form-group col-md-2">
                    <label for="inputProd">Code du produit</label>
                    <input name="product_code"  class="form-control"  value=${product_code}>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="inputProd">Prix unitaire</label>
                    <input name="purchase_cost"  class="form-control" value=${purchase_cost}>
                </div>
                <div class="form-group col-md-2">
                    <label for="inputQuantite">Quantité</label>
                    <input name="quantity_on_hand"  class="form-control" value=${quantity_on_hand}>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="inputMarkup">Marge</label>
                    <input name="markup"  class="form-control" value=${markup}>
                </div>
                <div class="form-group col-md-2">
                    <label for="inputAvailable">Disponibilité</label>
                    <select name="ZIP" class="form-control" >
                        <option value=${available}>Oui</option>
                        <option value=${available}>Non</option>
                    </select>
                </div>               
            </div>
            <div class="form-group">
                    <label for="inputDesc">Description du Produit</label>
                    <input name="description"  class="form-control" value=${description}>
            </div>
            <div>
                <input type="submit" name="action" value="Valider les modifications" class="btn btn-primary"/>
                <input type="submit" name="action" value="Annuler les modifications" class="btn btn-primary"/>
            </div>
            </form>
        
        <p style="color: red;text-align: center">${error}</p> 
        
    </body>
</html>
