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
public class MakeFakeTransactions
{
    private static ArrayList<Transaction> arr;
    
    public static ArrayList makeTransactions() {
//        public Transaction(int id, String place, Date date, String type, double ammount, 
//            String currType)
        arr = new ArrayList();
        for (int i = 1; i < 50; i++) {
            Transaction transaction = new Transaction(i, "McDonalds", 
                    new Date(), "Deposit", 29.99, "USD");
            
            arr.add(transaction);
        }
        
        return arr;
    }
}
