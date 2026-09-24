package Ver5;

public class CommissionEmployee extends Employee {
    private double totalSale;

    public CommissionEmployee() {
        super();
        this.totalSale = 0.0;
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
            throw new IllegalArgumentException("Total sale cannot be negative.");
        }

        this.totalSale = totalSale;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double rate;

        if (totalSale <= 10000) {
            rate = 0.05;
        } else if (totalSale <= 20000) {
            rate = 0.10;
        } else if (totalSale <= 30000) {
            rate = 0.15;
        } else {
            rate = 0.20;
        }

        double salary = totalSale * rate;

        if (currentMonth > 0 &&
                getBirthDate().getMonth() == currentMonth) {
            salary += 5000.00;
        }

        return salary;
    }

    public void displayCommissionEmployee() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("CommissionEmployee [ID: %d, Name: %s, Sales: ₱%,.2f, Total Salary: ₱%,.2f]", getEmpID(), getEmpName(), totalSale, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;

        if (!(obj instanceof CommissionEmployee))
            return false;

        CommissionEmployee other = (CommissionEmployee) obj;

        return Double.compare(totalSale, other.totalSale) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp = Double.doubleToLongBits(totalSale);

        result = 31 * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    @Override
    public CommissionEmployee clone() {
        return (CommissionEmployee) super.clone();
    }
}