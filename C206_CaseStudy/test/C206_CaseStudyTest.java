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
	public void testValidAddUser() {
		UserManagement userManagementObject = new UserManagement();
		userManagementObject.setUsername("JohnDoe123");
		userManagementObject.setPassword("Johnpassword");
		userManagementObject.setEmail("johndoe@example.com");
		userManagementObject.setFirstName("John");
		userManagementObject.setLastName("Doe");
		userManagementObject.setphoneNumber("12345678");
		int UserListSizeBeforeAdd = UserManagement.getUserListSize();

		UserManagement.AddUser(userManagementObject);
		assertEquals(UserListSizeBeforeAdd+1, UserManagement.getUserListSize());
	}

	@Test
	public void testInvalidAddUser() {
		UserManagement userManagementObject = new UserManagement();
		userManagementObject.setUsername("JohnDoe123");
		userManagementObject.setPassword("Johnpassword");
		userManagementObject.setEmail("johndoe");
		userManagementObject.setFirstName("John");
		userManagementObject.setLastName("Doe");
		userManagementObject.setphoneNumber("12345678");

		UserManagement.AddUser(userManagementObject);
		boolean result  ;
		if (UserManagement.getUserListSize() ==1) {
			result = true;
		}
		else {
			result = false;
		}
				assertFalse(result);
	}

	@Test
	public void testDeleteUser () {
		UserManagement userManagementObject = new UserManagement();
		userManagementObject.setUsername("JohnDoe123");
		userManagementObject.setPassword("Johnpassword");
		userManagementObject.setEmail("johndoe@gmail.com");
		userManagementObject.setFirstName("John");
		userManagementObject.setLastName("Doe");
		userManagementObject.setphoneNumber("12345678");

		UserManagement.AddUser(userManagementObject);
		int UserListSizeBeforeDelete =  UserManagement.getUserListSize();
		UserManagement.DeleteUser(userManagementObject.getUsername());

		assertEquals(UserListSizeBeforeDelete-1 , UserManagement.getUserListSize());
	}
	
	@Test
	public void testDeleteUserFail () {
		UserManagement userManagementObject = new UserManagement();
		userManagementObject.setUsername("JohnDoe123");
		userManagementObject.setPassword("Johnpassword");
		userManagementObject.setEmail("johndoe@gmail.com");
		userManagementObject.setFirstName("John");
		userManagementObject.setLastName("Doe");
		userManagementObject.setphoneNumber("12345678");

		UserManagement.AddUser(userManagementObject);
		int userListSizeBeforeDelete = UserManagement.getUserListSize();
		UserManagement.DeleteUser("Fakepassword");
		
	
		assertEquals(userListSizeBeforeDelete, UserManagement.getUserListSize());
	}
	
	
	@Test
	public void testValidAddAdmin() {
		UserManagement userManagementObject = new UserManagement();
		userManagementObject.setUsername("admin2");
		userManagementObject.setPassword("password2");
		userManagementObject.setEmail("johndoe@gmail.com");
		userManagementObject.setFirstName("Steve");
		userManagementObject.setLastName("Tan");
		userManagementObject.setphoneNumber("91111111");

		 ArrayList<UserManagement> adminList = UserManagement.getAdminList();
		 int AdminListSizeBeforeAdd = UserManagement.getAdminListSize();
		 adminList.add(userManagementObject);
		 UserManagement.setAdminList(adminList);
		 assertEquals(AdminListSizeBeforeAdd+1, UserManagement.getAdminListSize()); 
		 }
		 
	
	@Test
	public void testUserAuthentication () {
		UserManagement userManagementObject = new UserManagement();
		userManagementObject.setUsername("JohnDoe123");
		userManagementObject.setPassword("Johnpassword");
		userManagementObject.setEmail("johndoe@gmail.com");
		userManagementObject.setFirstName("John");
		userManagementObject.setLastName("Doe");
		userManagementObject.setphoneNumber("12345678");

		UserManagement.AddUser(userManagementObject);
		
		assertTrue(UserManagement.checkUserAuth(userManagementObject.getUsername(),userManagementObject.getPassword()));
	}
	
	@Test
	public void testUserAuthenticationFail () {
		UserManagement userManagementObject = new UserManagement();
		userManagementObject.setUsername("JohnDoe123");
		userManagementObject.setPassword("Johnpassword");
		userManagementObject.setEmail("johndoe@gmail.com");
		userManagementObject.setFirstName("John");
		userManagementObject.setLastName("Doe");
		userManagementObject.setphoneNumber("12345678");

		UserManagement.AddUser(userManagementObject);
		
		assertFalse(UserManagement.checkUserAuth(userManagementObject.getUsername(),"Wrong password"));
	}
	
	@Test
	public void testAdminAuthentication () {
		UserManagement userManagementObject = new UserManagement();
		userManagementObject.setUsername("admin2");
		userManagementObject.setPassword("password2");
		userManagementObject.setEmail("johndoe@gmail.com");
		userManagementObject.setFirstName("Steve");
		userManagementObject.setLastName("Tan");
		userManagementObject.setphoneNumber("91111111");

		 ArrayList<UserManagement> adminList = UserManagement.getAdminList();
		 adminList.add(userManagementObject);
		 UserManagement.setAdminList(adminList);
	
		assertTrue(UserManagement.checkAdminAuth("admin2","password2"));
	}
	
	@Test
	public void testAdminAuthenticationFail () {

		UserManagement userManagementObject = new UserManagement();
		userManagementObject.setUsername("admin2");
		userManagementObject.setPassword("password2");
		userManagementObject.setEmail("johndoe@gmail.com");
		userManagementObject.setFirstName("Steve");
		userManagementObject.setLastName("Tan");
		userManagementObject.setphoneNumber("91111111");

		 ArrayList<UserManagement> adminList = UserManagement.getAdminList();
		 adminList.add(userManagementObject);
		 UserManagement.setAdminList(adminList);
		assertFalse(UserManagement.checkAdminAuth("admin1","wrongpassword"));
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
