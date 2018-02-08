/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.FileService.CruptedObjectFileFormatException;
import Model.FileService.FileFormatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Brandon
 */
public final class ProductStringLineFileFormatter implements FileFormatter<Product, List<String>> {

    private static final String KEY_VALUE_SEPERATOR = " :: ";
    private static final String PRODUCT_ID_KEY = "Product Id";
    private static final String PRODUCT_NAME_KEY = "Product Name";
    private static final String UNIT_PRICE_KEY = "Unit Price";
    private static final String IMAGE_URL_KEY = "Image URL";
    private static final String DESCRIPT_SHORT_KEY = "Short Discription";
    private static final String DESCRIP_lONG_KEY = "Long Discription";

    ////////////////////////////////////////
    // ------ INTERACTABLE METHODS ------ //
    ////////////////////////////////////////
    @Override
    public List<String> toFormat(Product unformatedObject) {
        List<String> dataLines = new LinkedList<>();
        dataLines.add(PRODUCT_ID_KEY + KEY_VALUE_SEPERATOR + unformatedObject.getProductId());
        dataLines.add(PRODUCT_NAME_KEY + KEY_VALUE_SEPERATOR + unformatedObject.getProductName());
        dataLines.add(UNIT_PRICE_KEY + KEY_VALUE_SEPERATOR + unformatedObject.getUnitPrice());
        dataLines.add(IMAGE_URL_KEY + KEY_VALUE_SEPERATOR + unformatedObject.getImageURL());
        dataLines.add(DESCRIPT_SHORT_KEY + KEY_VALUE_SEPERATOR + unformatedObject.getDiscriptionShort());
        dataLines.add(DESCRIP_lONG_KEY + KEY_VALUE_SEPERATOR + unformatedObject.getDiscriptionLong());
        return dataLines;
    }

    @Override
    public Product fromFormat(List<String> dataLines) throws CruptedObjectFileFormatException {
        Product product = null;
        
        Map<String, String> tempMap = new HashMap<>();
        for (String line : dataLines) {
            String[] keyValuePair = line.split(KEY_VALUE_SEPERATOR);
            if (keyValuePair.length != 2) {
                throw new CruptedObjectFileFormatException();
            }
            tempMap.put(keyValuePair[0], keyValuePair[1]);
        }
        
        try {
            String productId = tempMap.get(PRODUCT_ID_KEY);
            String productName = tempMap.get(PRODUCT_ID_KEY);
            double unitPrice = Double.parseDouble(tempMap.get(PRODUCT_ID_KEY));
            String imageURL = tempMap.get(PRODUCT_ID_KEY) ;
            String discriptionShort = tempMap.get(PRODUCT_ID_KEY);
            String discriptionLong = tempMap.get(PRODUCT_ID_KEY);
            product = new Product(productId,productName,unitPrice,imageURL,discriptionShort,discriptionLong);
        } catch (NumberFormatException e) {
            throw new CruptedObjectFileFormatException();
        }
        return product;
    }

}
