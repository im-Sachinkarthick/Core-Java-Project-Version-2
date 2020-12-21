import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*Date:16-Dec-2020
MOdified date: 18-Dec-2020
Author:Sachin Karthick Ranganathan
Description of the file:DeliveryStaff Class is used to create a new Account to DeliveryStaff and generate a deliverystaff Id
Reviwed By:
Reviwed Date:
*/
class DeliveryStaff {

    private static final String Username = null;
    static Scanner scanner = new Scanner(System.in);
    public static String deliveryStaffDetails[][] = new String[5][10];
    public static String deliveryStaffAccountDetails[][] = new String[5][10];
    static String deliveryStaffId = null;

    public DeliveryStaff() {

        getDeliverystaffProfileDetails();
        getDeliveryStaffAccountDetails();

    }

    public static void getDeliverystaffProfileDetails() {

        // Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Username: ");
        deliveryStaffDetails[0][0] = scanner.nextLine();

        System.out.print("Enter Password: ");
        deliveryStaffDetails[0][1] = scanner.nextLine();

        System.out.print("Retype Password: ");
        String retypePassword = scanner.nextLine();
        if (deliveryStaffDetails[0][1].equals(retypePassword) == true) // checking for password and Retype-Password
        {

            System.out.print("Enter a name: ");
            deliveryStaffDetails[0][2] = scanner.nextLine();

            System.out.print("Enter a address: ");
            deliveryStaffDetails[0][3] = scanner.nextLine();

            System.out.print("Enter a phone: ");
            deliveryStaffDetails[0][4] = scanner.nextLine();

            System.out.print("Enter a mail: ");
            deliveryStaffDetails[0][5] = scanner.nextLine();

            System.out.print("Enter a pincode: ");
            deliveryStaffDetails[0][6] = scanner.nextLine();

            generateDeliveryStaffId();

            // System.out.println(customerDetails[o][1]);
            /*
             * System.out.println(name); System.out.println(address);
             * System.out.println(phone); System.out.println(mail);
             * System.out.println(pincode);
             */

        } else {
            System.out.println("Passwords do not match");
            getDeliverystaffProfileDetails();
        }
        // generateCustomerId();
        // scanner.close();
    }

    public static void generateDeliveryStaffId() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMMddYYYY-");
        String formattedDate = myDateObj.format(myFormatObj);
        var deliveryStaffId = formattedDate + Integer.toString(1);
        // customerPreviousnumber++;
        deliveryStaffDetails[0][7] = deliveryStaffId;
        System.out.println("Success !!!");
        System.out.println("Your account has been created");
        System.out.println("Your Staff ID  is :" + deliveryStaffId);
        System.out.println(deliveryStaffId);

    }

    public static void getDeliveryStaffAccountDetails() {

        System.out.print("Enter a AadharcardNumber: ");
        deliveryStaffAccountDetails[0][0] = getAadhar();
        System.out.print("Enter accountNumber: ");
        deliveryStaffAccountDetails[0][1] = getBankAccount();
        
        if ((deliveryStaffAccountDetails[0][1].length()) != 16) {
            System.out.println("Incorrect card number");
            getDeliveryStaffAccountDetails();
        }
        
        System.out.print("Enter bankName: ");
        deliveryStaffAccountDetails[0][2] = scanner.nextLine();

        System.out.print("Enter ifscCode: ");
        deliveryStaffAccountDetails[0][3] = scanner.nextLine();

        System.out.print("Enter a branchName: ");
        deliveryStaffAccountDetails[0][4] = scanner.nextLine();

    }

	public static boolean isValidAadhar(String aadhar) {
		String regex = "^[0-9]{12}$";
		Pattern p = Pattern.compile(regex);
	
		if (aadhar == null ) {
			return false;
		}
		Matcher m = p.matcher(aadhar);
		return m.matches();
		
	}

public static String getAadhar() {
		boolean condition = true;
		String aadhar = null;
		while (condition) {
			
			aadhar = scanner.nextLine();
			isValidAadhar(aadhar);
			// System.out.println(isValidAadhar(aadhar));
			if (!isValidAadhar(aadhar)) {
				System.out.println("Incorrect Aadhar... Try again");
			}
			condition = !isValidAadhar(aadhar);

		}
		return aadhar;
	}

public static boolean isValidBankAccount(String accountnumber) {
	String regex = "^[0-9]{16}$";
	Pattern p = Pattern.compile(regex);

	if (accountnumber == null ) {
		return false;
	}
	Matcher m = p.matcher(accountnumber);
	return m.matches();
	
}

public static String getBankAccount() {
	boolean condition = true;
	String accountnumber = null;
	while (condition) {
		
		 accountnumber = scanner.nextLine();
		isValidBankAccount(accountnumber);
		// System.out.println(isValidBankAccount(accountnumber));
		if (!isValidBankAccount(accountnumber)) {
			System.out.println("Incorrect Bank Account Number... Try again");
		}
		condition = !isValidBankAccount(accountnumber);

	}
	return accountnumber;
}


    
    public static  void getDeliverySchedule() {
        int TotalPrice = 0;
        System.out.println("\n ----Delivery Staff COnfrimation Page-----");
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
        System.out.println("\nTotal Amount to be Paid: "+TotalPrice);
        System.out.println(" Press 1 To Accept the  Order");
		System.out.println(" Press 2 To Cancel the  Order");
		System.out.print("Enter Your Option:");
		int selleroption=scanner.nextInt();
		if(selleroption==1)
		{
			Customer.getOrderStatus();
		}
		else if (selleroption==2){
			System.out.print("Order Cancelled by DeliveryStaff Due to HIGH DEMAND of food in your Location!!!!");
		}
    }

    static public void getStaffAvailablityStatus(String Username) {
        System.out.println("Welcome "+Username);
        Boolean availablityStatus = false;
        System.out.println("Welcome " );
        System.out.println("1.Avaliable \n 2.unavaliable");
        if (scanner.nextInt() == 1) {
            availablityStatus = true;
        } else {
            availablityStatus = false;
        }

        // availablityStatus=Boolean.parseBoolean(scanner.nextLine());
        // availablityStatus=scanner.nextBoolean();
        System.out.println(availablityStatus);

    }

    public void amountToBePaid() {

    }

    public static void main(String[] args) {
        DeliveryStaff deliveryStaff = new DeliveryStaff();
        //getStaffAvailablityStatus();
    }
}