# 🏦 Banking Management System

A Java-based Banking Management System developed using Object-Oriented Programming (OOP) concepts.

## 📌 Project Description

The Banking Management System allows users to create and manage different types of bank accounts through a console-based menu.

The system supports:

- Savings Account
- Checking Account
- Student Account

Users can create accounts, deposit money, withdraw money, find accounts, display account details, remove accounts, and calculate interest for Savings Accounts.

## 🚀 Features

### 1. Create Account
Users can create:

- Savings Account
- Checking Account
- Student Account

The system validates:

- Account number
- Account holder name
- Initial balance
- Account status
- Interest rate
- Withdrawal limit
- Student ID

### 2. Deposit Money

Users can deposit money into an existing active account.

The system checks:

- Whether the account exists
- Whether the account is active
- Whether the deposit amount is valid

### 3. Withdraw Money

Users can withdraw money from an existing active account.

The system checks:

- Whether the account exists
- Whether the account is active
- Whether the withdrawal amount is valid
- Whether sufficient balance is available
- Checking account withdrawal limit

### 4. Display Account

Displays account information such as:

- Account number
- Account holder name
- Balance
- Account status

### 5. Find Account

Searches for an account using its account number.

### 6. Remove Account

Removes an existing account from the banking system.

### 7. Calculate Interest

Calculates interest for Savings Accounts using:

Interest = Balance × Interest Rate / 100

### 8. Exit

Closes the banking application safely.

## 🧱 Project Structure

```text
Banking Management System
│
├── src
│   ├── model
│   │   ├── Account.java
│   │   ├── SavingsAccount.java
│   │   ├── CheckingAccount.java
│   │   └── StudentAccount.java
│   │
│   ├── service
│   │   └── BankService.java
│   │
│   └── main
│       └── Main.java
│
└── README.md