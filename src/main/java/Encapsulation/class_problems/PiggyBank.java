class Piggy {
    private double savings;
    private final String id;

    Piggy(String id) {
        this.id = id;
        savings = 0;
    }

    void deposit(double amount) {
        if (amount > 0) {
            savings = savings + amount;
        }
    }

    void withdraw(double amount) {
        if (amount <= savings) {
            savings = savings - amount;
        } else {
            System.out.println("Withdrawal rejected");
        }
    }

    double getSavings() {
        return savings;
    }

    String getId() {
        return id;
    }
}

public class PiggyBank {
    public static void main(String[] args) {

        Piggy pb = new Piggy("PB-1");

        pb.deposit(100);
        System.out.println("Savings after deposit: " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("Savings after withdrawal: " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("Final savings: " + pb.getSavings());
    }
}