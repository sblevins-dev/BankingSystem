/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankPackage;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author nechi
 */
public class Account
{
    private int id;
    private String name;
    private String accountNumber;
    private double accountBalance;
    private String accountType;
    private double interestRate;
    private Date dateOpened;
    private String accountStatus;
    private String currType;
    private ArrayList<Transaction> transactions;
    
    public Account() {
        
    }
    
    public Account(String name, String accountNumber, double accountBalance, 
            String accountType, Date dateOpened, String accountStatus, 
            String currType, ArrayList transactions) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
        this.dateOpened = dateOpened;
        this.accountStatus = accountStatus;
        this.currType = currType;
        this.transactions = transactions;
    }
    
    public int getID() {
        return this.id;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAccountNumber() {
        return this.accountNumber;
    }
    
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public double getBalance() {
        return this.accountBalance;
    }
    
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
    
    public String getAccountType() {
        return this.accountType;
    }
    
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    
    public String getAccountStatus() {
        return this.accountStatus;
    }
    
    public void setAccountStatus(String status) {
        this.accountStatus = status;
    }
    
    public Date getDateOpened() {
        return this.dateOpened;
    }
    
    public String getCurrType() {
        return this.currType;
    }
    
    public void setCurrType(String type) {
        this.currType = type;
    }
    
    public ArrayList getTransactions() {
        return this.transactions;
    }
}
