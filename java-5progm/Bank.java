import java.util.Scanner;

class Account {
    String name;
    int accno;
    String type;
    double balance;

    Account(String n, int a, String t, double b) {
        name = n;
        accno = a;
        type = t;
        balance = b;
    }

    void deposit(double amt) {
        balance += amt;
        System.out.println("Deposited: " + amt + ". Updated balance: " + balance);
    }

    void display() {
        System.out.println("Customer name: " + name);
        System.out.println("Account number: " + accno);
        System.out.println("Type of Account: " + type);
        System.out.println("Account Balance: " + balance);
    }
}


class SavAccount extends Account {
    SavAccount(String n, int a, double b) {
        super(n, a, "saving", b);
    }

    void interest() {
        double rate = 0.04; // 4% interest
        double intr = balance * rate;
        balance += intr;
        System.out.println("Interest added: " + intr + ". Updated balance: " + balance);
    }

    void withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            System.out.println("Withdrawn: " + amt + ". Updated balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}


class CurAccount extends Account {
    CurAccount(String n, int a, double b) {
        super(n, a, "current", b);
    }

    void withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            System.out.println("Withdrawn: " + amt + ". Updated balance: " + balance);
            checkMinBalance();
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    void checkMinBalance() {
        double min = 2000;
        if (balance < min) {
            balance -= 100;
            System.out.println("Service charge imposed! Updated balance: " + balance);
        }
    }
}


class Bank {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = s.nextLine();

        System.out.print("Enter account number: ");
        int accno = s.nextInt();

        System.out.print("Enter account type (saving/current): ");
        String type = s.next();

        System.out.print("Enter initial balance: ");
        double bal = s.nextDouble();

        if (type.equalsIgnoreCase("saving")) {
            SavAccount sa = new SavAccount(name, accno, bal);
            menu(sa, s);
        } else {
            CurAccount ca = new CurAccount(name, accno, bal);
            menu(ca, s);
        }
    }

    static void menu(Account acc, Scanner s) {
        int choice;
        do {
            System.out.println("\n------MENU------");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Compute Interest for Savings Account");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the deposit amount: ");
                    double d = s.nextDouble();
                    acc.deposit(d);
                    break;
                case 2:
                    System.out.print("Enter the withdrawal amount: ");
                    double w = s.nextDouble();
                    if (acc instanceof SavAccount)
                        ((SavAccount) acc).withdraw(w);
                    else if (acc instanceof CurAccount)
                        ((CurAccount) acc).withdraw(w);
                    break;
                case 3:
                    if (acc instanceof SavAccount)
                        ((SavAccount) acc).interest();
                    else
                        System.out.println("Interest not available for current account.");
                    break;
                case 4:
                    acc.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }
}

