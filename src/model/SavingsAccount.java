package model;

public class SavingsAccount extends Account {
    private double interestRate;
    public SavingsAccount(int accountNumber, String accountHolderName,
                          double balance, String accountStatus,double interestRate) {

        super(accountNumber, accountHolderName, balance, accountStatus);
        this.interestRate = interestRate ;
    }
    public double getInterestRate(){
        return interestRate ; 
    }
    public double calculateInterest() {
    return getBalance() * interestRate / 100;
  }
}