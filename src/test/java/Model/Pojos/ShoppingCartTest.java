/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Pojos;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Programming
 */
public class ShoppingCartTest {

    private static final Product dummyProduct = new Product("001", "DUMMY ITEM", .01, "None.png", "This Is A Dummy Item", "This Is A Dummy Item");
    private static final Product keepMeProduct = new Product("002", "DUMMY ITEM 2", .01, "None.png", "This Is A Dummy Item", "This Is A Dummy Item");
    private ShoppingCart instance;

    public ShoppingCartTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
        instance = new ShoppingCart();
    }

    @After
    public void tearDown() {
        instance = null;
    }

    @Test
    public void addProductRejectsNullProduct() {
        try {
            instance.addProduct(null);
            fail();
        } catch (IllegalArgumentException e) {
            //Do Nothing This Is What We Want!
        }

        try {
            instance.addProduct(null, 1);
            fail();
        } catch (IllegalArgumentException e) {
            //Do Nothing This Is What We Want!
        }
    }

    @Test
    public void addProductRejectsQuntatiesLessThanOne() {
        int[] testValues = {0, -1, -100, -1000};
        for (int value : testValues) {
            try {
                instance.addProduct(dummyProduct, value);
                fail();
            } catch (IllegalArgumentException e) {
                //Do Nothing This Is What We want!
            }
        }//end of test loop
    }
    
   @Test 
   public void addProductAcceptsValidProductAndQuntaties(){
       instance.addProduct(dummyProduct);
       instance.addProduct(keepMeProduct,5);
   }
    
    @Test
    public void addProductNoQuantityAddsOneCartItem() {
        int listSizeBefore = instance.getItemList().size();
        instance.addProduct(dummyProduct);
        int listSizeAfter = instance.getItemList().size();
        assertEquals(listSizeBefore+1,listSizeAfter);
    }
    
    @Test
    public void addProductWithQuantityAddsOneCartItem() {
        int listSizeBefore = instance.getItemList().size();
        instance.addProduct(dummyProduct,5);
        int listSizeAfter = instance.getItemList().size();
        assertEquals(listSizeBefore+1,listSizeAfter);
    }
    
    @Test
    public void addProductWithSameProductIncreasesQuanityNotList() {
        int listSizeBefore = instance.getItemList().size();
        instance.addProduct(dummyProduct);
        instance.addProduct(dummyProduct);
        instance.addProduct(dummyProduct,5);
        int listSizeAfter = instance.getItemList().size();
        int cartItemQnt = instance.getCartItemFor(dummyProduct).getQuantity();
        int expectedCartItemQnt = 7;
        assertEquals(listSizeBefore+1,listSizeAfter);
        assertEquals(cartItemQnt,expectedCartItemQnt);
    }
    
    // ----- REMOVE PRODUCT TESTS ----- //
    
    //Helper (assumes addProduct Is Bug Free)
    public void stageCartWithItems(){
        instance.addProduct(dummyProduct,100);
        instance.addProduct(keepMeProduct,100);
    }
    
    @Test
    public void removeProductRejectsNullProduct() {
        try {
            instance.removeProduct(null);
            fail();
        } catch (IllegalArgumentException e) {
            //Do Nothing This Is What We Want!
        }

        try {
            instance.removeProduct(null, 1);
            fail();
        } catch (IllegalArgumentException e) {
            //Do Nothing This Is What We Want!
        }
    }

    @Test
    public void removeProductRejectsQuntatiesLessThanOne() {
        int[] testValues = {0, -1, -100, -1000};
        for (int value : testValues) {
            try {
                instance.removeProduct(dummyProduct, value);
                fail();
            } catch (IllegalArgumentException e) {
                //Do Nothing This Is What We want!
            }
        }//end of test loop
    }
    
    @Test
    public void removeProductNoQntCompletyRemovesParamProductOnly() {
        stageCartWithItems();
        instance.removeProduct(dummyProduct);
        assertTrue(instance.getCartItemFor(dummyProduct) == null);
        assertTrue(instance.getCartItemFor(keepMeProduct) != null);
    }
    
    @Test
    public void removeProductWithQntDeductsParamProductQntOnly(){
        stageCartWithItems();
        instance.removeProduct(dummyProduct,25);
        CartItem dummyCart = instance.getCartItemFor(dummyProduct);
        CartItem keepCart = instance.getCartItemFor(keepMeProduct);
        int expectedDummyItems = 75;
        int expectedKeepMeItems = 100;
        assertEquals(expectedDummyItems,dummyCart.getQuantity());
        assertEquals(expectedKeepMeItems,keepCart.getQuantity());
    }
 
    @Test
    public void removeProductWithoutAddingProductDoesNothing(){
        int listSizeBefore = instance.getItemList().size();
        instance.removeProduct(dummyProduct);
        instance.removeProduct(dummyProduct,5);
        int listSizeAfter = instance.getItemList().size();
        assertEquals(listSizeBefore,listSizeAfter);
    }
    
    // ----- CONTAINS PRODUCT TEST ----- //
    
    @Test 
    public void containsProductReturnsTrueWhenProductAdded(){
        instance.addProduct(dummyProduct);
        assertTrue(instance.containsProduct(dummyProduct));
        assertTrue(instance.containsProduct(dummyProduct.getProductId()));
    }
    
    @Test
    public void containsProductReturnsFalseWhenProductNotAdded(){
        assertFalse(instance.containsProduct(dummyProduct));
        assertFalse(instance.containsProduct(dummyProduct.getProductId()));
    }
    
    @Test
    public void containsProductReturnsFalseWhenProductAddedAndRemoved(){
        instance.addProduct(dummyProduct);
        instance.removeProduct(dummyProduct);
        assertFalse(instance.containsProduct(dummyProduct));
        assertFalse(instance.containsProduct(dummyProduct.getProductId()));
        
        instance.addProduct(dummyProduct,50);
        instance.removeProduct(dummyProduct,50);
        assertFalse(instance.containsProduct(dummyProduct));
        assertFalse(instance.containsProduct(dummyProduct.getProductId()));
    }
}
