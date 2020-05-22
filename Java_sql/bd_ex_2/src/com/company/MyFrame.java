package com.company;

import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.sql.*;
import java.util.Arrays;

public class MyFrame extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private String new_str;
    private CachedRowSetImpl rowSet;
    RowSetMetaData rsmd;
    ArrayList<String> keys = new ArrayList<>();
    String prim_key = "";
    int count;
    JPanel panel_1 = new JPanel();

    ArrayList<String> columnNames = new ArrayList<String>();
    private JComboBox comboBox;
    ArrayList<JLabel> labels = new ArrayList<>();
    ArrayList<JTextField> textFields = new ArrayList<>();

    public ArrayList<ActionListener> listeners= new ArrayList<ActionListener>();
    String username = "newuser";
    String password = "password@A190997";
    String connectionUrl = "jdbc:mysql://localhost:3306/test2?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    JButton jButton_forward = new JButton("Вперёд");
    JButton jButton_back = new JButton("Назад");

    public MyFrame() throws ClassNotFoundException {
        super("MyFrame");
        createGUI();
    }

    public void createGUI() throws ClassNotFoundException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setTitle("Table app");
        setBackground(Color.white);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(31, 0, 939, 111);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton jButton_open = new JButton("Открыть набор");
        jButton_open.setFont(new Font("Dialog", Font.BOLD, 15));
        jButton_open.setBounds(277, 12, 163, 74);
        panel.add(jButton_open);

        JButton jButton_close = new JButton("Закрыть набор");
        jButton_close.setFont(new Font("Dialog", Font.BOLD, 15));
        jButton_close.setBounds(452, 12, 145, 74);
        panel.add(jButton_close);


        jButton_forward.setFont(new Font("Dialog", Font.BOLD, 15));
        jButton_forward.setBounds(782, 12, 145, 74);
        panel.add(jButton_forward);


        jButton_back.setFont(new Font("Dialog", Font.BOLD, 15));
        jButton_back.setBounds(609, 12, 151, 74);
        panel.add(jButton_back);

        String[] arrTables = getTableNames();
        comboBox = new JComboBox(arrTables);
        comboBox.setBounds(24, 17, 218, 67);
        panel.add(comboBox);



        panel_1.setBounds(31, 148, 939, 101);
        contentPane.add(panel_1);
        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton jButton_save = new JButton("Сохранить изменения");
        jButton_save.setBounds(278, 291, 406, 101);
        jButton_save.setFont(new Font("Dialog", Font.BOLD, 15));
        contentPane.add(jButton_save);

        //установление actioncommands
        jButton_back.setActionCommand("back");
        jButton_forward.setActionCommand("forward");
        jButton_open.setActionCommand("open");
        jButton_close.setActionCommand("close");
        jButton_save.setActionCommand("save");
        comboBox.setActionCommand("box");
        //добавление слушателей
        listeners.add(new eListener());
        jButton_back.addActionListener(listeners.get(0));
        jButton_forward.addActionListener(listeners.get(0));
        jButton_open.addActionListener(listeners.get(0));
        jButton_close.addActionListener(listeners.get(0));
        jButton_save.addActionListener(listeners.get(0));
        comboBox.addActionListener(listeners.get(0));
    }
    //класс слушателя для всех кнопок
    public class eListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String tmp = actionEvent.getActionCommand();
            if (rowSet == null && (tmp.equals("back") || tmp.equals("forward")
            || tmp.equals("save") || tmp.equals("close")))
                JOptionPane.showMessageDialog(null, "Сначала выберите таблицу и откройте набор данных");
            else {
                if (tmp.equals("back")) {
                    try {
                        if (rowSet.isFirst())
                        {
                            jButton_back.setEnabled(false);
                            jButton_forward.setEnabled(true);
                            return;
                        }
                        if (rowSet.previous())
                        {
                            for (int i = 0; i < count; i++)
                            {
                                textFields.get(i).setText(rowSet.getString(columnNames.get(i)));
                            }
                        }
                        else
                            jButton_back.setEnabled(false);
                        if (rowSet.isFirst())
                        {
                            jButton_back.setEnabled(false);
                        }
                        if (rowSet.isLast())
                        {
                            jButton_forward.setEnabled(false);
                            return;
                        }
                        jButton_forward.setEnabled(true);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                } else if (tmp.equals("forward")) {
                    try {
                        if (rowSet.next())
                        {
                            for (int i = 0; i < count; i++)
                                textFields.get(i).setText(rowSet.getString(columnNames.get(i)));
                        }
                        else
                        {
                            jButton_forward.setEnabled(false);
                        }
                        if (rowSet.isLast())
                        {
                            jButton_forward.setEnabled(false);
                        }
                        if (rowSet.isFirst())
                        {
                            jButton_back.setEnabled(false);
                            return;
                        }
                        jButton_back.setEnabled(true);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                } else if (tmp.equals("open")) {
                    if (new_str == null || new_str.equals("Не выбрано"))
                        JOptionPane.showMessageDialog(null, "Сначала выберите таблицу");
                    else {
                        try {
                            openSet();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (tmp.equals("close")) {
                    labels.clear();
                    textFields.clear();
                    panel_1.removeAll();
                    panel_1.updateUI();
                    jButton_back.setEnabled(false);
                    jButton_forward.setEnabled(false);
                } else if (tmp.equals("save")) {
                    if (new_str == null || new_str.equals("Не выбрано"))
                        JOptionPane.showMessageDialog(null, "Сначала выберите таблицу");
                    else {
                        try {
                            saveChanges();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (tmp.equals("box")) {
                    JComboBox box = (JComboBox) actionEvent.getSource();
                    new_str = (String) comboBox.getSelectedItem();
                }
            }
        }
    }
//сохранение изменений
    void saveChanges() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            Statement statement = conn.createStatement();){
            conn.setAutoCommit(false);
            for (int i=0; i < count; i++)
            {
                if (!columnNames.get(i).equals(prim_key))
                {

                    rowSet.updateString(columnNames.get(i), textFields.get(i).getText());
                    rowSet.updateRow();
                    rowSet.acceptChanges(conn);
                }
            }
            getKeys();
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
    }
//получение всех уникальных ключей
    void getKeys()
    {
        try(Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            Statement statement = conn.createStatement()){
            keys.clear();
            ResultSet rs = conn.getMetaData().getPrimaryKeys(null, conn.getSchema(), new_str);
            ResultSet res = statement.executeQuery("select * from " + new_str);
            if (rs.next())
                prim_key = rs.getString("COLUMN_NAME");
            while(res.next())
            {
                keys.add(res.getString(prim_key));
            }
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }
//автоматическое создание полей в соответсвии с количеством столбцов
    void createFields() throws SQLException {
        columnNames.clear();
        for (int i = 1; i <= count; i++)
            columnNames.add(rsmd.getColumnName(i));
        labels.clear();
        textFields.clear();
        panel_1.removeAll();
        rowSet.next();
        jButton_back.setEnabled(false);
        if (rowSet.isLast())
            jButton_forward.setEnabled(false);
        else
            jButton_forward.setEnabled(true);
        for (int i = 0; i < count; i++)
        {
            labels.add(new JLabel(columnNames.get(i)));
            textFields.add(new JTextField(rowSet.getString(columnNames.get(i))));
            textFields.get(i).setColumns(10);
            textFields.get(i).setFont(new Font("Dialog", Font.PLAIN, 17));
            if (columnNames.get(i).equals(prim_key))
                textFields.get(i).setEnabled(false);
            labels.get(i).setFont(new Font("Dialog", Font.BOLD, 17));
            panel_1.add(labels.get(i));
            panel_1.add(textFields.get(i));
        }
        panel_1.updateUI();
    }
//открытие кэштроусет
    void openSet() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            Statement statement = conn.createStatement()){
            ResultSet res = statement.executeQuery("select * from " + new_str);
            rowSet = new CachedRowSetImpl();
            keys.clear();
            rowSet.setTableName(new_str);
            rowSet.populate(res);
            prim_key = "";
            rsmd = (RowSetMetaData)rowSet.getMetaData();
            getKeys();
            count = rsmd.getColumnCount();
            createFields();
        }
        catch (SQLException exc)
        {
            exc.printStackTrace();
        }
    }

    int isInArr(String a, ArrayList<String> b)
    {
        for (int i = 0; i < b.size(); i++)
            if (b.get(i).equals(a))
                return 1;
        return 0;
    }
    //создание списка имен таблиц
    public String[] getTableNames() throws ClassNotFoundException
    {
        ArrayList<String> arr = new ArrayList<String>();
        String tmp = "";
        int i = 0;
        ResultSet mrs;
        DatabaseMetaData meta;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            Statement statement = conn.createStatement()){
            meta = conn.getMetaData();
            mrs = meta.getTables(null, null, null, new String[]{"TABLE"});
            while(mrs.next()){
                tmp = mrs.getString(3);
                if (isInArr(tmp, arr) == 0)
                {
                    if (tmp.equals("sys_config"))
                        tmp = "Не выбрано";
                    arr.add(tmp);
                    i++;
                }
            }
        }
        catch (Exception exc)
        {
            System.out.println("Unable to get tablenames");
        }
        return arr.toArray(String[]::new);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        MyFrame jFrame = new MyFrame();
        jFrame.setVisible(true);
    }
}
