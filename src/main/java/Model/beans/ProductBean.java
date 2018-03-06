package Model.beans;

import Model.FileReaderProductService;
import Model.Pojos.Product;
import Model.ProductService;
import java.io.File;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;


@Named(value = "productBean")
@SessionScoped
public class ProductBean implements Serializable {
    
    private ProductService productService;
    private Product product;
    private String listHeader;
    private List<Product> productList;
    
    ////////////////////////////////////////
    // ---------- CONSTRUCTORS ---------- //
    ////////////////////////////////////////
    
    public ProductBean() {
       ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String path = servletContext.getRealPath("WEB-INF" + File.separatorChar + "WebProducts.txt");  
        File file = new File(path);
        try {
            productService = new FileReaderProductService(file);
        } catch (IOException ex) {
            productService = null;
        }
        if(productService != null){
            productList = productService.getAllProducts();
            listHeader = "All Products";
        }
    }
    
    ////////////////////////////////////////
    // ------ INTERACTABLE METHODS ------ //
    ////////////////////////////////////////
    
    public String displayAllProducts(){
        productList = productService.getAllProducts();
        listHeader = "All Products";
        return "product-list.xhtml";
    }
    
    public void displayProductSearch(){
        String searchParam = (String) event.getComponent().getAttributes().get("searchParam");
        productList = productService.searchProducts(searchParam);
        listHeader = "Search Results For: " + searchParam;
    }
    
    ////////////////////////////////////////
    // --------- SETTER METHODS --------- //
    ////////////////////////////////////////
    
    public void setProductService(ProductService productService) throws IllegalArgumentException {
        if (productService == null) {
            throw new IllegalArgumentException("productService May Not Be Null");
        }
        this.productService = productService;
    }

    public void setProduct(Product product) throws IllegalArgumentException {
        if (product == null) {
            throw new IllegalArgumentException("product May Not Be Null");
        }
        this.product = product;
    }

    public void setProductList(List<Product> productList) throws IllegalArgumentException {
        if (productList == null) {
            throw new IllegalArgumentException("productList May Not Be Null");
        }
        this.productList = productList;
    }
    
    ////////////////////////////////////////
    // --------- GETTER METHODS --------- //
    ////////////////////////////////////////

    public ProductService getProductService() {
        return productService;
    }

    public Product getProduct() {
        return product;
    }

    public List<Product> getProductList() {
        return productList;
    }   

    public String getListHeader() {
        return listHeader;
    }
}
