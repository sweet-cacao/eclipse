package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MyTableModel extends AbstractTableModel {
    ArrayList<Categories> cat_arr;
    MyTableModel(ArrayList<Categories> cat_arr) {
        super();
        this.cat_arr = cat_arr;
    }
    @Override
    public int getRowCount() {
        return cat_arr.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
                return cat_arr.get(r).getId_cat();
            case 1:
                return cat_arr.get(r).getName_cat();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        String res = "";
        switch (column) {
            case 0:
                res = "id_cat";
                break;
            case 1:
                res = "name_cat";
                break;
        }
        return res;
    }
}
