package laba3;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JTable;


public class laba3 {

	private JFrame frame;
	private JTable table;
	private ArrayList<Otrezok> dict = new ArrayList<Otrezok>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					laba3 window = new laba3();
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
	public laba3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 1300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Координаты отрезка:");
		lblNewLabel.setBounds(44, 28, 391, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("x");
		lblNewLabel_1.setBounds(44, 77, 66, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblY = new JLabel("y");
		lblY.setBounds(144, 77, 66, 15);
		frame.getContentPane().add(lblY);
		
		JLabel lblX = new JLabel("x");
		lblX.setBounds(244, 77, 66, 15);
		frame.getContentPane().add(lblX);
		
		JLabel lblY_1 = new JLabel("y");
		lblY_1.setBounds(350, 77, 66, 15);
		frame.getContentPane().add(lblY_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(44, 112, 66, 32);
		frame.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(144, 112, 66, 32);
		frame.getContentPane().add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(244, 112, 66, 32);
		frame.getContentPane().add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(350, 112, 66, 32);
		frame.getContentPane().add(textArea_3);
		
		table = new JTable(5, 4);
		table.setShowGrid(true);
		table.setGridColor(Color.black);
		table.setBounds(448, 22, 233, 139);
		frame.getContentPane().add(table);
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		
		JButton btnNewButton = new JButton("Добавить отрезок");
		btnNewButton.setBounds(44, 171, 391, 25);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLine(textArea, textArea_1, textArea_2, textArea_3, table, dtm);
			}


		});
		
		JButton btnNewButton_1 = new JButton("Удалить отрезок");
		btnNewButton_1.setBounds(44, 224, 391, 25);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteLine(textArea, textArea_1, textArea_2, textArea_3, table, dtm);
			}

			


		});
		
		JLabel label_3 = new JLabel("Верхний левый угол прямоугольной области:");
		label_3.setBounds(44, 274, 391, 15);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Нижний правый угол прямоугольной области:");
		label_4.setBounds(44, 380, 391, 15);
		frame.getContentPane().add(label_4);
		
		JLabel label = new JLabel("x");
		label.setBounds(44, 301, 66, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("y");
		label_1.setBounds(132, 301, 66, 15);
		frame.getContentPane().add(label_1);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(44, 325, 66, 32);
		frame.getContentPane().add(textArea_4);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(132, 328, 66, 32);
		frame.getContentPane().add(textArea_5);
		
		JLabel label_2 = new JLabel("x");
		label_2.setBounds(54, 408, 66, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_5 = new JLabel("y");
		label_5.setBounds(132, 408, 66, 15);
		frame.getContentPane().add(label_5);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setBounds(44, 435, 66, 32);
		frame.getContentPane().add(textArea_6);
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setBounds(132, 435, 66, 32);
		frame.getContentPane().add(textArea_7);
		
		JButton button = new JButton("Установить координаты прямокгольной области");
		button.setBounds(44, 497, 589, 25);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Отобразить отрезки и прямоугольную область");
		button_1.setBounds(44, 552, 589, 25);
		frame.getContentPane().add(button_1);
		
		Canvas canvas = new Canvas();
		canvas.setBounds(44, 603, 589, 303);
		frame.getContentPane().add(canvas);
		
		JButton button_2 = new JButton("Отобразить координаты отрезков, пересекающих прямоугольную область");
		button_2.setBounds(44, 929, 637, 25);
		frame.getContentPane().add(button_2);
		
		JTextArea textArea_8 = new JTextArea();
		textArea_8.setBounds(54, 966, 627, 66);
		frame.getContentPane().add(textArea_8);
		
		
	}
	
	private void addLine(JTextArea a, JTextArea b, JTextArea c, JTextArea d, JTable table, DefaultTableModel dtm) {
		try
		{
			Otrezok k = new Otrezok();
			k.x = Integer.parseInt(a.getText().trim());
			k.y = Integer.parseInt(b.getText().trim());
			k.x1 = Integer.parseInt(c.getText().trim());
			k.y1 = Integer.parseInt(d.getText().trim());
			dict.add(k);
			Vector <String> v = new Vector<String>();
			v.add(a.getText().trim());
			v.add(b.getText().trim());
			v.add(c.getText().trim());
			v.add(d.getText().trim());
			a.setText(null);
			b.setText(null);
			c.setText(null);
			d.setText(null);
			dtm.insertRow((dict.size()-1), v);
		}
		catch (Exception exc)
		{
			JOptionPane.showMessageDialog(null, "Ошибка: неверный формат данных, введите число", "Ошибка", JOptionPane.INFORMATION_MESSAGE );
			a.setText(null);
			b.setText(null);
			c.setText(null);
			d.setText(null);
		}
	}
	
	private void deleteLine(JTextArea a, JTextArea b, JTextArea c, JTextArea d, JTable table, DefaultTableModel dtm) {
		try {
			Otrezok k = new Otrezok();
				k.x = Integer.parseInt(a.getText().trim());
				k.y = Integer.parseInt(b.getText().trim());
				k.x1 = Integer.parseInt(c.getText().trim());
				k.y1 = Integer.parseInt(d.getText().trim());
			
			a.setText(null);
			b.setText(null);
			c.setText(null);
			d.setText(null);
			for (int i = 0; i < dict.size(); i++)
			{
				System.out.print(k.x);
				if (dict.get(i).equals(k))
				{
					System.out.print("here");
					dict.remove(i);
					dtm.removeRow(i);
					return;
				}
			}//подумать будет ли удвленный индекс влиять на номер строки
			
		}
		catch (Exception exc)
		{
			JOptionPane.showMessageDialog(null, "Ошибка: неверный формат данных, введите число", "Ошибка", JOptionPane.INFORMATION_MESSAGE );
			a.setText(null);
			b.setText(null);
			c.setText(null);
			d.setText(null);
		}
	}
}
