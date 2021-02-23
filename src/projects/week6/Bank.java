package projects.week6;

import java.util.ArrayList;

public class Bank {
    private ArrayList<BankAccount> accounts;
    public Bank()
    {
        accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount bankAccount)
    {
        accounts.add(bankAccount);
    }

    public int find(int accountNumber)
    {
        for(int i=0; i<accounts.size(); i++)
        {
            /*
            What was shown in class in case you want it.
            BankAccount current = accounts.get(i);
            int accountNum = current.getAccountNumber();
            if(accountNum == accountNumber)
                return i;
             */
            if(accounts.get(i).getAccountNumber() == accountNumber)
                return i;
        }
        return -1;
    }

    @Override
    public String toString()
    {
        // The professor uses String concatination for this, however
        // String Builders are designed with the purpose of
        // building a string by appending elements together.
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<accounts.size(); i++)
        {
            BankAccount account = accounts.get(i);
            builder.append(String.format("%s\t%d\t%,.2f\n",account.getName(),account.getAccountNumber(), account.getBalance()));
        }
        return builder.toString();
    }

    public boolean checkBalance(int location)
    {
        BankAccount current = accounts.get(location);
        return current.getBalance() >= 0;
    }

    public void depositToBank(double amount, int location)
    {
        BankAccount current = accounts.get(location);
        current.deposit(amount);
        // In the case of Multi-threading, make sure this bank account is the updated version.
        accounts.set(location, current);
    }

    public void withdrawFromBank(double amount, int location)
    {
        BankAccount current = accounts.get(location);
        current.withdraw(amount);
        // In the case of Multi-threading, make sure this bank account is the updated version.
        accounts.set(location, current);
    }
}
