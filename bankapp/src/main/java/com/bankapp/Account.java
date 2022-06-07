package com.bankapp;
import java.util.UUID;
import java.text.DecimalFormat;
/**
 * This is the Account class.
 * The standard functions of interacting with an account will be here
 */
public class Account {
    private double balance;
    private UUID id;
    private String name;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    /**
     * Default constructor for Account 
     * Initializes variables
     */
    public Account(){
        this.balance = 0;
        this.id = UUID.randomUUID();
        this.name = "";
    }
    /**
     * Account constructor
     * Assigns @param name to the name variable.
     * Assigns the account its own UUID.
     * Initializes account balance to 0.
     * @param name
     */
    public Account(String name){
        this.balance = 0;
        this.id = UUID.randomUUID();
        this.name = name;
    }
    /**
     * Copy constructor for Account
     * Creates new 
     * @param account
     */
    public Account(Account account){
        this.balance = account.balance;
        this.id = account.id;
        this.name = account.name;
    }
    /**
     * getBalance method
     * Returns the balance of the account
     * @return this.balance
     */
    double getBalance(){
        //df.format(this.balance);
        return this.balance;
    }
    /**
     * deposit method
     * Takes @param depositAmount and adds it to account balance
     * @param depositAmount
     */
    void deposit(double depositAmount){
        this.balance += depositAmount;
        System.out.println("Deposit complete. $" + depositAmount + " has been deposited into your account.");
    }
    /**
     * Withdraw method
     */
    void withdraw(double withdrawAmount){
        this.balance = getBalance() - withdrawAmount;
        System.out.println("Withdrawal was complete. $" +withdrawAmount + " was withdrawn from your account.");
    }
    /**
     * getName method
     * Returns name of the account
     */
    String getName(){
        return this.name;
    }
    /**
     * getId method
     * returns the @param UUID of the account
     * @return this.id
     */
    UUID getId(){
        return this.id;
    }
    /**
     * Name setter method
     * Assigns @param name to objects name value
     */
    void setName(String name){
        this.name = name;
    }
    
}
