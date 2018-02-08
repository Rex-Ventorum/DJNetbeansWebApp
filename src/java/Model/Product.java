package Model;

import java.util.Objects;

/**
 *
 * @author Brandon
 */
public final class Product{
    
    private String productId;
    private String productName;
    private double unitPrice;
    private String imageURL;
    private String discriptionShort;
    private String discriptionLong;
    
    
    ////////////////////////////////////////
    // ---------- CONSTRUCTORS ---------- //
    ////////////////////////////////////////
    
    public Product(String productId, String productName, double unitPrice, String imageURL, String discriptionShort, String discriptionLong) {
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.imageURL = imageURL;
        this.discriptionShort = discriptionShort;
        this.discriptionLong = discriptionLong;
    }

    public Product(String productName, double unitPrice, String imageURL, String discriptionShort, String discriptionLong) {
        setProductName(productName);
        setUnitPrice(unitPrice);
        setImageURL(imageURL);
        setDiscriptionShort(discriptionShort);
        setDiscriptionLong(discriptionLong);
    }

    ////////////////////////////////////////
    // ------ INTERACTABLE METHODS ------ //
    ////////////////////////////////////////
        
    ////////////////////////////////////////
    // --------- SETTER METHODS --------- //
    ////////////////////////////////////////

    public void setProductId(String productId) {
        if(imageURL == null || imageURL.isEmpty()) throw new IllegalArgumentException("Product Id May Not Be Null Or Empty");
        this.productId = productId;
    }
    
    public void setProductName(String productName) {
        if(productName == null || productName.isEmpty()) throw new IllegalArgumentException("Product Name May Not Be Null Or Empty");
        this.productName = productName;
    }

    public void setUnitPrice(double unitPrice) {
        if(unitPrice < 0) throw new IllegalArgumentException("Unit Price May Not Be Negitive");
        this.unitPrice = unitPrice;
    }

    public void setImageURL(String imageURL){
        if(imageURL == null || imageURL.isEmpty()) throw new IllegalArgumentException("Image URL May Not Be Null Or Empty");
        this.imageURL = imageURL;
    }

    public void setDiscriptionShort(String discriptionShort) {
        if(discriptionShort == null) throw new IllegalArgumentException("Short Discription May Not Be Null");
        this.discriptionShort = discriptionShort;
    }

    public void setDiscriptionLong(String discriptionLong) {
        if(discriptionLong == null || discriptionLong.isEmpty()) throw new IllegalArgumentException("Long Discription May Not Be Null Or Empty");
        this.discriptionLong = discriptionLong;
    }
    
    ////////////////////////////////////////
    // --------- GETTER METHODS --------- //
    ////////////////////////////////////////

    public String getProductId() {
        return productId;
    }
    
    public String getProductName() {
        return productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getDiscriptionShort() {
        return discriptionShort;
    }

    public String getDiscriptionLong() {
        return discriptionLong;
    }
    
    ////////////////////////////////////////
    // ----- PRIVATE HELPER METHODS ----- //
    ////////////////////////////////////////
    
    
    ////////////////////////////////////////
    // --------- OTHER METHOID ---------- //
    ////////////////////////////////////////

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.productId);
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
        final Product other = (Product) obj;
        return Objects.equals(this.productId, other.productId);
    }    
    
}
