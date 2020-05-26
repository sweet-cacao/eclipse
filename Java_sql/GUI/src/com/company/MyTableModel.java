package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MyTableModel extends AbstractTableModel {
    ArrayList<Object[]> ints;
    int row;
    int column;

    MyTableModel (ArrayList<Object[]> ints)
    {
        super();
        this.ints = ints;
    }
    public  void getColRows(int row, int column)
    {
        this.row = row;
        this.column = column;
    }
    @Override
    public int getRowCount() {
        return row;
    }

    @Override
    public int getColumnCount() {
        return column;
    }

    @Override
    public Object getValueAt(int r, int c) {
        for (int i = 0; i < column; i++)
        {
            if (i == c && ints.size() == row){
                return ints.get(r)[i];
            }
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        Integer col = column;
        return col.toString();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Object[] tmp = ints.get(rowIndex-1);
        tmp[columnIndex-1] = aValue;
    }
}
