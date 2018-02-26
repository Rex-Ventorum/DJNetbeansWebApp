package Model.Pojos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public final class ShoppingCart {
    
    private String shoppingCartId;
    private List<CartItem> itemList;
    
    ////////////////////////////////////////
    // ---------- CONSTRUCTORS ---------- //
    ////////////////////////////////////////
    
    public ShoppingCart(){
        shoppingCartId = UUID.randomUUID().toString();
        itemList = new LinkedList();
    }
    
    ////////////////////////////////////////
    // ------ INTERACTABLE METHODS ------ //
    ////////////////////////////////////////
    
    public void setToCart(Product product, int quantity){
        if(product == null) throw new IllegalArgumentException("Product May Not Be Null");
        if(quantity < 1) throw new IllegalArgumentException("Quantity Must Be Greater Than 0");
        
        CartItem cartItem = null;
        for(CartItem existingItem : itemList){
            if(existingItem.idMatches(product.getProductId())){
                cartItem = existingItem; break;
            }
        }//end of loop
        
        if(cartItem != null){
            //If Item Exsists Update Quantity
            cartItem.setQuantity(quantity);
        }else{
            //Create New Cart Item
            itemList.add(new CartItem(product,quantity));
        }
    }
    
    public void removeFromCart(Product product){
        if(product == null) throw new IllegalArgumentException("Product May Not Be Null");
        for(Iterator<CartItem> iterator = itemList.iterator(); iterator.hasNext();){
            CartItem cartItem = iterator.next();
            if(cartItem.idMatches(product.getProductId())){
                iterator.remove(); break;
            }
        }//end of loop;
    }
    
    ////////////////////////////////////////
    // --------- SETTER METHODS --------- //
    ////////////////////////////////////////

    public void setShoppingCartId(String shoppingCartId) {
        if(shoppingCartId == null || shoppingCartId.isEmpty()) throw new IllegalArgumentException("Shopping Cart Id May Not Be Null Or Empty");
        this.shoppingCartId = shoppingCartId;
    }

    public void setItemList(List<CartItem> itemList) {
        if(itemList == null) throw new IllegalArgumentException("Item List May Not Be Null");
        this.itemList = itemList;
    }
        
    ////////////////////////////////////////
    // --------- GETTER METHODS --------- //
    ////////////////////////////////////////
    
    public CartItem getCartItemFor(Product product){
        if(product == null) return null;
        
        CartItem foundItem = null;
        for(CartItem cartItem : itemList){
            if(cartItem.idMatches(product.getProductId())){
                foundItem = cartItem; break;
            }
        }//end of loop
        
        return foundItem;
    }
    
    public String getShoppingCartId() {
        return shoppingCartId;
    }

    public List<CartItem> getItemList() {
        return itemList;
    }
    
    ////////////////////////////////////////
    // ----- PRIVATE HELPER METHODS ----- //
    ////////////////////////////////////////
    
    ////////////////////////////////////////
    // --------- OTHER METHOID ---------- //
    ////////////////////////////////////////

    
}
