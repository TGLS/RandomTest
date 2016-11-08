package cool;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BuddyInfoTest {
	private BuddyInfo testBuddy = null;
	
	@Before
	public void setUp() {
		testBuddy = new BuddyInfo();
	}
	
	@Test
	public void testDefaultValues() {
		assertTrue(testBuddy.getFirstName().compareTo(new String()) == 0);
		assertTrue(testBuddy.getLastName().compareTo(new String()) == 0);
		assertTrue(testBuddy.getAge() == 0);
	}

	@Test
	public void testSetters() {
		String newVal = new String("Go!");
		String otherVal = new String("Boom!");
		int number = 27;
		testBuddy.setFirstName(newVal);
		testBuddy.setLastName(otherVal);
		testBuddy.setAge(number);
		assertTrue(testBuddy.getFirstName().compareTo(newVal) == 0);
		assertTrue(testBuddy.getLastName().compareTo(otherVal) == 0);
		assertTrue(testBuddy.getAge() == number);
		assertTrue(testBuddy.isOver18());
	}

	@Test
	public void testCopyConstructor() {
		BuddyInfo copy = new BuddyInfo(testBuddy);
		assertTrue(testBuddy.getFirstName().compareTo(copy.getFirstName()) == 0);
		assertTrue(testBuddy.getLastName().compareTo(copy.getLastName()) == 0);
		assertTrue(testBuddy.getAge() == copy.getAge());
	}

	@Test
	public void testToString() {
		assertTrue(testBuddy.toString().compareTo(testBuddy.getFirstName() + " " + testBuddy.getLastName()) == 0);
	}
	
	@Test
	public void testGreeting() {
		assertTrue(testBuddy.greeting().compareTo("Hello, " + testBuddy.getFirstName()) == 0);
	}
	
	@Test
	public void testOver18() {
		testBuddy.setAge(27);
		assertTrue(testBuddy.isOver18());
		testBuddy.setAge(17);
		assertFalse(testBuddy.isOver18());
		testBuddy.setAge(18);
		assertFalse(testBuddy.isOver18());
	}

	@Test
	public void testRegConstructor() {
		BuddyInfo newBuddy = new BuddyInfo("60","4");
		assertTrue(newBuddy.getFirstName().compareTo("60") == 0);
		assertTrue(newBuddy.getLastName().compareTo("4") == 0);
		assertTrue(newBuddy.getAge() == 0);
	}
}
