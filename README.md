# ATM-Application
An app that performs bank functions. The app takes inputs from the user and outputs the outcome based on its functions in the terminal. Technologies used for this project are Java and IntelliJ.

#### Features
- App will have a GUI with functions of an ATM which includes:
  - Withdrawing Cash
  - Depositing cash and cheques
  - Transferring money between accounts
  - Balance inquiries
    - Checking account balances
  - Each transaction will be recorded under a file for the specific account
#### Functions
When the program is run, it asks the user for an `integer` input using scanner. 
If the user enters a number out of the range of the functions, the program gives a warning and, re-prompts the user for another input.

###### Create / Open Account
When the user inputs 1, the program creates an `Account` object, as well as asks for the name of the account holder. The name is then assigned to the created `Account` object.

###### Check balance
When the user inputs 2, the program returns the `balance` of the `Account`.

###### Deposit
When the user inputs 3, the program asks the user for an `double` input. Then the program adds that input with the balance of the `Account` object, and prints the amount deposited.

###### Withdraw
When the user inputs 4, the program asks the user for a `double` input. The program subtracts the input from the balance of the `Account` object, and prints the amount withdrawn.

###### Quit
When the user inputs 5, the program quits.
