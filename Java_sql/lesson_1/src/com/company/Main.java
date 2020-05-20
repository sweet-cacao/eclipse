package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import javax.lang.model.type.NullType;
import javax.swing.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        JFrame jFrame = getFrame();
        JPanel jPanel= new JPanel();

        jPanel.setBounds(0, 700, 1000, 30);
        JButton jButton = new JButton("Show tables");
        jPanel.add(jButton);
        jFrame.add(jPanel, BorderLayout.SOUTH);
        ArrayList<Books> books_arr= new ArrayList<Books>();
        ArrayList<Books> books_tmp= new ArrayList<Books>();
        ArrayList<Categories> cat_arr = new ArrayList<Categories>();
        MyTableModel tModel = new MyTableModel(cat_arr);
        //код создания родительской таблицы
        JTable jTable;
        jTable = new JTable(tModel);
        JScrollPane jscrlp = new JScrollPane(jTable);
        MyTableModel2 tModel2 = new MyTableModel2(books_tmp);

        JTable jTable2;
        jTable2 = new JTable(tModel2);
        JScrollPane jscrlp2 = new JScrollPane(jTable2);
        jFrame.add(jscrlp, BorderLayout.WEST);
        jFrame.add(jscrlp2, BorderLayout.EAST);
        jFrame.setVisible(true);
        // sql code
        String username = "newuser";
        String password = "password@A190997";
        String connectionUrl = "jdbc:mysql://localhost:3306/test?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    try(Connection conn = DriverManager.getConnection(connectionUrl, username, password);
                        Statement statement = conn.createStatement()){
//            statement.executeUpdate("drop table Books");
                        if (statement.executeUpdate("create table if not exists Categories (id_cat MEDIUMINT not null auto_increment, name_cat CHAR (30) not null, PRIMARY key(id_cat))")==1)
                        {
//                statement.executeUpdate("insert into Categories (name_cat) values('Fantasy')");
//                statement.executeUpdate("insert into Categories set name_cat = 'Romance'");
//                statement.executeUpdate("insert into Categories set name_cat = 'Detective'");
//                statement.executeUpdate("insert into Categories set name_cat = 'Thriller'");
//                statement.executeUpdate("insert into Categories set name_cat = 'Comedy'");
//                statement.executeUpdate("insert into Categories set name_cat = 'Biography'");
//                System.out.println("We are connected");
                        }
                        if (statement.executeUpdate("create table if not exists Books (id_book MEDIUMINT not null auto_increment, id_cat mediumint, name_book CHAR (30) not null, PRIMARY key(id_book), FOREIGN KEY(id_cat) REFERENCES Categories(id_cat))")==1)
                        {
//                statement.executeUpdate("insert into Books (name_book, id_cat) values('Harry Potter', (select id_cat FROM Categories where name_cat = 'Fantasy'))");
//                statement.executeUpdate("insert into Books (name_book, id_cat) values('Twilight', (select id_cat FROM Categories where name_cat = 'Romance'))");
//                statement.executeUpdate("insert into Books (name_book, id_cat) values('The Hound of the Baskervilles', (select id_cat FROM Categories where name_cat = 'Detective'))");
//                statement.executeUpdate("insert into Books (name_book, id_cat) values('Jane Eyre', (select id_cat FROM Categories where name_cat = 'Romance'))");
//                statement.executeUpdate("insert into Books set name_cat = 'Romance'");
                        }
//            statement.executeUpdate("insert into Categories (name_cat) values('Fantasy')");
//            statement.executeUpdate("insert into Categories set name_cat = 'Romance'");
//            statement.executeUpdate("insert into Categories set name_cat = 'Detective'");
//            statement.executeUpdate("insert into Categories set name_cat = 'Thriller'");
//            statement.executeUpdate("insert into Categories set name_cat = 'Comedy'");
//            statement.executeUpdate("insert into Categories set name_cat = 'Biography'");
//
//            statement.executeUpdate("insert into Books (name_book, id_cat) values('Harry Potter', (select id_cat FROM Categories where name_cat = 'Fantasy'))");
//            statement.executeUpdate("insert into Books (name_book, id_cat) values('Twilight', (select id_cat FROM Categories where name_cat = 'Romance'))");
//            statement.executeUpdate("insert into Books (name_book, id_cat) values('The Hound of the Baskervilles', (select id_cat FROM Categories where name_cat = 'Detective'))");
//            statement.executeUpdate("insert into Books (name_book, id_cat) values('Jane Eyre', (select id_cat FROM Categories where name_cat = 'Romance'))");

                        ResultSet resultSet2 = statement.executeQuery("select name_book, Books.id_cat, id_book from Books join Categories C on Books.id_cat = C.id_cat");

                        int id;
                        String name;
                        int id_b;
                        while (resultSet2.next()){
                            System.out.println(resultSet2.getString("name_book"));
                            System.out.println("--------------");
                            name = resultSet2.getString("name_book");
                            id = resultSet2.getInt("id_cat");
                            id_b = resultSet2.getInt("id_book");
                            Books n = new Books(id_b, id, name);
                            books_arr.add(n);
                            books_tmp.add(n);
                            tModel2.fireTableDataChanged();

                        }
                        resultSet2 = statement.executeQuery("select * from Categories");
                        while (resultSet2.next()){
                            name = resultSet2.getString("name_cat");
                            id = resultSet2.getInt("id_cat");
                            Categories l = new Categories(id, name);
                            cat_arr.add(l);
                            tModel.fireTableDataChanged();
                        }
                        resultSet2.close();
                        jTable.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {

                                if (e.getClickCount() == 1)
                                {
                                    int row = jTable.rowAtPoint(e.getPoint());
                                    if (row > -1){
                                        int realRow = jTable.convertRowIndexToModel(row);
                                        int id_qw = cat_arr.get(realRow).getId_cat();
                                        books_tmp.clear();
                                        tModel2.fireTableDataChanged();
                                        int i = 0;
                                        while(i < books_arr.size()){
                                            if (books_arr.get(i).getId_cat() == id_qw)
                                            {
                                                books_tmp.add(books_arr.get(i));
                                                tModel2.fireTableDataChanged();
                                            }
                                            i++;
                                        }
                                    }
                                }
                            }

                        });
                    }
                }
                catch (Exception exc)
                {

                }
            }
        });

    }

    static JFrame getFrame(){
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(1000, 800);
        jFrame.setLocationRelativeTo(null);
        jFrame.setTitle("Table app");
        jFrame.setBackground(Color.white);
        return (jFrame);
    }
}
