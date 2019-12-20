package labka22;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollBar;


public class lele {
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
	private JTable table_2;
	private JTextField textField_6;
	private JTextField textField_7;
	Integer[][] matrix1;
	Integer[][] matrix2;
	int i;
	int j;
	int i1;
	int j2;
	private DefaultTableModel model;
	private DefaultTableModel model2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lele window = new lele();
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
	public lele() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("ToolTip.background"));
		frame.getContentPane().setForeground(UIManager.getColor("ToolBar.floatingForeground"));
		frame.setBounds(100, 100, 700, 1250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setBounds(28, 31, 130, 26);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(28, 85, 130, 26);
		textField_1.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Установить размер\nматрицы 1");
		btnNewButton.setBounds(388, 31, 292, 82);
		btnNewButton.setActionCommand("M1");
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
		btnNewButton_1.setActionCommand("Fill1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillMatrix(e, textField_2, textField_3);
			}
		});
		
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
		button.setActionCommand("M2");
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSize(e, textField_4, textField_5);
			}
		});
		
		JButton button_1 = new JButton("Очистить значения матрицы 2");
		button_1.setBounds(388, 896, 292, 99);
		frame.getContentPane().add(button_1);

		JButton button_2 = new JButton("Отобразить матрицу 1");
		button_2.setBackground(new Color(144, 238, 144));
		button_2.setBounds(28, 598, 297, 99);
		frame.getContentPane().add(button_2);
		button_2.setActionCommand("Show1");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMatrix(e);
			}

		});
		
		JButton button_3 = new JButton("Заполнить матрицу 2");
		button_3.setBounds(388, 446, 292, 99);
		frame.getContentPane().add(button_3);
		button_3.setActionCommand("Fill2");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillMatrix(e, textField_6, textField_7);
			}
		});
		
		JLabel label_2 = new JLabel("Количество строк в матрице 2");
		label_2.setBounds(28, 287, 340, 16);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Количество столбцов");
		label_3.setBounds(28, 354, 340, 16);
		frame.getContentPane().add(label_3);
		
		JButton button_4 = new JButton("Очистить значения матрицы 1");
		button_4.setBounds(28, 896, 292, 99);
		frame.getContentPane().add(button_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Сложение матриц");
		rdbtnNewRadioButton.setBounds(28, 1007, 292, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Вычитание матриц");
		rdbtnNewRadioButton_1.setBounds(28, 1042, 292, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Умножение матриц");
		rdbtnNewRadioButton_2.setBounds(28, 1077, 292, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_2);
		
		JButton button_5 = new JButton("Выполнить выбранное действие");
		button_5.setBounds(388, 1006, 292, 99);
		frame.getContentPane().add(button_5);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAction(e, bg);
			}
	
		});
		
		
		

		
		JButton button_6 = new JButton("Отобразить матрицу 2");
		button_6.setBounds(388, 598, 292, 99);
		frame.getContentPane().add(button_6);
		button_6.setActionCommand("Show2");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMatrix(e);
			}

		});
		
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
		

		
		JScrollPane scrollBar_1 = new JScrollPane(table_1);
		scrollBar_1.setBounds(665, 721, 15, 163);
		frame.getContentPane().add(scrollBar_1);
	}
	
	//установка размера матрицы
	private void setSize(ActionEvent e, JTextField textField, JTextField textField_1) {
		JButton b = (JButton)e.getSource();
		try
		{
			
			if (b.getActionCommand() == "M1")
			{
				i = Integer.parseInt(textField.getText().trim());
				j = Integer.parseInt(textField_1.getText().trim());
				textField.setText(null);
				textField_1.setText(null);
				matrix1 = new Integer[i][j];
			}
			else
			{
				i1 = Integer.parseInt(textField.getText().trim());
				j2 = Integer.parseInt(textField_1.getText().trim());
				textField.setText(null);
				textField_1.setText(null);
				matrix2 = new Integer[i1][j2];
			}
		}
		catch (NumberFormatException nfe)
		{
			JOptionPane.showMessageDialog(null, "Ошибка: неверный формат данных, введите число", "Ошибка", JOptionPane.INFORMATION_MESSAGE );
			textField.setText(null);
			textField_1.setText(null);
		}
	}
	
	private void fillMatrix(ActionEvent e, JTextField textField_2, JTextField textField_3)
	{
		JButton b = (JButton)e.getSource();
		try
		{
			int start = Integer.parseInt(textField_2.getText().trim());
			int end = Integer.parseInt(textField_3.getText().trim());
			int start1 = start;
			textField_2.setText(null);
			textField_3.setText(null);
			if (b.getActionCommand() == "Fill1")
			{
				for (int k = 0; k < i; k++)
				{
					for (int l = 0; l<j; l++)
					{
						if (start > end)
						{
							start = start1;
						}
						matrix1[k][l] = start;
						start++;
					}
				}
			}
			else
			{
				for (int k = 0; k < i1; k++)
				{
					for (int l = 0; l<j2; l++)
					{
						matrix2[k][l] = start;
						start++;
						if (start > end)
						{
							start = start1;
						}
					}
				}
			}
		}
		catch (NumberFormatException nfe)
		{
			JOptionPane.showMessageDialog(null, "Ошибка: неверный формат данных, введите число", "Ошибка", JOptionPane.INFORMATION_MESSAGE );
			textField.setText(null);
			textField_1.setText(null);
		}
	}
	

	private void showMatrix(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		if (b.getActionCommand() == "Show1")
		{
			Integer tmp = 0;
			Object[] columnsHeader = new String[j];
			for (Integer k = 0; k < j; k++)
			{
				tmp = k + 1;
				columnsHeader[k] = "Col " + tmp.toString();
			}
		//	System.out.println(columnsHeader[0]);
			model = new DefaultTableModel(matrix1, columnsHeader);
			table = new JTable(model);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			JScrollPane scrollBar = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//	table.setFillsViewportHeight(true);
			scrollBar.setBounds(28, 721, 297, 163);
			scrollBar.createHorizontalScrollBar();
		//	table.setAutoscrolls(true);
		//	frame.getContentPane().add(table);
		//	table.setShowHorizontalLines(true);
		//	table.setShowVerticalLines(true);
		//	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			//		scrollBar.setBounds(310, 721, 15, 163);
			frame.getContentPane().add(scrollBar);
			
			scrollBar.setVisible(true);
		}
		else
		{
			Integer tmp = 0;
			Object[] columnsHeader = new String[j2];
			for (Integer k = 0; k < j2; k++)
			{
				tmp = k + 1;
				columnsHeader[k] = "Col " + tmp.toString();
			}
		//	System.out.println(columnsHeader[0]);
			model = new DefaultTableModel(matrix2, columnsHeader);
			table_1 = new JTable(model);
			table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			JScrollPane scrollBar = new JScrollPane(table_1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//	table_1.setFillsViewportHeight(true);
			
			scrollBar.setBounds(388, 721, 292, 163);
		//	scrollBar.setAutoscrolls(true);
		//	table_1.setAutoscrolls(true);
		//	frame.getContentPane().add(table_1);
		//	table_1.setShowHorizontalLines(true);
		//	table_1.setShowVerticalLines(true);
		//	table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			//		scrollBar.setBounds(310, 721, 15, 163);
			frame.getContentPane().add(scrollBar);
			
			scrollBar.setVisible(true);
		}
	}
	
	public class JTableResult extends JFrame
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = -4645915377313025630L;

		public JTableResult() {
			super("ResultTable");
			Integer tmp = 0;
			Object[] columnsHeader = new String[j];
			for (Integer k = 0; k < j; k++)
			{
				tmp = k + 1;
				columnsHeader[k] = "Col " + tmp.toString();
			}
			model2 = new DefaultTableModel(res, columnsHeader);
			table_2 = new JTable(model2);
			table_2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
			Font font = new Font("Verdana", Font.PLAIN, 15);
			table_2.setFont(font);
			table_2.setRowHeight(30);
			table_2.setGridColor(Color.pink);
			table_2.setBackground(Color.magenta);
			table_2.setShowGrid(true);
			this.setLayout(new BorderLayout());
			
			JScrollPane scrollBar = new JScrollPane(table_2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//	scrollBar.createHorizontalScrollBar();
		//	table_2.setFillsViewportHeight(true);
			this.getContentPane().add(scrollBar);
			//table_2.setBounds(100,100,500,500);
		//	table_2.setAutoscrolls(true);
		//	this.getContentPane().add(table_2);
		//	table_2.setShowHorizontalLines(true);
		//	table_2.setShowVerticalLines(true);
			//table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			//		scrollBar.setBounds(310, 721, 15, 163);
			
		}
		
	}
	Integer[][] res;// = new Integer[i][j];
	private void doAction(ActionEvent e, ButtonGroup bg) {
		
		Enumeration<AbstractButton> a = bg.getElements();
		AbstractButton but;
		for (but = a.nextElement(); a.hasMoreElements();)
		{
				but = a.nextElement();
				if (but.isSelected() && (but.getText().equals("Сложение матриц") || but.getText().equals("Вычитание матриц")))
				{
					
					res = new Integer[i][j];
					if (i != i1 || j != j2)
					{
					//	JOptionPane.showMessageDialog(null, "Ошибка: Невозможно выполнить операцию сложения, так как у матриц разная размерность. Matrix1 : " + i + "x" + j + " Matrix2 : " + i1 + "x + j2", "Ошибка", JOptionPane.INFORMATION_MESSAGE );
						int reply = JOptionPane.showConfirmDialog(null, "Ошибка: Невозможно выполнить операцию сложения, так как у матриц разная размерность. Откорректировать?", "Error", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
						if (reply == JOptionPane.OK_OPTION)
						{
							matrix2 = new Integer[i][j];
							i1 = i;
							j2 = j;
							for (int k = 0; k < i; k++)
							{
								for (int l = 0; l<j; l++)
								{
									matrix2[k][l] = 0;
								}
							}
						}
					}
					for (int t = 0; t < i; t++)
					{
						for (int p = 0; p<j; p++)
						{
							if (but.getText().equals("Сложение матриц"))
							{
								res[t][p] = (Integer)matrix1[t][p] + (Integer)matrix2[t][p];
							}
							else
								res[t][p] = (Integer)matrix1[t][p] - (Integer)matrix2[t][p];
						}
					}
					JTableResult fer = new JTableResult();
					fer.setBounds(100, 100, 500, 500);
					fer.setVisible(true);
					
				}
				if (but.isSelected() && (but.getText().equals("Умножение матриц")))
				{
					if (j != i1)
					{
						int reply = JOptionPane.showConfirmDialog(null, "Ошибка: Невозможно выполнить операцию сложения, так как у матриц разная размерность. Откорректировать?", "Error", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
						if (reply == JOptionPane.OK_OPTION)
						{
							matrix2 = new Integer[j][j];
							i1 = j;
							j2 = j;
							for (int k = 0; k < j; k++)
							{
								for (int l = 0; l<j; l++)
								{
									matrix2[k][l] = 0;
								}
							}
						}
					}
					res = new Integer[i][j2];
					int op;
					Integer tmpval;
					for (int t = 0; t < i; t++)
					{
						for (int p = 0; p < j2; p++)
						{
							op = 0;
							res[t][p] = 0;
							while(op != j)
							{
								
								System.out.println((Integer)matrix1[t][op]);
								System.out.println((Integer)matrix2[op][p]);
								tmpval = (Integer)(matrix1[t][op] * matrix2[op][p]);
								System.out.println(tmpval);
								res[t][p] = (Integer)(res[t][p] + tmpval);
								System.out.println((Integer)res[t][p]);
								op++;
							}						
						}
					}
					JTableResult fer = new JTableResult();
					fer.setBounds(100, 100, 500, 500);
					fer.setVisible(true);
				}
					
		}
	}
}
