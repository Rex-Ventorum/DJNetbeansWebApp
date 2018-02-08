/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.FileService.FileReaderProductService;
import Model.Product;
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
public class ProductController extends HttpServlet {

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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = null;

        String id = request.getParameter("id");
        String search = request.getParameter("searchParam");
        if (id != null) {
            Product product = productService.findProduct(id);
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("/product-description.jsp");
        } else if (search != null) {
            List<Product> productList;
            if(search.toLowerCase().equals("all")){
                productList = productService.getAllProducts();
            }else{
                productList = productService.searchProducts(search);
            }
            request.setAttribute("productList", productList);
            dispatcher = request.getRequestDispatcher("/product-list.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/index.jsp");
        }
        dispatcher.forward(request, response);
        
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
