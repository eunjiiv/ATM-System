//CAMPO, ARJIE
//ELCAMEL,
//PORTERIA , KIMBERLIE
//RONAT, MARCO
//WALES, ALIAH

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.menu();
    }
}

// This section defines the account properties.
class Account {
    private String accountNumber;
    private int pinNumber;
    private double balance;
    private String email;
    private String cellNumber;


    // This section initializes an account with the provided details.
    public Account(String accountNumber, int pinNumber, double initialBalance, String email, String cellNumber) {
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;
        this.balance = initialBalance;
        this.email = email;
        this.cellNumber = cellNumber;
    }


    // This section contains the getter and setter methods for account properties.
    public String getAccountNumber() { return accountNumber; }
    public int getPinNumber() { return pinNumber; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCellNumber() { return cellNumber; }
    public void setCellNumber(String cellNumber) { this.cellNumber = cellNumber; }


    // This section displays account details like account number, balance, email, and cell number.
    public void displayAccount() {
        System.out.println("+--------------------------------------+");
        System.out.println("Account Number:\t  " + accountNumber);
        System.out.println("Balance:\t      ₱" + balance);
        System.out.println("Email:\t          " + email);
        System.out.println("Cell Number:\t  " + cellNumber);
        System.out.println("+--------------------------------------+");
    }


    // This section allows depositing money into the account.
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("╠======================================╣");
            System.out.println("╭======================================╮");
            System.out.println( Main.YELLOW + "           Deposit successful\n      New balance: ₱" + balance);
            System.out.println("╰======================================╯");
            System.out.println("╚======================================╝");
        } else {
            System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
            System.out.println( Main.RED + "           ⚠ Invalid amount ⚠\n    ⚠ Please enter a positive value ⚠ " + Main.RESET );
            System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
        }
    }


    // This section handles withdrawing money from the account, ensuring sufficient balance.
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("╠======================================╣");
            System.out.println("╭======================================╮");
            System.out.println("          Withdrawal successful\n      New balance: ₱" + balance);
            System.out.println("╰======================================╯");
            System.out.println("╚======================================╝");

        } else if (amount > balance) {
            System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
            System.out.println( Main.RED + "     ⚠ Insufficient balance ⚠" + Main.RESET);
            System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
        } else {
            System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
            System.out.println( Main.RED + "           ⚠ Invalid amount ⚠\n    ⚠ Please enter a positive value ⚠ " + Main.RESET);
            System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
        }
    }
}

