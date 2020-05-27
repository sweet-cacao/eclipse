package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyFrame extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField textField;
    private JTextField textField_1;
    private JButton button;
    private JButton button_1;
    private JScrollPane scrollPane;
    private JTextField textField_2;
    private JTextField textField_3;
    private JLabel label_2;
    private JLabel label_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JLabel label_4;
    private JLabel label_5;
    private JLabel label_6;
    private JTextField textField_7;
    private JLabel label_7;
    private JButton btnNewButton_1;
    private JTextField textField_8;
    private JButton button_4;
    private JLabel label_8;
    private JButton button_5;

    Map<Object, Color> color = null;

    // Выбранный шрифт.
    private Font font;
    //Карта шрифтов
    private Map<Object, Font> fontsMap = null;
    //Прикрученныйт рендер
    private FontCellRenderer render=null;

    private ArrayList<Object[]> ints = new ArrayList<>();
    MyTableModel tModel = new MyTableModel(ints);
    String chFont;
    private Font f;
    private Font f1 = new Font("TimesRoman", Font.PLAIN, 22),
            f2 = new Font("Courier", Font.PLAIN, 10),
            f3 = new Font("Arial", Font.PLAIN, 16),
            f4 = new Font("Helvetica", Font.PLAIN, 10),
            f5 = new Font("System", Font.PLAIN, 16);

//    String[] name_fonts = {"Не выбрано", "TimesRoman", "Courier", "Arial", "Helvetica", "Arabic"};
    String[] name_fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    public void createGUI() throws ClassNotFoundException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setTitle("Table app");
        setBackground(Color.white);
        contentPane = new JPanel();

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(635, 23, 452, 150);
        contentPane.add(textArea);

        textField = new JTextField();
        textField.setBounds(236, 23, 164, 46);
        textField.setText("1");
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setText("2");
        textField_1.setBounds(38, 23, 164, 46);
        contentPane.add(textField_1);

        JButton btnNewButton = new JButton("Установить указанное количество строк и столбцов в таблице");
        btnNewButton.setToolTipText("");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    ints.clear();
                    int b = Integer.parseInt(textField.getText());
                    int a = Integer.parseInt(textField_1.getText());

                    System.out.println(a+" "+ b);
//                    tModel.fireTableDataChanged();
                    tModel.getColRows(a, b);
                    tModel.fireTableRowsInserted(a - 1, b - 1);
                    tModel.fireTableStructureChanged();
                    int col = tModel.column;
                    int row = tModel.row;

                    for (int i = 0; i < row; i++) {
                        Object[] arr = new Object[col];
                        for (int j = 0; j < col; j++) {
                            arr[j] = " ";
                        }
                        ints.add(arr);
                    }
                    tModel.fireTableDataChanged();
                }
                catch (Exception exc)
                {
                    JOptionPane.showMessageDialog(null, "Нет данных в поле количество столбцов или количество строк");
                }
            }
        });
        btnNewButton.setBounds(38, 82, 513, 36);
        contentPane.add(btnNewButton);

        button = new JButton("Заполнить таблицу произвольными значениями в указанном диапазоне");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    ints.clear();
                    int a = Integer.parseInt(textField_2.getText());
                    int b = Integer.parseInt(textField_3.getText());
                    int col = tModel.column;
                    int row = tModel.row;

                    int max = Math.max(a, b);
                    int min = Math.min(a, b);
                    for (int i = 0; i < row; i++) {
                        Integer[] arr = new Integer[col];
                        for (int j = 0; j < col; j++) {
                            if (min > max)
                                min = Math.min(a, b);
                            arr[j] = min;
                            min++;
                        }
                        ints.add(arr);
                    }
                    tModel.fireTableDataChanged();
                }
                catch (Exception exc)
                {
                    JOptionPane.showMessageDialog(null, "Введите начало и конец диапазона");
                }
            }
        });
        button.setBounds(42, 511, 562, 36);
        contentPane.add(button);

        button_1 = new JButton("Ввести заданное в поле ввода значение в указанную ячейку таблицы");
        button_1.setBounds(38, 648, 566, 36);
        contentPane.add(button_1);
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int col = tModel.column;
                    int row = tModel.row;
                    int zn = Integer.parseInt(textField_4.getText());
                    int st = Integer.parseInt(textField_5.getText());
                    int str = Integer.parseInt(textField_6.getText());
                    if (st > col || str > row || st <= 0 || str <= 0)
                    {
                        JOptionPane.showMessageDialog(null, "Неверное значение столбца или строки.\nВведите для столбца число от 1 до " + col + "\nДля строки введите значение от 1 до "+ row);
                        return;
                    }
//                    ints.get(1)[1] = 10;
                    tModel.setValueAt(zn, str,st);
                    tModel.fireTableDataChanged();
