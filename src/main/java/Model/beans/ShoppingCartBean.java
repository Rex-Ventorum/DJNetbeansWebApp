package Model.beans;

import Model.Pojos.Product;
import Model.Pojos.ShoppingCart;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedProperty;
import javax.swing.JOptionPane;

@Named(value = "cartBean")
@SessionScoped
public class ShoppingCartBean implements Serializable {
   
    private int qnt;
    private ShoppingCart shoppingCart;
    
    ////////////////////////////////////////
    // ---------- CONSTRUCTORS ---------- //
    ////////////////////////////////////////
    
    public ShoppingCartBean() {
        shoppingCart = new ShoppingCart();
    }
    
    ////////////////////////////////////////
    // ------ INTERACTABLE METHODS ------ //
    ////////////////////////////////////////
    
    public String displayShoppingCart(){
        qnt = 0;
        return "shopping-cart.xhtml";
    }
    
    public String addToCart(Product product){
        shoppingCart.editCartItem(product, qnt);
        return "shopping-cart.xhtml";
    }
    
    public String removeFromCart(Product product){
        shoppingCart.removeFromCart(product);
        return "shopping-cart.xhtml";
    }
    
    ////////////////////////////////////////
    // --------- SETTER METHODS --------- //
    ////////////////////////////////////////
    
    public void setShoppingCart(ShoppingCart shoppingCart) throws IllegalArgumentException {
        if (shoppingCart == null) {
            throw new IllegalArgumentException("shoppingCart May Not Be Null");
        }
        this.shoppingCart = shoppingCart;
    }

    public void setQnt(int qnt) throws IllegalArgumentException {
        if (qnt < 0) {
            throw new IllegalArgumentException("qnt May Not Be Negative");
        }
        this.qnt = qnt;
    }
        
    ////////////////////////////////////////
    // --------- GETTER METHODS --------- //
    ////////////////////////////////////////
    
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public int getQnt() {
        return qnt;
    }
    
    ////////////////////////////////////////
    // ----- PRIVATE HELPER METHODS ----- //
    ////////////////////////////////////////
    
    ////////////////////////////////////////
    // --------- OTHER METHOID ---------- //
    ////////////////////////////////////////

    

    

    

    

    
}
