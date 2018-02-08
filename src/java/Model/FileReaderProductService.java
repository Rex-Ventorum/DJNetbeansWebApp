package Model;

import Model.FileService.FileService;
import Model.FileService.StringLineFileService;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Brandon
 */
public final class FileReaderProductService implements ProductService{

    private final Map<String,Product> productMap;
    
    ////////////////////////////////////////
    // ---------- CONSTRUCTORS ---------- //
    ////////////////////////////////////////
    
    public FileReaderProductService(File readFile) throws IOException{
        if(readFile == null) throw new IllegalArgumentException("Read File May Not Be Null");
        FileService<Product> fileService = new StringLineFileService<>(readFile,new ProductStringLineFileFormatter());
        List<Product> productList = fileService.readFromFile();
        productMap = new HashMap();
        for(Product product : productList){
            productMap.put(product.getProductId(), product);
        }
    }
    
    ////////////////////////////////////////
    // ------ INTERACTABLE METHODS ------ //
    ////////////////////////////////////////
    
    @Override
    public Product findProduct(String productId) {
        return productMap.get(productId);
    }

    @Override
    public List<Product> searchProducts(String searchParam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> getAllProducts() {
        return new LinkedList(productMap.values());
    }
   
}
