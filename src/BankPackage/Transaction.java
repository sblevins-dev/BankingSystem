/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankPackage;

import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author nechi
 */
public class Transaction
{

    private int id;
    private String place;
    private String dateOfTrans;
    private Date date;
    private String type;
    private double amount;
    private String currType;
    private int UserId;

    public Transaction()
    {

    }

    public Transaction(int id, String place, String date, String type, double amount,
            String currType) throws ParseException
    {
        this.id = id;
        this.place = place;
        this.dateOfTrans = date;
        this.type = type;
        this.amount = amount;
        this.currType = currType;
    }

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getUserId()
    {
        return this.UserId;
    }

    public void setUserId(int id)
    {
        this.UserId = id;
    }

    public String getPlace()
    {
        return this.place;
    }

    public void setPlace(String place)
    {
        this.place = place;
    }

    public String getDate()
    {
        return this.dateOfTrans;
    }

    public void setDate(String date)
    {
        this.dateOfTrans = date;
    }

    public String getType()
    {
        return this.type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public double getAmount()
    {
        return this.amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public String getCurrType()
    {
        return this.getCurrType();
    }

    public void setCurrType(String currType)
    {
        this.currType = currType;
    }
}
