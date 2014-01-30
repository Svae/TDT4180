package oving2;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.event.FocusEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PassivePersonPanel extends PersonPanel {
	
	private JTextField genderText, heightText;
	
	public PassivePersonPanel(){

		this.remove(height);
		this.remove(gender);
		genderText = new JTextField(25);
		heightText = new JTextField(25);
		add(heightText,c);
		c.gridy = 3; add(genderText,c);
		
		for (Component comp : getComponents()){
			if(comp instanceof JTextField)
				((JTextField) comp).setEditable(false);
		}
		
		update();
	}
	
	@Override
	public void focusLost(FocusEvent arg0) {
		
	}
	
	@Override
	public void update(){
		if(this.person != null){
			name.setText(person.getName());
			email.setText(person.getEmail());
			dateOfBirth.setText(person.getDateOfBirth());
			heightText.setText(Integer.toString(person.getHeight()));
			if (person.getGender() != null){
				genderText.setText(person.getGender().toString());
			}
		}
	}

}
