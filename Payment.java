import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Payment {

	static Scanner scanner = new Scanner(System.in);

	public static void getpaymentMethod() {
		System.out.println("\n ----PAYMENT PAGE-----\n");
		System.out.println("Enter payment Method");
		System.out.println("1.UPI  2.credit card 3.debit card 4.cash on delivery");
		System.out.print("Enter your Options:");
		int paymentMethod = scanner.nextInt();
		scanner.nextLine();
		switch (paymentMethod) {

			case 1: {
				getUpiDetails();
				break;
			}
			case 2: {
				getCreditCardDetails();
				break;
			}
			case 3: {
				getDebitCardDetails();
				break;
			}
			case 4: {
				getCashOnDeliveryDetails();
				break;
			}
			default:
				System.out.println("Enter an valid Payment Option");
		}
		Seller.receiveOrderDetails();
		//DeliveryStaff.generateDeliveryStaffId();
	}

	public static void getCreditCardDetails() {

		System.out.println("Enter your creditCard Details");
		System.out.println("creditCard Number: ");
		String creditCardNumber = getBankAccount();

//		if ((creditCardNumber.length()) != 16) {
//			System.out.println("Incorrect card number");
//			return;
//		} else {
//			System.out.println("CreditCard Number: " + creditCardNumber);
//		}
		System.out.println("Name in Creditcard: ");
		String creditcardName = scanner.nextLine();

		System.out.println("Credit Card: " + creditcardName);
		System.out.println("Creditcard Type: VISA or MASTER or MAESTRO");
		String creditcardType = scanner.nextLine();
		creditcardType = creditcardType.toUpperCase();
		if (!(creditcardType.equals("VISA") || creditcardType.equals("MASTER") || creditcardType.equals("MAESTRO"))) {
			System.out.println("Enter a valid Type");
		}

	}

	public static void getDebitCardDetails() {

		System.out.println("Enter your DebititCard Details");
		System.out.println("DebitCard Number: ");
		String debitCardNumber = getBankAccount();

//		if ((debitCardNumber.length()) != 16) {
//			System.out.println("Incorrect card number");
//			// return;
//		} else {
//			System.out.println("DebitCard Number: " + debitCardNumber);
//		}
		System.out.println("Name in Debitcard: ");
		String debitcardName = scanner.nextLine();

		System.out.println("Debit Card: " + debitcardName);
		System.out.println("Debitcard Type: VISA or MASTER or MAESTRO or Rupay");
		String debitcardType = scanner.nextLine();
		debitcardType = debitcardType.toUpperCase();
		if (!(debitcardType.equals("VISA") || debitcardType.equals("MASTER") || debitcardType.equals("MAESTRO")
				|| debitcardType.equals("RUPAY"))) {
			System.out.println("Enter a valid Type");
		}

	}

	public static void getUpiDetails() {
		System.out.println("Enter UPI id: ");

		// System.out.println();
		try {
			String upiId = scanner.nextLine();
			String upiIdSplit[] = upiId.split("@", 2);
			// System.out.println(upiIdSplit[1]);
			if (!(upiIdSplit[1].equals("okicici") || upiIdSplit[1].equals("okaxis") || upiIdSplit[1].equals("oksbi"))) {
				System.out.println("Enter a valid UPI ID Extension");
				getUpiDetails();
			}
		} catch (Exception e) {
			System.out.println("Enter valid UPI Id");
			getUpiDetails();
		}

	}

	public static void getCashOnDeliveryDetails() {
		System.out.println("cash on delivery");

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

	
	public static void main(String[] args) {
		Payment payment = new Payment();
	}
}