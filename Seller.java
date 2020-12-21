import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import sun.awt.AWTAccessor.SystemTrayAccessor;

//import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*Date:16-Dec-2020
MOdified date: 18-Dec-2020
Author:Sachin Karthick Ranganathan
Description of the file:Seller Class is used to create a new Account to Seller and generate a Seller Id
Reviwed By:
Reviwed Date:
*/


class Seller {
    
    static boolean availablity=false;
    static Scanner scanner=new Scanner(System.in);
    public static String sellerDetails[][] = new String[5][10];
    public static String sellerAccountDetails[][] = new String[5][10];
    static String sellerId=null;


    public Seller() {
        receiveOrderDetails();
      // getSellerProfileDetails();
        //getAccountDetails();
        //availablityStatus();

    }
    

    
    public static  void getSellerProfileDetails() {

        // Scanner scanner = new Scanner(System.in);
        System.out.print("Enter RestaurantsUsername: ");
        sellerDetails[0][0] = getName();

        System.out.print("Enter RestaurantsPassword: ");
        sellerDetails[0][1] = getPassword();

        System.out.print("Retype RestaurantsPassword: ");
        String retypePassword = scanner.nextLine();
        if (sellerDetails[0][1].equals(retypePassword) == true) // checking for password and Retype-Password
        {

            System.out.print("Enter a ShopName: ");
            sellerDetails[0][2] = scanner.nextLine();

            System.out.print("Enter a ShopAddress: ");
            sellerDetails[0][3] = scanner.nextLine();

            System.out.print("Enter a ShopPhoneNO: ");
            sellerDetails[0][4] = getPhone();

            System.out.print("Enter a ShopMailId: ");
            sellerDetails[0][5] = getMail();

            System.out.print("Enter a ShopPincode: ");
            sellerDetails[0][6] = getPinCode();

            generateSellerId();

            // System.out.println(customerDetails[o][1]);
            /*
             * System.out.println(name); System.out.println(address);
             * System.out.println(phone); System.out.println(mail);
             * System.out.println(pincode);
             */

        } else {
            System.out.println("Passwords do not match");
            getSellerProfileDetails();
        }
        // generateCustomer
    }

    public static void generateSellerId() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMMddYYYY-");
        String formattedDate = myDateObj.format(myFormatObj);
        var sellerId = formattedDate + Integer.toString(1);
        // customerPreviousnumber++;
        sellerDetails[0][7] = sellerId;
        System.out.println("Success !!!");
        System.out.println("Your account has been created");
        System.out.println("Your Hotel ID :" + sellerId);
        getAccountDetails();
        Login login=new Login();
        

    }

    public static void availablityStatus(String Username) {
        System.out.println("Welcome " +Username);
        System.out.print("Enter a Hotel AvailablityStatus: ");
            availablity = scanner.nextBoolean();

    }

    public static void getAccountDetails() {
        System.out.print("Enter a ShopLicenseId: ");
        sellerAccountDetails[0][0] = scanner.nextLine();
        //good:
        System.out.print("Enter accountNumber: ");
        sellerAccountDetails[0][1] = scanner.nextLine();
        if ((sellerAccountDetails[0][1].length()) != 16) {
            System.out.println("Incorrect card number");
           // continue good;
        getAccountDetails();
        }

        System.out.print("Enter bankName: ");
        sellerAccountDetails[0][2] = scanner.nextLine();

        System.out.print("Enter ifscCode: ");
        sellerAccountDetails[0][3] = scanner.nextLine();

        System.out.print("Enter a branchName: ");
        sellerDetails[0][4] = scanner.nextLine();

        System.out.println("Restaurants Account Details is Saved Sucessfully");

        
    }


    
    
    
    public static void receiveOrderDetails() {
		// calling order details
		int TotalPrice = 0;
        System.out.println("\n ----Seller Confrimation  Page-----");
        for (int i = 0; i <= 2; i++) {
            int orderId = DeliveryPhase.customerList[i][0];
            if (orderId == 0)
                break;
            int price = Integer.parseInt(DeliveryPhase.dishList[orderId][2]);
            int quantity = DeliveryPhase.customerList[i][1];
            // dishList[][2]*customerList[i][0];
            TotalPrice += (price * quantity);
            
            System.out.println("DishId: " + orderId + " Name " + DeliveryPhase.dishList[orderId][1] + " Quantity: " + quantity
                    + " Price/item:  " + price);

        }
		System.out.println("\nTotal Amount paid for this order: "+TotalPrice);
		System.out.println(" Press 1 To Confrim Order");
		System.out.println(" Press 2 To Cancel Order");
		System.out.print("Enter Your Option:");
		int selleroption=scanner.nextInt();
		if(selleroption==1)
		{
			DeliveryStaff.getDeliverySchedule();
		}
		else if (selleroption==2){
			System.out.print("Order Cancelled!!!!");
		}

       // DeliveryPhase.priceCalculation();
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
       Seller seller = new Seller();
        //seller.receiveOrderDetails();
        //availablityStatus();
        
    }



}