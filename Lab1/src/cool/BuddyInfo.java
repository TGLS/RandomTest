package cool;

public class BuddyInfo {
	private String firstName;
	private String lastName;
	public BuddyInfo() {
		this(new String(), new String());
	}
	
	public BuddyInfo(String first, String last) {
		firstName = first;
		lastName = last;
	}
	
	public void setFirstName(String name) {
		firstName = name;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String name) {
		lastName = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public static void main(String[] args) {
		BuddyInfo info;
		AddressBook book = new AddressBook();
		info = new BuddyInfo();
		
		info.setFirstName("Thompson");
		info.setLastName("Stubbs");
		book.addBuddy(info);
		
		info.setFirstName("Dude");
		info.setLastName("Guy");
		book.addBuddy(info);
		
		info.setFirstName("A");
		info.setLastName("Change");
		book.addBuddy(info);
		
		System.out.println("Hello "+book.getBuddy("Thompson").getFirstName());
		System.out.println("Hello "+book.getBuddy("A").getFirstName());
	}

}
