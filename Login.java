
//package mylogin;
import java.util.Scanner;
/* Date:16-Dec-2020
Team Members: Hashavarthan  Sachin Karthick  Sangeetha
Author:Sachin Karthick Ranganathan
Description of the file:A class named as UserProfile collets all details when new user try to register in this site
A Class named as VerifyProfile will verify the Username and Password from Back end.
Modified Date:18-Dec-2020
Last Editied By: Harshavarthan and Sangeetha
Reviwed By:Jaya and Antony
Reviwed Date:17-Dec-2020
*/

class Login {
	static Scanner scanner = new Scanner(System.in);
	// static String[] credentials;
	static String userName = "null";
	static String mailID = "null";
	static String password = "null";

	Login() {
		String[] credentials = getUserCredentials();

		verifycredentials(credentials);

	}

	public static void validUserId(String user_Id) {
		String[] name = user_Id.split("-", 2);
		//String userString= user_Id;
		//System.out.println(name[0]);
		if (name[0].equals("Sel")) {
			//System.out.println("if function");
			// seller=new Seller();
			Seller.availablityStatus(name[0]);
		}  else if (name[0].equals("Del")) {
			DeliveryStaff.getStaffAvailablityStatus(name[0]);
		}else {
			//System.out.println("else-Function");
			Customer.viewList(name[0]);
		}
		
	}

	public String[] getUserCredentials() {
		System.out.println("\n--------Login Page--------");
		System.out.print("\nUser name/ mail Id:");
		String username = scanner.nextLine();
		System.out.print("Password:");
		String password = scanner.nextLine();
		// System.out.println("getting user cred "+username+" "+password);
		return new String[] { username, password };
	}

	void verifycredentials(String[] userCredential) {

		password = userCredential[1];
		try {
			// String upiId = scanner.nextLine();
			String credentialSplit[] = userCredential[0].split("@", 2);
			// System.out.println(upiIdSplit[1]);
			if ((credentialSplit[1].equals("gmail.com") || credentialSplit[1].equals("yahoo.com"))) {
				System.out.println("valid mail id");
				mailID = userCredential[0];
				System.out.println("This is mail id : " + userName + " " + mailID + " " + password);
			} else {
				System.out.println("incorrect userid/mail id");
				String[] credentials = getUserCredentials();
				// System.out.println(Arrays.toString(credentials));
				verifycredentials(credentials);

			}
		} catch (Exception e) {
			userName = userCredential[0];
			//System.out.println("This is user name");
			validUserId(userName);
			// System.out.println(userName + " " + mailID + " " + password);

			// String[] credentials=getUserCredentials();
		}
		UserProfile.verifyUserProfile();

	}

	public static void main(String[] Args) {

		Login login = new Login();

	}
}
