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
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
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
		
		String[] types = {"Integer","Float","Date","String"};
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
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(19, 366, 293, 75);
		frame.getContentPane().add(textArea_2);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(371, 366, 247, 63);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton_2 = new JButton("Вывести найденные элементы в виде списка");
		btnNewButton_2.setBounds(317, 333, 317, 29);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.setActionCommand("B7");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent p) {
				fifthButton(p, textArea, textArea_2);
			}
		});
		
		JButton btnNewButton_3 = new JButton("Добавить элемент в коллекцию");
		btnNewButton_3.setBounds(371, 481, 247, 31);
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.setActionCommand("B4");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent k) {
				Secondbutton(k, textArea_1, bg, comboBox, textField_1);
			}
		});
		
		
		
		JButton btnNewButton_4 = new JButton("Отобразить коллекцию");
		btnNewButton_4.setBounds(371, 515, 247, 29);
		frame.getContentPane().add(btnNewButton_4);
		btnNewButton_4.setActionCommand("B5");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent p) {
				Thirdbutton(p, textArea_1, bg, null, null);
			}
		});
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(375, 708, 243, 63);
		frame.getContentPane().add(textArea_3);
		
		JButton btnNewButton_5 = new JButton("Удалить элемент и отобразить коллекцию");
		btnNewButton_5.setBounds(285, 650, 333, 29);
		frame.getContentPane().add(btnNewButton_5);
		btnNewButton_5.setActionCommand("B6");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forthButton(e, textArea_5, textField_2);
				Thirdbutton(e, textArea_3, bg, null, null);
			}		
		});
		
		JLabel lblNewLabel = new JLabel("Индекс удаляемого элемента:");
		lblNewLabel.setBounds(19, 655, 233, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Найти в коллекции все элементы указанного типа:");
		lblNewLabel_1.setBounds(19, 338, 293, 34);
		frame.getContentPane().add(lblNewLabel_1);
		

		JLabel lblNewLabel_2 = new JLabel("Тип добавляемого элемента");
		lblNewLabel_2.setBounds(19, 453, 293, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel label = new JLabel("Тип создаваемой коллекции");
		label.setBounds(359, 21, 267, 29);
		frame.getContentPane().add(label);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setForeground(UIManager.getColor("Desktop.background"));
		horizontalBox.setBounds(265, 851, -261, -224);
		frame.getContentPane().add(horizontalBox);
		
		textField_1 = new JTextField();
		textField_1.setText("Значение добавляемого элемента");
		textField_1.setBounds(19, 518, 293, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(19, 683, 252, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Очистить коллекцию");
		btnNewButton_1.setBounds(19, 55, 293, 29);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setActionCommand("B2");
		
		
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (j != null)
				j.clear();
			if (j2 != null)
				j2.clear();
		}
	});
	}
	
	//Создание коллекций при нажатии первой кнопки и радиобаттон
	String k;//вид коллекции
	AbstractMap<Object, Object> j2;
	AbstractCollection<Object> j;
	

	private JTextField textField_2;
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
						textArea_1.setText(null);
						textArea_1.append(j.toString());
					}
					else
					{
						k = i.getText();
						j2 = createMap(i.getText());
						textArea_1.setText(null);
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
						textArea_1.setText(null);
						textArea_1.append(j.toString());
					}
					else
					{
						k = new String(i.getText());
						j2= createMap(i.getText());
						textArea_1.setText(null);
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
	
	//добавление
	private void Secondbutton(ActionEvent e, JTextArea textArea_1, ButtonGroup bg, JComboBox combobox, JTextField textField)
	{
		JButton b = (JButton)e.getSource();
		Object item = combobox.getSelectedItem();
		if (item.equals("Integer"))
		{
			try
			{
				int element = Integer.parseInt(textField.getText().trim());
				if (k.equals("HashMap") || k.equals("TreeMap"))
				{
					int ind = j2.size();
					j2.putIfAbsent((Object)ind, (Object)element);
				}
				else
					j.add((Object)element);
			
			}
			catch (NumberFormatException nfe)
			{
				System.out.println("NumberFormatException");
			}
		}
		if (item.equals("String"))
		{
	
				String element = textField.getText().trim();
				if (k.equals("HashMap") || k.equals("TreeMap"))
				{
					int ind = j2.size();
					j2.putIfAbsent((Object)ind, (Object)element);
				}
				else
					j.add((Object)element);
			
		}
		if (item.equals("Float"))
		{
			try
			{
				Float element = Float.parseFloat(textField.getText().trim());
				if (k.equals("HashMap") || k.equals("TreeMap"))
				{
					int ind = j2.size();
					j2.putIfAbsent((Object)ind, (Object)element);
				}
				else
					j.add((Object)element);
			
			}
			catch (Exception a)
			{
				System.out.println("Неверный формат");
			}
		}
		if (item.equals("Date"))
		{
			try
			{
				Date element = new Date(Integer.parseInt(textField.getText().trim()));
				if (k.equals("HashMap") || k.equals("TreeMap"))
				{
					int ind = j2.size();
					j2.putIfAbsent((Object)ind, (Object)element);
				}
				else
					j.add((Object)element);
			
			}
			catch (NumberFormatException nfe)
			{
				System.out.println("NumberFormatException");
			}
		}
	}
	//отображение
	private void Thirdbutton(ActionEvent e, JTextArea textArea_1, ButtonGroup bg, JComboBox combobox, JTextField textField)
	{
		if (k.equals("HashMap") || k.equals("TreeMap"))
		{
			textArea_1.setText(null);
			textArea_1.append(j2.toString());
		}
		else
		{
			textArea_1.setText(null);
			textArea_1.append(j.toString());
		}
	}
	//удаление
	private void forthButton(ActionEvent e, JTextArea textArea_5, JTextField textField_2)
	{
		try
		{
			int element = Integer.parseInt(textField_2.getText().trim());
			if (k.equals("HashMap") || k.equals("TreeMap"))
				j2.remove(element);
			else
			{
				Object[] k = j.toArray();
				j.remove(k[element]);
			}
		}
		catch (NumberFormatException nfe)
		{
			System.out.println("NumberFormatException");
		}
		
	}
	//выведение элементов указанного типа
	@SuppressWarnings("unlikely-arg-type")
	private void fifthButton(ActionEvent p, JTextArea textArea_1, JTextArea textArea_2) {
		Integer a = 7;
		Float  b = (float) 0.9;
		Date c = new Date(199991);
		String txt = textArea_2.getText();
		textArea_1.setText(null);
		Object[] lil;
		
			if (k.equals("HashMap") || k.equals("TreeMap"))
			{
				Collection<Object> castik =  j2.values();
				lil = castik.toArray();
			}
			else
			{
				lil = j.toArray();
			}
				for(int i = 0; i < lil.length; i++)
				{
					if (lil[i].getClass().equals(a.getClass()) && txt.equals("Integer"))
					{
						textArea_1.append(lil[i].toString());
						textArea_1.append(", ");
					}
					if (lil[i].getClass().equals(b.getClass()) && txt.equals("Float"))
					{
						textArea_1.append(lil[i].toString());
						textArea_1.append(", ");
					}
					if (lil[i].getClass().equals(c.getClass()) && txt.equals("Date"))
					{
						textArea_1.append(lil[i].toString());
						textArea_1.append(", ");
					}
					if (lil[i].getClass().equals(txt.getClass()) && txt.equals("String"))
					{
						textArea_1.append(lil[i].toString());
						textArea_1.append(", ");
					}
					if (txt.contentEquals("Object"))
					{
						textArea_1.append(lil[i].toString());
						textArea_1.append(", ");
					}
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
