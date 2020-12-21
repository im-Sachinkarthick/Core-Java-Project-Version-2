
//import java.text.SimpleDateFormat;  
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/* Date:16-Dec-2020
Team Members: Hashavarthan  Sachin Karthick  Sangeetha
Author:Hashavarthan
Description of the file:A class named as UserProfile collets all details when new user try to register in this site
A Class named as VerifyProfile will verify the Username and Password from Back end.
Modified Date:18-Dec-2020
Last Editied By: Sachin Karthick
Reviwed By:Jaya and Antony
Reviwed Date:17-Dec-2020
*/

class DeliverySystem {
  String estime = "30mins";
  LocalDateTime localdatetime = LocalDateTime.now();
  DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("dd-MMM-E-");
  String formattedDate = localdatetime.format(datetimeformatter);

  void getdeliveryId() {
    int delivno = 10;
    String delivId = formattedDate + Integer.toString(delivno);
    System.out.println("\ndelivId:" + delivId);
    delivno++;

  }

  public void getorderDetails(int cid, String sellid, String droploc) {
    int ordernum = 200;
    DateTimeFormatter datetimeformatter1 = DateTimeFormatter.ofPattern("E-MMM-dd-");
    DateTimeFormatter datetimeformatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formatDate1 = localdatetime.format(datetimeformatter1);
    String formatDate2 = localdatetime.format(datetimeformatter2);
    String orderid = formatDate1 + Integer.toString(ordernum);
    String ordtime = formatDate2;
    System.out.println("\ncid:" + cid);
    System.out.println("\nsellerid:" + sellid);
    System.out.println("\norderid:" + orderid);
    System.out.println("\nordertime:" + ordtime);
    System.out.println("\nDrop location:" + droploc);
    orderid += 1;
  }

 /*public static void getpaymentdetails(String Info){
  System.out.println("\n 1.credit/debit card");
  
 System.out.println("\n2.UPI");
  
 System.out.println("\n 3.cash on delivery");
switch(options){
    case 1: 

            break;
    case 2: 
            break;
    case 3: 
            break;
    Default:
            System.out.println("Invalid Options Select a Vaild one");
            getpaymentdetails();
  }
}*/

public static void main(String args[]){
DeliverySystem deliverysystem = new DeliverySystem();
deliverysystem.getdeliveryId();
deliverysystem.getorderDetails(101,"A2b05","Ambattur");
//getpaymentdetails();
System.out.println("\n Estimated time:" + deliverysystem.estime); 
}
}
