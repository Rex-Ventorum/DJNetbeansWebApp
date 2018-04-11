package Model.beans;

import Model.Services.DatabaseProductService;
import Model.Pojos.Product;
import Model.Services.ProductService;
import Model.Services.SpringProductService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "productBean")
@Scope("session")
public class ProductBean implements Serializable {

    private ProductService productService;
    private String searchParam;
    private Product product;
    private String listHeader;
    private List<Product> productList;

    ////////////////////////////////////////
    // ---------- CONSTRUCTORS ---------- //
    ////////////////////////////////////////
    @Autowired
    public ProductBean(ProductService productService){
        this.productService = productService;
    }
    
    public ProductBean() {
//        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
//        String path = servletContext.getRealPath("WEB-INF" + File.separatorChar + "WebProducts.txt");
//        File file = new File(path);
//        try {
//            productService = new FileReaderProductService(file);
//        } catch (IOException ex) {
//            productService = null;
//        }
        productService = new SpringProductService();
        if (productService != null) {
            productList = productService.getAllProducts();
            listHeader = "All Products";
        }
    }

    ////////////////////////////////////////
    // ------ INTERACTABLE METHODS ------ //
    ////////////////////////////////////////
    public String displayProductDescription(String id) {
        product = productService.findProduct(id);
        return "product-description.xhtml";
    }

    public String displayAllProducts() {
        productList = productService.getAllProducts();
        listHeader = "All Products";
        return "product-list.xhtml";
    }

    public String displayProductSearch() {
            if(searchParam == null || searchParam.isEmpty()) return displayAllProducts();
            productList = productService.searchProducts(searchParam);
            listHeader = "Search Results For: " + searchParam;
            return "product-list.xhtml";
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

    public void setSearchParam(String searchParam) {
        this.searchParam = searchParam;
    }

    ////////////////////////////////////////
    // --------- GETTER METHODS --------- //
    ////////////////////////////////////////
    public String getSearchParam() {
        return searchParam;
    }
    
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
