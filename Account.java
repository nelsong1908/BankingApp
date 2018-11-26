// **********************************************************************************************
// Program: Account.java
// Name: Gerald Nelson
// VUnetID: nelsong3
// Section: Section 1
// Email: gerald.nelson@vanderbilt.edu 
// Class: CS 1101 - Vanderbilt University
// Date: 4/16/2018
// Honor statement: I attest that I understand the honor code for this class and have neither given 
//                  nor received any unauthorized aid on this assignment.
//
// Program Description:
//      A application that holds the data and methods for some bank account.
//
// **********************************************************************************************


public class Account {
    //field variables
    private int accountNumber;
    private double balance;
    //constructor for Account class
    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        balance = 0;
    }

    //object methods

    /**
     * getBalance() -returns account balance
     * @return - account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * getAccountNumber() - returns account number
     * @return - account number
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * credit() - adds an specified amount to the balance.
     * @param amount - an amount passed to the method.
     */
    public void credit (double amount) {
        balance += amount;
        return;
    }

    /**
     * debit() - subtracts a specified amount from the balance.
     * @param amount - an amount passed to the method.
     */
    public void debit (double amount) {
        balance -= amount;
        return;
    }

}
