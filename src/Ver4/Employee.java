
package Ver4;

public class Employee {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    public Employee() {
        this(0, new Name(), new MyDate(), new MyDate());
    }

    public Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
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

    public void displayEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s%n", empID, empName, birthDate, dateHired);
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, DOB: %s, Hired: %s", empID, empName, birthDate, dateHired);
    }
}

