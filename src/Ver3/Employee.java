
package Ver3;

import java.util.Objects;

public class Employee implements Cloneable {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    public Employee() {
        this(0, new Name(), new MyDate(), new MyDate());
    }

    public Employee(int empID, Name empName,
                    MyDate birthDate, MyDate dateHired) {
        setEmpID(empID);
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        if (empID < 0) {
            throw new IllegalArgumentException("ID cannot be negative.");
        }
        this.empID = empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public void setEmpName(Name empName) {
        if (empName == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        }
        this.empName = empName;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        if (birthDate == null) {
            throw new IllegalArgumentException("Birth date cannot be null.");
        }
        this.birthDate = birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        if (dateHired == null) {
            throw new IllegalArgumentException("Hire date cannot be null.");
        }
        this.dateHired = dateHired;
    }

    // Returns only the birthday bonus.
    // Subclasses add their own regular salary.
    public double computeSalary(int currentMonth) {
        if (birthDate.getMonth() == currentMonth) {
            return 5000.00;
        }
        return 0.00;
    }

    public double computeSalary() {
        return 0.00;
    }

    public void displayEmployee() {
        System.out.printf(
                "ID: %d | Name: %s | DOB: %s | Hired: %s%n",
                empID, empName, birthDate, dateHired
        );
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d, Name: %s, DOB: %s, Hired: %s",
                empID, empName, birthDate, dateHired
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;

        Employee other = (Employee) obj;

        return empID == other.empID
                && empName.equals(other.empName)
                && birthDate.equals(other.birthDate)
                && dateHired.equals(other.dateHired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empID, empName, birthDate, dateHired);
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
            throw new AssertionError(e);
        }
    }
}
