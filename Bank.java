import java.util.Scanner;

public class Bank 
{
    public static void main(String[] args){
        String idManager;
        String passManager;
        int amount;
        Manager m = new Manager();
        Scanner mID = new Scanner(System.in);
        System.out.println("Setting Manager User");
        System.out.print("Enter ManagerID:");
        idManager = mID.nextLine();
        Scanner mPass = new Scanner(System.in);
        System.out.print("Enter ManagerPass:");
        passManager = mPass.nextLine();
        while(passManager.length() != 4 || passManager.matches(".*[a-zA-Z]+.*"))
        {
            System.out.println("Input Password Worng!!!");
            System.out.print("Enter ManagerPassword 4 digit ="); 
            passManager = mPass.nextLine();
        }
        m.setManager(idManager,passManager);
        m.login();
        m.setBitrate();
        Scanner user = new Scanner(System.in);
        System.out.print("Enter Amount Accout:");
        amount = user.nextInt();
        System.out.println(amount);
        m.setAmountUser(amount);
        m.home(); 
        m.home();  
    }
    
}
