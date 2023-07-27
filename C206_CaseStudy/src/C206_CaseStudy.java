
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// display standard menu and ask for option

		ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
		ArrayList<CurrencyManagement> currentCurrency = new ArrayList<CurrencyManagement>();
		int option = -99;
		publicMenu();

		// indefinite while loop
		while (option != 9) {
			boolean patientfound = true;
			option = Helper.readInt("\nEnter option or 0 for main menu > ");
			System.out.println(option);

			// check for options
			if (option == 0) {
				// display main menu
				publicMenu();
			} else if (option == 1) {
				// View Feedback
				ViewFeedback(feedbackList);
			} else if (option == 2) {
				// Enter Feedback
				EnterFeedback(feedbackList);
			} else if (option == 3) {
				// Add currency
				AddCurrency(currentCurrency);
			} else if (option == 4) {
				// Delete currency
				DeleteCurrency(currentCurrency);
			} else if (option == 5) {
				// View Currency
				ViewCurrencyManagement(currentCurrency);
			} else if (option == 6) {
				// Update Currency
				UpdateCurrency(currentCurrency);
			} else if (option == 7) {
				// End visit
			} else if (option == 8) {
				// End visit
			} else if (option == 9) {
				// log out
				System.out.println("\nGood bye!");
				System.exit(0);
			} else {
				// invalid option chosen
				System.out.println("\n*** Invalid option selected ***\n");
			}

			// if patient does not exist based on return boolean
			if (!patientfound) {
				System.out.println("\n*** No such patient in ward ***\n");
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

		String menu = "1. View Feedback\n" + "2. Enter Feedback\n" + "3. Add Currency\n" + "4. Delete Currency\n"
				+ "5. View all Currencies\n" + "6. Update Currency\n" + "7. Check Transaction details\n"
				+ "8. Update Exchange rates\n" + "9. Check accounts\n" + "9. Logout\n";

		System.out.println(menu);
	}

	public static void EnterFeedback(ArrayList<Feedback> feedbackList) {
		int customerID = Helper.readInt("Enter Customer ID");
		Date date = Helper.readDate("Enter Transaction Date");
		int ratingScale = Helper.readInt(
				"From a scale of 1-5 with 5 being the most satisfactory money exchange experience, please rate");
		while (ratingScale > 5 || ratingScale <= 0) {
			ratingScale = Helper.readInt("Please enter a number from 1-5");
		}
		String comments = Helper.readString("Enter comments");

		Feedback feedback = new Feedback();
		feedback.setFeedback(comments, ratingScale, customerID, date);
		feedbackList.add(feedback);
	}

	public static Feedback ViewFeedback(ArrayList<Feedback> feedbackList) {
		int inputcustomerID = Helper.readInt("Enter Customer ID");
		Date inputdate = Helper.readDate("Enter Transaction Date");

		for (Feedback f : feedbackList) {
			if ((Helper.sameDate(f.date, inputdate)) && (f.customerID == inputcustomerID)) {
				System.out.println(f.comments);
				return f;

			}

		}
		System.out.println("Unavailable");
		return null;
	}

	public static void AddCurrency(ArrayList<CurrencyManagement> currentCurrency) {
		String Addcurrency = Helper.readString("Enter Currency");
		CurrencyManagement CurrencyManagement = new CurrencyManagement();
		CurrencyManagement.Addcurrency(Addcurrency);
		currentCurrency.add(CurrencyManagement);
	}


	public static void DeleteCurrency(ArrayList<CurrencyManagement> currentCurrency) {
		String Deletecurrency = Helper.readString("Enter Currency");
		CurrencyManagement CurrencyManagement = new CurrencyManagement();
		CurrencyManagement.Deletecurrency(Deletecurrency);
		currentCurrency.remove(CurrencyManagement);
	}

	{
	}

	public static ArrayList<CurrencyManagement> ViewCurrencyManagement(ArrayList<CurrencyManagement> currentCurrency) {
		for (CurrencyManagement C : currentCurrency) {
			System.out.println(C.currency);
		}
		return currentCurrency;
	}
	
	public static ArrayList<CurrencyManagement> UpdateCurrency(ArrayList<CurrencyManagement> currentCurrency) {
		String oldCurrency = Helper.readString("Enter old Currency");
		if(currentCurrency.size() == 0) {
			System.out.println("No currency in currency list");
			return null;
		}
		
		
		
		String newCurrency = Helper.readString("Enter new Currency");
		for (CurrencyManagement C : currentCurrency) {
			if (C.currency.equals(oldCurrency)){
				C.setCurrency(newCurrency);
			}
		}
		
		return currentCurrency;
	}
}

