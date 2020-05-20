package com.company;

public class Categories {
        private int id_cat;
        private String name_book;

        public Categories(int id_c, String name)
        {
            id_cat = id_c;
            name_book = name;
        }
        int getId_cat()
        {
            return(id_cat);
        }
        String getName_cat()
        {
            return(name_book);
        }
}
