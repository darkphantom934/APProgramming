package com.restifo.StyleOptions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StyleOptionsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel saying;
	private JCheckBox bold, italic;
	private JTextField lmao;
	public StyleOptionsPanel()
	{
		saying = new JLabel("Say it with style!");
		saying.setFont(new Font("Helvetica", Font.PLAIN, 36));
		
		bold = new JCheckBox("Bold");
		bold.setBackground(Color.cyan);
		
		italic = new JCheckBox("Italic");
		italic.setBackground(Color.pink);
		
		lmao = new JTextField(3);
		
		StyleListener listener = new StyleListener();
		bold.addItemListener(listener);
		italic.addItemListener(listener);
		
		add(saying);
		add(bold);
		add(italic);
		add(lmao);
		
		setBackground(Color.cyan);
		setPreferredSize(new Dimension(300, 100));
	}
	
	private class StyleListener implements ItemListener {
		public void itemStateChanged(ItemEvent arg0) 
		{
			int style = Font.PLAIN;
			if (bold.isSelected()) 	 style = Font.BOLD;
			if (italic.isSelected()) style += Font.ITALIC;
			saying.setFont(new Font("Helvetica", style, Integer.parseInt(lmao.getText())));
		}
	}
}