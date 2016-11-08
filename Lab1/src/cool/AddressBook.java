package cool;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

public class AddressBook extends AbstractListModel<BuddyInfo> {
	private List<BuddyInfo> people;
	
	public AddressBook() {
		super();
		people = new ArrayList<BuddyInfo>();
	}
	
	public void addBuddy(BuddyInfo guy) {
		if (people.add(guy)) {
			fireIntervalAdded(this, people.size(), people.size());
		}
	}
	
	public void removeBuddy(BuddyInfo guy) {
		int index = people.indexOf(guy);
		if (people.remove(guy)) {
			fireIntervalRemoved(this, index, index);
		}
	}
	
	public void removeAllBuddys() {
		int index = people.size() - 1;
		people.removeAll(people);
		if (index >= 0) {
			fireIntervalRemoved(this, 0, index);
		}
	}
	
	public String saveBook() {
		String retVal = new String();
		for (BuddyInfo b : people) {
			retVal += b.toString() + System.getProperty("line.separator");
		}
		return retVal;
	}

	@Override
	public BuddyInfo getElementAt(int arg0) {
		return people.get(arg0);
	}

	@Override
	public int getSize() {
		return people.size();
	}
}
