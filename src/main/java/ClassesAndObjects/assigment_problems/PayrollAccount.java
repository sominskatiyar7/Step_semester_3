class Payroll {
    private double basicSalary;
    private double bonus;

    public Payroll(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Negative salary. Starting with 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }

        bonus = 0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus rejected: invalid amount");
        } else {
            bonus = bonus + amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax rejected: invalid percentage");
        } else {
            basicSalary = basicSalary - (basicSalary * percent / 100);
            System.out.println("Tax deducted: " + percent + "%");
        }
    }

    public double getNetSalary() {
        return basicSalary + bonus;
    }
}

public class PayrollAccount {
    public static void main(String[] args) {

        Payroll payroll = new Payroll(50000);

        payroll.creditBonus(5000);
        payroll.deductTax(10);

        System.out.println("Net salary: Rs " + payroll.getNetSalary());
    }
}