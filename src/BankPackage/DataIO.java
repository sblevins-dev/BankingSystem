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

    public DataIO() throws SQLException
    {
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

        if (rs.next())
        {
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

    public ArrayList getTransactions(int id) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        ArrayList<Transaction> transList = new ArrayList();
        Transaction trans;

        String sql = "SELECT * FROM transaction WHERE UserId = ? ORDER BY DateOfTrans";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next())
        {
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

    public <T extends Transaction> void updateAmount(T transaction, Account currAccount) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
         System.out.println("In UpdateAmount");
        double accBalance = 0.0;
        
        if (transaction instanceof Deposit) {
            accBalance = currAccount.getBalance() + transaction.getAmount();
        } else if (transaction instanceof Withdrawal) {
            accBalance = currAccount.getBalance() - transaction.getAmount();
        }
        
        String sql = "UPDATE account "
                + "SET AccountBalance = ? "
                + "WHERE account.id = ?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setDouble(1, accBalance);
        stmt.setInt(2, currAccount.getID());

        stmt.execute();

        con.close();
    }

    public void addDeposit(Deposit deposit, Account currAccount) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String sql = "INSERT INTO transaction "
                + "(Place, DateOfTrans, Type, Amount, CurrType, UserId)"
                + "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, deposit.getPlace());
        stmt.setString(2, deposit.getDate());
        stmt.setString(3, deposit.getType());
        stmt.setDouble(4, deposit.getAmount());
        stmt.setString(5, deposit.getCurrType());
        stmt.setInt(6, deposit.getUserId());

        stmt.execute();
        updateAmount(deposit, currAccount);

        con.close();
    }
    
    public void makeWithdrawal(Withdrawal withdrawal, Account currAccount) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String sql = "INSERT INTO transaction "
                + "(Place, DateOfTrans, Type, Amount, CurrType, UserId)"
                + "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, withdrawal.getPlace());
        stmt.setString(2, withdrawal.getDate());
        stmt.setString(3, withdrawal.getType());
        stmt.setDouble(4, withdrawal.getAmount());
        stmt.setString(5, withdrawal.getCurrType());
        stmt.setInt(6, withdrawal.getUserId());

        stmt.execute();
        updateAmount(withdrawal, currAccount);

        con.close();
    }
}
