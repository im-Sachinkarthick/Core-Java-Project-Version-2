import java.net.*;
import java.io.*;
//import java.net.dataoutputstream;

public class CustomerData {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 6666);
            DataOutputStream dataoutputstream = new DataOutputStream(socket.getOutputStream());
            dataoutputstream.writeUTF("Hello Server");
            int TotalPrice = 0;
        dataoutputstream.writeUTF("\n ----Cart Page-----");
        for (int i = 0; i <= 2; i++) {
            int orderId = DeliveryPhase.customerList[i][0];
            if (orderId == 0)
                break;
            int price = Integer.parseInt(DeliveryPhase.dishList[orderId][2]);
            int quantity = DeliveryPhase.customerList[i][1];
            // dishList[][2]*customerList[i][0];
            TotalPrice += (price * quantity);
            
            dataoutputstream.writeUTF("DishId: " + orderId + " Name " + DeliveryPhase.dishList[orderId][1] + " Quantity: " + quantity
                    + " Price/item:  " + price);

        }
        dataoutputstream.writeUTF("\nTotal Amount to be Paid: "+TotalPrice);
            dataoutputstream.flush();
            dataoutputstream.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}