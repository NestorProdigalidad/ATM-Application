package com.bankapp;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * This class the main BankApp class.
 * How it works:
 * create an account, withdraw, deposit.
 */
public class BankApp extends Account{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //ArrayList<Account> accountArray = new ArrayList<Account>();
        int bankFunction = 0;
        System.out.println("\nWelcome to the bank.");
        
        Account account = new Account();
        while(bankFunction != 5){
            System.out.println("Select a function you would like to perform.");
            System.out.println("1. Open an account.\n2. Check Balance.\n3. Deposit to an account.\n4. Withdraw from an account.\n5. Quit");
            bankFunction = sc.nextInt();
            sc.nextLine();
            if(bankFunction == 1){
                System.out.println("What is the name of the account holder?");
                account.setName(sc.nextLine());
                System.out.println("An account has been opened under the name " + account.getName() + ". Your corresponding ID is: " + account.getId());
            }
            if(bankFunction == 2){
                System.out.println("Your account balance is $" + account.getBalance() + ".");
            }
            if(bankFunction == 3){
                System.out.println("How much would you like to deposit?");
                account.deposit(sc.nextDouble());
            }
            if(bankFunction == 4){
                System.out.println("How much would you like to withdraw?");
                account.withdraw(sc.nextDouble());
            }
            else if (bankFunction > 5 || bankFunction <= 0 ){
                System.out.println("Only inputs 1, 2, 3, 4, and 5 are accepted. Please enter a valid input.");
            }
        }
        sc.close();
    }
}
/**
 * To do:
 * Finish bank App
 *  functionalities should be
 *      Withdraw/deposit
 *      open/close account
 *          must withdraw all funds before closing

 */
