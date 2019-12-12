package myframe2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.beans.PropertyChangeListener;
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

public class framik2 {

	private JFrame frame;
	private final Action action = new SwingAction();

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
		
		JButton btnNewButton = new JButton("Создать и отобразить коллекцию");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnNewButton.setBounds(19, 16, 293, 29);
		btnNewButton.setActionCommand("B1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventFirstbutton(e, textArea_5);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Очистить коллекцию");
		btnNewButton_1.setBounds(19, 55, 293, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Vector");
		rdbtnNewRadioButton.setBounds(371, 83, 211, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("ArrayList");
		rdbtnNewRadioButton_1.setBounds(371, 128, 211, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("LinkedList");
		rdbtnNewRadioButton_2.setBounds(371, 178, 211, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("HasMap");
		rdbtnNewRadioButton_3.setBounds(371, 225, 221, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("TreeMap");
		rdbtnNewRadioButton_4.setForeground(UIManager.getColor("ComboBox.foreground"));
		rdbtnNewRadioButton_4.setBounds(371, 275, 211, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_4);
		
		JButton btnNewButton_2 = new JButton(" Вывести найденные элементы в виде строки");
		btnNewButton_2.setBounds(317, 333, 317, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Добавить элемент в коллекцию");
		btnNewButton_3.setBounds(371, 481, 247, 31);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Отобразить коллекцию");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		btnNewButton_4.setBounds(371, 515, 247, 29);
		frame.getContentPane().add(btnNewButton_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(19, 481, 293, 29);
		frame.getContentPane().add(comboBox);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setText("Значение добавляемого элемента");
		editorPane.setBounds(19, 515, 293, 29);
		frame.getContentPane().add(editorPane);
		
		JButton btnNewButton_5 = new JButton("Удалить элемент и отобразить коллекцию");
		btnNewButton_5.setBounds(285, 650, 333, 29);
		frame.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("Индекс удаляемого элемента:");
		lblNewLabel.setBounds(19, 655, 233, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Найти в коллекции все элементы указанного типа:");
		lblNewLabel_1.setBounds(19, 338, 293, 34);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(19, 384, 243, 45);
		frame.getContentPane().add(textArea_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(371, 366, 247, 63);
		frame.getContentPane().add(textArea);
		

		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(375, 708, 243, 63);
		frame.getContentPane().add(textArea_3);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
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
		
		
	}
	private void eventFirstbutton(ActionEvent e, JTextArea textArea_1)
	{
		JButton b = (JButton)e.getSource();
		if (b.getActionCommand() == "B1")
			textArea_1.append("Collection");
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
