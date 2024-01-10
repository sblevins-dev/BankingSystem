/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankPackage;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nechi
 */
public class MyTableModel extends AbstractTableModel
{
    String[] columnNames = {"Place", "Date Of Transaction", "Type", "Amount"};
    ArrayList<Transaction> transArr;
    
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
                return trans.getAmount();
            default:
                return null;
        }
    }
    
}
