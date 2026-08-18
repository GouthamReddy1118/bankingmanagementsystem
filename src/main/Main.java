package main;

import java.util.Scanner;
import model.Account;
import model.SavingsAccount;
import model.CheckingAccount;
import model.StudentAccount;
import service.BankService;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BankService bank = new BankService();

        while (true) {

            System.out.println("\n========================================");
            System.out.println("       BANKING MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Display Account");
            System.out.println("5. Find Account");
            System.out.println("6. Remove Account");
            System.out.println("7. Calculate Interest");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.nextLine();
                        continue;
                    }
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter account number: ");
                    int accountNumber = scanner.nextInt();
                    if (bank.findAccount(accountNumber) != null) {
                              System.out.println("Account number already exists.");
                              break;
                      }
                    System.out.print("Enter account holder name: ");
                    scanner.nextLine();
                    String accountHolderName = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double balance = scanner.nextDouble();
                    if (balance < 0) {
                                  System.out.println("Initial balance cannot be negative.");
                                 break;
                            }
                    System.out.print("Enter account status: ");
                    scanner.nextLine();
                    String accountStatus = scanner.nextLine();
                    if (!accountStatus.equalsIgnoreCase("Active")
                                     && !accountStatus.equalsIgnoreCase("Inactive")) {
                            System.out.println("Invalid account status.");
                             break;
                        }
                    System.out.println("Select account type:");
                    System.out.println("1. Savings Account");
                    System.out.println("2. Checking Account");
                    System.out.println("3. Student Account");
                    System.out.print("Enter account type: ");
                    int accountType = scanner.nextInt();
                        Account account = null;
                    if (accountType == 1) {
                    System.out.print("Enter interest rate: ");
                    double interestRate = scanner.nextDouble();
                    if (interestRate < 0) {
                            System.out.println("Interest rate cannot be negative.");
                            break;
                        }
                    account = new SavingsAccount(
                    accountNumber,
                    accountHolderName,
                    balance,
                    accountStatus,
                    interestRate
                );
            }
                    else if (accountType == 2) {
                    System.out.print("Enter withdrawal limit: ");
                    double withdrawalLimit = scanner.nextDouble();
                     if (withdrawalLimit < 0) {
                                System.out.println("Withdrawal limit cannot be negative.");
                                 break;
                            }
                    account = new CheckingAccount(
                    accountNumber,
                    accountHolderName,
                    balance,
                    accountStatus,
                    withdrawalLimit
                );
            }
                   else if (accountType == 3) {
                   System.out.print("Enter student ID: ");
                   scanner.nextLine();
                   String studentId = scanner.nextLine();
                   account = new StudentAccount(
                   accountNumber,
                   accountHolderName,
                   balance,
                   accountStatus,
                   studentId
                );
            }
                   else {
                   System.out.println("Invalid account type.");
            }
                  if (account != null) {
                   bank.addAccount(account);
            }
                   break;
                case 2:
                    System.out.print("Enter account number: ");
                     int depositAccountNumber = scanner.nextInt();
                    if (bank.findAccount(depositAccountNumber) == null) {
                           System.out.println("Account not found.");
                            break;
                        }
                        Account depositAccount = bank.findAccount(depositAccountNumber);
                                if (!depositAccount.getAccountStatus().equalsIgnoreCase("Active")) {
                                         System.out.println("Account is inactive.");
                                         break;
                                        }
                      System.out.print("Enter deposit amount: ");
                      double depositAmount = scanner.nextDouble();
                     if (depositAmount <= 0) {
                                    System.out.println("Deposit amount must be greater than zero.");
                                    break;
                                } 
                     bank.deposit(depositAccountNumber, depositAmount);
                     break;
                case 3:
                    System.out.print("Enter account number: ");
                    int withdrawAccountNumber = scanner.nextInt(); 
                    if (bank.findAccount(withdrawAccountNumber) == null) {
                                 System.out.println("Account not found.");
                                 break;
                                }
                    Account withdrawAccount = bank.findAccount(withdrawAccountNumber);
                            if (!withdrawAccount.getAccountStatus().equalsIgnoreCase("Active")) {
                                    System.out.println("Account is inactive.");
                                    break;
                                }           
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount <= 0) {
                                System.out.println("Withdrawal amount must be greater than zero.");
                                break;
                            }
                    bank.withdraw(withdrawAccountNumber, withdrawAmount);
                    break;
                case 4 : 
                    System.out.print("Enter account number: ");
                    int displayAccountNumber = scanner.nextInt();
                      if (bank.findAccount(displayAccountNumber) == null) {
                                 System.out.println("Account not found.");
                                 break;
                                 }

                    bank.displayAccount(displayAccountNumber);
                     break;
                case 5:
                    System.out.print("Enter account number: ");
                    int findAccountNumber = scanner.nextInt();
                    Account foundAccount = bank.findAccount(findAccountNumber);
                     if (foundAccount != null) {
                          System.out.println("Account found successfully.");
                         foundAccount.displayAccountInfo();
                    } else {
                        System.out.println("Account not found.");
                           }
                  break;
                case 6:              
                    System.out.print("Enter account number: ");
                    int removeAccountNumber = scanner.nextInt();
                    if (bank.findAccount(removeAccountNumber) == null) {
                            System.out.println("Account not found.");
                             break;
                        }
                    bank.removeAccount(removeAccountNumber);
                    break;
                    case 7:
                         System.out.print("Enter account number: ");
                        int interestAccountNumber = scanner.nextInt();
                        Account interestAccount = bank.findAccount(interestAccountNumber);
                        if (interestAccount == null) {
                                 System.out.println("Account not found.");
                                break;
                                }
                        if (interestAccount instanceof SavingsAccount) {
                                SavingsAccount savingsAccount =
                                 (SavingsAccount) interestAccount;
                                double interest = savingsAccount.calculateInterest();
                                System.out.println("Interest Rate: "
                                                         + savingsAccount.getInterestRate() + "%");
                             System.out.println("Calculated Interest: "
                                             + interest);
                     } else {
                            System.out.println(
                           "Interest calculation is available only for Savings Account."
                        );
                    }
                    break;
                case 8:
                    System.out.println(
                        "Thank you for using Banking Management System."
                    );
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
} 
 