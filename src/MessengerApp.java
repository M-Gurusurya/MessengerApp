import java.util.Scanner;
import java.util.regex.*;
interface MessagingService{
    void sendMessage();
}
class SMSMessagingService implements MessagingService
{
    @Override
    public void sendMessage()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter mobile number");
        long mobile_number = scanner.nextLong();
        String mob_num = String.valueOf(mobile_number);
        if(mob_num.matches("[6-9]\\d{9}"))
        {
            System.out.println("Enter message to sent:");
            String message= scanner.next();
            System.out.println("SMS SENDED !! ");
            System.out.println(message+" is sent to "+mobile_number);
        }
        else
        {
            System.out.println("Enter Valid Mobile Number");
        }
    }
}
class EmailMessagingService implements MessagingService
{
    Scanner scanner=new Scanner(System.in);
    @Override
    public void sendMessage()
    {
        System.out.println("enter email address");
        String email = scanner.next();
        Scanner scanner=new Scanner(System.in);
        if(email.matches("[a-z0-9]+@[a-z]+\\.[a-z]{2,3}"))
        {
            System.out.println("Enter message to sent:");
            String message= scanner.next();
            System.out.println("Email SENDED !! ");
            System.out.println(message+" is sent to "+email);
        }
        else
        {
            System.out.println("Enter Valid Email Address");
        }
    }
}class WhatsAppMessagingService implements MessagingService
{
    Scanner scanner=new Scanner(System.in);
    @Override
    public void sendMessage()
    {
        System.out.println("Do you have whatsapp? if yes press '1' or press '2'");
        int have_whatsapp=scanner.nextInt();
        if(have_whatsapp==1)
        {
            System.out.println("enter whatsapp number");
            long whatsapp_number=scanner.nextLong();
            String wha_num=String.valueOf(whatsapp_number);
            if(wha_num.matches("[6-9]\\d{9}"))
            {
                System.out.println("Enter message to sent:");
                String message= scanner.next();
                System.out.println("Whatsapp Message SENDED !! ");
                System.out.println(message+" is sent to "+whatsapp_number);
            }
            else
            {
                System.out.println("Enter Valid Whatsapp Number");
            }
        }
        else
        {
            System.out.println("you are not able to send whatsapp message without whatsapp");
        }
    }
}
class Message
{
    public void displayMessage(MessagingService ms)
    {
        ms.sendMessage();
    }
}
public class MessengerApp {
    public static void main(String[] args) {
        SMSMessagingService sms=new SMSMessagingService();
        EmailMessagingService ems=new EmailMessagingService();
        WhatsAppMessagingService wms=new WhatsAppMessagingService();
        Message message=new Message();
        Scanner scanner=new Scanner(System.in);
        do{
            System.out.println("\npress '1' for sms");
            System.out.println("press '2' for email");
            System.out.println("press '3' for whatsapp");
            System.out.println("press '4' to exit");
            int choice=scanner.nextInt();
            if(choice==1)
            {
                message.displayMessage(sms);
            }
            else if(choice==2)
            {
                message.displayMessage(ems);
            }
            else if(choice==3)
            {
                message.displayMessage(wms);
            } else if (choice==4) {
                System.out.println("Thankyou !");
                break;
            }
        }while(true);
    }
}