//                    if (ints.size() > 0)
//                        ints.get(str-1)[st-1] = zn;

                }
                catch(Exception exc)
                {
                    JOptionPane.showMessageDialog(null, "Введите значение и номер ячейки");
                    exc.printStackTrace();
                }
            }
        });

        JLabel label = new JLabel("Количество строк");
        label.setBounds(38, 0, 180, 15);
        contentPane.add(label);

        JLabel label_1 = new JLabel("Количество столбцов");
        label_1.setBounds(243, 0, 180, 15);
        contentPane.add(label_1);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(38, 155, 513, 269);
        contentPane.add(scrollPane);


        table = new JTable(tModel);
        scrollPane.add(table);
        scrollPane.setViewportView(table);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setText("2");
        textField_2.setBounds(42, 453, 164, 46);
        contentPane.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setText("3");
        textField_3.setBounds(243, 453, 164, 46);
        contentPane.add(textField_3);

        label_2 = new JLabel("Начало диапазона");
        label_2.setBounds(48, 436, 154, 15);
        contentPane.add(label_2);

        label_3 = new JLabel("Конец диапазона");
        label_3.setBounds(249, 436, 164, 15);
        contentPane.add(label_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setText("4");
        textField_4.setBounds(48, 590, 164, 46);
        contentPane.add(textField_4);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setText("5");
        textField_5.setBounds(243, 590, 164, 46);
        contentPane.add(textField_5);

        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setText("6");
        textField_6.setBounds(434, 590, 164, 46);
        contentPane.add(textField_6);

        label_4 = new JLabel("Значение");
        label_4.setBounds(52, 563, 70, 15);
        contentPane.add(label_4);

        label_5 = new JLabel("Номер столбца");
        label_5.setBounds(254, 563, 127, 15);
        contentPane.add(label_5);

        label_6 = new JLabel("Номер строки");
        label_6.setBounds(445, 563, 137, 15);
        contentPane.add(label_6);

        JComboBox comboBox = new JComboBox(name_fonts);
        JLabel newlab = new JLabel("jjjj");
        newlab.setFont(f5);
        Remap();
//        color = Color.white;
        render=new FontCellRenderer(fontsMap, color);
        comboBox.setRenderer(render);
        comboBox.setBounds(650, 219, 385, 36);
        contentPane.add(comboBox);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                JComboBox box = (JComboBox) actionEvent.getSource();
                chFont = (String) comboBox.getSelectedItem();
                f = new Font(chFont, Font.PLAIN, 18);
            }
        });

        JButton button_2 = new JButton("Отформатировать текст выбранным шрифтом");
        button_2.setBounds(646, 296, 470, 36);
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) { textArea.setFont(f); }
        });
        contentPane.add(button_2);

        JButton button_3 = new JButton("Отформатировать текст таблицы выбранным шрифтом");
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                table.setFont(f);
            }
        });
        button_3.setBounds(646, 362, 470, 36);
        contentPane.add(button_3);

        textField_7 = new JTextField();
        textField_7.setColumns(10);
        textField_7.setBounds(650, 434, 164, 46);
        contentPane.add(textField_7);

        label_7 = new JLabel("Номер элемента списка");
        label_7.setBounds(650, 410, 233, 15);
        contentPane.add(label_7);

        btnNewButton_1 = new JButton("Установить для элемента списка цвет фона");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    int num = Integer.parseInt(textField_7.getText());
                    Color tmp = JColorChooser.showDialog(null, "Choose text color", null);
                    color.replace(name_fonts[num-1], tmp);
                    render = new FontCellRenderer(fontsMap, color);
                    comboBox.setRenderer(render);
                }
                catch (Exception exc)
                {
                    JOptionPane.showMessageDialog(null, "Неверный номер шрифта\nВведите значение от 1 до " + (name_fonts.length -1));
                    exc.printStackTrace();
                }
            }
        });
        btnNewButton_1.setBounds(650, 492, 466, 36);
        contentPane.add(btnNewButton_1);

        textField_8 = new JTextField();
        textField_8.setColumns(10);
        textField_8.setBounds(650, 561, 164, 46);
        contentPane.add(textField_8);

        button_4 = new JButton("Отобразить названия файлов из выбранного каталога");
        button_4.setBounds(650, 628, 466, 36);
        contentPane.add(button_4);

        label_8 = new JLabel("Название каталога");
        label_8.setBounds(650, 540, 180, 15);
        contentPane.add(label_8);

        button_5 = new JButton("Загрузить файл");
        button_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        button_5.setBounds(650, 694, 466, 36);
        contentPane.add(button_5);
    }

    public void Remap(){
        Map<Object, Font> newMap = new HashMap<Object, Font>();
        Map<Object, Color> newColor = new HashMap<Object, Color>();
        for (int i=0; i< name_fonts.length-1; i++)
        {
            Font value=new Font(name_fonts[i],0,12);
            newMap.put(name_fonts[i],value);
            newColor.put(name_fonts[i], Color.white);
        }
        color = newColor;
        fontsMap=newMap;
    }

    private class FontCellRenderer implements ListCellRenderer {
        protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
        //карта шрифтов
        private Map<Object, Font> fonts = null;
        private Map<Object, Color> col = null;
        //конструктор с мапой
        public FontCellRenderer(Map<Object, Font> fonts, Map<Object, Color> col) {
            this.fonts = fonts;
            this.col = col;
        }

        //функция раскраски
        public Component getListCellRendererComponent(JList list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            //родительский
            JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
                    isSelected, cellHasFocus);
            Font newFontStyle=fonts.get(value);
            renderer.setFont(newFontStyle);
            Color newCol = col.get(value);
            renderer.setBackground(newCol);
            return renderer;
        }
    }

    public MyFrame() throws ClassNotFoundException {
        super("MyFrame");
        createGUI();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        MyFrame jFrame = new MyFrame();
        jFrame.setVisible(true);
    }
}
