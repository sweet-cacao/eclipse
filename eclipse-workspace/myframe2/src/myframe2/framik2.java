package myframe2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import java.beans.PropertyChangeListener;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.Vector;
import java.util.zip.Inflater;
import java.beans.PropertyChangeEvent;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextField;

public class framik2 {

	private JFrame frame;
	private final Action action = new SwingAction();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					framik2 window = new framik2();
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
	public framik2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		action.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		frame = new JFrame();
		frame.getContentPane().setForeground(UIManager.getColor("EditorPane.selectionBackground"));
		frame.getContentPane().setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		frame.setBounds(100, 100, 700, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(19, 87, 284, 211);
		frame.getContentPane().add(textArea_5);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(375, 555, 243, 72);
		frame.getContentPane().add(textArea_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Vector");
		rdbtnNewRadioButton.setBounds(371, 83, 211, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("ArrayList");
		rdbtnNewRadioButton_1.setBounds(371, 128, 211, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("LinkedList");
		rdbtnNewRadioButton_2.setBounds(371, 178, 211, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("HashMap");
		rdbtnNewRadioButton_3.setBounds(371, 225, 221, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("TreeMap");
		rdbtnNewRadioButton_4.setForeground(UIManager.getColor("ComboBox.foreground"));
		rdbtnNewRadioButton_4.setBounds(371, 275, 211, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_4);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_2);
		bg.add(rdbtnNewRadioButton_3);
		bg.add(rdbtnNewRadioButton_4);
		
		String[] types = {"Integer","Float","Date","Object","String"};
		JComboBox comboBox = new JComboBox(types);
		comboBox.setBounds(19, 481, 293, 29);
		frame.getContentPane().add(comboBox);
		
		//первая кнопка создания коллекции
		JButton btnNewButton = new JButton("Создать и отобразить коллекцию");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnNewButton.setBounds(19, 16, 293, 29);
		btnNewButton.setActionCommand("Кнопка1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventFirstbutton(e, textArea_5, bg, null, null);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Очистить коллекцию");
		btnNewButton_1.setBounds(19, 55, 293, 29);
		frame.getContentPane().add(btnNewButton_1);
	//	btnNewButton_1.setActionCommand("B2");
	//	btnNewButton.addActionListener(new ActionListener() {
	//		public void actionPerformed(ActionEvent e) {
	//			eventFirstbutton(e, textArea_5, bg, null, null);
	//		}
	//	});//edit
		
		
		JButton btnNewButton_2 = new JButton(" Вывести найденные элементы в виде строки");
		btnNewButton_2.setBounds(317, 333, 317, 29);
		frame.getContentPane().add(btnNewButton_2);
	//	btnNewButton.setActionCommand("B3");
	//	btnNewButton.addActionListener(new ActionListener() {
	//		public void actionPerformed(ActionEvent e) {
//				eventFirstbutton(e, textArea_5, bg, null, null);
	//		}
	//	});//edit
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(19, 384, 243, 45);
		frame.getContentPane().add(textArea_2);
		
		JButton btnNewButton_3 = new JButton("Добавить элемент в коллекцию");
		btnNewButton_3.setBounds(371, 481, 247, 31);
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.setActionCommand("B4");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent k) {
				Secondbutton(k, textArea_2, bg, comboBox, textField_1);
			}
		});//edit
		
		
		JButton btnNewButton_4 = new JButton("Отобразить коллекцию");
		btnNewButton_4.setBounds(371, 515, 247, 29);
		frame.getContentPane().add(btnNewButton_4);
		btnNewButton_4.setActionCommand("B5");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent p) {
				Thirdbutton(p, textArea_2, bg, null, null);
			}
		});//edit
		
		JButton btnNewButton_5 = new JButton("Удалить элемент и отобразить коллекцию");
		btnNewButton_5.setBounds(285, 650, 333, 29);
		frame.getContentPane().add(btnNewButton_5);
	//	btnNewButton.setActionCommand("B6");
	//	btnNewButton.addActionListener(new ActionListener() {
	//		public void actionPerformed(ActionEvent e) {
		//		eventFirstbutton(e, textArea_5, bg, null, null);
	//		}
	//	});
		
		JLabel lblNewLabel = new JLabel("Индекс удаляемого элемента:");
		lblNewLabel.setBounds(19, 655, 233, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Найти в коллекции все элементы указанного типа:");
		lblNewLabel_1.setBounds(19, 338, 293, 34);
		frame.getContentPane().add(lblNewLabel_1);
		

		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(371, 366, 247, 63);
		frame.getContentPane().add(textArea);
		

		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(375, 708, 243, 63);
		frame.getContentPane().add(textArea_3);
		
		JLabel lblNewLabel_2 = new JLabel("Тип добавляемого элемента");
		lblNewLabel_2.setBounds(19, 453, 293, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel label = new JLabel("Тип создаваемой коллекции");
		label.setBounds(359, 21, 267, 29);
		frame.getContentPane().add(label);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(9, 708, 243, 45);
		frame.getContentPane().add(textArea_4);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setForeground(UIManager.getColor("Desktop.background"));
		horizontalBox.setBounds(265, 851, -261, -224);
		frame.getContentPane().add(horizontalBox);
		
		textField_1 = new JTextField();
		textField_1.setText("Значение добавляемого элемента");
		textField_1.setBounds(19, 518, 293, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		
	}
	
	//Создание коллекций при нажатии первой кнопки и радиобаттон
	String k;//вид коллекции
	AbstractMap<Object, Object> j2;
	AbstractCollection<Object> j;
	private void eventFirstbutton(ActionEvent e, JTextArea textArea_1, ButtonGroup bg, JComboBox combobox, JTextField textField)
	{
		JButton b = (JButton)e.getSource();
		Enumeration<AbstractButton> a = bg.getElements();
		if (b.getActionCommand() == "Кнопка1")
		{
			AbstractButton i;
			for (i = a.nextElement(); a.hasMoreElements();)
			{
				if (i.isSelected())
				{
					if (i.getText().equals("ArrayList") || i.getText().equals("LinkedList") || i.getText().equals("Vector"))
					{
						k = i.getText();
						j= createCollection(i.getText());
						textArea_1.append(j.toString());
					}
					else
					{
						k = i.getText();
						j2 = createMap(i.getText());
						textArea_1.append(j2.toString());
					}
					break;
				}
				i = a.nextElement();
				if (i.isSelected())
				{
					if (i.getText().equals("ArrayList") || i.getText().equals("LinkedList") || i.getText().equals("Vector"))
					{
						k = i.getText();
						j= createCollection(i.getText());
						textArea_1.append(j.toString());
					}
					else
					{
						k = new String(i.getText());
						j2= createMap(i.getText());
						textArea_1.append(j2.toString());
					}
					break;
				}
			}
		}	
	}
	
	private <E, K> AbstractMap<E, K> createMap(String str)
	{
		AbstractMap<E, K> a;
		if(str.equals("HashMap"))
		{
			a = new HashMap<E, K>();
		}
		else 
		{
			a = new TreeMap<E, K>();
		}
		return (a);
	}

	private  <E> AbstractCollection<E> createCollection(String str)
	{
		AbstractCollection<E> a;
		if (str.equals("ArrayList"))
		{
			a = new ArrayList<E>();
		}
		else if(str.equals("Vector"))
		{
			a = new Vector<E>();
		}
		else
		{
			a = new LinkedList<E>();
		}
		return(a);
	}
	//окончание кода для создания коллекций
	
	private void Secondbutton(ActionEvent e, JTextArea textArea_1, ButtonGroup bg, JComboBox combobox, JTextField textField)
	{
		JButton b = (JButton)e.getSource();
		Object item = combobox.getSelectedItem();
		System.out.println(k);
		if (item.equals("Integer"))
		{
			try
			{
				int element = Integer.parseInt(textField.getText().trim());
				if (k.equals("HashMap") || k.equals("TreeMap"))
					j2.putIfAbsent((Object)element, (Object)element);
				else
					j.add((Object)element);
			
			}
			catch (NumberFormatException nfe)
			{
				System.out.println("NumberFormatException");
			}
		}
	}
	
	private void Thirdbutton(ActionEvent e, JTextArea textArea_1, ButtonGroup bg, JComboBox combobox, JTextField textField)
	{
		if (k.equals("HashMap") || k.equals("TreeMap"))
			textArea_1.append(j2.toString());
		else
			textArea_1.append(j.toString());
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
