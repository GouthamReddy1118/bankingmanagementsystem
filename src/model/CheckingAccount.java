package model;

public class CheckingAccount extends Account {
    private double withdrawalLimit ;
    public CheckingAccount(int accountNumber,String accountHolderName,double balance , String accountStatus,double withdrawalLimit){
        super(accountNumber,accountHolderName,balance,accountStatus) ;
        this.withdrawalLimit = withdrawalLimit ;
    }
    public double getWithdrawalLimit(){
        return withdrawalLimit ; 
    }
    @Override
public void withdraw(double amount) {
        if (amount > withdrawalLimit) {
    System.out.println("Withdrawal exceeds the daily limit.");
      }
      else{
        super.withdraw(amount) ; 
      }
    }
}
