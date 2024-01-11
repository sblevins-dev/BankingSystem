/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankPackage;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nechi
 */
public class MyTableModel extends AbstractTableModel
{
    String[] columnNames = {"Place", "Date Of Transaction", "Type", "Amount"};
    ArrayList<Transaction> transArr;
    NumberFormat nF
            = NumberFormat
                  .getCurrencyInstance(Locale.US);
    
    public MyTableModel(ArrayList transArr) {
        this.transArr = transArr;
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount()
    {
        return transArr.size();
    }

    @Override
    public int getColumnCount()
    {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Transaction trans = transArr.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return trans.getPlace();
            case 1:
                return trans.getDate();
            case 2:
                return trans.getType();
            case 3:
                return nF.format(trans.getAmount());
            default:
                return null;
        }
    }
    
}
