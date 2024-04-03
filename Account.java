package atm;

class Account
{
    private final int accountNumber; 
    private String accountHolder;
    private double balance;
    private final int pin;

    public Account(int accountNumber, String accountHolder, double balance, int pin) //Generating Constructor Using Fields
    {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder; 
        this.balance = balance; 
        this.pin = pin;
    }

    public int getAccountNumber()  //returning account number
    {
        return accountNumber;
    }
    
    public String getAccountHolder()
    {
    	return accountHolder; 
    }

    public double getBalance()     // returning balance
    {
        return balance;
    }

    public int getPin()            // returning pin
    {
        return pin;
    }

    public void withdraw(double amount) // method for withdraw an amount
    {
        if (amount > 0 && amount <= balance)
        {
            balance = balance - amount;  // withdraw the amount from balance 
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        }
        else
        {
            System.out.println("Insufficient funds!");
        }
    }

    public void deposit(double amount)     // method for deposit an amount
    
    {
        if (amount > 0)
        {
            balance = balance + amount;    // adding the amount to the balance
            System.out.println("Deposit successful. New balance: " + balance);
        }
        else
        {
            System.out.println("Invalid amount!");
        }
    }
}