import java.util.*;

public class ATM {
    private double balance = 1000.0;

    public void display() {
        Scanner input = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("1. Withdraw\n2. Deposit\n3. Check Balance\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter amount to withdraw: ");
                    double amount = input.nextDouble();
                    withdraw(amount);
                }
                case 2 -> {
                    System.out.print("Enter amount to deposit: ");
                    double amount = input.nextDouble();
                    deposit(amount);
                }
                case 3 -> checkBalance();
                case 4 -> {
                    System.out.println("Goodbye!");
                    isRunning = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        input.close();
        System.exit(0); // Clean exit
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful!");
    }

    public void checkBalance() {
        System.out.println("Your balance is: " + balance);
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.display();
    }
}
