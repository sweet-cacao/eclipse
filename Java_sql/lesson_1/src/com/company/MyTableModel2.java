package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

//модель для дочерней таблицы
public class MyTableModel2 extends AbstractTableModel {
    ArrayList<Books> cat_arr;
    MyTableModel2(ArrayList<Books> cat_arr) {
        super();
        this.cat_arr = cat_arr;
    }
    @Override
    public int getRowCount() {
        return cat_arr.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    //результат для колонки
    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
                return cat_arr.get(r).getId_book();
            case 1:
                return cat_arr.get(r).getName_book();
            case 2:
                return cat_arr.get(r).getId_cat();
            default:
                return "";
        }
    }
    //названия колонок
    @Override
    public String getColumnName(int column) {
        String res = "";
        switch (column) {
            case 0:
                res = "id_book";
                break;
            case 1:
                res = "name_cat";
                break;
            case 2:
                res = "id_cat";
                break;
        }
        return res;
    }
}
