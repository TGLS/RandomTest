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
		// TODO Auto-generated method stub
		BuddyInfo info = new BuddyInfo(); 
		info.setFirstName("Thompson");
		info.setLastName("Stubbs");
		System.out.println("Hello "+info.getFirstName());
	}

}
