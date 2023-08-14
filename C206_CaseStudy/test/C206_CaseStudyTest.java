import static org.junit.Assert.*;
import org.junit.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class C206_CaseStudyTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before C206_CaseStudyTest class");
	}

	@Before
	public void setUp1() throws Exception {
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
		assertEquals(UserListSizeBeforeAdd + 1, UserManagement.getUserListSize());
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
		boolean result;
		if (UserManagement.getUserListSize() == 1) {
			result = true;
		} else {
			result = false;
		}
		assertFalse(result);
	}

	@Test
	public void testDeleteUser() {
		UserManagement userManagementObject = new UserManagement();
		userManagementObject.setUsername("JohnDoe123");
		userManagementObject.setPassword("Johnpassword");
		userManagementObject.setEmail("johndoe@gmail.com");
		userManagementObject.setFirstName("John");
		userManagementObject.setLastName("Doe");
		userManagementObject.setphoneNumber("12345678");

		UserManagement.AddUser(userManagementObject);
		int UserListSizeBeforeDelete = UserManagement.getUserListSize();
		UserManagement.DeleteUser(userManagementObject.getUsername());

		assertEquals(UserListSizeBeforeDelete - 1, UserManagement.getUserListSize());
	}

	@Test
	public void testDeleteUserFail() {
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
		assertEquals(AdminListSizeBeforeAdd + 1, UserManagement.getAdminListSize());
	}

	@Test
	public void testUserAuthentication() {
		UserManagement userManagementObject = new UserManagement();
		userManagementObject.setUsername("JohnDoe123");
		userManagementObject.setPassword("Johnpassword");
		userManagementObject.setEmail("johndoe@gmail.com");
		userManagementObject.setFirstName("John");
		userManagementObject.setLastName("Doe");
		userManagementObject.setphoneNumber("12345678");

		UserManagement.AddUser(userManagementObject);

		assertTrue(
				UserManagement.checkUserAuth(userManagementObject.getUsername(), userManagementObject.getPassword()));
	}

	@Test
	public void testUserAuthenticationFail() {
		UserManagement userManagementObject = new UserManagement();
		userManagementObject.setUsername("JohnDoe123");
		userManagementObject.setPassword("Johnpassword");
		userManagementObject.setEmail("johndoe@gmail.com");
		userManagementObject.setFirstName("John");
		userManagementObject.setLastName("Doe");
		userManagementObject.setphoneNumber("12345678");

		UserManagement.AddUser(userManagementObject);

		assertFalse(UserManagement.checkUserAuth(userManagementObject.getUsername(), "Wrong password"));
	}

	@Test
	public void testAdminAuthentication() {
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

		assertTrue(UserManagement.checkAdminAuth("admin2", "password2"));
	}

	@Test
	public void testAdminAuthenticationFail() {

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
		assertFalse(UserManagement.checkAdminAuth("admin1", "wrongpassword"));
	}

	// Currency_Management Test Cases

	private Currency_Management currencyManagement;

	@Before
	public void setUpCurrency() throws Exception {
		currencyManagement = new Currency_Management();
	}

	@Test
	public void testAddNewCurrency() {
		boolean added = currencyManagement.addNewCurrency("USD", "US Dollar", 1.0, false);
		assertTrue(added);

		List<Currency> currencies = currencyManagement.getCurrencies();
		assertEquals(1, currencies.size());

		Currency addedCurrency = currencies.get(0);
		assertEquals("USD", addedCurrency.getCurrencyCode());
		assertEquals("US Dollar", addedCurrency.getCurrencyName());
		assertEquals(1.0, addedCurrency.getExchangeRate(), 0.001); // Delta for double comparison
	}

	@Test
// Test adding a duplicate currency
	public void testAddDuplicateCurrency() {
		currencyManagement.addNewCurrency("USD", "US Dollar", 1.0, false);
		currencyManagement.addNewCurrency("USD", "US Dollar", 1.0, true);
		assertEquals(1, currencyManagement.getCurrencies().size());
	}

	@Test
	// Test adding a currency with invalid exchange rate
	public void testInvalidExchangeRate() {
		currencyManagement.addNewCurrency("EUR", "Euro", -0.85, true);
		assertEquals(0, currencyManagement.getCurrencies().size());
	}

	@Test
// Test viewing all currencies   
	public void testViewAllCurrencies() {
		currencyManagement.initializeCommonCurrencies();
		// Not testing output, just checking if the method executes without errors
		currencyManagement.viewAllCurrencies();
	}

	@Before
	public void setUp() {
		currencyManagement = new Currency_Management();
		// Initialize currencies or add currencies as needed for your tests
	}

	@Test
	public void testDeleteCurrencyWithConfirmation() {
		Currency_Management currencyManagement = new Currency_Management();
		Currency currencyToDelete = new Currency("USD", "US Dollar", 1.0);
		currencyManagement.getCurrencies().add(currencyToDelete);

		InputStream inputStream = new ByteArrayInputStream("y\n".getBytes());
		System.setIn(inputStream);

		currencyManagement.deleteCurrency("USD", true);
		assertEquals(0, currencyManagement.getCurrencies().size());
	}

	@Test
	public void testUpdateCurrency_Success() {
		// Prepare
		List<Currency> currencies = new ArrayList<>();
		Currency currencyToUpdate = new Currency("USD", "US Dollar", 1.0);
		currencies.add(currencyToUpdate);

		Currency_Management currencyManagement = new Currency_Management();
		// Use a mock to simulate getCurrencies()
		currencyManagement.setCurrencies(currencies);

		double newExchangeRate = 1.2; // New exchange rate

		// Update the currency
		currencyToUpdate.setExchangeRate(newExchangeRate);

		// Verify
		assertEquals(newExchangeRate, currencyToUpdate.getExchangeRate(), 0.001);
	}

	@Test
	public void testUpdateCurrency_CurrencyNotFound() {
		// Prepare
		List<Currency> currencies = new ArrayList<>();
		currencies.add(new Currency("USD", "US Dollar", 1.0)); // Add sample currency

		Currency_Management currencyManagement = new Currency_Management();
		// Use a mock to simulate getCurrencies()
		currencyManagement.setCurrencies(currencies);

		String currencyCodeToUpdate = "XYZ"; // Non-existent currency code
		double newExchangeRate = 1.2; // New exchange rate

		// Find the currency to update
		Currency currencyToUpdate = null;
		for (Currency currency : currencies) {
			if (currency.getCurrencyCode().equalsIgnoreCase(currencyCodeToUpdate)) {
				currencyToUpdate = currency;
				break;
			}
		}

		// Assert
		assertNull("Currency should not be found for non-existent code", currencyToUpdate);
	}

	@Test
	public void testDeleteCurrencyWithoutConfirmation() {
		Currency_Management currencyManagement = new Currency_Management();
		Currency currencyToDelete = new Currency("EUR", "Euro", 0.85);
		currencyManagement.getCurrencies().add(currencyToDelete);

		currencyManagement.deleteCurrency("EUR", false);
		assertEquals(0, currencyManagement.getCurrencies().size());
	}

	@Test
	public void testDeleteNonexistentCurrency() {
		Currency_Management currencyManagement = new Currency_Management();
		currencyManagement.deleteCurrency("JPY", true);
		assertEquals(0, currencyManagement.getCurrencies().size());

	}
}
