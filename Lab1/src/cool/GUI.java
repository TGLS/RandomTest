package cool;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.*;

public class GUI {
	private JFrame main;
	private JButton newAddButton;
	private JButton saveAddButton;
	private JButton addInfoButton;
	private ArrayList<JButton> needsSelectionButtons;
	private JButton removeInfoButton;
	private JButton changeFirstButton;
	private JButton changeLastButton;
	private JList<BuddyInfo> listView;
	private AddressController control;
	
	public GUI() {
		main = new JFrame();
		newAddButton = new JButton();
		saveAddButton = new JButton();
		addInfoButton = new JButton();
		needsSelectionButtons = new ArrayList<JButton>();
		removeInfoButton = new JButton();
		changeFirstButton = new JButton();
		changeLastButton = new JButton();
		control = new AddressController(this);
		getNeedsSelectionButtons().add(removeInfoButton);
		getNeedsSelectionButtons().add(changeFirstButton);
		getNeedsSelectionButtons().add(changeLastButton);
		listView = new JList<BuddyInfo>(control.getBook());
	}
	
	public void run() {
		main.setSize(640, 480);
		main.setTitle("Address Book");
		
		main.setLayout(new GridLayout(0,2));
		
		main.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				control.close();
			}
		});
		
		newAddButton.setText("New Address Book");
		newAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.newAddressBook();
			}
		});
		
		getSaveAddButton().setText("Save Address Book");
		getSaveAddButton().setEnabled(false);
		getSaveAddButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.saveAddressBook();
			}
		});
		
		getAddInfoButton().setText("Add Person");
		getAddInfoButton().setEnabled(false);
		getAddInfoButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fName = JOptionPane.showInputDialog("Enter First Name");
				String lName = JOptionPane.showInputDialog("Enter Last Name");
				control.addBuddy(fName, lName);
			}
		});
		
		removeInfoButton.setText("Remove Person");
		removeInfoButton.setEnabled(false);
		removeInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.removeBuddy();
			}
		});
		
		changeFirstButton.setText("Change First Name");
		changeFirstButton.setEnabled(false);
		changeFirstButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fName = (JOptionPane.showInputDialog("Enter New First Name"));
				control.changeFirst(fName);
			}
		});
		
		changeLastButton.setText("Change Last Name");
		changeLastButton.setEnabled(false);
		changeLastButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getListView().getSelectedValue() != null) {
					String lName = (JOptionPane.showInputDialog("Enter New Last Name"));
					control.changeFirst(lName);
				}
			}
		});
		
		getListView().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getListView().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				control.changeSelectionButtons();
			}
		});

		main.add(newAddButton);
		
		main.add(getSaveAddButton());
		
		main.add(getAddInfoButton());
		
		main.add(removeInfoButton);
		
		main.add(changeFirstButton);
		
		main.add(changeLastButton);
		
		main.add(getListView());
		
		main.setVisible(true);
	}

	public JList<BuddyInfo> getListView() {
		return listView;
	}

	public ArrayList<JButton> getNeedsSelectionButtons() {
		return needsSelectionButtons;
	}
	public JButton getSaveAddButton() {
		return saveAddButton;
	}

	public JButton getAddInfoButton() {
		return addInfoButton;
	}
}
