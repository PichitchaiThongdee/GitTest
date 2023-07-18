import java.util.Scanner;
public class Person
{
    int num;
    String[] ID = new String[5];
    String[] name = new String[5];
    String[] gender = new String[5];
    
    
    
}
class Account extends Person 
{   
    String[] accountID = new String[5];
    String[] password = new String[5];
    float[] balance = new float[5];
    String[] inputBalance = new String[5];
    String loginID;
    String loginPass;
    String choice;
    int currentAccount;
    float BTC;
    String inputBTC;
    interface ATMAction
    {
        public void checkable(int currentAccount);
        public void withdrawal(int currentAccount);
        public void depositeable(int currentAccounti);
        public void transferable(int currentAccount);
    }
    class ATM implements ATMAction
    {

        public void checkable(int currentAccount) {
            String checkChoice;
            float BTCBalance;
            System.out.println("1.Check:THB      2.Check:BTC");
            Scanner choose = new Scanner(System.in);
            System.out.print("choose: ");
            checkChoice = choose.nextLine();
            if(checkChoice.equals("1"))
            { 
                System.out.println("Balance = "+balance[currentAccount]+" THB");
            }
            if(checkChoice.equals("2"))
            { 
                BTCBalance = balance[currentAccount]/BTC; 
                System.out.println("Balance = "+BTCBalance+" BTC");
            }

            
        }

        public void withdrawal(int currentAccount) 
    {
            String withdrawChoice;
            float BTCBalance;
            BTCBalance = balance[currentAccount]/BTC; 
            System.out.println("Balance = "+balance[currentAccount]+" THB");
            System.out.println("Balance = "+BTCBalance+" BTC");
            System.out.println("1.Withdraw:THB      2.Withdraw:BTC");
            Scanner choose = new Scanner(System.in);
            System.out.print("choose: ");
            withdrawChoice = choose.nextLine();
        if(withdrawChoice.equals("1"))
            { 
                String select;
                System.out.println("Balance = "+balance[currentAccount]+" THB");
                System.out.println("Withdraw");
                System.out.println("1.100       2.500");
                System.out.println("3.1000      4.5000");
                System.out.println("5.Withdrawal Amount");
                Scanner s = new Scanner(System.in);
                System.out.print("choose: ");
                select = s.nextLine();
                if(select.equals("1") && balance[currentAccount] > 100)
                {
                balance[currentAccount] = balance[currentAccount] - 100;
                System.out.println("Balance = "+balance[currentAccount]);
                
                }
                if(select.equals("2") && balance[currentAccount] > 500)
                {
                    balance[currentAccount] = balance[currentAccount] - 500;
                    System.out.println("Balance = "+balance[currentAccount]);
                
                }
                if(select.equals("3") && balance[currentAccount] > 1000)
                {
                balance[currentAccount] = balance[currentAccount] - 1000;
                System.out.println("Balance = "+balance[currentAccount]);
                
                }
                if(select.equals("4") && balance[currentAccount] > 5000)
                {
                    balance[currentAccount] = balance[currentAccount] - 5000;
                    System.out.println("Balance = "+balance[currentAccount]);   
                }
                if(select.equals("5"))
                {
                    String withdraw;
                    Float withdrawal;
                    System.out.print("Pls Enter Withdrawal Amount: ");
                    Scanner money = new Scanner(System.in);
                    withdraw = money.nextLine();
                    while(withdraw.matches(".*[a-zA-Z]+.*"))
                    {  
                        System.out.print("Pls Enter Withdrawal Amount: ");
                        withdraw = money.nextLine();
                    }
                
                    withdrawal = Float.parseFloat(withdraw); 
                    if(balance[currentAccount] < withdrawal)
                    {
                        System.out.println("Dont have enough money!!!");
                    }
                    else
                    {
                    balance[currentAccount] = balance[currentAccount] - withdrawal;
                    System.out.println("Balance = "+balance[currentAccount]);
                    }
                }
                else
                {
                System.out.println("Dont have enough money!!!");
                }
                
            }
        if(withdrawChoice.equals("2") && BTCBalance >= 1)
            { 
                BTCBalance = balance[currentAccount]/BTC; 
                System.out.println("Balance = "+BTCBalance+" BTC");
                System.out.println("Balance = "+balance[currentAccount]+" THB");
                String withdraw;
                Float withdrawal;
                System.out.print("Pls Enter Withdrawal Amount on BTC: ");
                Scanner money = new Scanner(System.in);
                withdraw = money.nextLine();
                while(withdraw.matches(".*[a-zA-Z]+.*"))
                {  
                    System.out.print("Pls Enter Withdrawal Amount on BTC: ");
                    withdraw = money.nextLine();
                }
                
                withdrawal = Float.parseFloat(withdraw); 

                if(BTCBalance < withdrawal)
                {
                    System.out.println("Dont have enough money!!!");
                }
                else
                {
                    balance[currentAccount] = balance[currentAccount] - (withdrawal*BTC);
                    BTCBalance = balance[currentAccount]/BTC; 
                    System.out.println("Balance = "+BTCBalance+" BTC");
                    System.out.println("Balance = "+balance[currentAccount]+" THB");
                }
                
            }  
            else if(withdrawChoice.equals("2") && BTCBalance < 1)
                {
                    BTCBalance = balance[currentAccount]/BTC; 
                    System.out.println("Balance = "+BTCBalance+" BTC");
                    System.out.println("Balance = "+balance[currentAccount]+" THB");
                    String withdraw;
                    Float withdrawal;
                    System.out.print("Pls Enter Withdrawal Amount on THB: ");
                    Scanner money = new Scanner(System.in);
                    withdraw = money.nextLine();
                    while(withdraw.matches(".*[a-zA-Z]+.*"))
                    {  
                        System.out.print("Pls Enter Withdrawal Amount on THB: ");
                        withdraw = money.nextLine();
                    }
                
                    withdrawal = Float.parseFloat(withdraw); 
                    if(balance[currentAccount] < withdrawal)
                    {
                        System.out.println("Dont have money");
                    }
                    else
                    {
                        balance[currentAccount] = balance[currentAccount] - withdrawal;
                        BTCBalance = balance[currentAccount]/BTC;
                        System.out.println("Balance = "+BTCBalance+" BTC");
                        System.out.println("Balance = "+balance[currentAccount]+" THB");
                    }
                }
    }

