package com.atmApp;
/**
 * This is the Account class.
 * The standard functions of interacting with an account will be here
 */
public class Account extends Database{
    private double balance;
    private int id;
    private String name;
    private String pinNumber;
    /**
     * Default constructor for Account 
     * Initializes variables
     */
    public Account(){
        this.balance = 0;
        this.id = 0;
        this.name = "";
        this.pinNumber = "0000";
    }
    /**
     * Account constructor
     * Assigns @param name to the name variable.
     * Assigns the account its own UUID.
     * Initializes account balance to 0.
     * @param name
     */
    public Account(String name, String pinNumber){
        this.balance = 0;
        this.id = (int) (Math.random() * 10);
        this.name = name;

        this.pinNumber = pinNumber;

        newAccount(this);
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
    int getId(){
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
