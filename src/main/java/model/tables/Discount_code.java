/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tables;


public class Discount_code {
    
    char discount_code;//clé primaire
    double rate;

    public Discount_code(char discount_code, double rate) {
        this.discount_code = discount_code;
        this.rate = rate;
    }

    public void setDiscount_code(char discount_code) {
        this.discount_code = discount_code;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    
    
    
}
