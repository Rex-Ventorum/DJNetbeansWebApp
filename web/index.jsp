<%-- 
    Document   : index
    Created on : Feb 7, 2018, 9:45:02 PM
    Author     : Brandon
--%>

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
        <link href="css/main.css" rel="stylesheet"/>
        <link href="css/index.css" rel="stylesheet"/>

    </head>
    <body>
        <nav class="navbar navbar-default navbar-fixed-top">
            <h1> Shopstuff Inc </h1>

            <ul class="nav navbar-nav">
                <li><a href="#">Home</a></li>
                <li><a href="products.jsp">Products</a></li>
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
            <h2> Welcome! Please Use Navigation Bar To Shop Products</h2>
            <h3> or Check Out Today's Featured Item Below.</h3>
                <a href="product-description.html" class="list-group-item">
                    <div class="media-body">
                        <h4 class="media-heading">Item heading</h4>
                        Price: amount In Stock: no
                        <img class="media-object" src="images/unknownItem.png" height="300" width="300" alt="Image Picture">
                    </div>    
                </a>
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
