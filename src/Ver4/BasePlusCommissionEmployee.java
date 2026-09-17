
package Ver4;

public class BasePlusCommissionEmployee
        extends CommissionEmployee {

    private double baseSalary;

    public BasePlusCommissionEmployee() {
        super();
        baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale, double baseSalary) {

        super(empID, empName, birthDate, dateHired, totalSale);

        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) {
            throw new IllegalArgumentException("Base salary cannot be negative.");
        }
        this.baseSalary = baseSalary;
    }

    @Override
    public double computeSalary(int currentMonth) {

        return baseSalary + super.computeSalary(currentMonth);
    }

    public void displayBasePlusCommissionEmployee() {
        displayEmployee();

        System.out.printf("Total Sale: ₱%.2f | Base Salary: ₱%.2f%n", getTotalSale(), baseSalary);
    }

    @Override
    public String toString() {
        return String.format("BasePlusCommissionEmployee [%s, Base Salary: ₱%.2f, " + "Total Sale: ₱%.2f]", super.toString(), baseSalary, getTotalSale());
    }
}