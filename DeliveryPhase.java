
//import java.io.ObjectInputFilter.Config;
import java.util.*;

class DeliveryPhase {
    static Scanner scanner = new Scanner(System.in);

    static String[][] dishList = { { "DishId", "Dish Name", "Price" }, { "1", "Chicken Burger", "120" },
            { "2", "chicken wrap", "130" }, { "3", "French Fries", "140" }, { "4", "Milkshake", "150" },
            { "5", "pepsi Large", "160" } };

    static int[][] customerList = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

    DeliveryPhase() {
        displayDishList();
        // displayCustomerList();
        // addingToCart();
        // displayCustomerList();
        // priceCalculation();
    }

    DeliveryPhase(int a) {
        addingToCart();
    }

    public static void priceCalculation() {
        int TotalPrice = 0;
        System.out.println("\n ----CART PAGE-----\n");
        for (int i = 0; i <= 2; i++) {
            int orderId = customerList[i][0];
            if (orderId == 0)
                break;
            int price = Integer.parseInt(dishList[orderId][2]);
            int quantity = customerList[i][1];
            // dishList[][2]*customerList[i][0];
            TotalPrice += (price * quantity);
            
            System.out.println("DishId: " + orderId + " Name " + dishList[orderId][1] + " Quantity: " + quantity
                    + " Price/item:  " + price);

        }
        System.out.println("\nTotal Amount to be Paid: "+TotalPrice);
        //System.out.println(TotalPrice);
        System.out.println("\n\n");
        Customer.addDeliveryNote();
        System.out.println("\n ----CONFIRMATION OF ORDER PAGE-----\n");
        System.out.println("\nPress 1 to Confirm Order");
        System.out.print("Enter your Options:");
        int confrimOrder = scanner.nextInt();
        if (confrimOrder == 1) {
            Payment.getpaymentMethod();

        }

    }

    public static void displayDishList() {
        System.out.println("\n -----MENU PAGE-----");
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 2; j++) {

                System.out.print(dishList[i][j] + "\t");

            }
            System.out.println();
        }
       // displayCustomerList();
        addingToCart();
        priceCalculation();

    }

    public static void displayCustomerList() {
        System.out.println();
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {

                System.out.print(customerList[i][j] + "   ");

            }
            System.out.println();
        }

    }

    public static void addingToCart() {

        makeListEmpty();
        System.out.println("-----Adding to Cart Page-----");
        System.out.println("Please enter the DishId and Quantity as Mentioned in above Menu ");
        System.out.println("Note: Only 3 dishes allowed per order and max of 5 quantity per dish");
        //System.out.println();
        int i = 0;

        while (i <= 2) {
            System.out.print("\nEnter Dishid:");
            int dishId = scanner.nextInt();
            System.out.print("Enter Quantity:");
            int quantity = scanner.nextInt();

            if (((dishId < 4 && dishId > 0)) && ((quantity < 6 && quantity > 0))) {

                customerList[i][0] = dishId;
                customerList[i][1] = quantity;
                i++;
                System.out.println("\nEnter 0 to End Ordering");
                System.out.println("Enter 1 to Continue Ordering");
                System.out.print("Enter your Options:");
                int exitCode = scanner.nextInt();
                if (exitCode == 0) {
                    break;
                } else if (exitCode == 1) {
                    continue;
                } else {
                    System.out.println("Enter a valid");
                }

            } else {
                System.out.println("Enter a valid OrderId and Quantity");
                i = 0;
                // makeListEmpty();
            }

        }
        System.out.println("End of Adding to Cart");
    }

    public static void makeListEmpty() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++)
                customerList[i][j] = 0;

        }
        System.out.println();
    }

    

    public static void main(String[] Args) {
        DeliveryPhase Deliveryphase = new DeliveryPhase();
        // displayDishList();
        // priceCalculation();
    }
}
