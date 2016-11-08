package cool;

public class BuddyInfo {
	private String firstName;
	private String lastName;
	private int age;
	public BuddyInfo() {
		this(new String(), new String());
	}
	
	public BuddyInfo(BuddyInfo old) {
		this(old.firstName, old.lastName);
		this.setAge(old.getAge());
	}
	
	public BuddyInfo(String first, String last) {
		firstName = first;
		lastName = last;
		setAge(0);
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
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean isOver18() {
		return (age > 18);
	}

	@Override
	public String toString() {
		return (firstName + " " + lastName);
	}
	
	public String greeting() {
		return ("Hello, " + firstName);
	}
	
	public static void main(String[] args) {
		new GUI().run();
	}

}
