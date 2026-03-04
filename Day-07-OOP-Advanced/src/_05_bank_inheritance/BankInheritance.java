package _05_bank_inheritance;

class BankAccount {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    void displayInfo() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    void addInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest added: $" + interest);
    }

    void displayInfo() {
        System.out.println("=== Savings Account ===");
        super.displayInfo();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CurrentAccount extends BankAccount {
    double overdraftLimit;

    CurrentAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= (balance + overdraftLimit)) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Exceeds overdraft limit!");
        }
    }

    void displayInfo() {
        System.out.println("=== Current Account ===");
        super.displayInfo();
        System.out.println("Overdraft Limit: $" + overdraftLimit);
    }
}

public class BankInheritance {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA108", "Venkatram", 5000, 5);
        savings.displayInfo();
        savings.deposit(1000);
        savings.addInterest();
        savings.displayInfo();

        System.out.println();

        CurrentAccount current = new CurrentAccount("CA670", "Nikhil",2000, 1000);
        current.displayInfo();
        current.withdraw(2500);     // Uses overdraft
        current.displayInfo();
    }
}
