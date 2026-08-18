package service;

import java.util.ArrayList;
import model.Account;

public class BankService {

    private ArrayList<Account> accounts;

    public BankService() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account added successfully.");
    }

    public Account findAccount(int accountNumber) {

        for (Account account : accounts) {

            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        return null;
    }
    public void deposit(int accountNumber, double amount) {

    Account account = findAccount(accountNumber);

    if (account != null) {
        account.deposit(amount);
    } else {
        System.out.println("Account not found.");
    }
  }
  public void withdraw(int accountNumber, double amount) {

    Account account = findAccount(accountNumber);

    if (account != null) {
        account.withdraw(amount);
    } else {
        System.out.println("Account not found.");
    }
  }
  public void displayAccount(int accountNumber) {

    Account account = findAccount(accountNumber);

    if (account != null) {
        account.displayAccountInfo();
    } else {
        System.out.println("Account not found.");
    }
   }
   public void removeAccount(int accountNumber) {

    Account account = findAccount(accountNumber);

    if (account != null) {
        accounts.remove(account);
        System.out.println("Account removed successfully.");
    } else {
        System.out.println("Account not found.");
    }
   }
}