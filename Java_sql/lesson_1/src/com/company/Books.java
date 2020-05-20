package com.company;

public class Books {
    private int id_book;
    private int id_cat;
    private String name_book;

    public Books(int id, int id_c, String name)
    {
        this.id_book = id;
        this.id_cat = id_c;
        this.name_book = name;
    }
    int getId_book()
    {
        return(this.id_book);
    }
    int getId_cat()
    {
        return(this.id_cat);
    }
    String getName_book()
    {
        return(this.name_book);
    }
}
