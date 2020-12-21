import java.util.Scanner;
//import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/* Date:16-Dec-2020
Team Members: Hashavarthan  Sachin Karthick  Sangeetha
Author:Sachin Karthick Ranganathan
Description of the file:A class named as UserProfile collets all details when new user try to register in this site
A Class named as VerifyProfile will verify the Username and Password from Back end.
Modified Date:21-Dec-2020
Last Editied By: Harshavarthan 
Reviwed By:Jaya and Antony
Reviwed Date:17-Dec-2020
*/

class Customer {
	String customerId;
	public static String customerDetails[][] = new String[5][10];
	static Scanner scanner = new Scanner(System.in);

	public Customer() {

		// getCustomerProfileDetails();
	}

	public static String getPassword() {
		boolean condition = true;
		String password = null;
		while (condition) {
			// System.out.println("The password must b 8-20 must contaon 1 uppercase, 1
			// Lowercase, 1 characters and no space allowed");
			password = scanner.nextLine();
			isValidPassword(password);
			// System.out.println(isValidPassword(password));
			if (!isValidPassword(password)) {
				System.out.println("Incorrect Password.... Try again");
			}
			condition = !isValidPassword(password);

		}
		return password;
	}

	public static boolean isValidPassword(String password) {

		// Regex to check valid password.
		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#!$%^&+=])" + "(?=\\S+$).{8,20}$";

		Pattern p = Pattern.compile(regex);

		if (password == null) {
			return false;
		}

		Matcher m = p.matcher(password);
		return m.matches();
	}

	public static void getCustomerProfileDetails() {

		// Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Username: ");
		customerDetails[0][0] = scanner.nextLine();

		System.out.print("Enter Password: ");
		// customerDetails[0][1] = scanner.nextLine();
		customerDetails[0][1] = getPassword();
		isValidPassword(customerDetails[0][1]);
		System.out.print("Retype Password: ");
		// String retypePassword = scanner.nextLine();
		String retypePassword = getPassword();
		// isValidPassword(retypePassword);
		if (customerDetails[0][1].equals(retypePassword) == true) // checking for password and Retype-Password
		{
			// good:
			System.out.print("Enter a name: ");

			customerDetails[0][2] = getName();
			if (customerDetails[0][2] == "!Null") {
				// continue good;
			}
			System.out.print("Enter a address: ");
			customerDetails[0][3] = scanner.nextLine();

			System.out.print("Enter a phone: ");
			customerDetails[0][4] = getPhone();

			System.out.print("Enter a mail: ");
			customerDetails[0][5] = getMail();

			System.out.print("Enter a pincode: ");
			customerDetails[0][6] = getPinCode();

			generateCustomerId();

			// System.out.println(customerDetails[o][1]);
			/*
			 * System.out.println(name); System.out.println(address);
			 * System.out.println(phone); System.out.println(mail);
			 * System.out.println(pincode);
			 */

		} else {
			System.out.println("Passwords do not match.....Try Again....");
			getCustomerProfileDetails();
		}
		// generateCustomerId();
		scanner.close();
	}

	public static void generateCustomerId() {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMMddYYYY-");
		String formattedDate = myDateObj.format(myFormatObj);
		var customerId = formattedDate + Integer.toString(1);
		// customerPreviousnumber++;
		customerDetails[0][7] = customerId;
		System.out.println("Success !!!");
		System.out.println("Your account has been created");
		System.out.println("Your Customer ID :" + customerId);

		Login login = new Login();
		// System.out.println(customerId);

	}

	public static void viewList(String Username) {
		// get datas from DishList method
		System.out.println("\n -----Main Landing Page for CUSTOMER -----");
		System.out.println("\n Welcome " + Username);
		System.out.println("Press 1 to Order Food");
		System.out.println("Press 2 to Log-out");
		System.out.print("Enter your Options:");
		int customeroption = scanner.nextInt();
		if (customeroption == 1) {
			DeliveryPhase.displayDishList();
		} else if (customeroption == 2) {
			logout();
		} else {

			System.out.println("Invalid Option Try another options as follow");
			viewList(Username);

		}

	}

	public static void logout() {
		System.out.println("\n -----Logout Page for CUSTOMER -----");
		System.out.println("Thank You  ");
		System.out.println("Come Again and enjoy the lastest food at lowest cost ");
	}

