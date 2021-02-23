package projects.week6;

public class BankAccount {
    private int accountNumber;
    private double balance;
    private String name;

    private static int acctCount = 0;
    public BankAccount()
    {
        /*
        What he had in class in case you want to use it instead.
        accountNumber = 0;
        balance = 0;
        name = "";
        acctCount++;
         */
        this(0,0,"");
    }

    public BankAccount(int accountNumber, double balance, String name)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.name = name;
        acctCount++;
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public void deposit(double amount)
    {
        this.balance += amount;
    }

    public void withdraw(double amount)
    {
        this.balance -= amount;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public static int getAcctCount()
    {
        return acctCount;
    }

    @Override
    public String toString()
    {
        return String.format("BankAccount: acctNumber %d balance : $%,.2f name : %s",accountNumber,balance,name);
    }
}
