/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Services;

import Model.Pojos.IProductDAO;
import Model.Pojos.Product;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;
import org.springframework.stereotype.Service;

/**
 *
 * @author L117student
 */
@Service
@Transactional
public class SpringProductService implements ProductService{

    @Autowired
    private IProductDAO productDao;
    
    @Override
    public Product findProduct(String productId) {
        return productDao.findOne(productId);
    }

    @Override
    public List<Product> searchProducts(String searchParam) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("productName", startsWith().ignoreCase());
        Product product = new Product();
        product.setProductName(searchParam);
        return productDao.findAll(Example.of(product,matcher));
    }

    @Override
    public List<Product> getAllProducts() {
       return productDao.findAll();
    }
}
