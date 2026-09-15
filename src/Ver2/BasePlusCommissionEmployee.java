package Ver2;

public class BasePlusCommissionEmployee {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private double totalSale;
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        empID = 0;
        empName = new Name();
        birthDate = new MyDate();
        dateHired = new MyDate();
        totalSale = 0;
        baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        totalSale = 0;
        baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale, double baseSalary) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
    }

    public int getEmpID() {
        return empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public void setEmpName(Name empName) {
        this.empName = empName;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    }

    public void setTotalSale(double totalSale) {
        if (totalSale >= 0) {
            this.totalSale = totalSale;
        }
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        }
    }

    private double getCommissionRate() {
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

    public double computeSalary() {
        return baseSalary + totalSale * getCommissionRate();
    }

    public double computeSalary(int currentMonth) {
        double salary = computeSalary();

        if (birthDate.getMonth() == currentMonth) {
            salary += 5000;
        }

        return salary;
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Total Sale: ₱%.2f | Base Salary: ₱%.2f%n", empID, empName, birthDate, dateHired, totalSale, baseSalary);
    }

    @Override
    public String toString() {
        return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Sales: ₱%.2f, Base Salary: ₱%.2f, Total Salary: ₱%.2f]", empID, empName, birthDate, dateHired, totalSale, baseSalary, computeSalary());
    }
}