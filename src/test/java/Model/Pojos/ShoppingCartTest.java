/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Pojos;

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
    
    private static final Product dummyProduct = new Product("001","Dummy Product",0.00,"n/a","n/a","n/a");
    private static final Product keepMeProduct = new Product("002","Keep Me Product",0.00,"n/a","n/a","n/a");
    private static final int dummyProductQnt = 100;
    private static final int keepMeProductQnt = 200;
    private ShoppingCart instance;
    
    public ShoppingCartTest() {
    }
        
    @Before
    public void setUp() {
        instance = new ShoppingCart();
    }
    
    @After
    public void tearDown() {
        instance = null;
    } 
    
    // ----- SET PRODUCT TESTS ----- //
    
    @Test (expected = IllegalArgumentException.class)
    public void setToCartRejectsNullProduct(){
        instance.setToCart(null, 1);
    }
    
    @Test
    public void setToCartRejectsQuantitesBelowOne(){
       int[] testValues = {0,-1,-100,-1000};
       for(int testValue : testValues){
           try{
               instance.setToCart(dummyProduct, testValue);
               fail();
           }catch(IllegalArgumentException e){
               //Do nothing this is what we want!
           }
       }
    }
    
    @Test
    public void setToCartAcceptsValidProductsAndQuantites(){
        int[] testQnts = {1,20,30,400,500};
        Product[] testProducts = {dummyProduct, keepMeProduct};
        for(Product testProduct : testProducts){
            for(int testQnt : testQnts){
                instance.setToCart(testProduct, testQnt);
            }
        }
    }
    
    @Test
    public void setToCartWithNewProductCreatesNewCartItem(){
        int listSizeBefore = instance.getItemList().size();
        instance.setToCart(dummyProduct, 1);
        int listSizeAfter = instance.getItemList().size();
        assertEquals(listSizeBefore+1,listSizeAfter);
        
        listSizeBefore = instance.getItemList().size();
        instance.setToCart(keepMeProduct, 1);
        listSizeAfter = instance.getItemList().size();
        assertEquals(listSizeBefore+1,listSizeAfter);
    }
    
    @Test
    public void setToCartWithExisitingProductUpdatesQuantyNOTListSize(){
        instance.setToCart(dummyProduct, 1);
        instance.setToCart(dummyProduct, 5);
        CartItem cartItem = instance.getCartItemFor(dummyProduct);
        
        int expectedQuantity = 5;
        assertEquals(cartItem.getQuantity(),expectedQuantity);
        
        int expectedListSize = 1;
        assertEquals(instance.getItemList().size(), expectedListSize);
    }
    
    // ----- REMOVE PRODUCT TESTS ----- //
    
    private void stageCart(){
        instance.setToCart(dummyProduct,dummyProductQnt);
        instance.setToCart(keepMeProduct, keepMeProductQnt);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void removeFromCartRejectsNullProduct(){
        instance.removeFromCart(null);
    }
    
    @Test
    public void removeFromCartDecreasesListSizeByOne(){
        stageCart();
        int listSizeBefore = instance.getItemList().size();
        instance.removeFromCart(dummyProduct);
        int listSizeAfter = instance.getItemList().size();
        assertEquals(listSizeBefore-1,listSizeAfter);
    }
    
    @Test
    public void removeFromCartRemovesCorrectCartItem(){
        stageCart();
        instance.removeFromCart(dummyProduct);
        CartItem dummyItem = instance.getCartItemFor(dummyProduct);
        CartItem keepItem = instance.getCartItemFor(keepMeProduct);
        assertTrue(dummyItem == null);
        assertTrue(keepItem != null);
    }
    
    // ----- GET CART ITEM TESTS ----- //
    
    @Test
    public void getCartItemReturnsNullWithNullParam(){
        assertTrue(instance.getCartItemFor(null) == null);
    }
    
    @Test
    public void getCartItemReturnsCorrectCartItem(){
        stageCart();
        CartItem cartItem = instance.getCartItemFor(dummyProduct);
        assertEquals(cartItem.getProduct(),dummyProduct);
        assertEquals(cartItem.getQuantity(),dummyProductQnt);
        
        cartItem = instance.getCartItemFor(keepMeProduct);
        assertEquals(cartItem.getProduct(),keepMeProduct);
        assertEquals(cartItem.getQuantity(),keepMeProductQnt);
    }
    
    @Test
    public void getCartItemReturnsNullWhenItemNotInCart(){
        CartItem cartItem = instance.getCartItemFor(dummyProduct);
        assertTrue(cartItem == null);
    }
}
