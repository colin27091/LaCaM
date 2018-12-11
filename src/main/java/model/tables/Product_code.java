package model.tables;


public class Product_code {
    
    String prod_code;//clé primaire
    String discount_code;//clé primaire
    String description;

    public Product_code() {
    }

    public Product_code(String prod_code, String discount_code) {
        this.prod_code = prod_code;
        this.discount_code = discount_code;
    }

    public void setProd_code(String prod_code) {
        this.prod_code = prod_code;
    }

    public void setDiscount_code(String discount_code) {
        this.discount_code = discount_code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProd_code() {
        return prod_code;
    }

    public String getDiscount_code() {
        return discount_code;
    }

    public String getDescription() {
        return description;
    }

    
    
    
    
}
