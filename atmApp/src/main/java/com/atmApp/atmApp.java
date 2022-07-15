package com.atmApp;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Scanner;
import javax.swing.*;

/**
 * This class the main BankApp class.
 * How it works:
 * create an account, withdraw, deposit.
 */
public class atmApp extends Database implements ActionListener{
    private static JTextField usernameField;
    private static JPasswordField pinField;
    String loginPanel = "Login card";
    String atmPanel = "ATM card";
    String createAccountPanel = "Create Account card";
    String successPanel = "Success card";
    String transferPanel = "Transfer card";
    String depositPanel = "Deposit card";
    String withdrawPanel = "withdraw card";
    String transactionsPanel = "Transactions card";
    //String comboBoxElements[] = {loginPanel,atmPanel,createAccountPanel,successPanel,transferPanel,depositPanel,withdrawPanel,transactionsPanel};
    JFrame frame = new JFrame("ATM");
    JPanel cardPane = new JPanel();
    JPanel loginScreen = new JPanel();
    JPanel atmScreen = new JPanel();
    JPanel createAccountScreen = new JPanel();
    JPanel successScreen = new JPanel();
    JPanel transferScreen = new JPanel();
    JPanel depositScreen = new JPanel();
    JPanel withdrawScreen = new JPanel();
    JPanel transactionsScreen = new JPanel();
    CardLayout card = new CardLayout();

    public void atmGUI(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,200);

        //Login screen GUI card
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

        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(154,110,130,25);
        createAccountButton.addActionListener(this);

        loginScreen.add(userName);
        loginScreen.add(usernameField);
        loginScreen.add(pinNumber);
        loginScreen.add(pinField);
        loginScreen.add(loginButton);
        loginScreen.add(createAccountButton);
        loginScreen.setLayout(null);

        //atm main screen GUI
        JLabel welcomeNameLabel = new JLabel("Welcome");
        welcomeNameLabel.setBounds(50,20,70, 25);

        JButton transferButton = new JButton("Transfers");
        transferButton.setBounds(50,50,150, 25);
        transferButton.addActionListener(this);

        JButton transactionHistoryButton = new JButton("Transaction History");
        transactionHistoryButton.setBounds(50,80,150, 25);
        transactionHistoryButton.addActionListener(this);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(50,110,150, 25);
        logoutButton.addActionListener(this);

        atmScreen.add(welcomeNameLabel);
        atmScreen.add(transferButton);
        atmScreen.add(transactionHistoryButton);
        atmScreen.add(logoutButton);
        atmScreen.setLayout(null);

        //createAccount Screen GUI
        JLabel createAccountLabel = new JLabel("Create account");

        createAccountLabel.setBounds(10,50,50,25);
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10,40,20,25);
        JTextField nameTextField = new JTextField("Enter your name...");
        nameTextField.setBounds(35,40,40,25);
        JLabel pinLabel = new JLabel("Create a Pin:");
        JPasswordField pinField = new JPasswordField();
        JButton createButton = new JButton("Create");
        createButton.addActionListener(this);
        createAccountScreen.add(createAccountLabel);
        createAccountScreen.add(nameLabel);
        createAccountScreen.add(nameTextField);
        createAccountScreen.add(pinLabel);
        createAccountScreen.add(pinField);
        createAccountScreen.add(createButton);

        //transfer Screen GUI
        JLabel transferLabel = new JLabel("Transfers");
        transferLabel.setBounds(50,20,70, 25);


        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(50,50,70, 25);
        depositButton.addActionListener(this);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(50,85,70, 25);
        depositButton.addActionListener(this);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(this);
        transferScreen.add(transferLabel);
        transferScreen.add(transferLabel);
        transferScreen.add(depositButton);
        transferScreen.add(withdrawButton);

        //deposit screen GUI
        JLabel depositLabel = new JLabel("Deposit");
        depositLabel.setBounds(50,50,50,25);
        JLabel depositAmount = new JLabel("Amount:");
        depositAmount.setBounds(50,80,50,25);
        JTextField depositField = new JTextField("Enter deposit amount...");
        depositField.setBounds(110,80,75,25);
        depositScreen.add(depositAmount);
        depositScreen.add(depositField);
        depositScreen.add(depositLabel);

        //withdrawn screen GUI

        //transaction history Screen GUI

        //success Screen GUI

        //Adding All JPanels to the card Panel
        cardPane.setLayout(card);
        cardPane.add(loginScreen,loginPanel);
        cardPane.add(createAccountScreen,createAccountPanel);
        cardPane.add(atmScreen,atmPanel);
        cardPane.add(transferScreen,transferPanel);
        cardPane.add(transactionsScreen,transactionsPanel);
        cardPane.add(successScreen,successPanel);
        cardPane.add(withdrawScreen,withdrawPanel);
        cardPane.add(depositScreen,depositPanel);

        //Adding Card panel to main frame
        frame.add(cardPane);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String pinNum = String.valueOf(pinField.getPassword());
        System.out.println(username+" "+ pinNum);
        String actionCommand = e.getActionCommand();
        switch(actionCommand){
            case "Login":
                /**
                 *
                 if(login is authenticated){
                    show atm screen and resize window
                 }
                 else{
                 Add login Failed message
                 }
                 */
            case "Create Account":
                /**
                 * Show create screen and resize window
                 * Then show Atm screen after creation
                 */
                frame.setSize(500, 300);
                card.show(cardPane,createAccountPanel);

            case "Create":
                /**
                 * creates Account with a name and pin
                 */

            case "Transfers":
                /**
                 * Show transfers screen
                 */

            case "Transaction history":
                /**
                 * Show accounts transaction history
                 */

            case "Back":
                /**
                 * show previous screen
                 */

            case "Logout":
                /**
                 * Show login screen and resize window
                 */
        }
    }

    public static void main(String[] args) {
        atmApp atm = new atmApp();
        atm.atmGUI();
    }
}
