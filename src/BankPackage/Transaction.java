/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankPackage;

import java.util.Date;

/**
 *
 * @author nechi
 */
public class Transaction
{
    private int id;
    private String place;
    private Date dateOfTrans;
    private String type;
    private double ammount;
    private String currType;
    
    public Transaction(int id, String place, Date date, String type, double ammount, 
            String currType) {
        this.id = id;
        this.place = place;
        this.dateOfTrans = date;
        this.type = type;
        this.ammount = ammount;
        this.currType = currType;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getPlace() {
        return this.place;
    }
    
    public Date getDate() {
        return this.dateOfTrans;
    }
    
    public String getType() {
        return this.type;
    }
    
    public double getAmmount() {
        return this.ammount;
    }
    
    public String getCurrType() {
        return this.getCurrType();
    }
    
    public String toString() {
        String str = "";
        
        str += this.getPlace() + "\t" + this.getDate() + "\t" + this.getType() 
                + "\t" + this.getAmmount();
        
    
        
        return str;
    }
}
