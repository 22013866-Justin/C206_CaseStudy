import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;
import java.util.List;
import java.util.Arrays;

public class C206_CaseStudy {


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
		while (option != 3) {
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
				while (adminOption != 19) {
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
						// Delete currency

					} else if (adminOption == 5) {
						// View Currency

					} else if (adminOption == 6) {
						// Update Currency

					} else if (adminOption == 7) {
						// View feedback

					} else if (adminOption == 8) {
						// End visit

					} else if (adminOption == 9) {
						// Delete an existing transaction

					} else if (adminOption == 10) {
						// Add a new account

					} else if (adminOption == 11) {
						// View all accounts

					} else if (adminOption == 12) {
						// Delete an existing account

					} else if (adminOption == 13) {
						// Add a new rate

					} else if (adminOption == 14) {
						// View all rates

					} else if (adminOption == 15) {
						// Delete an existing rate

					} else if (adminOption == 16) {
						// Add new feedback

					} else if (adminOption == 17) {
						// View all feedbacks

					} else if (adminOption == 18) {
						// Delete existing feedback
					} else {
						// invalid option chosen
						System.out.println("\n*** Invalid option selected ***\n");
					}

				}
			}
		}
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

		String menu = "1. Add a new user\n" + "2. View all users\n" + "3. Delete an existing user\n"
				+ "4. Delete Currency\n" + "5. View all Currencies\n" + "6. Update Currency\n" + "7. View feedback\n"
				+ "8. Update Exchange rates\n" + "9. Check accounts\n" + "9. Logout\n" + "10. Add a new account\n"
				+ "11. View all accounts\n" + "12. Delete an existing account\n" + "13. Add a new rate\n"
				+ "14. View all rates\n" + "15. Delete an existing rate\n" + "16. Add new feedback\n"
				+ "17. View all feedbacks\n" + "18. Delete existing feedback\n" + "19. exit \n";

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
