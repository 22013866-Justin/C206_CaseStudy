import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;
import java.util.List;
import java.util.Arrays;

class Currency {
	// Currency class to represent currency information
	private String currencyCode;
	private String currencyName;
	private double exchangeRate;


	public Currency(String currencyCode, String currencyName, double exchangeRate) {
		this.currencyCode = currencyCode;
		this.currencyName = currencyName;
		this.exchangeRate = exchangeRate;


	}
	// Getter and setter methods for the currency attributes
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}


}
class Currency_Management {

	private List<Currency> currencies;



	public Currency_Management() {

		// Constructor initializes the list of currencies
		setCurrencies(new ArrayList<>());

	}
	void initializeCommonCurrencies() {
		// Method to add common currencies to the list during initialization
		// Add currency codes, names, exchange rates, and a boolean indicating whether to show messages
		// list of common currencies
		addNewCurrency("USD", "US Dollar", 1.0, false);
		addNewCurrency("EUR", "Euro", 0.85, false);
		addNewCurrency("GBP", "British Pound", 0.75, false);
		addNewCurrency("JPY", "Japanese Yen", 110.0, false);
		addNewCurrency("AUD", "Australian Dollar", 1.35, false);
		addNewCurrency("CAD", "Canadian Dollar", 1.25, false);
		addNewCurrency("CHF", "Swiss Franc", 0.92, false);
		addNewCurrency("CNY", "Chinese Yuan", 6.48, false);
		addNewCurrency("INR", "Indian Rupee", 73.5, false);
		addNewCurrency("SGD", "Singapore Dollar", 1.34, false);
		addNewCurrency("NZD", "New Zealand Dollar", 1.44, false);
		addNewCurrency("SEK", "Swedish Krona", 8.78, false);
		addNewCurrency("KRW", "South Korean Won", 1179.0, false);
		addNewCurrency("RUB", "Russian Ruble", 76.5, false);
		addNewCurrency("BRL", "Brazilian Real", 5.25, false);
		addNewCurrency("TRY", "Turkish Lira", 8.95, false);
		addNewCurrency("ZAR", "South African Rand", 14.45, false);
		addNewCurrency("AED", "United Arab Emirates Dirham", 3.67, false);
		addNewCurrency("MXN", "Mexican Peso", 20.15, false);
		addNewCurrency("THB", "Thai Baht", 33.6, false);
		addNewCurrency("HKD", "Hong Kong Dollar", 7.77, false);
	}



	// Method to add a new currency to the list
	public boolean addNewCurrency(String currencyCode, String currencyName, double exchangeRate, boolean showMessage) {
		// Input validation
		if (currencyCode.isEmpty() || currencyName.isEmpty() || exchangeRate <= 0) {
			if (showMessage) {
				System.out.println("Invalid input. Please provide valid details.");
			}
			return false;
		}

		// Convert input currency code to lowercase for case-insensitive comparison
		String lowercaseCurrencyCode = currencyCode.toLowerCase();

		// Check for duplicate currency code (case-insensitive)
		for (Currency existingCurrency : getCurrencies()) {
			if (existingCurrency.getCurrencyCode().equalsIgnoreCase(lowercaseCurrencyCode)) {
				if (showMessage) {
					System.out.println("Currency with the same code already exists.");
				}
				return false;
			}
		}

		// If no duplicate is found, add the new currency
		Currency newCurrency = new Currency(currencyCode, currencyName, exchangeRate);

		getCurrencies().add(newCurrency);

		return true;
	}
	// Getter method to retrieve the list of currencies
	public List<Currency> getCurrencies() {
		return currencies;
	}
	// Method to display information about all currencies
	public void viewAllCurrencies() {
		System.out.println("List of all currencies:");
		for (Currency currency : getCurrencies()) {
			System.out.println("Currency Code: " + currency.getCurrencyCode()
					+ ", Currency Name: " + currency.getCurrencyName()
					+ ", Exchange Rate: " + currency.getExchangeRate());
		}
	}

