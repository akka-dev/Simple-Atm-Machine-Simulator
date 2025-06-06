import java.util.InputMismatchException;
import java.util.Scanner;

class Account {
    private String user;
    private int balance;

    public Account(String user, int balance) {
        this.user = user;
        this.balance = balance;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid amount. Enter a positive value.");
            return;
        }
        balance += amount;
        System.out.println("✅ Deposited: ₹" + amount);
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid amount. Enter a positive value.");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient funds. Withdrawal denied.");
        } else {
            balance -= amount;
            System.out.println("✅ Withdrawn: ₹" + amount);
        }
    }

    public void showBalance() {
        System.out.println("💰 " + user + "'s Current Balance: ₹" + balance);
    }

    public String getUser() {
        return user;
    }
}

public class Atmmachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account acc = new Account("John", 1000);
        int choice;

        System.out.println("🔐 Welcome to the ATM Machine, " + acc.getUser());

        do {
            showMenu();
            try {
                System.out.print("🔘 Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> acc.showBalance();
                    case 2 -> {
                        System.out.print("➕ Enter amount to deposit: ₹");
                        int deposit = sc.nextInt();
                        acc.deposit(deposit);
                    }
                    case 3 -> {
                        System.out.print("➖ Enter amount to withdraw: ₹");
                        int withdraw = sc.nextInt();
                        acc.withdraw(withdraw);
                    }
                    case 4 -> System.out.println("✅ Thank you for using the ATM. Goodbye!");
                    default -> System.out.println("❗ Invalid option. Please choose 1-4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❗ Error: Please enter a valid number.");
                sc.next(); // clear invalid input
                choice = -1;
            }

            System.out.println(); // spacer
        } while (choice != 4);

        sc.close();
    }

    public static void showMenu() {
        System.out.println("----------- ATM MENU -----------");
        System.out.println("1. 🧾 Check Balance");
        System.out.println("2. 💵 Deposit");
        System.out.println("3. 💳 Withdraw");
        System.out.println("4. ❌ Exit");
        System.out.println("--------------------------------");
    }
}