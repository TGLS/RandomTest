package cool;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;


public class AddressBook extends AbstractListModel<BuddyInfo> implements Serializable {
	private static final long serialVersionUID = -8033956006058457305L;
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

	public void exporter(String fName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fName));
			out.write(saveBook());
			out.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void importer(String fName) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(fName));
			BuddyInfo guy;
			String buffer;
			while (true) {
				buffer = in.readLine();
				if (buffer == null) {
					break;
				}
				guy = BuddyInfo.importer(buffer);
				if (guy != null) {
					this.addBuddy(guy);
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void streamExporter(String fName) {
		try {
			FileOutputStream fos = new FileOutputStream(fName);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(this);
			out.close();
			fos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static AddressBook streamImporter(String fName) {
		AddressBook retVal = null;
		try {
			FileInputStream fis = new FileInputStream(fName);
			ObjectInputStream in = new ObjectInputStream(fis);
			retVal = (AddressBook) in.readObject();
			in.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e1) {
			e1.printStackTrace();
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
