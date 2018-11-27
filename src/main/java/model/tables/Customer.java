package model.tables;


public class Customer {
    
    int customer_id;//clé primaire
    char discount_code;//clé etrangère de la table DISCOUNT_CODE
    String zip;//clé etrangère de ta table MICRO_MARKET
    String name;
    String addressline1;
    String addressline2;
    String city;
    String state;
    String fax;
    String email;
    int credit_limit;
    
    public Customer(int customer_id, char discount_code, String zip) {
        this.customer_id = customer_id;
        this.discount_code = discount_code;
        this.zip = zip;
    }
    
    
    public Customer(int customer_id, char discount_code, String zip, String name, String addressline1, String addressline2, String city, String state, String fax, String email, int credit_limit) {
        this.customer_id = customer_id;
        this.discount_code = discount_code;
        this.zip = zip;
        this.name = name;
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.city = city;
        this.state = state;
        this.fax = fax;
        this.email = email;
        this.credit_limit = credit_limit;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setDiscount_code(char discount_code) {
        this.discount_code = discount_code;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCredit_limit(int credit_limit) {
        this.credit_limit = credit_limit;
    }
    
    
}
