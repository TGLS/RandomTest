package cool;

import java.io.Serializable;
import java.util.Scanner;

public class BuddyInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4524399552824098570L;
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
		return (firstName + ";" + lastName + ";" + age);
	}
	
	public String greeting() {
		return ("Hello, " + firstName);
	}
	
	public static void main(String[] args) {
		AddressBook book = new AddressBook();
		BuddyInfo guy = new BuddyInfo("Some","Guy");
		guy.setAge(28);
		book.addBuddy(guy);
		guy = new BuddyInfo("Other","Guy");
		guy.setAge(18);
		book.addBuddy(guy);
		guy = new BuddyInfo("Some","Dude");
		guy.setAge(35);
		book.addBuddy(guy);
		guy = new BuddyInfo("Random","Dude");
		guy.setAge(32);
		book.addBuddy(guy);
		//book.exporter("things.txt");
		System.out.println(book.getSize());
		book = new AddressBook();
		book.importer("things.txt");
		System.out.println(book.getSize());
	}

	public static BuddyInfo importer(String input) {
		BuddyInfo retVal = new BuddyInfo();
		String firstBuffer, lastBuffer, ageBuffer;
		Scanner tokenizer = new Scanner(input).useDelimiter(";");
		if (!tokenizer.hasNext()) {
			return null;
		}
		firstBuffer = tokenizer.next();
		retVal.setFirstName(firstBuffer);
		if (!tokenizer.hasNext()) {
			return null;
		}
		lastBuffer = tokenizer.next();
		retVal.setLastName(lastBuffer);
		if (!tokenizer.hasNext()) {
			return null;
		}
		ageBuffer = tokenizer.next();
		retVal.setAge(Integer.parseInt(ageBuffer));
		return retVal;
	}
}
