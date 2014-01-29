package oving1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;


public class ButtonsNText extends JPanel{
	
	private JPanel panel;
	private ButtonGroup buttons;
	
	private JTextField textLine;
	private JToggleButton upperBtn, lowerBtn;
	private JCheckBox contBtn;
	
	public ButtonsNText(){
		panel = new JPanel();
		add(panel);
		
		textLine = new JTextField();
		textLine.setColumns(20);
		textLine.addKeyListener(new MyKeyAction());
		textLine.setName("TextLine");
		panel.add(textLine);
		
		buttons = new ButtonGroup();
		
		upperBtn = new JToggleButton("Upper case");
		upperBtn.addActionListener(new UpperCaseButtonAction());
		upperBtn.setName("UpperCaseButton");
		buttons.add(upperBtn);
		
		lowerBtn = new JToggleButton("Lower case");
		lowerBtn.addActionListener(new LowerCaseButtonAction());
		lowerBtn.setName("LowerCaseButton");
		buttons.add(lowerBtn);
		
		panel.add(upperBtn);
		panel.add(lowerBtn);
		
		contBtn = new JCheckBox("Continous?");
		contBtn.setName("ContinuousButton");
		panel.add(contBtn);
		
	}
	
	public void keyAction(){
		if(upperBtn.isSelected()){
			textLine.setText(textLine.getText().toUpperCase());
		} else if (lowerBtn.isSelected()){
			textLine.setText(textLine.getText().toLowerCase());
		}
	}
	
	class UpperCaseButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			textLine.setText(textLine.getText().toUpperCase());
		}
	}
	
	class LowerCaseButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			textLine.setText(textLine.getText().toLowerCase());
		}
	}
	
	class MyKeyAction implements KeyListener {
		public void keyPressed(KeyEvent e){
			int pos =textLine.getCaretPosition();
			if(e.getKeyCode() == e.VK_ENTER){
				keyAction();
			}
			textLine.setCaretPosition(pos);
		}
		
		public void keyReleased(KeyEvent e){
			int pos =textLine.getCaretPosition();
			if(contBtn.isSelected()){
				keyAction();
			}
			textLine.setCaretPosition(pos);
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public static void main (String[] args){
		JFrame frame = new JFrame("ButtonsNText");
		frame.getContentPane().add(new ButtonsNText());
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}

