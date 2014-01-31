package oving4;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PersonListPanel extends JPanel implements ListSelectionListener, ListCellRenderer {
	
	JList<Person> personlist;
	PersonPanel personPanel;
	DefaultListModel<Person> listmodel = new DefaultListModel<Person>();
	
	
	
	public PersonListPanel(){
		
		Person p1 = new Person("Per");
		Person p2 = new Person("Jon");
		Person p3 = new Person("Kari");
		
		personPanel = new PersonPanel();
		personPanel.setName("PersonPanel");
		
		personlist = new JList<Person>(listmodel);
		personlist.setName("PersonList");
		

		personlist.addListSelectionListener(this);
		personlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		this.setLayout(new GridLayout(1,2));
		
		add(personPanel);
		add(personlist);
		
		listmodel.addElement(p1);
		listmodel.addElement(p2);
		listmodel.addElement(p3);
		JScrollPane myJScrollPane = new JScrollPane(personlist); 
		myJScrollPane.setVerticalScrollBarPolicy( 
		 JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		add(myJScrollPane); 
		
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

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		Person model = (Person) value;
		JLabel label = new JLabel(model.getName());
		return label;
		
	}
	
	

}
