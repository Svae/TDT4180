package oving4;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class PersonRender extends DefaultListCellRenderer{


	@Override
	public Component getListCellRendererComponent(JList list, Object model, int index, boolean isSelected, boolean hasFocus) {
		Person person = (Person) model;
		JLabel label = new JLabel();
		if(person.getName()!= null && person.getName() != ""){
			label.setText(person.getName() + (person.getEmail() != null  ? ": " + person.getEmail():""));
		} else {
			label.setText("Ny person");
		}
		if (person.getGender() != null){
			label.setIcon(new ImageIcon(getClass().getResource(person.getGender()+".gif")));
		}
		return label;
	}
}
