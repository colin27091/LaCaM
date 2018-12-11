package model.tables;


public class Customer {
    
    int customer_id;//clé primaire
    String discount_code;//clé etrangère de la table DISCOUNT_CODE
    String zip;//clé etrangère de ta table MICRO_MARKET
    String name;
    String addressline1;
    String addressline2;
    String city;
    String state;
    String phone;
    String fax;
    String email;
    int credit_limit;
    
    float sommeTotale;
    
    
    public Customer(){
    }
    
    public Customer(int customer_id, String discount_code, String zip) {
        this.customer_id = customer_id;
        this.discount_code = discount_code;
        this.zip = zip;
    }

    public Customer(int customer_id, String discount_code, String zip, String name, String addressline1, String addressline2, String city, String state, String phone, String fax, String email, int credit_limit) {
        this.customer_id = customer_id;
        this.discount_code = discount_code;
        this.zip = zip;
        this.name = name;
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.credit_limit = credit_limit;
    }

    @Override
    public String toString() {
        return "Customer{" + "customer_id=" + customer_id + ", name=" + name + ", city=" + city + ", email=" + email + '}';
    }

    public float getSommeTotale() {
        return sommeTotale;
    }

    public void setSommeTotale(float sommeTotale) {
        this.sommeTotale = sommeTotale;
    }   

    public int getCustomer_id() {
        return customer_id;
    }

    public String getDiscount_code() {
        return discount_code;
    }

    public String getZip() {
        return zip;
    }

    public String getName() {
        return name;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail() {
        return email;
    }

    public int getCredit_limit() {
        return credit_limit;
    }
    
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setDiscount_code(String discount_code) {
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

    public void setPhone(String phone) {
        this.phone = phone;
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