	public static void getOrderStatus() {
		System.out.println("\n ----ORDER DETAILS PAGE-----\n");
		System.out.println("1.Track Order Details");
		System.out.println("2.Cancel Order ");
		System.out.print("Enter Your Option:");
		int statusoption = scanner.nextInt();
		if (statusoption == 1) {
			System.out.println("Food will be Delivered in 30min(Esm. Time)");
			Customer.logout();

		} else if (statusoption == 2) {
			System.out.println("Do you Want to cancel current Order");
			System.out.println("Cancellation Policy");
			System.out.println("1. You must notify us  within 15 minutes of placing the order. \n ");
			System.out.println("2. FoodCloud or the chef may cancel an order if the product is not available for any reason.\n");
			System.out.println("3. We will notify you about the Reductions of amount for cancellation depends on the time you cancel your order.\n");
			System.out.println("(e.g)if the order is fully prepared and packed for the delivery then only 25% of the total bill amount will be refunded via Credit or Debit card.\n");
			System.out.println("if case COD method is enabled for that order then the required amount(75% of the bill amount ) will be collected extra in  Next order. \n");
			System.out.println("4. Refunds may take up to 4-5 Working days, depending upon the mode of payment. \n");
			Customer.logout();
			// calling order class methods
		} else

		{
			System.out.println("Invalid Option ");
			Customer.getOrderStatus();
		}

	}

	public static void addDeliveryNote() {

		// Scanner scanner = new Scanner(System.in);

		int DeliveryOptions;
		// username = scanner.nextLine();
		System.out.println("Order Should be Delivered to ");
		System.out.println("Press 1 Self Order");
		System.out.println("Press 2 Friends");
		System.out.println("Press 3 Family");
		System.out.println("Press 4 Others");
		System.out.print("Enter Options:");
		DeliveryOptions = scanner.nextInt();
		switch (DeliveryOptions) {
			case 1:
				break;
			case 2:
				System.out.println("\nFriends");
				System.out
						.println("Enter Your Friend Name and Number \n (Note)-Number is Optional for Security Purpose");
				String friendinfromation = scanner.nextLine();

				break;
			case 3:
				System.out.println("\nFamily");
				System.out.println(
						"Enter Your Family member Name and Number \n (Note)-Number is Optional for Security Purpose");
				String familyinfromation = scanner.nextLine();

				break;
			case 4:
				System.out.println("\n Others");
				break;
			default:
				System.out.println("Pls Select other option from 1 to 4");
				addDeliveryNote();

		}

	}

	public static boolean isValidPhone(String phone) {

		String regex = "^\\d{10}$";
		Pattern p = Pattern.compile(regex);

		char firstLetter = phone.charAt(0);
		if (phone == null || firstLetter == '5' || firstLetter == '4' || firstLetter == '3' || firstLetter == '2'
				|| firstLetter == '1' || firstLetter == '0') {
			return false;
		}

		Matcher m = p.matcher(phone);

		return m.matches();

	}

	public static String getPhone() {
		boolean condition = true;
		String phone = null;
		while (condition) {

			phone = scanner.nextLine();
			isValidPhone(phone);

			if (!isValidPhone(phone)) {
				System.out.println("Incorrect Phone number... Try again");
			}
			condition = !isValidPhone(phone);

		}
		return phone;
	}

	public static boolean isValidMail(String mail) {

		// String regex = "^[a-z0-9+_.-]+@(.+)$";
		String regex = "^[A-Za-z0-9\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(regex);

		if (mail == null) {
			return false;
		}
		Matcher m = p.matcher(mail);
		return m.matches();

	}

	public static String getMail() {
		boolean condition = true;
		String mail = null;
		while (condition) {

			mail = scanner.nextLine();
			isValidMail(mail);
			// System.out.println(isValidMail(mail));
			if (!isValidMail(mail)) {
				System.out.println("Incorrect mail... Try again");
			}
			condition = !isValidMail(mail);

		}
		return mail;
	}

	public static boolean isValidPinCode(String pincode) {

		// Regex to check valid password.
		String regex = "^\\d{6}$";
		Pattern p = Pattern.compile(regex);
		char firstLetter = pincode.charAt(0);
		if (pincode == null || !(firstLetter == '6')) {
			return false;
		}
		Matcher m = p.matcher(pincode);
		return m.matches();

	}

	public static String getPinCode() {
		boolean condition = true;
		String pincode = null;
		while (condition) {

			pincode = scanner.nextLine();
			isValidPinCode(pincode);
			// System.out.println(isValidPinCode(pincode));
			if (!isValidPinCode(pincode)) {
				System.out.println("Incorrect pincode... Try again");
			}
			condition = !isValidPinCode(pincode);

		}
		return pincode;
	}

	public static boolean isValidName(String name) {
		String regex = "^([a-zA-Z]{2,}\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)";
		// String regex = "^[a-zA-Z]*$";
		Pattern p = Pattern.compile(regex);

		if (name == null) {
			return false;
		}
		Matcher m = p.matcher(name);
		return m.matches();

	}

	public static String getName() {
		boolean condition = true;
		String name = null;
		while (condition) {

			name = scanner.nextLine();
			isValidPinCode(name);
			// System.out.println(isValidName(name));
			if (!isValidName(name)) {
				System.out.println("Incorrect Name... Try again");
			}
			condition = !isValidName(name);

		}
		return name;
	}

	public static void main(String[] args) {
		//getCustomerProfileDetails();
		getOrderStatus();
	}
}
