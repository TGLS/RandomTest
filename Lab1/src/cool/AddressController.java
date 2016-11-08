package cool;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class AddressController {
	private GUI view;
	private AddressBook book;
	
	public AddressController(GUI view) {
		this.view = view;
		this.book = new AddressBook();
	}
	
	public void close() {
		System.exit(0);
	}
	
	public void newAddressBook() {
		getBook().removeAllBuddys();
		view.getSaveAddButton().setEnabled(true);
		view.getAddInfoButton().setEnabled(true);
	}
	
	public void saveAddressBook() {
		try {
			String fName = JOptionPane.showInputDialog("Enter File Name (No Extension)");
			BufferedWriter out = new BufferedWriter(new FileWriter(fName+".txt"));
			out.write(getBook().saveBook());
			out.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void addBuddy(String fName, String lName) {
		getBook().addBuddy(new BuddyInfo(fName, lName));
	}
	
	public void removeBuddy() {
		if (view.getListView().getSelectedValue() != null) {
			getBook().removeBuddy(view.getListView().getSelectedValue());
		}
	}
	
	public void changeFirst(String fName) {
		if (view.getListView().getSelectedValue() != null) {
			BuddyInfo newGuy = new BuddyInfo(view.getListView().getSelectedValue());
			newGuy.setFirstName(fName);
			getBook().addBuddy(newGuy);
			getBook().removeBuddy(view.getListView().getSelectedValue());
		}
	}
	
	public void changeLast(String lName) {
		if (view.getListView().getSelectedValue() != null) {
			BuddyInfo newGuy = new BuddyInfo(view.getListView().getSelectedValue());
			newGuy.setFirstName(lName);
			getBook().addBuddy(newGuy);
			getBook().removeBuddy(view.getListView().getSelectedValue());
		}
	}
	
	public void changeSelectionButtons() {
		boolean isNotNull = view.getListView().getSelectedValue() != null;
		for (JButton j : view.getNeedsSelectionButtons()) {
			j.setEnabled(isNotNull);
		}
	}

	public AddressBook getBook() {
		return book;
	}
}
