<%-- 
    Document   : product-list
    Created on : Feb 7, 2018, 9:48:10 PM
    Author     : Brandon
--%>

<%@page import="Model.Product"%>
<%@page import="java.util.List"%>
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
                    <li><a href="index.html">Home</a></li>
                    <li><a href="products.html">Products</a></li>
                    <li><a href="shopping-cart.html">Shopping Cart</a></li>
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
            <h2> All Shopstuff Products </h2>

            <!-- START OF PRODUCT LIST -->            
            <div class="productList">
                <%
                    List<Product> productList = (List<Product>) request.getAttribute("productList");
                    for (Product product : productList) {
                %>
                <div class="media">
                    <a href="?id=<%= product.getProductId()%>" class="list-group-item">
                        <div class="media-left media-middle">
                            <img class="media-object" src="Images/<%= product.getImageURL() %>" height="125" width="125" alt="Picture of "<%= product.getProductName()%>>
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading"><%= product.getProductName()%></h4>
                            Price: $<%= product.getUnitPrice() %> <br> In Stock: yes
                        </div>
                    </a>
                </div>
                <% } %>
            </div> 
            <!-- END OF PRODUCT LIST -->

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
