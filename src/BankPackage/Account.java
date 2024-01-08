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
    private String name;
    private String accountNumber;
    private double accountBalance;
    private String accountType;
    private double interestRate;
    private Date dateOpened;
    private String accountStatus;
    private String currType;
    private ArrayList<Transaction> transactions;
    
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
    
    public String getName() {
        return this.name;
    }
    
    public String getAccountNumber() {
        return this.accountNumber;
    }
    
    public double getBalance() {
        return this.accountBalance;
    }
    
    public void setBalance(double balance) {
        this.accountBalance = balance;
    }
    
    public String getAccountType() {
        return this.accountType;
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
