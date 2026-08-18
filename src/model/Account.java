package model;

public class Account { 

    private int accountNumber ; 
    private String accountHolderName ; 
    private double balance ; 
    private String accountStatus ; 
    
    public Account(int accountNumber,String accountHolderName ,
                    double balance ,String accountStatus ) {
                        this.accountNumber = accountNumber ; 
                        this.accountHolderName = accountHolderName ; 
                        this.balance = balance ; 
                        this.accountStatus = accountStatus ; 
                    } 

public int getAccountNumber() {
    return accountNumber;
}

public String getAccountHolderName() {
    return accountHolderName;
}

public double getBalance() {
    return balance;
}

public String getAccountStatus() {
    return accountStatus;
}
public void setAccountHolderName(String accountHolderName) {
    this.accountHolderName = accountHolderName;
}

public void setAccountStatus(String accountStatus) {
    this.accountStatus = accountStatus;
}
public void deposit(double amount) {

    if (amount > 0) {
        balance += amount;
        System.out.println("Amount deposited successfully.");
    } else {
        System.out.println("Invalid deposit amount.");
    }
}
public void withdraw(double amount) {

    if (amount <= 0) {
        System.out.println("Invalid withdrawal amount.");
    } 
    else if (amount > balance) {
        System.out.println("Insufficient balance.");
    } 
    else {
        balance -= amount;
        System.out.println("Withdrawal successful.");
    }
}
public void displayAccountInfo() {
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Account Holder: " + accountHolderName);
    System.out.println("Balance: " + balance);
    System.out.println("Account Status: " + accountStatus);
  }
}