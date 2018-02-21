/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Pojos;

import java.util.List;

/**
 *
 * @author L117student
 */
public final class ShoppingCart {
    
    private List<CartItem> itemList;
    
    ////////////////////////////////////////
    // ---------- CONSTRUCTORS ---------- //
    ////////////////////////////////////////
    
    ////////////////////////////////////////
    // ------ INTERACTABLE METHODS ------ //
    ////////////////////////////////////////
    
    public void addProduct(Product product){addProduct(product,1);}
    public void addProduct(Product product, int quantity){
        validateProductQuantity(product,quantity);
        
        boolean itemInCart = false;
        for(CartItem cartItem : itemList){
            if(cartItem.getProduct().equals(product)){
                itemInCart = true;
                cartItem.setQuantity(cartItem.getQuantity()+quantity);
                break;
            }
        }//end of loop
        
        if(itemInCart == false){
            itemList.add(new CartItem(product,quantity));
        }
        
    }
    
    public void removeProduct(Product product){removeProduct(product,Integer.MAX_VALUE);}
    public void removeProduct(Product product, int quantity){
        validateProductQuantity(product,quantity);
        
        CartItem editMe = null;
        for(CartItem cartItem : itemList){
            if(cartItem.getProduct().equals(product)){
                editMe = cartItem; break;
            }
        }
        
        if(editMe != null){
            int oldQnt = editMe.getQuantity();
            int newQnt = oldQnt-quantity;
            if(newQnt <= 0) itemList.remove(editMe);
            else editMe.setQuantity(newQnt);
        }
    }
    
    ////////////////////////////////////////
    // --------- SETTER METHODS --------- //
    ////////////////////////////////////////
    
    public void setItemList(List<CartItem> itemList) {
        if(itemList == null) throw new IllegalArgumentException("Item List May Not Be Null");
        this.itemList = itemList;
    }
    
    ////////////////////////////////////////
    // --------- GETTER METHODS --------- //
    ////////////////////////////////////////
    
    public List<CartItem> getItemList() {
        return itemList;
    }
    
    public double getCartTotal(){
        double total = 0;
        for(CartItem cartItem : itemList){
            total += cartItem.getTotalCost();
        }
        return total;
    }
    
    ////////////////////////////////////////
    // ----- PRIVATE HELPER METHODS ----- //
    ////////////////////////////////////////
    
    private void validateProductQuantity(Product product, int quantity){
        if(product == null) throw new IllegalArgumentException("Product May Not Be Null");
        if(quantity < 1) throw new IllegalArgumentException("Quanitity Must Greater Than 0");
    }
    
    ////////////////////////////////////////
    // --------- OTHER METHOID ---------- //
    ////////////////////////////////////////


}
