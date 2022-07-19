package com.atmApp;
/**
 * This is the Account class.
 * The standard functions of interacting with an account will be here
 */
public class Account {
    private double balance;
    private int id;
    private String name;
    private String pinNumber;
    private transactionHistory transactionHistory;
    /**
     * Default constructor for Account
     * Initializes variables
     */
    Account(){
        this.balance = 0;
        this.id = 0;
        this.name = "";
        this.pinNumber = "";
        this.transactionHistory = null;
    }
    /**
     * Account constructor
     * Assigns @param name to the name variable.
     * Assigns the account its own ID.
     * Initializes account balance to 0.
     * @param name
     */
    Account(String name, String pin){
        this.balance = 0;
        this.id = (int) (Math.random() * 10);
        setName(name);
        setPinNumber(pin);
        this.transactionHistory = new transactionHistory(this);
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
    public Account getAccount(int id){
        Database account = new Database();
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

    public void setTransactionHistory(com.atmApp.transactionHistory transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }

    public void setName(String name) {
        this.name = name;
    }
}