        public void depositeable(int currentAccount) 
        {
            String depositeable;
            int deposite;
            System.out.println("Balance = "+balance[currentAccount]);
            System.out.print("Enter Amount Deposite: ");
            Scanner money = new Scanner(System.in);
            depositeable = money.nextLine();   
            while(depositeable.matches(".*[a-zA-Z]+.*"))
                {  
                    System.out.println("Pls Enter Withdrawal Amount");
                    depositeable = money.nextLine();
                }
            deposite = Integer.parseInt(depositeable);
            balance[currentAccount] = balance[currentAccount] + deposite;
        }

        public void transferable(int currentAccount) 
        {
            String transferID;
            System.out.print("Enter Account ID For Transferable: ");
            Scanner inputID = new Scanner(System.in);
            transferID = inputID.nextLine();
            for(int i = 0 ; i < num ; i++)
            {   
                if(transferID.equals(accountID[i]))
                    {
                        String transferable;
                        int transfer;
                        System.out.print("Enter Amount To Tranferable: ");
                        Scanner money = new Scanner(System.in);
                        transferable = money.nextLine();
                            while(transferable.matches(".*[a-zA-Z]+.*"))
                            {  
                                System.out.print("Pls Enter Withdrawal Amount: ");
                                transferable = money.nextLine();
                            }
                        transfer = Integer.parseInt(transferable);
                        balance[currentAccount] = balance[currentAccount] - transfer;
                        balance[i] = balance[i] + transfer;
                        System.out.println("i account Balance ="+balance[i]);
                        System.out.println("Current account Balance = "+balance[currentAccount]);
                    }
            } 
        }
    }
    public void setAmountUser(int amount)
    {
        setAccout(amount);
        this.num = amount;
    }
    public void setAccout(int amount) 
    {   
        int count = 0;
        for(int i = 0 ; i < amount ; i++){
        count++;
        System.out.println("No."+count);
        System.out.print("Enter ID =");
        Scanner inputID = new Scanner(System.in);
        this.ID[i] = inputID.nextLine();
        System.out.print("Enter Name =");
        Scanner inputName = new Scanner(System.in);
        this.name[i] = inputID.nextLine();
        System.out.print("Gender M / F =");
        Scanner inputGender = new Scanner(System.in);
        this.gender[i] = inputGender.nextLine();
        while(this.gender[i].length() != 1 || !gender[i].matches(("[mfFM]")))
        {
            System.out.println("Error Wrong word!!!");
            System.out.print("Gender M / F ="); 
            this.gender[i] = inputGender.nextLine();
        }
        System.out.print("Enter Accout ID =");
        Scanner inputAccountID = new Scanner(System.in);
        this.accountID[i] = inputAccountID.nextLine();
        System.out.println("Account ID ="+this.accountID[i]);
        System.out.print("Enter Password 4 digit =");
        Scanner inputPassword = new Scanner(System.in);
        this.password[i] = inputPassword.nextLine();
        while(this.password[i].length() != 4 || this.password[i].matches(".*[a-zA-Z]+.*"))
        {
            System.out.println("Input Password Worng!!!");
            System.out.print("Enter Password 4 digit ="); 
            this.password[i] = inputPassword.nextLine();
        }
        System.out.println("Password = ****");
        System.out.print("Enter Balance = ");
        Scanner inputBalance = new Scanner(System.in);
        this.inputBalance[i] = inputBalance.nextLine();
        while(this.inputBalance[i].matches(".*[a-zA-Z]+.*"))
        {  
            System.out.println("Balance Wrong!!! Pls Enter Number");
            System.out.print("Enter Balance = ");
            this.inputBalance[i] = inputBalance.nextLine();
        }
        this.balance[i] = Integer.parseInt(this.inputBalance[i]);
        System.out.println("Balance = "+this.balance[i]);
        
        }
    }
    public void home()
    {
        if(this.num != 0)
        {  
            
            System.out.println("ATM ComputerThanyaburi Bank");
            System.out.print("Enter Account ID :");
            Scanner inputID = new Scanner(System.in);
            this.loginID = inputID.nextLine();
            System.out.println(" Account ID ="+this.loginID);
            System.out.print("Enter Password :");
            Scanner inputPass = new Scanner(System.in);
            this.loginPass = inputPass.nextLine();
            for(int i = 0 ; i < this.num ; i++)
            {
                while (this.loginPass.length() != 4 || this.loginPass.matches(".*[a-zA-Z]+.*")) 
                {
                    System.out.println("Input Password Worng!!!");
                    System.out.print("Enter Password 4 digit ="); 
                    this.loginPass = inputPass.nextLine();
                }
            }
            System.out.println("Password ="+this.loginPass);
            for(int i = 0 ; i < this.num ; i++)
            {
                if(this.loginID.equals(this.accountID[i]) && this.loginPass.equals(this.password[i]))
                    {
                        this.currentAccount = i;
                        logedIn();
                    }
        
            }
        }
        else
        {
            System.out.println("Dont have any accout");
        }
                
    }
    public void logedIn()
    {
        ATM b = new ATM();
        System.out.println("ATM ComputerThanyaburi Bank");
                    System.out.println("Account ID :"+accountID[currentAccount]);
                    System.out.println("Menu Service");
                    System.out.println("1.Account Balance");
                    System.out.println("2.Withdrawal");
                    System.out.println("3.Deposite");
                    System.out.println("4.Transfer");
                    System.out.println("5.Exit");
                    System.out.print("Choose: ");
                    Scanner choose = new Scanner(System.in);
                    choice = choose.nextLine();
                
                if(choice.equals("1"))
                {
                    b.checkable(currentAccount);
                    logedIn();
                    this.choice = "";
                }
                if(choice.equals("2"))
                {
                    b.withdrawal(currentAccount);
                    logedIn();
                    this.choice = "";
                }
                if(choice.equals("3"))
                {
                    b.depositeable(currentAccount);
                    logedIn();
                    this.choice = "";
                }
                if(choice.equals("4"))
                {
                    b.transferable(currentAccount);
                    logedIn();
                    this.choice = "";
                }
                if(choice.equals("5"))
                {
                    System.out.println("Exit");
                    this.choice = "";
                }
    }
}

