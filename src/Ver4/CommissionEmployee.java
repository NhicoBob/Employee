
package Ver4;

public class CommissionEmployee extends Employee {

    private double totalSale;

    public CommissionEmployee() {
        super();
        totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale) {

        super(empID, empName, birthDate, dateHired);

        setTotalSale(totalSale);
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        if (totalSale < 0) {
            throw new IllegalArgumentException(
                    "Total sale cannot be negative.");
        }
        this.totalSale = totalSale;
    }

    public double getCommissionRate() {

        if (totalSale < 50000) {
            return 0.05;
        } else if (totalSale < 100000) {
            return 0.10;
        } else if (totalSale < 500000) {
            return 0.15;
        } else {
            return 0.20;
        }
    }

    public double computeSalary(int currentMonth) {

        double salary = totalSale * getCommissionRate();

        if (getBirthDate().getMonth() == currentMonth) {
            salary += 5000;
        }

        return salary;
    }

    public void displayCommissionEmployee() {
        displayEmployee();

        System.out.printf("Total Sale: ₱%.2f | Commission Rate: %.2f%%%n", totalSale, getCommissionRate() * 100);
    }

    @Override
    public String toString() {
        return String.format("CommissionEmployee [%s, Total Sale: ₱%.2f, " + "Commission Rate: %.2f%%]", super.toString(), totalSale, getCommissionRate() * 100);
    }
}