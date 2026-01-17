import java.util.Scanner;

class BankAccount {
    String name;
    String accountNumber;
    double balance;

    // Constructor
    BankAccount(String name, String accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(" Deposited ₹" + amount);
        } else {
            System.out.println(" Invalid amount!");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(" Withdrawn ₹" + amount);
        } else {
            System.out.println(" Insufficient balance or invalid amount!");
        }
    }

    void checkBalance() {
        System.out.println("💰 Current Balance: ₹" + balance);
    }

    void accountInfo() {
        System.out.println("\n📋 Account Details:");
        System.out.println(" Name: " + name);
        System.out.println(" Account Number: " + accountNumber);
        System.out.println(" Balance: ₹" + balance);
    }
}

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Welcome to Simple Bank System");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Create account number: ");
        String accNumber = scanner.nextLine();

        BankAccount account = new BankAccount(name, accNumber);

        int choice;
        do {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Info");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ₹");
                    double dep = scanner.nextDouble();
                    account.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ₹");
                    double wit = scanner.nextDouble();
                    account.withdraw(wit);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.accountInfo();
                    break;

                case 0:
                    System.out.println("👋 Thank you for using our banking system!");
                    break;

                default:
                    System.out.println(" Invalid option! Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
