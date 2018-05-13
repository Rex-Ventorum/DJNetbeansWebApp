package DJSpringbootApp.Rest;

import DJSpringbootApp.Model.Pojos.Product;
import DJSpringbootApp.Services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    
    //GET: ~/product
    @RequestMapping(method = GET, path = "/product")
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }
    
    //GET: ~/product/{id}
    @RequestMapping(method = GET, path = "/product/{id}")
    public Product getProduct(@PathVariable String id){
        return productService.findProduct(id);
    }
    
    //POST: ~/product
    @RequestMapping(method = POST, path = "/product")
    public Product setProduct(@RequestBody Product product){
       Product p = productService.createProduct(product);
       return p;
    }
    
    //PUT: ~/product
    @RequestMapping(method = PUT, path = "/product")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }
    
    //Delete: ~/product/{id}
    @RequestMapping(method = DELETE, path = "/product/{id}")
    public void deleteProduct (@PathVariable String id){
        productService.deleteProduct(id);
    }
}
