<%-- 
    Document   : shopping-cart
    Created on : Feb 7, 2018, 9:49:28 PM
    Author     : Brandon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Shopstuff Web Portal</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Bootstrap core and CSS Links -->
        <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <link href="css/main.css" rel="stylesheet"/>
        <link href="css/shopping-cart.css" rel="stylesheet"/>

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
                    <li class="current"><a href="javascript:;">Shopping Cart</a></li>
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
            <!-- PAYMENT INFO FORM -->
            <form>
                <div class="form-group">
                    <label class="sr-only" for="exampleInputAmount">Street Address</label>
                    <div class="input-group">
                        <div class="input-group-addon">Address</div>
                        <input type="text" class="form-control" id="exampleInputAmount" placeholder="123 Example Address Rd">
                    </div>
                </div>
                <div class="form-group">
                    <label class="sr-only" for="exampleInputAmount">City</label>
                    <div class="input-group">
                        <div class="input-group-addon">City</div>
                        <input type="text" class="form-control" id="exampleInputAmount" placeholder="City">
                    </div>
                </div>
                <div class="form-group">
                    <label class="sr-only" for="exampleInputAmount">State</label>
                    <div class="input-group">
                        <div class="input-group-addon">State</div>
                        <input type="text" class="form-control" id="exampleInputAmount" placeholder="State">
                    </div>
                </div>
                <div class="form-group">
                    <label class="sr-only" for="exampleInputAmount">Zip</label>
                    <div class="input-group">
                        <div class="input-group-addon">Zip</div>
                        <input type="text" class="form-control" id="exampleInputAmount" placeholder="Zip">
                    </div>
                </div>
                <input class="btn" type="submit" value="Complete Prurchase">
            </form>

            <!-- CART ITEM LIST -->
            <ul class="list-group">
                <li class="list-group-item">
                    <span class="badge">x1</span>
                    <span class="badge">$0.00</span>
                    <img class="media-object" src="images/unknownItem.png" height="75" width="75" alt="Image Picture">
                    <h4 class="media-heading">Item Heading</h4>
                    <input type="button" value="Remove">
                </li>
                <li class="list-group-item">
                    <span class="badge">x1</span>
                    <span class="badge">$0.00</span>
                    <img class="media-object" src="images/unknownItem.png" height="75" width="75" alt="Image Picture">
                    <h4 class="media-heading">Item Heading</h4>
                    <input type="button" value="Remove">
                </li>
                <li class="list-group-item">
                    <span class="badge">x1</span>
                    <span class="badge">$0.00</span>
                    <img class="media-object" src="images/unknownItem.png" height="75" width="75" alt="Image Picture">
                    <h4 class="media-heading">Item Heading</h4>
                    <input type="button" value="Remove">
                </li>
                <li class="list-group-item">
                    <span class="badge">x1</span>
                    <span class="badge">$0.00</span>
                    <img class="media-object" src="images/unknownItem.png" height="75" width="75" alt="Image Picture">
                    <h4 class="media-heading">Item Heading</h4>
                    <input type="button" value="Remove">
                </li>
                <li class="list-group-item">
                    <span class="badge">x1</span>
                    <span class="badge">$0.00</span>
                    <img class="media-object" src="images/unknownItem.png" height="75" width="75" alt="Image Picture">
                    <h4 class="media-heading">Item Heading</h4>
                    <input type="button" value="Remove">
                </li>
                <li class="list-group-item">
                    <span class="badge">x1</span>
                    <span class="badge">$0.00</span>
                    <img class="media-object" src="images/unknownItem.png" height="75" width="75" alt="Image Picture">
                    <h4 class="media-heading">Item Heading</h4>
                    <input type="button" value="Remove">
                </li>
                <li class="list-group-item">
                    <span class="badge">x1</span>
                    <span class="badge">$0.00</span>
                    <img class="media-object" src="images/unknownItem.png" height="75" width="75" alt="Image Picture">
                    <h4 class="media-heading">Item Heading</h4>
                    <input type="button" value="Remove">
                </li>
            </ul>

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
