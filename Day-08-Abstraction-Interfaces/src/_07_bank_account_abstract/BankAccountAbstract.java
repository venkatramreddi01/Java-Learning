package _07_bank_account_abstract;

// Abstract Account class
abstract class Account {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Abstract methods
    abstract void calculateInterest();
    abstract double getMinimumBalance();
    abstract String getAccountType();

    // Concrete methods
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && balance - amount >= getMinimumBalance()) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or below minimum!");
        }
    }

    void displayInfo() {
        System.out.println("\n=== " + getAccountType() + " ===");
        System.out.println("Account: " + accountNumber);
        System.out.println("Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println("Min Balance: $" + getMinimumBalance());
    }
}

// Savings Account
class SavingsAccount extends Account {
    double interestRate = 4.5;

    SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber,accountHolder, balance);
    }

    @Override
    void calculateInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest added: $" + interest);
    }

    @Override
    double getMinimumBalance() {
        return 1000;
    }

    @Override
    String getAccountType() {
        return "Savings Account";
    }
}

// Current Account
class CurrentAccount extends Account {
    double overdraftLimit = 5000;

    CurrentAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    void calculateInterest() {
        System.out.println("No interest for current account");
    }

    @Override
    double getMinimumBalance() {
        return -overdraftLimit;     // Can go negative up to limit
    }

    @Override
    String getAccountType() {
        return "Current Account";
    }

    @Override
    void withdraw(double amount) {
        if (amount > 0 && balance - amount >= -overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }
}

// Fixed Deposit Account
class FixedDepositAccount extends Account {
    double interestRate = 7.5;
    int months;

    FixedDepositAccount(String accountNumber, String accountHolder, double balance, int months) {
        super(accountNumber, accountHolder, balance);
        this.months = months;
    }

    @Override
    void calculateInterest() {
        double interest = balance * (interestRate / 100) * (months / 12.0);
        balance += interest;
        System.out.println("Interest for " + months + " months: $" + interest);
    }

    @Override
    double getMinimumBalance() {
        return balance;     // Cannot withdraw from FD
    }

    @Override
    String getAccountType() {
        return "Fixed Deposit Account";
    }

    @Override
    void withdraw(double amount) {
        System.out.println("Cannot withdraw from Fixed Deposit before maturity!");
    }
}

public class BankAccountAbstract {
    public static void main(String[] args) {
        Account savings = new SavingsAccount("SA001", "Jack", 5000);
        Account current = new CurrentAccount("CA001","Bob", 2000);
        Account fd = new FixedDepositAccount("FD001", "Alice", 100000, 12);

        savings.displayInfo();
        savings.deposit(1000);
        savings.calculateInterest();
        savings.displayInfo();

        current.displayInfo();
        current.withdraw(3000);     // Uses overdraft
        current.displayInfo();

        fd.displayInfo();
        fd.calculateInterest();
        fd.withdraw(1000);  // Not allowed
        fd.displayInfo();
    }
}
