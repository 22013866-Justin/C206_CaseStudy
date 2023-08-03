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

		ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
		int option = -99;
		publicMenu();
		// indefinite while loop
		while (option != 9) {
			option = Helper.readInt("\nEnter option or 0 for main menu > ");

			// check for options
			if (option == 0) {
				// display main menu
				publicMenu();
			} else if (option == 1) {
				// Add a new user
				AddUser(UserManagement);
			} else if (option == 2) {
				// View all users
				
			} else if (option == 3) {
				// Add currency
			
			} else if (option == 4) {
				// Delete currency
				

			} else if (option == 5) {
				// View Currency
		
			} else if (option == 6) {
				// Update Currency
				
			} else if (option == 7) {
				// View feedback
				
			} else if (option == 8) {
				// End visit
				
			} else if (option == 9) {
				//Delete an existing transaction
				
			} else if (option == 10) {
				//Add a new account
				
			} else if (option == 11) {
				//View all accounts
				
			} else if (option == 12) {
				//Delete an existing account
				
			} else if (option == 13) {
				//Add a new rate
				
			} else if (option == 14) {
				//View all rates
				
			} else if (option == 15) {
				//Delete an existing rate
				
			} else if (option == 16) {
				//Add new feedback
				List<Object> feedback = AddFeedbackHelper();
				EnterFeedback (feedbackList,feedback.get(0).toString(),feedback.get(1),feedback.get(2).toString());
				
			} else if (option == 17) {
				//View all feedbacks
				ViewFeedback(feedbackList);
			} else if (option == 18) {
				//Delete existing feedback
				DeleteFeedback (feedbackList);
			} else {
				// invalid option chosen
				System.out.println("\n*** Invalid option selected ***\n");
			}

		}

	} // end of main

	// -------------------------------------------------------------------------------------------------------
	// static method to print the standard menu
	// -------------------------------------------------------------------------------------------------------
	public static void publicMenu() {
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*****     Money Management System     *****");
		Helper.line(45, "*");

		// -------------------
		// Complete code here
		// -------------------

		String menu = "1. Add a new user\n" + "2. View all users\n" + "3. Delete an existing user\n" + "4. Delete Currency\n"
				+ "5. View all Currencies\n" + "6. Update Currency\n" + "7. View feedback\n"
				+ "8. Update Exchange rates\n" + "9. Check accounts\n" + "9. Logout\n" + "10. Add a new account\n" 
				+ "11. View all accounts\n" + "12. Delete an existing account\n" + "13. Add a new rate\n" + "14. View all rates\n"
				+ "15. Delete an existing rate\n" + "16. Add new feedback\n" + "17. View all feedbacks\n" + "18. Delete existing feedback\n";

		System.out.println(menu);
	}
	
	
	public static List<Object> AddFeedbackHelper(){
		String comments = Helper.readString("Enter comments");
		int ratingScale = Helper.readInt("From a scale of 1-5 with 5 being the most satisfactory money exchange experience, please rate");
		while (ratingScale > 5 || ratingScale <= 0) {
			ratingScale = Helper.readInt("Please enter a number from 1-5");
		}
		Date date = Helper.readDate("Enter date");
		return  Arrays.asList(comments,ratingScale,date);
	}
	public static void EnterFeedback(ArrayList<Feedback> feedbackList, String comments, int ratingScale, Date date) {
		int ratingScale = Helper.readInt(
				"From a scale of 1-5 with 5 being the most satisfactory money exchange experience, please rate");

		Feedback feedback = new Feedback();
		 String uniqueID= UUID.randomUUID().toString();
		feedback.setFeedback(uniqueID, comments, ratingScale, customerID, date);
		feedbackList.add(feedback);
	}

	public static boolean ViewFeedback(ArrayList<Feedback> feedbackList) {
		boolean getAllFeedback = Helper.readBoolean("View all feeback");
		if(getAllFeedback) {
			Feedback feedback = new Feedback();
			feedback.viewAllFeedback(feedbackList);
			return true;
		}
		
		int inputcustomerID = Helper.readInt("Enter Customer ID");
		Date inputdate = Helper.readDate("Enter Transaction Date");

		for (Feedback f : feedbackList) {
			if ((Helper.sameDate(f.date, inputdate)) && (f.customerID == inputcustomerID)) {
				System.out.println(f.comments);
				return true;
			}

		}
		return true;

	}

	public static int DeleteFeedback(ArrayList<Feedback> feedbackList, String uniqueID ) {
		Feedback feedback = new Feedback();
		feedback.deleteFeedback(feedbackList, uniqueID);
		return feedbackList.size();
	}

	
	public static List<Object> AddUserHelper(){
		String username = Helper.readString("Enter username");
		String password = Helper.readString("Enter password");
		String email = Helper.readString("Enter email");
		String firstName = Helper.readString("Enter first name");
		String lastName = Helper.readString("Enter last name");
		String phoneNumber = Helper.readString("Enter phone number");
		return  Arrays.asList(username,password,email,firstName,lastName,phoneNumber);
		
		public static void AddUser(ArrayList<UserManagement> arrayListName, String username, String password, String email, String firstName, String lastName, String phoneNumber) {
			
			UserManagement UserManagement = new UserManagement();
			UserManagement.AddUser(UserToAdd);
			
		}
		
		
		    
		    
		

	
