
import java.util.Scanner;
import java.util.ArrayList;

class BankAccount {
    private double balance;
    private ArrayList<String> transactions;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
        transactions = new ArrayList<String>();
        transactions.add("Account opened with Rs. "
                + String.format("%.2f", initialBalance));
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Enter a valid deposit amount.");
        } else {
            balance = balance + amount;
            transactions.add("Deposited Rs. "
                    + String.format("%.2f", amount));
            System.out.println("Deposit successful!");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Enter a valid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance = balance - amount;
            transactions.add("Withdrew Rs. "
                    + String.format("%.2f", amount));
            System.out.println("Please collect your cash.");
            System.out.println("Withdrawal successful!");
        }
    }

    public void showTransactions() {
        System.out.println("\n--- Transaction History ---");

        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(5000);

        int choice = 0;

        System.out.println("================================");
        System.out.println("          WELCOME TO ATM");
        System.out.println("================================");

        while (choice != 5) {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid menu number.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Current balance: Rs. %.2f%n",
                            account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: Rs. ");

                    if (sc.hasNextDouble()) {
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Enter a valid amount.");
                        sc.next();
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: Rs. ");

                    if (sc.hasNextDouble()) {
                        double withdrawAmount = sc.nextDouble();
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Enter a valid amount.");
                        sc.next();
                    }
                    break;

                case 4:
                    account.showTransactions();
                    break;

                case 5:
                    System.out.println("Thank you for using our ATM!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}
