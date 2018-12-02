package model.tables;


public class Product {
    
    int product_id;//clé primaire
    int manufacturer_id;//clé etrangère (manufacturer_id)
    String product_code;//clé etrangère (product_code)
    double purchase_cost;
    int quantity_on_hand;
    double markup;
    String available;
    String description;

    public Product(){
    }
    
    public Product(int product_id, int manufacturer_id, String product_code) {
        this.product_id = product_id;
        this.manufacturer_id = manufacturer_id;
        this.product_code = product_code;
    }

    public Product(int product_id, int manufacturer_id, String product_code, double purchase_cost, int quantity_on_hand, double markup, String available, String description) {
        this.product_id = product_id;
        this.manufacturer_id = manufacturer_id;
        this.product_code = product_code;
        this.purchase_cost = purchase_cost;
        this.quantity_on_hand = quantity_on_hand;
        this.markup = markup;
        this.available = available;
        this.description = description;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setManufacturer_id(int manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public void setPurchase_cost(double purchase_cost) {
        this.purchase_cost = purchase_cost;
    }

    public void setQuantity_on_hand(int quantity_on_hand) {
        this.quantity_on_hand = quantity_on_hand;
    }

    public void setMarkup(double markup) {
        this.markup = markup;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getManufacturer_id() {
        return manufacturer_id;
    }

    public String getProduct_code() {
        return product_code;
    }

    public double getPurchase_cost() {
        return purchase_cost;
    }

    public int getQuantity_on_hand() {
        return quantity_on_hand;
    }

    public double getMarkup() {
        return markup;
    }

    public String getAvailable() {
        return available;
    }

    public String getDescription() {
        return description;
    }
    
    
    
    
}
