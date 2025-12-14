import java.util.Scanner;

class Account {
    String customerName;
    String accountNumber;
    String accountType;
    double balance;

    Account(String customerName, String accountNumber, String accountType, double initialBalance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = initialBalance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    void displayBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}

class Saving extends Account {
    static final double INTEREST_RATE = 0.05;

    Saving(String customerName, String accountNumber, double initialBalance) {
        super(customerName, accountNumber, "Savings", initialBalance);
    }

    void computeInterest(int years) {
        double interest = balance * Math.pow(1 + INTEREST_RATE, years) - balance;
        balance += interest;
        System.out.println("Interest of ₹" + String.format("%.2f", interest) + " added.");
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

class Current extends Account {
    static final double MIN_BALANCE = 1000.0;
    static final double SERVICE_CHARGE = 50.0;

    Current(String customerName, String accountNumber, double initialBalance) {
        super(customerName, accountNumber, "Current", initialBalance);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
            checkMinimumBalance();
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void checkMinimumBalance() {
        if (balance < MIN_BALANCE) {
            balance -= SERVICE_CHARGE;
            System.out.println("Balance below minimum! Service charge of ₹" + SERVICE_CHARGE + " imposed.");
        }
    }
}

public class BankAccount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter Customer Name: ");
        String name = in.nextLine();

        System.out.print("Enter Account Number: ");
        String accNo = in.nextLine();

        System.out.print("Enter Account Type (savings/current): ");
        String type = in.nextLine().toLowerCase();

        System.out.print("Enter Initial Balance: ");
        double balance = in.nextDouble();

        Account account;
        if (type.equals("savings")) {
            account = new Saving(name, accNo, balance);
        } else {
            account = new Current(name, accNo, balance);
        }

        int choice;
        do {
            System.out.println("\nOptions Available");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            if (account instanceof Saving)
                System.out.println("4. Compute Interest");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    account.deposit(in.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double amt = in.nextDouble();
                    if (account instanceof Saving)
                        ((Saving) account).withdraw(amt);
                    else
                        ((Current) account).withdraw(amt);
                    break;

                case 3:
                    account.displayBalance();
                    break;

                case 4:
                    if (account instanceof Saving) {
                        System.out.print("Enter number of years: ");
                        ((Saving) account).computeInterest(in.nextInt());
                    } else {
                        System.out.println("Interest not applicable for Current Account.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        in.close();
    }
}
