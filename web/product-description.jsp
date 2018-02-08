<%-- 
    Document   : product-description
    Created on : Feb 7, 2018, 9:48:45 PM
    Author     : Brandon
--%>

<%@page import="Model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <h1> Shopstuff Inc </h1>

            <ul class="nav navbar-nav">
                <li><a href="index.html">Home</a></li>
                <li><a href="products.html">Products</a></li>
                <li><a href="shopping-cart.html">Shopping Cart</a></li>
                <li>
                    <form class="navbar-form navbar-right" method="post" action="ProductController" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" name="searchParam" placeholder="Search">
                            <button type="submit" class="btn btn-default" value="POST">Search</button>
                        </div>
                    </form>
                </li>
            </ul>
        </nav>

        <div class="body-contnet">
            <div class="media">
                <% Product product = (Product) request.getAttribute("product"); %>
                <div class="media-left media-top">
                    <img class="media-object" src="Images/<%= product.getImageURL() %>" height="300" width="300" alt="Picture of "<%= product.getProductName()%>>
                </div>
                <div class="media-body">
                    <h2 class="media-heading"><%= product.getProductName()%></h2>
                    <h4> <%= product.getDescriptionShort() %> </h4>
                    <h4>Price: $<%= product.getUnitPrice() %> <br> In Stock: Yes</h4>
                    <p> <%= product.getDescriptionLong() %> </p>
                </div>
            </div>

            <div class="form">
                <form class="form-inline">
                    <div class="form-group">
                        <label class="sr-only" for="exampleInputAmount">Add X Amount To Cart</label>
                        <div class="input-group">
                            <div class="input-group-addon">Buy</div>
                            <input type="number" class="form-control" id="exampleInputAmount" placeholder="Amount">
                            <div class="input-group-addon">For: $0.00</div>
                        </div>
                    </div>
                    <button type="button" class="btn">Add To Cart</button>
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
