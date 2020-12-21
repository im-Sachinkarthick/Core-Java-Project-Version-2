import java.util.Scanner;

/* Date:16-Dec-2020
Team Members: Hashavarthan  Sachin Karthick  Sangeetha
Author:Sachin Karthick Ranganathan
Description of the file:A class named as UserProfile collets all details when new user try to register in this site
A Class named as VerifyProfile will verify the Username and Password from Back end.
Modified Date:18-Dec-2020
Last Editied By: Harshavarthan
Reviwed By:Jaya and Antony
Reviwed Date:17-Dec-2020
*/

class UserProfile {

    static int accountoption;
    static Scanner scanner = new Scanner(System.in);
    public UserProfile(){
        System.out.println("\n\n------ Welcome to Online Food Order and Delivery Systems ------");
        System.out.println("\nClick the below Options:");
        //Scanner scanner = new Scanner(System.in);
        System.out.println("Click 1 to LOGIN");
        System.out.println("Click 2 to Register a New Account");
        System.out.print("Enter your Options:");
        int profileOptions = scanner.nextInt();
        switch (profileOptions) {
            case 1:

                Login login = new Login();
                break;
            case 2:
                accountselection();
                break;
        }
    }


    public static void accountselection(){
        System.out.println("\n ----ACCOUNT REGISTRATION PAGE-----\n");
        System.out.println("Press 1 Customer Acccunt");
        System.out.println("Press 2 Seller Account");
        System.out.println("Press 3 DeliveryStaff Account");
        System.out.print("Enter your Options:");
        accountoption=scanner.nextInt();
        switch (accountoption) {
            case 1:

                Customer.getCustomerProfileDetails();
                break;
            case 2:
                Seller.getSellerProfileDetails();
                break;
            case 3:
                DeliveryStaff.getDeliverystaffProfileDetails();
               DeliveryStaff.getDeliveryStaffAccountDetails();

        }


    }

    
    public static void verifyUserProfile() {

        // get username and password from Login class and verify with statically defined
        // attributes
        // check the entered password and username from Database
        // System.out.println(Login.userName);
        // System.out.println(Login.mailID);
        if (Login.userName == "Null" || Login.password == "NUll") {
            if (Login.userName == "Null") {
                System.out.println(Login.mailID);
                System.out.println(Login.password);
            } else {
                System.out.println(Login.userName);
                System.out.println(Login.password);
            }
        }
        
       /* System.out.println("Welcome to Online Food Order and Delivery Systems");
        System.out.println("Click the below Options:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Click 1 to LOGIN");
        System.out.println("Click 2 to Register a New Account");
        int profileOptions = scanner.nextInt();
        switch (profileOptions) {
            case 1:

                Login login = new Login();
                break;
            case 2:
                Customer.getCustomerProfileDetails();
                break;
        }
        scanner.close();*/

    }

    public static void main(String args[]) {
       
        UserProfile userprofile = new UserProfile(); // calling Default Construtor
        verifyUserProfile();

    }

}
