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
    private transactionHistory transactionHistory;
    /**
     * Default constructor for Account 
     * Initializes variables
     */
    public Account(){
        this.balance = 0;
        this.id = 0;
        this.name = "";
        this.pinNumber = "0000";
        this.transactionHistory = new transactionHistory(this);
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
        this.transactionHistory = new transactionHistory(this);
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
    public Account getAccount(int id){
        Database account= new Database();
        return account.accountDatabase.get(id);
    }
    /**
     * Returns transaction history for the corresponding account.
     * @return transactionHistory
     */
    public transactionHistory getTransactionHistory() {
        return this.transactionHistory;
    }
    /**
     * getBalance method
     * Returns the balance of the account
     * @return this.balance
     */
    double getBalance(){
        return this.balance;
    }
    /**
     * deposit method
     * Takes @param depositAmount and adds it to account balance
     * @param depositAmount
     */
    void deposit(double depositAmount){
        this.balance += depositAmount;
        this.transactionHistory.depositTransaction(depositAmount,this.balance);
    }
    /**
     * Withdraw method
     */
    void withdraw(double withdrawAmount){
        this.balance = getBalance() - withdrawAmount;
        this.transactionHistory.withdrawTransaction(withdrawAmount,this.balance);
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
}
