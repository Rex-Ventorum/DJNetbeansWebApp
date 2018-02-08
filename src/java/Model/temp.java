package Model;

import Model.FileService.StringLineFileService;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Brandon
 */
public class temp {
  
    public static void main(String[] args) throws IOException {
        File file = new File("web" + File.separatorChar + "WEB-INF" + File.separatorChar + "WebProducts.txt");
        StringLineFileService service = new StringLineFileService(file, new ProductStringLineFileFormatter());
        List<Product> list = service.readFromFile();
        for(Product p : list){
            System.out.println(p.getProductId() + ": "  + p.getProductName());
        }
    }
}
