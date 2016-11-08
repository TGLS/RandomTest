package cool;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AddressBookTest {
	private AddressBook book = null;
	@Before
	public void setUp() throws Exception {
		book = new AddressBook();
	}

	@Test
	public void testGetSize() {
		//Test empty book
		assertTrue(book.getSize() == 0);
		//Add somebody
		book.addBuddy(new BuddyInfo());
		//Test count 1 book
		assertTrue(book.getSize() == 1);
		//Add somebody
		book.addBuddy(new BuddyInfo());
		//Test count 2 book
		assertTrue(book.getSize() == 2);
	}
	
	@Test
	public void testRemoveAllBuddys() {
		//Book must not be empty
		//Add somebody
		book.addBuddy(new BuddyInfo());
		//Add somebody
		book.addBuddy(new BuddyInfo());
		assertTrue(book.getSize() == 2);
		//Empty it
		book.removeAllBuddys();
		//Test empty book
		assertTrue(book.getSize() == 0);
	}

	
	@Test
	public void testRemoveBuddy() {
		BuddyInfo mario = new BuddyInfo("Mario","Mario");
		BuddyInfo luigi = new BuddyInfo("Luigi","Mario");
		BuddyInfo wario = new BuddyInfo("Wario","Mario");
		//Add mario and luigi then test size
		book.addBuddy(mario);
		book.addBuddy(luigi);
		//Test size
		assertTrue(book.getSize() == 2);
		//Remove mario.
		book.removeBuddy(mario);
		//Test size
		assertTrue(book.getSize() == 1);
		//Remove wario
		book.removeBuddy(wario);
		//Test size
		assertTrue(book.getSize() == 1);
	}

	@Test
	public void testGetElementAt() {
		int exceptionFlg = 0;
		BuddyInfo mario = new BuddyInfo("Mario","Mario");
		BuddyInfo luigi = new BuddyInfo("Luigi","Mario");
		//Add mario then check index 0
		book.addBuddy(mario);
		
		assertTrue(book.getElementAt(0) == mario);
		//Add luigi then check index 0 and 1
		book.addBuddy(luigi);
		assertTrue(book.getElementAt(0) == mario);
		assertTrue(book.getElementAt(1) == luigi);
		//Remove mario then check index 0
		book.removeBuddy(mario);
		assertTrue(book.getElementAt(0) == luigi);
		//Add mario then check index 0 and 1
		book.addBuddy(mario);
		assertTrue(book.getElementAt(0) == luigi);
		assertTrue(book.getElementAt(1) == mario);
		//Check index 7, if exception increment exceptionFlg
		try {
			book.getElementAt(7);
		} catch (Exception e) {
			exceptionFlg++;
		}
		assertTrue(exceptionFlg == 1);
		
		//Remove everyone and check index 0, if exception increment exceptionFlg
		book.removeAllBuddys();
		try {
			book.getElementAt(0);
		} catch (Exception e) {
			exceptionFlg++;
		}
		assertTrue(exceptionFlg == 2);
	}
	
	@Test
	public void testSaveBook() {
		BuddyInfo mario = new BuddyInfo("Mario","Mario");
		BuddyInfo luigi = new BuddyInfo("Luigi","Mario");
		//Generate fake saved book.
		String fake = mario.toString() + System.getProperty("line.separator") + luigi.toString() + System.getProperty("line.separator");
		//Add entries to book and compare
		book.addBuddy(mario);
		book.addBuddy(luigi);
		assertTrue(fake.compareTo(book.saveBook()) == 0);
	}
}
