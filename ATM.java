package atm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ATM {
    private final Map<Integer, Account> accounts = new HashMap<>(); // creating a map
    Scanner scanner = new Scanner(System.in); // for reading inputs from the console

    public ATM() 
    {
        accounts.put(123456, new Account(123456, "Vasavi", 5000, 1234)); // inserting values to the map.
        accounts.put(11111, new Account(11111, "Yaswanth", 2000, 1111));
    } 

    public void run()
    {
        System.out.println("Welcome to the ATM!");
        System.out.print("Enter your account number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();

        if (authenticateUser(accountNumber, pin)) 
        {
              Account account = accounts.get(accountNumber);
              processTransactions(account);   
        } 
        else
        {
            System.out.println("Invalid Account number or PIN!");
        }
    }

    private boolean authenticateUser(int accountNumber, int pin) // if accountnumber with provided accountnumber exists in the map and pin with provided pin matches, then only the method will return true.
    { 
        Account account = accounts.get(accountNumber);
        return account != null && account.getPin() == pin;  
    }

    private void processTransactions(Account account)
    { 
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: "); 
            int choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                	System.out.println("Current balance: " + account.getBalance());  
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount); //calling withdraw method from Account class to perform withdraw operation
                    break;
                case 2:
                	System.out.println("Current balance: " + account.getBalance());
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount); //calling deposit method from Account class to perform deposit operation
                    break;
                case 3:
                    System.out.println("Current balance: " + account.getBalance());  // It will print the current balance
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");   // Exit from the ATM
                    return;                  
                default:
                    System.out.println("Invalid choice!");
                    return; 
            } 
        }
    }
}

