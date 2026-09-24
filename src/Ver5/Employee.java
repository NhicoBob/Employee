package Ver5;

public class Employee implements Cloneable {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    public Employee() {
        this(0, new Name(), new MyDate(), new MyDate());
    }

    public Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public void setEmpName(Name empName) {
        this.empName = empName;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    }

    // Version 5 baseline implementation
    public double computeSalary(int currentMonth) {
        return 0.0;
    }

    // Overloaded version
    public double computeSalary() {
        return computeSalary(-1);
    }

    public void displayEmployee() {
        System.out.println("Employee ID: " + empID);
        System.out.println("Name: " + empName);
        System.out.println("Birth Date: " + birthDate);
        System.out.println("Date Hired: " + dateHired);
    }

    @Override
    public String toString() {
        return String.format("Employee [ID: %d, Name: %s, Birth Date: %s, Date Hired: %s]", empID, empName, birthDate, dateHired);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Employee))
            return false;

        Employee other = (Employee) obj;

        return empID == other.empID && empName.equals(other.empName) && birthDate.equals(other.birthDate) && dateHired.equals(other.dateHired);
    }

    @Override
    public int hashCode() {
        int result = empID;
        result = 31 * result + empName.hashCode();
        result = 31 * result + birthDate.hashCode();
        result = 31 * result + dateHired.hashCode();
        return result;
    }

    @Override
    public Employee clone() {
        try {
            Employee copy = (Employee) super.clone();
            copy.empName = empName.clone();
            copy.birthDate = birthDate.clone();
            copy.dateHired = dateHired.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}