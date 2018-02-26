<%-- 
    Document   : product-description
    Created on : Feb 7, 2018, 9:48:45 PM
    Author     : Brandon
--%>

<%@page import="Model.Pojos.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Shopstuff Web Portal</title>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

        <!-- Bootstrap core and CSS Links -->
        <link href="css/bootstrap.css" rel="stylesheet"/>
        <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <link href="css/bootstrap-theme.min.css" rel="stylesheet"/>
        <link href="css/product-description.css" rel="stylesheet"/>
        <link href="css/main.css" rel="stylesheet"/>

    </head>
    <body>
        <nav class="navbar navbar-default navbar-fixed-top">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <h1> The Dark Brew </h1>
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#nav-content" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="nav-content">
                <ul class="nav navbar-nav">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="ProductController">Products</a></li>
                    <li><a href="ShoppingCartController">Shopping Cart</a></li>
                    <li>
                        <form class="navbar-form center-block" method="post" action="ProductController" role="search">
                            <div class="input-group">
                                <input type="text" class="form-control" name="searchParam" placeholder="Search">
                                <span class="input-group-btn">
                                      <button type="submit" class="btn btn-default" value="POST">Search</button>
                                </span>
                            </div>
                        </form>
                    </li> 
            </div>
        </nav>

        <div class="body-contnet">
            <div class="media">
                <div class="media-left media-top">
                    <img class="media-object" src="Images/<c:out value="${product.imageURL}"/>" height="300" width="300" alt="Picture of "<c:out value="${product.productName}"/>>
                </div>
                <div class="media-body">
                    <h2 class="media-heading"><c:out value="${product.productName}"/></h2>
                    <h4> <c:out value="${product.descriptionShort}"/> </h4>
                    <h4>Price: $<c:out value="${product.unitPrice}"/> <br> In Stock: Yes</h4>
                    <p> <c:out value="${product.descriptionLong}"/> </p>
                </div>
            </div>

            <div class="form">
                <form class="form-inline" method="post" action="ShoppingCartController">
                    <div class="form-group">
                        <label class="sr-only" for="exampleInputAmount">Add X Amount To Cart</label>
                        <div class="input-group">
                            <div class="input-group-addon">Buy</div>
                            <input type="hidden" name="productId" value=<c:out value="${product.productId}"/>/>
                            <input type="number" name="quantity" class="form-control" id="exampleInputAmount" placeholder="Quantity">
                            <div class="input-group-addon">For: $0.00</div>
                        </div>
                    </div>
                    <button type="submit" class="btn" value="POST">Add To Cart</button>
                </form>
            </div>
        </div>

        <footer class="footer">
            <div class="footer_contents">
                <p class="text-muted">&copy; Brandon M. Dopp 2018</p>
            </div>
        </footer>

        <!-- Bootstrap core JavaScript -->
        <!-- Should Stay At Bottom and In Body Tag -->
        <script src  ="js/jquery.min.js"></script> 
        <script src  ="js/bootstrap.min.js"></script>
    </body>
</html>
