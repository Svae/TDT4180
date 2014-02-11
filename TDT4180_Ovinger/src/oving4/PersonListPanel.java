package oving4;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PersonListPanel extends JPanel implements ListSelectionListener{
	
	JList<Person> personlist;
	PersonPanel personPanel;
	DefaultListModel<Person> listmodel = new DefaultListModel<Person>();
	private JButton newPerson, deletePerson;
	
	
	
	public PersonListPanel(){
		
		//Person p1 = new Person("Alexander", "03.01.92", "Alexandersvae@gmail.com", Gender.male, 193);
	//	Person p2 = new Person("Jon");
	//	Person p3 = new Person("Kari");
	//	p3.setGender(Gender.female);
		makeLayout();
		addListeners();
		//listmodel.addElement(p1);
		//listmodel.addElement(p2);
		//listmodel.addElement(p3);		
		
	}
	
	
	private void makeLayout(){
		
		setLayout(new GridBagLayout());
		
		newPerson = new JButton("Add");
		newPerson.setName("NewPersonButton");
		
		deletePerson = new JButton("Delete");
		deletePerson.setName("DeletePersonButton");
		
		personPanel = new PersonPanel();
		personPanel.setName("PersonPanel");
		
		personlist = new JList<Person>(listmodel);
		personlist.setName("PersonList");
		

		personlist.addListSelectionListener(this);
		personlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		personlist.setCellRenderer(new PersonRender());
		personlist.setFixedCellHeight(25);
		
		JScrollPane myJScrollPane = new JScrollPane(personlist); 
		myJScrollPane.setVerticalScrollBarPolicy( 
		 JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		add(myJScrollPane); 
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0; c.gridy = 0; c.anchor = GridBagConstraints.NORTHWEST; 
		c.ipadx = 10; add(personlist,c);
		c.gridx = 1; add(personPanel,c);
		c.gridy = 1; c.gridx = 0; c.anchor = GridBagConstraints.WEST; add(newPerson,c); 
		c.anchor = GridBagConstraints.EAST; add(deletePerson,c);
		
		
		
	}
	
	private void addListeners() {
		newPerson.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listmodel != null){
					listmodel.addElement(new Person());
					personlist.setSelectedIndex(listmodel.size() - 1);
				}
			}
		});
		
		deletePerson.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					try{
						listmodel.remove(personlist.getSelectedIndex());
					} catch(Exception e1){
						listmodel.remove(0);
					}
				} catch (Exception e2) {
					System.err.println("No person to remove");
				}
				
				}				
			});
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new PersonListPanel());
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		personPanel.setModel(personlist.getSelectedValue());
		
	}
	

}
