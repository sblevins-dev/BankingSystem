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
public class Withdrawal extends Transaction
{
    private String place;
    private Date currDate;
    private String type;
    private double amount;
    private String currType;
    private int userId;
    
    public Withdrawal(double amount, Account user) {
        this.place = "ATM";
        this.currDate = new Date();
        this.type = "Withdrawal";
        this.amount = amount;
        this.currType = "USD";
        this.userId = user.getID();
    }
    
    @Override
    public int getUserId() {
        return this.userId;
    }
    
    @Override
    public String getPlace() {
        return this.place;
    }
    
    @Override
    public String getDate() {
        return String.valueOf(this.currDate);
    }
    
    @Override
    public String getType() {
        return this.type;
    }
    
    @Override
    public double getAmount() {
        return this.amount;
    }
    
    @Override
    public String getCurrType() {
        return this.currType;
    }
    
    @Override
    public String toString() {
        return getDate();
    }
}
