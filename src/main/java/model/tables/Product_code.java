package model.tables;


public class Product_code {
    
    String prod_code;//clé primaire
    char discount_code;//clé primaire
    String description;

    public Product_code(String prod_code, char discount_code) {
        this.prod_code = prod_code;
        this.discount_code = discount_code;
    }

    public Product_code(String prod_code, char discount_code, String description) {
        this.prod_code = prod_code;
        this.discount_code = discount_code;
        this.description = description;
    }

    public void setProd_code(String prod_code) {
        this.prod_code = prod_code;
    }

    public void setDiscount_code(char discount_code) {
        this.discount_code = discount_code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
    
    
}
