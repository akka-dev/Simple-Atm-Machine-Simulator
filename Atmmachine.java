import java.util.*;

class Account {
    String user; int balance;
    Account(String user, int balance) { this.user = user; this.balance = balance; }

    void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else System.out.println("Insufficient funds.");
    }

    void showBalance() {
        System.out.println(user + "'s Balance: " + balance);
    }
}

public class Atmmachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account acc = new Account("John", 1000);

        acc.showBalance();
        acc.deposit(500);
        acc.withdraw(300);
        acc.withdraw(1500);
        acc.showBalance();
    }
}