	// Method to delete a currency from the list
	public void deleteCurrency(String currencyCodeToDelete, boolean confirmDeletion) {
	    Currency currencyToDelete = null;
	    for (Currency currency : getCurrencies()) {
	        if (currency.getCurrencyCode().equalsIgnoreCase(currencyCodeToDelete)) {
	            currencyToDelete = currency;
	            break;
	        }
	    }

	    if (currencyToDelete != null) {
	        if (confirmDeletion) {
	            Scanner scanner = new Scanner(System.in);
	            System.out.print("Are you sure you want to delete the currency " + currencyToDelete.getCurrencyName() + " (Y/N)? ");
	            String confirmation = scanner.nextLine().trim().toLowerCase();
	            if (confirmation.equals("y")) {
	                getCurrencies().remove(currencyToDelete);
	                System.out.println("Currency deleted successfully!");
	            } else {
	                System.out.println("Currency deletion canceled.");
	            }
	        } else {
	            getCurrencies().remove(currencyToDelete);
	            System.out.println("Currency deleted successfully!");
	        }
	    } else {
	        System.out.println("Currency not found.");
	    }
	}


	private void deleteCurrency(String currencyCodeToDelete) {
		// TODO Auto-generated method stub

	}
	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}
}

public class C206_CaseStudy {

	private static Currency_Management currencyManagement;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// display standard menu and ask for option

