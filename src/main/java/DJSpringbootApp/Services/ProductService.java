package DJSpringbootApp.Services;

import DJSpringbootApp.Model.Pojos.Product;
import java.util.List;

/**
 *
 * @author Brandon
 */
public interface ProductService {
    public abstract Product findProduct(String productId);
    public abstract List<Product> searchProducts(String searchParam);
    public abstract List<Product> getAllProducts();
}