class Manager extends Account
{   
    
    String loginID;
    String loginPass;
    String managerID;
    String managerPass;
    public void setManager(String idManager,String passManager)
    {
        this.managerID = idManager;
        this.managerPass = passManager;
    }
    public void setBitrate()
    {
        System.out.print("Enter BTC Rate = ");
        Scanner inputRate = new Scanner(System.in);
        this.inputBTC = inputRate.nextLine();
        while(this.inputBTC.matches("*[a-zA-Z]+.*."))
        {  
            System.out.println("Pls Enter Number");
            System.out.print("Enter BTC Rate = ");
            this.inputBTC = inputRate.nextLine();
        }
        this.BTC = Integer.parseInt(this.inputBTC);
        System.out.println("BTC Rate 1 BTC : "+this.BTC+" THB");
    }
    public void login()
    {
        System.out.println("Manager Login");
        System.out.print("Enter Account ID :");
        Scanner inputID = new Scanner(System.in);
        this.loginID = inputID.nextLine();
        System.out.println(" Account ID ="+this.loginID);
        System.out.print("Enter Password :");
        Scanner inputPass = new Scanner(System.in);
        this.loginPass = inputPass.nextLine();
        if(this.loginID.equals(this.managerID) && this.loginPass.equals(this.managerPass))
        {
            System.out.println("Login Success");
        }
        else
        {
            System.out.println("Wrong ID or Password!!!");
            login();
        }
    }
    
}
