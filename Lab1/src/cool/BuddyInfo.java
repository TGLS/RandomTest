package cool;

public class BuddyInfo {
	private String firstName;
	private String lastName;
	BuddyInfo() {
		firstName = new String();
		lastName = new String();
	}
	
	void setFirstName(String name) {
		firstName = name;
	}
	
	String getFirstName() {
		return firstName;
	}
	
	void setLastName(String name) {
		lastName = name;
	}
	
	String getLastName() {
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
		
		System.out.println("Hello "+book.getBuddy("Thompson").getFirstName());
	}

}
