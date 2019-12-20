package labika;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JRadioButton;

public class Laba2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	private JTable table_1;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Laba2 window = new Laba2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Laba2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("ToolTip.background"));
		frame.getContentPane().setForeground(UIManager.getColor("ToolBar.floatingForeground"));
		frame.setBounds(100, 100, 700, 1150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setBounds(28, 31, 130, 26);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(28, 85, 130, 26);
		textField_1.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Установить размер\nматрицы 1");
		btnNewButton.setBounds(388, 31, 292, 82);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSize(e, textField, textField_1);
			}

			
		});
		
		lblNewLabel = new JLabel("Количество строк в матрице 1");
		lblNewLabel.setBounds(28, 6, 340, 16);
		
		lblNewLabel_1 = new JLabel("Количество столбцов");
		lblNewLabel_1.setBounds(28, 63, 348, 16);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(textField_1);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(28, 171, 130, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(28, 238, 130, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Заполнить матрицу 1");
		btnNewButton_1.setBounds(388, 171, 292, 99);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel label = new JLabel("Начальное значение диапазона");
		label.setBounds(28, 143, 340, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Конечное значение диапазона");
		label_1.setBounds(28, 210, 340, 16);
		frame.getContentPane().add(label_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(28, 315, 130, 26);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(28, 382, 130, 26);
		frame.getContentPane().add(textField_5);
		
		JButton button = new JButton("Установить размер матрицы 2");
		button.setBounds(388, 315, 292, 99);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Очистить значения матрицы 2");
		button_1.setBounds(388, 896, 292, 99);
		frame.getContentPane().add(button_1);
		
		table = new JTable();
		table.setBounds(28, 721, 297, 163);
		frame.getContentPane().add(table);
		
		table_1 = new JTable();
		table_1.setBounds(388, 721, 292, 163);
		frame.getContentPane().add(table_1);
		
		JButton button_2 = new JButton("Отобразить матрицу 1");
		button_2.setBackground(new Color(144, 238, 144));
		button_2.setBounds(28, 598, 297, 99);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Заполнить матрицу 2");
		button_3.setBounds(388, 446, 292, 99);
		frame.getContentPane().add(button_3);
		
		JLabel label_2 = new JLabel("Количество строк в матрице 2");
		label_2.setBounds(28, 287, 340, 16);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Количество столбцов");
		label_3.setBounds(28, 354, 340, 16);
		frame.getContentPane().add(label_3);
		
		JButton button_4 = new JButton("Очистить значения матрицы 1");
		button_4.setBounds(28, 896, 292, 99);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("Выполнить выбранное действие");
		button_5.setBounds(388, 1006, 292, 99);
		frame.getContentPane().add(button_5);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Сложение матриц");
		rdbtnNewRadioButton.setBounds(28, 1007, 292, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Вычитание матриц");
		rdbtnNewRadioButton_1.setBounds(28, 1042, 292, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Умножение матриц");
		rdbtnNewRadioButton_2.setBounds(28, 1077, 292, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JButton button_6 = new JButton("Отобразить матрицу 2");
		button_6.setBounds(388, 598, 292, 99);
		frame.getContentPane().add(button_6);
		
		JLabel label_4 = new JLabel("Начальное значение диапазона");
		label_4.setBounds(28, 431, 340, 16);
		frame.getContentPane().add(label_4);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(28, 456, 130, 26);
		frame.getContentPane().add(textField_6);
		
		JLabel label_5 = new JLabel("Конечное значение диапазона");
		label_5.setBounds(28, 494, 340, 16);
		frame.getContentPane().add(label_5);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(28, 519, 130, 26);
		frame.getContentPane().add(textField_7);
	}
	//установка размера матрицы
	private void setSize(ActionEvent e, JTextField textField, JTextField textField_1) {
		try
		{
			int i = Integer.parseInt(textField.getText().trim());
			int j = Integer.parseInt(textField.getText().trim());
		}
		catch (NumberFormatException nfe)
		{
			JOptionPane.showMessageDialog(null, "Ошибка: неверный формат данных, введите число", "Ошибка", JOptionPane.INFORMATION_MESSAGE );
		}
		
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
