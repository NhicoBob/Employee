package Ver5;

public class HourlyEmployee extends Employee {
    private double hoursWorked;
    private double hourlyRate;

    public HourlyEmployee() {
        super();
        this.hoursWorked = 0.0;
        this.hourlyRate = 0.0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double hoursWorked, double hourlyRate) {
        super(empID, empName, birthDate, dateHired);
        setHoursWorked(hoursWorked);
        setHourlyRate(hourlyRate);
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked < 0) {
            throw new IllegalArgumentException("Hours worked cannot be negative.");
        }

        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < 0) {
            throw new IllegalArgumentException("Hourly rate cannot be negative.");
        }

        this.hourlyRate = hourlyRate;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double salary;

        if (hoursWorked <= 40) {
            salary = hoursWorked * hourlyRate;
        } else {
            double overtimeHours = hoursWorked - 40;
            salary = (40 * hourlyRate)
                    + (overtimeHours * hourlyRate * 1.5);
        }

        if (currentMonth > 0 &&
                getBirthDate().getMonth() == currentMonth) {
            salary += 5000.00;
        }

        return salary;
    }

    public void displayHourlyEmployee() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("HourlyEmployee [ID: %d, Name: %s, Hours: %.2f, Rate: ₱%,.2f, Total Salary: ₱%,.2f]", getEmpID(), getEmpName(), hoursWorked, hourlyRate, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;

        if (!(obj instanceof HourlyEmployee))
            return false;

        HourlyEmployee other = (HourlyEmployee) obj;

        return Double.compare(hoursWorked, other.hoursWorked) == 0
                && Double.compare(hourlyRate, other.hourlyRate) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;

        temp = Double.doubleToLongBits(hoursWorked);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        temp = Double.doubleToLongBits(hourlyRate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    @Override
    public HourlyEmployee clone() {
        return (HourlyEmployee) super.clone();
    }
}