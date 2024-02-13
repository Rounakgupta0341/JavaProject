import java.util.Scanner;

class BankAccount {
    private double currentBalance;

    public BankAccount(double initialBalance) {
        this.currentBalance = initialBalance;
    }

    public double checkBalance() {
        return currentBalance;
    }

    public void deposit(double amount) {
        currentBalance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= currentBalance) {
            currentBalance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATM {
    private BankAccount userBankAccount;
    private Scanner atmScanner;

    public ATM(BankAccount account) {
        this.userBankAccount = account;
        this.atmScanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void checkBalance() {
        System.out.println("Your current balance is: $" + userBankAccount.checkBalance());
    }

    public void deposit() {
        System.out.print("Enter deposit amount: $");
        double depositAmount = atmScanner.nextDouble();
        userBankAccount.deposit(depositAmount);
        System.out.println("Deposit successful.");
    }

    public void withdraw() {
        System.out.print("Enter withdrawal amount: $");
        double withdrawalAmount = atmScanner.nextDouble();
        boolean success = userBankAccount.withdraw(withdrawalAmount);
        if (success) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            System.out.print("Enter option: ");
            int option = atmScanner.nextInt();
            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        atmScanner.close();
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Initial balance $1000
        ATM atmMachine = new ATM(account);
        atmMachine.start();
    }
}
