package com.atmApp;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * This class the main BankApp class.
 * How it works:
 * create an account, withdraw, deposit.
 */
public class atmApp extends Database implements ActionListener{
    String loginPanel = "Login card";
    String atmPanel = "ATM card";
    String createAccountPanel = "Create Account card";
    String successPanel = "Success card";
    String transferPanel = "Transfer card";
    String depositPanel = "Deposit card";
    String withdrawPanel = "withdraw card";
    String transactionsPanel = "Transactions card";
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
    Account account = new Account();
    JTextField loginUsernameField, createNameField,depositField,withdrawField;
    JPasswordField loginPinField,createPinField;
    Database atmDatabase = new Database();

    public void atmGUI(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        loginScreenGUI();
        //Adding Card panel to main frame
        frame.add(cardPane);
        frame.setVisible(true);
    }
    public JPanel loginScreenGUI(){
        frame.setSize(320,190);
        JLabel userName = new JLabel("Enter your Username: ");
        userName.setBounds(20,20,135,25);

        loginUsernameField = new JTextField();
        System.out.println(loginUsernameField.getText());
        loginUsernameField.setBounds(150,20,135,25);

        JLabel pinNumber = new JLabel("Enter your PIN: ");
        pinNumber.setBounds(60,50,135,25);

        loginPinField = new JPasswordField();
        loginPinField.setBounds(150,50,135,25);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(215,80,69,25);
        loginButton.addActionListener(this);

        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(154,110,130,25);
        createAccountButton.addActionListener(this);

        loginScreen.add(userName);
        loginScreen.add(loginUsernameField);
        loginScreen.add(pinNumber);
        loginScreen.add(loginPinField);
        loginScreen.add(loginButton);
        loginScreen.add(createAccountButton);
        loginScreen.setLayout(null);
        card.show(cardPane,loginPanel);
        return loginScreen;

    }
    public JPanel atmMainScreenGUI(){
        //atm main screen GUI
        frame.setSize(500,300);
        card.show(cardPane,atmPanel);
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
        return atmScreen;
    }
    public JPanel createAccountScreenGUI(){
        //createAccount Screen GUI
        frame.setSize(350,180);
        JLabel createAccountLabel = new JLabel("Create account");
        createAccountLabel.setBounds(10,10,100,25);

        JLabel nameLabel = new JLabel("Enter your Name:");
        nameLabel.setBounds(60,40,100,25);

        createNameField = new JTextField("");
        createNameField.setBounds(170,40,150,25);

        JLabel pinLabel = new JLabel("Enter a Pin:");
        pinLabel.setBounds(95, 70,100,25);

        createPinField = new JPasswordField();
        createPinField.setBounds(170,70,150,25);

        JButton createButton = new JButton("Create");
        createButton.addActionListener(this);
        createButton.setBounds(220,105,100,25);

        createAccountScreen.add(createAccountLabel);
        createAccountScreen.add(nameLabel);
        createAccountScreen.add(createNameField);
        createAccountScreen.add(pinLabel);
        createAccountScreen.add(createPinField);
        createAccountScreen.add(createButton);
        createAccountScreen.setLayout(null);
        card.show(cardPane,createAccountPanel);

        return createAccountScreen;
    }
    public JPanel transfersScreenGUI(){
        //transfer Screen GUI
        frame.setSize(350,150);
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
        transferScreen.setLayout(null);
        card.show(cardPane,transferPanel);
        return transferScreen;
    }
    public JPanel depositScreenGUI(){
        //deposit screen GUI
        frame.setSize(350,300);

        JLabel depositLabel = new JLabel("Deposit");
        depositLabel.setBounds(50,50,50,25);

        JLabel depositAmount = new JLabel("Amount:");
        depositAmount.setBounds(50,80,50,25);

        depositField = new JTextField("Enter deposit amount...");
        depositField.setBounds(110,80,75,25);

        depositScreen.add(depositAmount);
        depositScreen.add(depositField);
        depositScreen.add(depositLabel);
        depositScreen.setLayout(null);
        card.show(cardPane,depositPanel);
        return depositScreen;
    }
    public JPanel transactionScreenGUI(){
        card.show(cardPane,transactionsPanel);
        return transactionsScreen;
    }
    public JPanel withdrawScreenGUI(){
        card.show(cardPane,withdrawPanel);
        return withdrawScreen;
    }
    public JPanel successScreenGUI(){
        card.show(cardPane,successPanel);
        return successScreen;
    }
    public Account loginVerification(JTextField loginUser,JPasswordField loginPin){
        String id= loginUser.getText();
        System.out.println(id);
        int idNum = Integer.parseInt(id);
        account = atmDatabase.accountDatabase.get(idNum);
        return account;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame errorFrame = new JFrame();
        String actionCommand = e.getActionCommand();
        switch(actionCommand){
            case "Login":
                account = loginVerification(loginUsernameField, loginPinField);
                if(account !=null) {
                    System.out.println(account.getName());
                    atmMainScreenGUI();
                } else{
                    JOptionPane.showMessageDialog(errorFrame,"Account not in database, please create an account.");
                }

                break;
            case "Create Account":
                /**
                 * Show create screen and resize window
                 * Then show Atm screen after creation
                 */
                createAccountScreenGUI();
                break;

            case "Create":
                /**
                 * creates Account with a name and pin
                 */
                account = new Account(createNameField.getText(),String.valueOf(createPinField.getPassword()));
                atmDatabase.newAccount(account);
                JOptionPane.showMessageDialog(errorFrame,"Your Login credentials are:\n User: "+account.getId()+"\n Don't forget your PIN.");
                System.out.println(account.getName()+" "+account.getId());
                atmMainScreenGUI();
                break;

            case "Transfers":
                /**
                 * Show transfers screen
                 */
                transfersScreenGUI();
                break;
            case "Deposit":
                depositScreenGUI();
                break;
            case "Withdraw":
                withdrawScreenGUI();
                break;
            case "Transaction history":
                /**
                 * Show accounts transaction history
                 */
                transactionScreenGUI();
                break;

            case "Back":
                /**
                 * show previous screen
                 */
                break;

            case "Logout":
                /**
                 * Show login screen and resize window
                 */
                account = new Account();
                loginUsernameField.setText("");
                loginPinField.setText("");
                loginScreenGUI();
                break;

            default:
                break;
        }
    }

    public static void main(String[] args) {
        atmApp atm = new atmApp();
        atm.atmGUI();
        //atm.accountDatabase.put();
    }
}
