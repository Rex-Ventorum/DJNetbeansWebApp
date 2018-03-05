/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Pojos;

import java.util.Objects;

/**
 *
 * @author L117student
 */
public final class CartItem {
  
    private Product product;
    private int quantity;
    
    ////////////////////////////////////////
    // ---------- CONSTRUCTORS ---------- //
    ////////////////////////////////////////
    
    public CartItem(Product product, int quantity) {
        setProduct(product);
        setQuantity(quantity);
    }
    
    ////////////////////////////////////////
    // ------ INTERACTABLE METHODS ------ //
    ////////////////////////////////////////
    
    public boolean idMatches(String productId){
        return product.idMatches(productId);
    }
    
    ////////////////////////////////////////
    // --------- SETTER METHODS --------- //
    ////////////////////////////////////////
    
    public void setProduct(Product product) {
        if(product == null) throw new IllegalArgumentException("Product May Not Be Null");
        this.product = product;
    }

    public void setQuantity(int quantity) {
        if(quantity < 0) throw new IllegalArgumentException("Quantity May Not Be Negitive");
        this.quantity = quantity;
    }
    
    ////////////////////////////////////////
    // --------- GETTER METHODS --------- //
    ////////////////////////////////////////
    
    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public double getTotalCost(){
        return product.getUnitPrice() * quantity;
    }
    
    ////////////////////////////////////////
    // ----- PRIVATE HELPER METHODS ----- //
    ////////////////////////////////////////
    
    ////////////////////////////////////////
    // --------- OTHER METHOID ---------- //
    ////////////////////////////////////////

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.product);
        hash = 97 * hash + this.quantity;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CartItem other = (CartItem) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        return Objects.equals(this.product, other.product);
    }    

    
}
