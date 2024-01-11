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
public class Deposit
{
    private String place;
    private Date currDate;
    private String type;
    private double amount;
    private String currType;
    private int userId;
    
    public Deposit(double amount, Account user) {
        this.place = "Bank";
        this.currDate = new Date();
        this.type = "Deposit";
        this.amount = amount;
        this.currType = "USD";
        this.userId = user.getID();
    }
    
    public int getUserId() {
        return this.userId;
    }
    
    public String getPlace() {
        return this.place;
    }
    
    public String getDate() {
        return String.valueOf(this.currDate);
    }
    
    public String getType() {
        return this.type;
    }
    
    public double getAmount() {
        return this.amount;
    }
    
    public String getCurrType() {
        return this.currType;
    }
    
    @Override
    public String toString() {
        return getDate();
    }
}
