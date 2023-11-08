import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount userAccount) {
        account = userAccount;
    }

    public double checkBalance() {
        return account.getBalance();
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public String withdraw(double amount) {
        boolean success = account.withdraw(amount);
        if (success) {
            return "Withdrawal successful. Remaining balance: $" + account.getBalance();
        } else {
            return "Insufficient balance. Withdrawal failed.";
        }
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000);
        ATM atm = new ATM(userAccount);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Current Balance: $" + atm.checkBalance());
            } else if (choice == 2) {
                System.out.print("Enter the amount to deposit: $");
                double amountToDeposit = scanner.nextDouble();
                atm.deposit(amountToDeposit);
                System.out.println("Deposited $" + amountToDeposit);
            } else if (choice == 3) {
                System.out.print("Enter the amount to withdraw: $");
                double amountToWithdraw = scanner.nextDouble();
                String withdrawalResult = atm.withdraw(amountToWithdraw);
                System.out.println(withdrawalResult);
            } else if (choice == 4) {
                System.out.println("Exiting ATM. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        scanner.close();
    }
}
