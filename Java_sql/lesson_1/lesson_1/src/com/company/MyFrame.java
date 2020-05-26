package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class MyFrame extends JFrame {

    String username = "newuser";
    String password = "password@A190997";
    String connectionUrl = "jdbc:mysql://localhost:3306/test?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    //массив для хранения изначальной таблицы Books
    ArrayList<Books> books_arr= new ArrayList<Books>();
    //массив для храниения конкретной выборки из Books
    ArrayList<Books> books_tmp= new ArrayList<Books>();
    //массив для хранения выборки из категорий
    ArrayList<Categories> cat_arr = new ArrayList<Categories>();
    //создание модели для родительской таблицы
    MyTableModel tModel = new MyTableModel(cat_arr);
    //созлание модели для дочерней таблицы
    MyTableModel2 tModel2 = new MyTableModel2(books_tmp);
    JButton jButton = new JButton("Show tables");
    JTable jTable;
    JTable jTable2;
    void createGUI()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setTitle("Table app");
        setBackground(Color.white);
        JPanel jPanel= new JPanel();
//        jPanel.setBounds(0, 700, 1000, 30);
        jPanel.add(jButton);
        add(jPanel, BorderLayout.SOUTH);
        //код создания родительской таблицы
        jTable = new JTable(tModel);
        JScrollPane jscrlp = new JScrollPane(jTable);
        jTable2 = new JTable(tModel2);
        JScrollPane jscrlp2 = new JScrollPane(jTable2);
        //добавление таблиц на фрейм
        add(jscrlp, BorderLayout.WEST);
        add(jscrlp2, BorderLayout.EAST);

        NewListener list = new NewListener();
        //отлавливание нажатия кнопки
        jButton.addActionListener(list);

    }
    class NewListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //установление кнопки нерабочей после нажатия, так как таблицы уже выбраны
            books_tmp.clear();
            cat_arr.clear();
            books_arr.clear();
//            jButton.setEnabled(false);
            try {
                get_tables();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
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
                            //вариант нахождения нужной выборки через запрос sql
                            try {
                                get_tm_arr(id_qw);
                            } catch (ClassNotFoundException classNotFoundException) {
                                classNotFoundException.printStackTrace();
                            }
                            //Вариант нахождения нужных значений с помощью классов
//                            while(i < books_arr.size()){
//                                if (books_arr.get(i).getId_cat() == id_qw)
//                                {
//                                    books_tmp.add(books_arr.get(i));
//                                    tModel2.fireTableDataChanged();
//                                }
//                                i++;
//                            }
                        }
                    }
                }

            });
        }
    }
    //извлечение нужной выборки
    void get_tm_arr(int idsh) throws ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            Statement statement = conn.createStatement()) {
            ResultSet resultSet2 = statement.executeQuery("select * from Books where id_cat = " + idsh);
            int id;
            String name;
            int id_b;
            if (resultSet2 != null && resultSet2.isLast() == false ) {
                while (resultSet2.next()) {
                    name = resultSet2.getString("name_book");
                    id = resultSet2.getInt("id_cat");
                    id_b = resultSet2.getInt("id_book");
                    Books n = new Books(id_b, id, name);
                    books_tmp.add(n);
                    tModel2.fireTableDataChanged();
                }
            }
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }
    // sql code для извлечения изначальных таблиц
    void get_tables () throws ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            Statement statement = conn.createStatement()) {
            //На скриншотах видно создание таблиц в консоли, но это также можно сделать и
            // в коде аналогичным образом с помощью statement.executeUpdate

            //Также если бы таблицы изначально не были связаны, здесь можно добавить foreign key:
            //statement.executeUpdate("alter table Books add constraint cat_const FOREIGN KEY (id_cat)" +
            //        "references test.Categories(id_cat) on update cascade  on delete restrict ");
            ResultSet resultSet2 = statement.executeQuery("select * from Books");
            int id;
            String name;
            int id_b;
            while (resultSet2.next()) {
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
            while (resultSet2.next()) {
                name = resultSet2.getString("name_cat");
                id = resultSet2.getInt("id_cat");
                Categories l = new Categories(id, name);
                cat_arr.add(l);
                tModel.fireTableDataChanged();
            }
        }
        catch (Exception exc) {
            JOptionPane.showMessageDialog(null, "SQL Error");
        }

    }
    public MyFrame() throws ClassNotFoundException
    {
        super();
        createGUI();
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        MyFrame jFrame = new MyFrame();
        jFrame.setVisible(true);
    }
}
