package cool;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
	private List<BuddyInfo> people;
	public AddressBook() {
		people = new ArrayList<BuddyInfo>();
	}
	
	public boolean addBuddy(BuddyInfo guy) {
		return people.add(guy);
	}
	
	public boolean removeBuddy(BuddyInfo guy) {
		return people.remove(guy);
	}
	
	public BuddyInfo getBuddy(String firstName) {
		//Editing on GITHub
		for (BuddyInfo b : people) {
			if (b.getFirstName().equals(firstName)) {
				return b;
			}
		}
		return null;
	}
}
