import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author osamabuhamad
 *
 */
public class BuddyInfoTest {
	
	private BuddyInfo nullbuddy;
	private BuddyInfo buddy1;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		nullbuddy = null;
		buddy1 = new BuddyInfo("Osama", "123 LA", "342343",25);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNullBuddy() {
		assertEquals(null,nullbuddy);
	}
	
	@Test
	public void testGetName() {
		assertEquals("Osama",buddy1.getName());
	}

	@Test
	public void testGetAddress() {
		assertEquals("123 LA",buddy1.getAddress());
	}
	
	@Test
	public void testGetNumber() {
		assertEquals("342343",buddy1.getNumber());
	}
	
	@Test
	public void testSetName() {
		buddy1.setName("Obama");
		assertEquals("Obama",buddy1.getName());
	}
	
	@Test
	public void testSetAddress() {
		buddy1.setAddress("333 Ny");
		assertEquals("333 Ny",buddy1.getAddress());
	}
	
	@Test
	public void testSetNumber() {
		buddy1.setNumber("123456");
		assertEquals("123456",buddy1.getNumber());
	}
	
	@Test
	public void testGetAge() {
		assertEquals(25,buddy1.getAge());
	}
	
	@Test
	public void testSetAge() {
		buddy1.setAge(10);
		assertEquals(10,buddy1.getAge());
	}
	
	@Test
	public void testIsOver18() {
		assertTrue(buddy1.isOver18());
	}
	
	@Test
	public void testGreeting() {
		String greetMessage = "Hi from Leo";
		buddy1 = new BuddyInfo("Leo", "123 LA", "342343",25);
		assertEquals(greetMessage,buddy1.greeting());
	}
	
	@Test
	public void testCopy(){
		buddy1 = new BuddyInfo("Leo", "123 LA", "342343",25);
		BuddyInfo buddy2 = new BuddyInfo(buddy1);
		assertEquals(buddy2.getName(),buddy1.getName()); 
		assertEquals(buddy2.getAddress(),buddy1.getAddress()); 
		assertEquals(buddy2.getNumber(),buddy1.getNumber()); 
		assertEquals(buddy2.getAge(),buddy1.getAge()); 
		
	}
	
	
	
	
	
	
}
