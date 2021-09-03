package com.example;

public class Account {
    private int accountNumber;
    private double accountBalance;

    public Account() {}

    public Account(int accountNumber, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return this.accountBalance;
    }

    public void setBalance(double saldo) {
        this.accountBalance = saldo;
    }

    public void withdraw(double withdrawValue) {
        this.accountBalance -= withdrawValue;
    }

    public void deposit(double depositValue) {
        this.accountBalance += depositValue;
    }
}
