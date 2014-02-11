package oving2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PersonPanel extends JPanel implements PropertyChangeListener, FocusListener{
	
	private JPanel panel;
	protected JTextField name;
	protected JTextField dateOfBirth;
	protected JTextField email;
	protected JSlider height;
	protected JComboBox gender;
	protected JLabel labelname, labelemail, labeldate, labelgender, labelheight;
	protected Person person;
	protected GridBagConstraints c; 
	
	public PersonPanel(){
		
		c = new GridBagConstraints();
		setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.HORIZONTAL;
		
		labelname = new JLabel("Name:");
		labelemail = new JLabel("Email:");
		labeldate = new JLabel("Birthday:");
		labelgender = new JLabel("Gender:");
		labelheight = new JLabel("Height:");
		
		c.gridx = 0; 
		c.gridy = 0; add(labelname,c);
		c.gridy = 1; add(labelemail,c);
		c.gridy = 2; add(labeldate,c);
		c.gridy = 3; add(labelgender,c);
		c.gridy = 4; add(labelheight,c);
		
		c.gridy = 0; c.gridx = 1;
		name = new JTextField();
		name.setColumns(25);
		name.setName("NamePropertyComponent");
		add(name,c);
		
		c.gridy = 1;
		email = new JTextField();
		email.setColumns(25);
		email.setName("EmailPropertyComponent");
		add(email,c);
		
		c.gridy = 2;
		dateOfBirth = new JTextField();
		dateOfBirth.setColumns(15);
		dateOfBirth.setName("DateOfBirthPropertyComponent");
		add(dateOfBirth,c);
		
		
		c.gridy = 3;
		gender = new JComboBox(Gender.values());
		gender.setName("GenderPropertyComponent");
		add(gender,c);
		
		c.gridy = 4;
		height = new JSlider(120,220,170);
		height.setMajorTickSpacing(10);
		height.setMinorTickSpacing(5);
		height.setPaintTicks(true);
		height.setPaintLabels(true);
		height.setName("HeightPropertyComponent");
		add(height,c);
		
		ActionListener action = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(person != null){
					person.setGender((Gender)gender.getSelectedItem());
				}
			}
		};
		
		
		
		name.addFocusListener(this);
		email.addFocusListener(this);
		dateOfBirth.addFocusListener(this);
		gender.addActionListener(action);
		height.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent arg0) {
				person.setHeight(height.getValue());
			}
		});
	}
	
	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		person.setName(name.getText());
		person.setDateOfBirth(dateOfBirth.getText());
        person.setEmail(email.getText());
		
	}

	public void setModel(Person person){
		if (this.person != null){
			this.person.removePropertyChangeListener(this);
		}
		this.person = person;
		if(this.person != null){
			this.person.addPropertyChangeListener(this);
		}
		update();
	}
	
	protected void update() {
		if(this.person != null){
			name.setText(person.getName());
			email.setText(person.getEmail());
			dateOfBirth.setText(person.getDateOfBirth());
			gender.setSelectedItem(person.getGender());
			height.setValue(person.getHeight());
		}
	}

	public Person getModel(){
		return person;
	}
	

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		update();
	}
	
	public static void main(String[] args){
		Person person1 = new Person("Alexander","03.01.92", "al@d.com", Gender.male, 182);
		final PersonPanel personPanel1 = new PersonPanel();
		final PassivePersonPanel personPanel2 = new PassivePersonPanel();
		personPanel1.setModel(person1);
		personPanel2.setModel(person1);
		
		JFrame frame = new JFrame("PersonPanel");
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2,1));
		centerPanel.add(personPanel1);
		centerPanel.add(personPanel2);
		frame.setContentPane(centerPanel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	


	
}