		int option = -99;
		int adminOption = -99;
		int userOption = -99;
		int exisingUserOption = -99;
		boolean authUser = false;
		boolean authAdmin = false;
		UserManagement.initAdmin();
		publicMenu();
		// indefinite while loop
		currencyManagement = new Currency_Management();
		while (option != 3) {
			currencyManagement = new Currency_Management();
			currencyManagement.initializeCommonCurrencies();
			publicMenu();
			option = Helper.readInt("\nEnter option or 0 for public menu > ");
			String[] userNameAndPassWord;
			if (option == 1) {
				// money system user
				userMenu();
				userOption = Helper.readInt("\nEnter user options or 0 for user menu > ");
				while (userOption != 3) {
				
					if (userOption == 1) {
						// Add a new user
						AddUser();
						System.out.println("User added");
						userMenu();
						userOption = Helper.readInt("\nEnter user options or 0 for user menu > ");
					} else if (userOption == 2) {
						// existing  user
						userNameAndPassWord = UserManagement.userNameAndPassWordAsker();
						System.out.println("checking user: " +userNameAndPassWord[0] + "pw: " + userNameAndPassWord[1]);
						authUser = UserManagement.checkUserAuth(userNameAndPassWord[0], userNameAndPassWord[1]);
						while (authUser == false) {
							System.out.println("\n*** Wrong Username or password ***\n");
							System.out.println("checking user: " +userNameAndPassWord[0] + "pw: " + userNameAndPassWord[1]);
							userNameAndPassWord = UserManagement.userNameAndPassWordAsker();
							System.out.println(userNameAndPassWord);

							authUser = UserManagement.checkUserAuth(userNameAndPassWord[0], userNameAndPassWord[1]);
						}
						existingUserMenu();
						exisingUserOption = Helper.readInt("\nEnter user options or 0 for exisitng user menu > ");

						while (exisingUserOption != 6) {
							if (exisingUserOption == 0) {
								// view existing user menu
								existingUserMenu();
								exisingUserOption = Helper.readInt("\nEnter user options or 0 for exisitng user menu > ");

							}
							if (exisingUserOption == 1) {
								// Add a new user
							} else if (exisingUserOption == 2) {
								// View all users

							} else if (exisingUserOption == 3) {
								// Add currency

							} else if (exisingUserOption == 4) {
								// Delete currency

							} else if (exisingUserOption == 5) {
								// View Currency

							} else if (exisingUserOption == 6){
								break;

							}else {
								// invalid option chosen
								System.out.println("\n*** Invalid option selected ***\n");
								existingUserMenu();

								exisingUserOption = Helper.readInt("\nEnter user options or 0 for exisitng user menu > ");

							}
						}
						break;
					} else if (userOption == 3) {
						break;
					}
					else  {
							// invalid option chosen
							System.out.println("\n*** Invalid option selected ***\n");
							userOption = Helper.readInt("\nEnter user options or 0 for user menu > ");

					}
				}
			} else if (option == 2) {
				// money system admin
				System.out.println("\n*** Enter Admin Username and password ***\n");
				userNameAndPassWord = UserManagement.userNameAndPassWordAsker();
				authAdmin = UserManagement.checkAdminAuth(userNameAndPassWord[0], userNameAndPassWord[1]);
				while (authAdmin == false) {
					System.out.println("\n*** Wrong Admin Username or password ***\n");
					userNameAndPassWord = UserManagement.userNameAndPassWordAsker();
					authAdmin = UserManagement.checkAdminAuth(userNameAndPassWord[0], userNameAndPassWord[1]);
				}
				adminMenu();
				adminOption = Helper.readInt("\nEnter option or 0 for admin menu > ");
				while (adminOption != 20) {
					if (adminOption == 0) {
						adminMenu();
					} else if (adminOption == 1) {
						// Add a new user1
						AddUser();
						System.out.println("User: added");
						adminMenu();
						adminOption = Helper.readInt("\nEnter user options or 0 for user menu > ");
					} else if (adminOption == 2) {
						// View all users
						UserManagement.viewAllsers();
						adminMenu();
						adminOption = Helper.readInt("\nEnter user options or 0 for user menu > ");


					} else if (adminOption == 3) {
						// delete user
						DeleteUser();
						adminMenu();
						adminOption = Helper.readInt("\nEnter user options or 0 for user menu > ");

					} else if (adminOption == 4) {
						// Add currency
						String currencyCode = Helper.readString("Enter the currency code: ");
						String currencyName = Helper.readString("Enter the currency name: ");
						double exchangeRate = Helper.readDouble("Enter the exchange rate: ");

						boolean currencyAdded = currencyManagement.addNewCurrency(currencyCode, currencyName, exchangeRate, true);
						if (currencyAdded) {
							System.out.println("Currency added successfully!");
						} else {
							System.out.println("Currency could not be added. Please provide valid details.");
						}
						adminMenu();
						adminOption = Helper.readInt("\nEnter user options or 0 for user menu > ");

					} else if (adminOption == 5) {
						// View Currency
						currencyManagement.viewAllCurrencies();
						adminMenu();
						adminOption = Helper.readInt("\nEnter user options or 0 for user menu > ");
						
						
					}	else if (adminOption == 6) {
						    // Update Currency
						    String currencyCodeToUpdate = Helper.readString("Enter the currency code to update: ");
						    
						    // Find the currency to update in the list
						    Currency currencyToUpdate = null;
						    for (Currency currency : currencyManagement.getCurrencies()) {
						        if (currency.getCurrencyCode().equalsIgnoreCase(currencyCodeToUpdate)) {
						            currencyToUpdate = currency;
						            break;
						        }
						    }
						    
						    if (currencyToUpdate != null) {
						        double newExchangeRate = Helper.readDouble("Enter the new exchange rate: ");
						        currencyToUpdate.setExchangeRate(newExchangeRate);
						        System.out.println("Currency updated successfully!");
						    } else {
						        System.out.println("Currency not found.");
						    }
						    
						    adminMenu();
						    adminOption = Helper.readInt("\nEnter option or 0 for admin menu > ");
						


					} else if (adminOption == 7) {
						// Delete Currency
						String currencyCodeToDelete = Helper.readString("Enter the currency code to delete: ");
						currencyManagement.deleteCurrency(currencyCodeToDelete, true);
						adminMenu();
						adminOption = Helper.readInt("\nEnter user options or 0 for user menu > ");

					} else if (adminOption == 8) {
						// View feedback

					} else if (adminOption == 9) {
						// Update Exchange rates

					} else if (adminOption == 10) {
						// Check accounts

					} else if (adminOption == 11) {
						// Add a new account

					} else if (adminOption == 12) {
						// View all accounts

					} else if (adminOption == 13) {
						// Delete an existing account

					} else if (adminOption == 14) {
						// Add a new rate

					} else if (adminOption == 15) {
						// View all rates

					} else if (adminOption == 16) {
						// Delete an existing rate

					} else if (adminOption == 17) {
						// Add new feedback

					} else if (adminOption == 18) {
						// View all feedbacks

					} else if (adminOption == 19) {
						// Delete existing feedback
					} else if (adminOption == 20) {
						
						// invalid option chosen
						System.out.println("\n*** Invalid option selected ***\n");
					}

				}}}				
						
		

	} // end of main

	// -------------------------------------------------------------------------------------------------------
	// static method to print the standard menu
	// -------------------------------------------------------------------------------------------------------

	public static void userMenu() {
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*****     Money Management User System     *****");
		Helper.line(45, "*");

		// -------------------
		// Complete code here
		// -------------------

		String menu = "1. New user \n" +  "2. Existing user\n"+"3. Exit\n";

		System.out.println(menu);
	}

	public static void existingUserMenu() {
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*****     Money Management Exisiting User System     *****");
		Helper.line(45, "*");

		// -------------------
		// Complete code here
		// -------------------

		String menu = "1. Make transaction\n" + "2. Create account\n" + "3. Check accounts\n" + "4. Add new feedback\n"
				+ "6. exit\n";

		System.out.println(menu);
	}

	public static void publicMenu() {
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*****     Money Management System Public menu      *****");
		Helper.line(45, "*");

		// -------------------
		// Complete code here
		// -------------------

		String menu = "choose user type\n" + "1.User\n" + "2.Admin\n" +"3.Exit \n";

		System.out.println(menu);
	}

	public static void adminMenu() {
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*****     Money Management System Admin menu     *****");
		Helper.line(45, "*");

		// -------------------
		// Complete code here
		// -------------------

		String menu = "1. Add a new user\n" +
                "2. View all users\n" +
                "3. Delete an existing user\n" +
                "4. Add Currency\n" +
                "5. View all Currencies\n" +
                "6. Update Currency\n" +  // New option for updating currency
                "7. Delete Currency\n" +
                "8. View feedback\n" +
                "9. Update Exchange rates\n" +
                "10. Check accounts\n" +
                "11. Add a new account\n" +
                "12. View all accounts\n" +
                "13. Delete an existing account\n" +
                "14. Add a new rate\n" +
                "15. View all rates\n" +
                "16. Delete an existing rate\n" +
                "17. Add new feedback\n" +
                "18. View all feedback\n" +
                "19. Delete existing feedback\n" +
                "20. Exit\n"; 
                

  System.out.println(menu);
}

	public static void AddUser() {
		String username = Helper.readString("Enter username");
		String password = Helper.readString("Enter password");
		String email = Helper.readString("Enter email");
		String firstName = Helper.readString("Enter first name");
		String lastName = Helper.readString("Enter last name");
		String phoneNumber = Helper.readString("Enter phone number");

		UserManagement userManagementObject = new UserManagement();
		userManagementObject.setUsername(username);
		userManagementObject.setPassword(password);
		userManagementObject.setEmail(email);
		userManagementObject.setFirstName(firstName);
		userManagementObject.setLastName(lastName);
		userManagementObject.setphoneNumber(phoneNumber);

		UserManagement.AddUser(userManagementObject);
	}

	public static void DeleteUser() {
		String username = Helper.readString("Enter username");
		UserManagement.DeleteUser(username);
		return;
	}

}

                
                    
                        