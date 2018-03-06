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
        String path = "WEB-INF" + File.separatorChar + "WebProducts.txt";  
        File file = new File(path);
        try {
            productService = new FileReaderProductService(file);
        } catch (IOException ex) {
            productService = null;
        }
        if(productService != null){
            productList = productService.getAllProducts();
        }
    }
    
    ////////////////////////////////////////
    // ------ INTERACTABLE METHODS ------ //
    ////////////////////////////////////////
    
    public final String displayAllProducts(){
        productList = productService.getAllProducts();
        listHeader = "All Products";
        return "product-list.xhtml";
    }
    
    ////////////////////////////////////////
    // --------- SETTER METHODS --------- //
    ////////////////////////////////////////
    
    public final void setProductService(ProductService productService) throws IllegalArgumentException {
        if (productService == null) {
            throw new IllegalArgumentException("productService May Not Be Null");
        }
        this.productService = productService;
    }

    public final void setProduct(Product product) throws IllegalArgumentException {
        if (product == null) {
            throw new IllegalArgumentException("product May Not Be Null");
        }
        this.product = product;
    }

    public final void setProductList(List<Product> productList) throws IllegalArgumentException {
        if (productList == null) {
            throw new IllegalArgumentException("productList May Not Be Null");
        }
        this.productList = productList;
    }
    
    ////////////////////////////////////////
    // --------- GETTER METHODS --------- //
    ////////////////////////////////////////

    public final ProductService getProductService() {
        return productService;
    }

    public final Product getProduct() {
        return product;
    }

    public final List<Product> getProductList() {
        return productList;
    }   

    public final String getListHeader() {
        return listHeader;
    }
}
