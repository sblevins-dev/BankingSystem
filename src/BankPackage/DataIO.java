/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author nechi
 */
public class DataIO
{
    private final String DATABASE_NAME = System.getProperty("DATABASE_NAME");
    private final String CONNECTION_STRING = System.getProperty("CONNECTION_STRING");
    private final String USER_NAME = System.getProperty("USER_NAME");
    private final String PASSWORD = System.getProperty("SQL_PASS");
    
    Connection con;
    
    public DataIO() throws SQLException {
        con = DriverManager.getConnection(CONNECTION_STRING,
                USER_NAME, PASSWORD);
    }
    
    
    // Gets account information by id passed in
    public Account getAccount(int id) throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Account currAcct;
        
        String sql = "SELECT id, Name, AccountNumber, AccountType, "
                + "AccountStatus, AccountBalance FROM account WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        currAcct = new Account();
        
        if (rs.next()) {
            currAcct.setID(rs.getInt(1));
            currAcct.setName(rs.getString(2));
            currAcct.setAccountNumber(rs.getString(3));
            currAcct.setAccountType(rs.getString(4));
            currAcct.setAccountStatus(rs.getString(5));
            currAcct.setAccountBalance(rs.getDouble(6));
        }
        
        con.close();

        return currAcct;
    }
    
    public ArrayList getTransactions(int id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        ArrayList<Transaction> transList = new ArrayList();
        Transaction trans;
        
        String sql = "SELECT * FROM transaction WHERE UserId = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            trans = new Transaction();
            
            trans.setId(rs.getInt(1));
            trans.setPlace(rs.getString(2));
            trans.setDate(rs.getString(3));
            trans.setType(rs.getString(4));
            trans.setAmount(rs.getDouble(5));
            trans.setCurrType(rs.getString(6));
            trans.setUserId(rs.getInt(7));
            
            transList.add(trans);

        }
        
        con.close();
        
        return transList;
    }
}
