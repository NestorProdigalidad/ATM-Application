package com.atmApp;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;

/**
 * This class the main BankApp class.
 * How it works:
 * create an account, withdraw, deposit.
 */
public class atmApp implements ActionListener {
    private static JTextField usernameField;
    private static JPasswordField pinField;
    JFrame frame = new JFrame("ATM");
    JPanel loginScreen,atmScreen,cardPane;
    CardLayout card;
    public void atmGUI(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,150);
        loginScreen = new JPanel();
        atmScreen = new JPanel();
        cardPane = new JPanel();

        JLabel userName = new JLabel("Enter your Username: ");
        userName.setBounds(20,20,135,25);
        usernameField = new JTextField();
        usernameField.setBounds(150,20,135,25);
        JLabel pinNumber = new JLabel("Enter your PIN: ");
        pinNumber.setBounds(60,50,135,25);
        pinField = new JPasswordField();
        pinField.setBounds(150,50,135,25);
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(215,80,69,25);
        loginButton.addActionListener(this);
        loginScreen.add(userName);
        loginScreen.add(usernameField);
        loginScreen.add(pinNumber);
        loginScreen.add(pinField);
        loginScreen.add(loginButton);
        loginScreen.setLayout(null);

        JLabel checkBalanceButton = new JLabel("Check Balance.");
        checkBalanceButton.setBounds(20,20,70, 25);
        atmScreen.add(checkBalanceButton);
        //atmScreen.setLayout(null);

        card = new CardLayout();

        cardPane.setLayout(card);
        cardPane.add(loginScreen);
        cardPane.add(atmScreen);

        frame.add(cardPane);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String pinNum = String.valueOf(pinField.getPassword());
        System.out.println(username+" "+ pinNum);
        card.last(cardPane);
    }
    public static void main(String[] args) {
        atmApp atm = new atmApp();
        atm.atmGUI();
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
