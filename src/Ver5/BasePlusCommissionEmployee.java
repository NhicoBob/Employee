package Ver5;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0.0;
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
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, Base Salary: ₱%,.2f, Total Salary: ₱%,.2f]", getEmpID(), getEmpName(), baseSalary, computeSalary()
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;

        if (!(obj instanceof BasePlusCommissionEmployee))
            return false;

        BasePlusCommissionEmployee other =
                (BasePlusCommissionEmployee) obj;

        return Double.compare(baseSalary, other.baseSalary) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp = Double.doubleToLongBits(baseSalary);

        result = 31 * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    @Override
    public BasePlusCommissionEmployee clone() {
        return (BasePlusCommissionEmployee) super.clone();
    }
}