package oving4;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Person {

	private String name, dateOfBirth, email;
	private Gender gender;
	private int height;
	
	public Person() {
		
	}
	
	public Person(String name){
		this.name = name;
	}
	
	public Person(String name, String dateOfBirth, String email, Gender gender, int height){
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.gender = gender;
		this.height = height;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		String oldName = this.name;
		this.name = name;
		pcs.firePropertyChange("name", oldName, name);
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String datoOfBirth) {
		String oldDate = this.dateOfBirth;
		this.dateOfBirth = datoOfBirth;
		pcs.firePropertyChange("dateOfBirth", oldDate, dateOfBirth);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		String oldEmail = this.email;
		this.email = email;
		pcs.firePropertyChange("email",oldEmail,email);
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		Gender oldGender = this.gender;
		this.gender = gender;
		pcs.firePropertyChange("gender", oldGender, this.gender);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		int oldHeight = this.height;
		this.height = height;
		pcs.firePropertyChange("height", oldHeight, this.height);
	}

	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	public void addPropertyChangeListener(PropertyChangeListener listener){
		pcs.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener){
		pcs.removePropertyChangeListener(listener);
	}
	
	
}