// This section declares the accounts list and a scanner object for user input.
class ATM {
    private ArrayList<Account> accounts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);


    // This section displays the ATM menu and handles user choices through a loop.
    public void menu() {
        while (true) {
            System.out.println("\n╔======================================╗");
            System.out.println("               ATM MACHINE              ");
            System.out.println("╠======================================╣\n");
            System.out.println("                   MENU\n          ");
            System.out.println("   [1] ➤ Create Account");
            System.out.println("   [2] ➤ Update Account");
            System.out.println("   [3] ➤ Delete Account");
            System.out.println("   [4] ➤ Check Balance");
            System.out.println("   [5] ➤ Deposit");
            System.out.println("   [6] ➤ Withdraw");
            System.out.println("   [7] ➤ Exit");
            System.out.println("\n╠======================================╣");
            System.out.print("Enter an option: ");
            int choice = getValidInteger();


            // This section displays the ATM menu and handles user choices.
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    updateAccount();
                    break;
                case 3:
                    deleteAccount();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    deposit();
                    break;
                case 6:
                    withdraw();
                    break;
                case 7:
                    System.out.println("╠======================================╣");
                    System.out.println("Exiting... Thank you for using the ATM.");
                    System.out.println("╚======================================╝");
                    return;
                default:
                    System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
                    System.out.println( Main.RED + "           ⚠ Invalid option ⚠\n          ⚠ Please try again ⚠" + Main.RESET );
                    System.out.println( Main.RED +"▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
            }
        }
    }

    // This section handles the account creation process that collects details from the user.
    public void createAccount() {
        String accountNumber = getValidAccountNumber();
        int pinNumber = getValidPinNumber();
        double initialBalance = getValidInitialBalance();
        String email = getValidEmail();
        String cellNumber = getValidCellNumber();

        Account newAccount = new Account(accountNumber, pinNumber, initialBalance, email, cellNumber);
        accounts.add(newAccount);
        System.out.println("╠======================================╣");
        System.out.println("╭======================================╮");
        System.out.println("     Account created successfully!");
        System.out.println("╰======================================╯");
        System.out.println("╚======================================╝");
    }

    // This section continuously prompts the user to enter a valid 8-digit account number.
    private String getValidAccountNumber() {
        while (true) {
            System.out.println("╠======================================╣");
            System.out.print("Enter 8-digit account number: ");
            String accountNumber = scanner.nextLine();
            if (accountNumber.matches("\\d{8}") && findAccountByNumber(accountNumber) == null) {
                return accountNumber;
            } else if (findAccountByNumber(accountNumber) != null) {
                System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
                System.out.println( Main.RED + "   ⚠ Account number already exists ⚠ " + Main.RESET );
                System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
            } else {
                System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
                System.out.println( Main.RED + "           ⚠ Invalid input ⚠\n   ⚠ Please enter exactly 8 digits ⚠" + Main.RESET );
                System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
            }
        }
    }


    // This section prompts the user to select a 4 or 6-digit PIN
    private int getValidPinNumber() {
        while (true) {
            System.out.print("Do you want a 4-digit or 6-digit PIN?\n(Enter 4 or 6): ");
            int pinLength = getValidIntegerPin();

            if (pinLength == 4 || pinLength == 6) {
                System.out.print("Enter your " + pinLength + "-digit PIN: ");
                String pinInput = scanner.nextLine();

                if (pinInput.matches("\\d{" + pinLength + "}")) {
                    return Integer.parseInt(pinInput);
                } else {
                    System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
                    System.out.println( Main.RED + "           ⚠ Invalid input ⚠\n  ⚠ Please enter exactly " + pinLength + " digits ⚠ " + Main.RESET);
                    System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET) ;
                }
            } else {
                System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
                System.out.println( Main.RED + " ⚠ Kindly choose between 4 or 6 only ⚠" + Main.RESET );
                System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
            }
        }
    }

    // This section ensures that the initial balance entered by the user is valid
    private double getValidInitialBalance() {
        while (true) {
            System.out.print("Enter initial balance: ");
            if (scanner.hasNextDouble()) {
                double initialBalance = scanner.nextDouble();
                scanner.nextLine();

                if ((initialBalance >= 0) && (initialBalance < 999999999)) {
                    return initialBalance;
                } else {
                    System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
                    System.out.println( Main.RED + "      ⚠ Invalid Balance ⚠" + Main.RESET );
                    System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );

                }
            } else {
                System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
                System.out.println( Main.RED + "           ⚠ Invalid input ⚠\n   ⚠ Please enter a valid number ⚠ " + Main.RESET );
                System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
                scanner.next();
            }
        }
    }

    // This section simply prompts the user to enter an email address.
    private String getValidEmail() {
        while (true) {
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            if (email.toLowerCase().endsWith("@gmail.com")) {
                return email;
            } else {
                System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
                System.out.println( Main.RED + "           ⚠ Invalid email ⚠ " + Main.RESET );
                System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
            }
        }
    }


    // This section prompts the user for an 11-digit cell number.
    private String getValidCellNumber() {
        while (true) {
            System.out.print("Enter your cell number: ");
            String cellNumber = scanner.nextLine();
            if (cellNumber.matches("09\\d{9}")) {
                return cellNumber;
            } else {
                System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
                System.out.println( Main.RED + "           ⚠ Invalid input ⚠\n   ⚠ Please enter exactly 11 digits ⚠ " + Main.RESET );
                System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
            }
        }
    }

    // This section allows the user to update an existing account's email and cell number.
    public void updateAccount() {
        System.out.println("╠======================================╣");
        System.out.print("Enter account number to update: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccountByNumber(accountNumber);

        if (account == null) {
            System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
            System.out.println( Main.RED + "         ⚠ Account not found ⚠ " + Main.RESET);
            System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲"+ Main.RESET );
            return;
        }

        if (verifyPin(account)) {
            System.out.println("\nCurrent Account Details:");
            account.displayAccount();

            System.out.println("\nWhat would you like to update?");
            System.out.println("   [1] ➤ Email");
            System.out.println("   [2] ➤ Cell Number");
            System.out.println("   [3] ➤ Both Email and Cell Number");

            System.out.println("╠======================================╣");
            System.out.print("Enter your choice (1, 2, or 3): ");
            int choice = getValidInteger();
            System.out.println("╠======================================╣");



            switch (choice) {
                case 1:
                    String newEmail = getValidEmail();
                    account.setEmail(newEmail);
                    System.out.println("╠======================================╣");
                    System.out.println("╭======================================╮");
                    System.out.println("       Email updated successfully!");
                    System.out.println("╰======================================╯");
                    System.out.println("╚======================================╝");
                    break;

                case 2:
                    String newCellNumber = getValidCellNumber();
                    account.setCellNumber(newCellNumber);
                    System.out.println("╠======================================╣");
                    System.out.println("╭======================================╮");
                    System.out.println("    Cell number updated successfully!");
                    System.out.println("╰======================================╯");
                    System.out.println("╚======================================╝");
                    break;

                case 3:
                    String updtEmail = getValidEmail();
                    account.setEmail(updtEmail);

                    String updatedCellNumber = getValidCellNumber();  // Validate cell number
                    account.setCellNumber(updatedCellNumber);
                    System.out.println("╠======================================╣");
                    System.out.println("╭======================================╮");
                    System.out.println("         Email and cell number\n         updated successfully!");
                    System.out.println("╰======================================╯");
                    System.out.println("╚======================================╝");
                    break;

                default:
                    System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
                    System.out.println( Main.RED +"  ⚠ Invalid choice. No updates made ⚠ " + Main.RESET );
                    System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );

                    break;
            }
        }
    }


    // This section allows the user to delete an account.
    public void deleteAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccountByNumber(accountNumber);

        if (account != null && verifyPin(account)) {
            accounts.remove(account);
            System.out.println("╠======================================╣");
            System.out.println("╭======================================╮");
            System.out.println( "     Account deleted successfully.");
            System.out.println("╰======================================╯");
            System.out.println("╚======================================╝");
        } else {
            System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
            System.out.println( Main.RED + "         ⚠ Account not found ⚠" + Main.RESET );
            System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
        }
    }

    // This section checks the balance of an account
    public void checkBalance() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccountByNumber(accountNumber);

        if (account == null) {
            System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
            System.out.println( Main.RED + "      ⚠ Account does not exist ⚠" + Main.RESET );
            System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲"+ Main.RESET );
        } else if (verifyPin(account)) {
            account.displayAccount();
            offerReceipt("Check Balance", 0, account);
        }
    }

    // This section allows the user to deposit money from their account
    public void deposit() {
        System.out.println("╠======================================╣");
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccountByNumber(accountNumber);

        if (account == null) {
            System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
            System.out.println( Main.RED + "      ⚠ Account does not exist ⚠" + Main.RESET );
            System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲"+ Main.RESET );
        } else if (verifyPin(account)) {
            double amount = getValidAmount("deposit");
            account.deposit(amount);
            offerReceipt("Deposit", amount, account);
        }
    }

    // This section allows the user to withdraw money from their account
    public void withdraw() {
        System.out.println("╠======================================╣");
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccountByNumber(accountNumber);

        if (account == null) {
            System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
            System.out.println( Main.RED + "      ⚠ Account does not exist ⚠" + Main.RESET );
            System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
        } else if (verifyPin(account)) {
            double amount = getValidAmount("withdraw");
            account.withdraw(amount);
            offerReceipt("Withdrawal", amount, account);
        }
    }

    // This section ensures that the deposit or withdrawal amount is valid.
    private double getValidAmount(String transactionType) {
        while (true) {
            System.out.print("Enter amount to " + transactionType + ": ");
            if (scanner.hasNextDouble()) {
                double amount = scanner.nextDouble();
                scanner.nextLine();
                if ((amount > 0) && (amount <= 999999999)){
                    return amount;
                } else {
                    System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
                    System.out.println( Main.RED + "      ⚠ Amount Invalid ⚠" + Main.RESET );
                    System.out.println( Main.RED +"▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
                }
            } else {
                System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
                System.out.println( Main.RED + "           ⚠ Invalid input ⚠\n     ⚠ Please enter a valid number ⚠" + Main.RESET );
                System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
                scanner.next();
            }
        }
    }

    // This section offers the user a receipt option after completing a transaction.
    private void offerReceipt(String transactionType, double amount, Account account) {
        System.out.print("Would you like a receipt? (yes/no): ");
        String response = scanner.nextLine();
        System.out.println("+======================================+");
        if (response.equalsIgnoreCase("yes")) {
            String censoredAccountNumber =
                    censorAccountNumber(account.getAccountNumber());

            System.out.println("\n-------------- RECEIPT----------------");
            System.out.println("Transaction Type:\t     " + transactionType);
            System.out.println("Account Number:\t         " + censoredAccountNumber);

            if (amount > 0) {
                System.out.println("Transaction Amount:\t     ₱" + amount);
            }
            System.out.println("Remaining Balance:\t     ₱" + account.getBalance());
            System.out.println("---------------------------------------\n");
        } else {
            System.out.println("          No receipt requested");
        }
    }



    // This section censors part of the account number in the receipt to enhance privacy.
    private String censorAccountNumber(String accountNumber) {
        return "**" + accountNumber.substring(accountNumber.length() - 2);
    }

    // This section looks for an account by the account number.
    private Account findAccountByNumber(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    // This section verifies the PIN number for the account.
    private boolean verifyPin(Account account) {
        while (true) {
            System.out.println("╠======================================╣");
            System.out.print("Enter your PIN number:");
            int pinNumber = getValidIntegerPin();
            if (account.getPinNumber() == pinNumber) {
                return true;
            } else {
                if (!askRetryOrExit( Main.RED + "           ⚠ Incorrect PIN ⚠" + Main.RESET)) {
                    return false;
                }
            }
        }
    }


    // This section asks the user if they want to retry an operation in case of failure.
    private boolean askRetryOrExit(String message) {
        System.out.println(message);
        System.out.print("Would you like to try again?\n(yes/no): ");
        String response = scanner.nextLine();
        System.out.println("╠======================================╣");
        return response.equalsIgnoreCase("yes");
    }


    // This section ensures that the user enters a valid integer.
    private int getValidInteger() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
                System.out.println( Main.RED + "           ⚠ Invalid input ⚠\n   ⚠ Please enter a valid integer ⚠" + Main.RESET );
                System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
                System.out.print("Enter an option: ");
                scanner.next();
            } finally {
                scanner.nextLine();
            }
        }
    }

    private int getValidIntegerPin() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
                System.out.println( Main.RED + "           ⚠ Invalid input ⚠\n   ⚠ Please enter a valid integer ⚠" + Main.RESET );
                System.out.println( Main.RED + "▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲" + Main.RESET );
                System.out.print("Enter your pin: ");
                scanner.next();
            } finally {
                scanner.nextLine();
            }
        }
    }
}
