/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tables;

    
public class Micro_market {
    
    String zip_code;//clé primaire
    double radius;
    double area_lenght;
    double area_width;

    public Micro_market(String zip_code) {
        this.zip_code = zip_code;
    }

    public Micro_market(String zip_code, double radius, double area_lenght, double area_width) {
        this.zip_code = zip_code;
        this.radius = radius;
        this.area_lenght = area_lenght;
        this.area_width = area_width;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setArea_lenght(double area_lenght) {
        this.area_lenght = area_lenght;
    }

    public void setArea_width(double area_width) {
        this.area_width = area_width;
    }
    
    
}
