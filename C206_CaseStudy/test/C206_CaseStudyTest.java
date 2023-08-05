import static org.junit.Assert.*;

import org.junit.*;

import java.util.ArrayList;
import java.util.Currency;

public class C206_CaseStudyTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before C206_CaseStudyTest class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("before");
	}

	@Test
	public void testValidUserManagement() {
		UserManagement userManagementObject = new UserManagement();
		boolean result = userManagementObject.AddUser("JohnDoe123", "Johnpassword", "johndoe@example.com", "John", "Doe", "12345678");
		assertTrue(result);
	}
	
	@Test
	public void testInvalidEmail() {
		UserManagement userManagementObject = new UserManagement();
		boolean result = userManagementObject.AddUser("JohnDoe123", "Johnpassword", "invalidemail", "John", "Doe", "12345678");
		assertFalse(result);
	
}

	@Test
	public void testAddUser() {
		//fail ("Not yet implemented");
		// User list is not null and it is empty
		assertNotNull("Test if there is valid User arrayList to add to", UserList);
		assertEquals("Test  that the User arrayList is empty.", 0, UserList.size());
		//Given an empty list, after adding 1 item, the size of the list is 1
		UserManagement.AddUser(UserList, UL1);
		assertEquals("Test that the UserList size is 1.", 1, UserList.size());
		
		//Add a new user
		UserManagement.AddUser(UserList, UL2);
		assertEquals("Test that the UserList size is now 2.", 2, UserList.size());
		//The item just added is as same as the last item in the list
		assertSame("Test that UserList is added to the end of the list.", UL2, UserList.get(1));
		
		//
		Ul3.setIsAvailable(false);
		UserManagement.AddUser(UserList, UL3);
		assertEquals("Test that UserList size  is 2.", 3, UserList.get());
		assertFalse("Test that the last item in the arraylist is not available", UserList.get(2).getIsAvailable());
		
	}
	
	@Test
	public void testDeleteUser() {
		//fail ("Not yet implemented");
	
	}


	
	@After
	public void tearDown() throws Exception {
		System.out.println("afters");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after C206_CaseStudyTest class");
	}

}


	