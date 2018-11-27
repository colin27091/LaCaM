package model.tables;

public class Manufacturer {
    
    int manufacturer_id;//clé primaire
    String name;
    String addressline1;
    String addressline2;
    String city;
    String state;
    String zip;
    String phone;
    String fax;
    String email;
    String rep;

    public Manufacturer(int manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
    }

    public void setManufacturer_id(int manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
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

    public void setZip(String zip) {
        this.zip = zip;
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

    public void setRep(String rep) {
        this.rep = rep;
    }

    
    
}
