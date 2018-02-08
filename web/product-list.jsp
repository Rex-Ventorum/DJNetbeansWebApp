<%-- 
    Document   : product-list
    Created on : Feb 7, 2018, 9:48:10 PM
    Author     : Brandon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Shopstuff Web Portal</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Bootstrap core and CSS Links -->
        <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <link href="css/main.css" rel="stylesheet"/>
        <link href="css/products.css" rel="stylesheet"/>
    </head>
    <body>
        <nav class="navbar navbar-default navbar-fixed-top">
            <h1> Shopstuff Inc </h1>

            <ul class="nav navbar-nav">
                <li><a href="index.html">Home</a></li>
                <li><a href="#">Products</a></li>
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
            <h2> All Shopstuff Products </h2>
            <div class="media">
                <a href="product-description.html" class="list-group-item">
                    <div class="media-left media-middle">
                        <img class="media-object" src="images/unknownItem.png" height="125" width="125" alt="Image Picture">
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">Item heading</h4>
                        Price: amount <br> In Stock: no
                    </div>
                </a>
            </div>
            <div class="media">
                <a href="product-description.html" class="list-group-item">
                    <div class="media-left media-middle">
                        <img class="media-object" src="images/unknownItem.png" height="125" width="125" alt="Image Picture">
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">Item heading</h4>
                        Price: amount <br> In Stock: no
                    </div>
                </a>
            </div>
            <div class="media">
                <a href="product-description.html" class="list-group-item">
                    <div class="media-left media-middle">
                        <img class="media-object" src="images/unknownItem.png" height="125" width="125" alt="Image Picture">
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">Item heading</h4>
                        <p>Price: amount <br> In Stock: no</p>
                    </div>
                </a>
            </div>

            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>

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
