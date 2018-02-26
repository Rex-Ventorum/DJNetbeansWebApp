/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.FileReaderProductService;
import Model.Pojos.Product;
import Model.Pojos.ShoppingCart;
import Model.ProductService;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Brandon
 */
public class ShoppingCartController extends HttpServlet {

    private ProductService productService;

    @Override
    public void init() {
        String path = getServletContext().getRealPath("WEB-INF" + File.separatorChar + "WebProducts.txt");  
        File file = new File(path);
        try {
            productService = new FileReaderProductService(file);
        } catch (IOException ex) {
            productService = null;
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = null;
        dispatcher = request.getRequestDispatcher("/shopping-cart.jsp");
        
        ShoppingCart dummyCart = new ShoppingCart();
        
        //TODO Add Error Handeling!
        String productId = request.getParameter("productId");
        Product product = productService.findProduct(productId);
        String requestType = request.getParameter("requestType");
        requestType = requestType ==null? "" : requestType;
        
        if(requestType.equals("setToCart")){
            //Add Edit Cart
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            dummyCart.editCartItem(product, quantity);
        }else if(requestType.equals("removeFromCart")){
            //Remove From Cart
            dummyCart.removeFromCart(product);
        }else{
            dummyCart.editCartItem(productService.findProduct("L704"), 5);
            dummyCart.editCartItem(productService.findProduct("P106"), 2);
            dummyCart.editCartItem(productService.findProduct("Y005"), 7);
            dummyCart.editCartItem(productService.findProduct("G514"), 1);
        }
        
        request.setAttribute("shoppingCart", dummyCart);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
