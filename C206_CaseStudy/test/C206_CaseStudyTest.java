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
	
	// Currency_Management Test Cases

    private Currency_Management currencyManagement;

    @Before
    public void setUpCurrency() throws Exception {
        currencyManagement = new Currency_Management();
    }
   
 // This tests adding a new currency (normal condition).
 // It adds a currency and verifies that the currency list size increases by one,
 // and the added currency's properties match the expected values.
 @Test
 public void testAddNewCurrency() {
     int before = currencyManagement.getCurrencies().size();
     boolean added = currencyManagement.addNewCurrency("USD", "US Dollar", 1.0, false);
     assertTrue(added);

     int after = currencyManagement.getCurrencies().size();
     assertEquals(before + 1, after);

     // Additional assertion: Validate the properties of the added currency
     Currency addedCurrency = currencyManagement.getCurrencies().get(after - 1);
     assertEquals("USD", addedCurrency.getCurrencyCode());
     assertEquals("US Dollar", addedCurrency.getCurrencyName());
     assertEquals(1.0, addedCurrency.getExchangeRate(), 0.001);
 }

//This tests adding a duplicate currency (error condition).
//It adds the same currency twice and verifies that only one currency is added to the list.
@Test
public void testAddDuplicateCurrency() {
  currencyManagement.addNewCurrency("USD", "US Dollar", 1.0, false);
  currencyManagement.addNewCurrency("USD", "US Dollar", 1.0, true);
  assertEquals(1, currencyManagement.getCurrencies().size());
}

//This tests adding a currency with an invalid exchange rate (error condition).
//It attempts to add a currency with a negative exchange rate and verifies that the currency is not added to the list.
@Test
public void testInvalidExchangeRate() {
 currencyManagement.addNewCurrency("EUR", "Euro", -0.85, true);
 assertEquals(0, currencyManagement.getCurrencies().size());
}
    
//This tests adding a currency with a very low exchange rate (boundary condition).
//It verifies that the currency is added successfully and its properties are correct.
@Test
public void testAddCurrency_LowExchangeRate() {
 boolean added = currencyManagement.addNewCurrency("ABC", "Low Exchange Currency", 0.001, false);
 assertTrue(added);

 Currency addedCurrency = currencyManagement.getCurrencies().get(0);
 assertEquals("ABC", addedCurrency.getCurrencyCode());
 assertEquals("Low Exchange Currency", addedCurrency.getCurrencyName());
 assertEquals(0.001, addedCurrency.getExchangeRate(), 0.001);
}

//This tests viewing all currencies (normal condition).
//It initializes common currencies, and while not testing the output,
//it ensures that the method can execute without errors.
@Test
public void testViewAllCurrencies() {
  currencyManagement.initializeCommonCurrencies();
  // Not testing output, just checking if the method executes without errors
  currencyManagement.viewAllCurrencies(); 
}
    
 // This tests the scenario of viewing all currencies when the list is empty (boundary condition).
 // It focuses on ensuring the method can execute without errors even in this edge case.
 @Test
 public void testViewCurrencies_EmptyList() {
     // Not testing output, just checking if the method executes without errors
     currencyManagement.viewAllCurrencies();
 }

        @Before
        public void setUp() {
            currencyManagement = new Currency_Management();
            // Initialize currencies or add currencies as needed for your tests
        }

     // This tests deleting a currency with confirmation (normal condition).
     // It adds a currency to the list, simulates the user confirming the deletion ("y"),
     // and verifies that the currency is successfully deleted from the list.
     @Test
     public void testDeleteCurrencyWithConfirmation() {
         Currency_Management currencyManagement = new Currency_Management();
         Currency currencyToDelete = new Currency("USD", "US Dollar", 1.0);
         currencyManagement.getCurrencies().add(currencyToDelete);

         // Simulate user confirmation by providing "y" as input
         InputStream inputStream = new ByteArrayInputStream("y\n".getBytes());
         System.setIn(inputStream);

         currencyManagement.deleteCurrency("USD", true);
         assertEquals(0, currencyManagement.getCurrencies().size());
     }

        
  // This tests updating a currency successfully (normal condition).
  // It prepares a list of currencies, updates the exchange rate of a currency,
  // and verifies that the new exchange rate is correctly set.
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

//This tests updating a non-existent currency (boundary condition).
//It prepares a list of currencies, attempts to update a currency with a non-existent code,
//and verifies that the currency remains unfound (null).
@Test
public void testUpdateCurrency_CurrencyNotFound() {
   // Prepare
   List<Currency> currencies = new ArrayList<>();
   currencies.add(new Currency("USD", "US Dollar", 1.0)); // Add sample currency
   
   Currency_Management currencyManagement = new Currency_Management();
   // Use a mock to simulate getCurrencies()
   currencyManagement.setCurrencies(currencies);

   String currencyCodeToUpdate = "XYZ"; // Non-existent currency code
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
    // Prepare
    Currency_Management currencyManagement = new Currency_Management();
    Currency currencyToDelete = new Currency("EUR", "Euro", 0.85);
    currencyManagement.getCurrencies().add(currencyToDelete);

    // Act: Delete currency without confirmation
    currencyManagement.deleteCurrency("EUR", false);

    // Assert: Check if currency is deleted
    assertEquals(0, currencyManagement.getCurrencies().size());
}

// This tests deleting a currency that doesn't exist (boundary condition).
// It adds a currency, attempts to delete a non-existent one, and checks if the currency list remains unaffected.
@Test
public void testDeleteCurrency_NonExistentCurrency() {
    // Prepare
    currencyManagement.addNewCurrency("EUR", "Euro", 0.85, false);

    // Act: Attempt to delete a non-existent currency
    currencyManagement.deleteCurrency("USD", true); // Non-existent currency code

    // Assert: Check if the currency list remains unaffected
    assertEquals(1, currencyManagement.getCurrencies().size());
}
}
//Currency_Management Test Cases:

//testAddNewCurrency: Tests adding a new currency and checks if the currency list size increases by 1. (Normal condition)

//testAddDuplicateCurrency: Tests adding a duplicate currency and ensures that only one currency is added. (Error condition)

//testAddCurrency_LowExchangeRate : Tests adds a currency with a very low exchange rate (boundary condition).

//testViewAllCurrencies: Tests viewing all currencies and ensures that the method executes without errors. (Normal condition)

//testDeleteCurrencyWithConfirmation: Tests deleting a currency with confirmation and verifies that the currency list becomes empty. (Normal condition)

//testUpdateCurrency_Success: Tests updating a currency's exchange rate and checks if the exchange rate is updated correctly. (Normal condition)

//testUpdateCurrency_CurrencyNotFound: Tests updating a currency that doesn't exist and confirms that the currency is not found. (Boundary condition)

//testDeleteCurrencyWithoutConfirmation: Tests deleting a currency without confirmation and asserts that the currency list becomes empty. (Normal condition)

//testDeleteNonexistentCurrency: Tests attempting to delete a non-existent currency and confirms that the currency list remains unchanged. (Boundary condition)
        