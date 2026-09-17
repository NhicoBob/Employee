
package Ver4;

public class EmployeeRoster {

    private Employee[] empList;
    private int max;
    private int count;

    public EmployeeRoster() {
        this(10);
    }

    public EmployeeRoster(int max) {

        if (max <= 0) {
            throw new IllegalArgumentException(
                    "Maximum capacity must be greater than zero.");
        }

        this.max = max;
        this.empList = new Employee[max];
        this.count = 0;
    }

    public Employee[] getEmpList() {
        return empList;
    }

    public void setEmpList(Employee[] empList) {
        if (empList == null) {
            throw new IllegalArgumentException("Array cannot be null.");
        }

        this.empList = empList;
        this.max = empList.length;
        this.count = 0;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException(
                    "Maximum capacity must be greater than zero.");
        }

        this.max = max;
        this.empList = new Employee[max];
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count < 0 || count > max) {
            throw new IllegalArgumentException("Invalid count.");
        }
        this.count = count;
    }

    public boolean addEmployee(Employee emp) {

        if (emp == null || count >= max) {
            return false;
        }

        empList[count] = emp;
        count++;

        return true;
    }

    public Employee removeEmployee(int empID) {

        for (int i = 0; i < count; i++) {

            if (empList[i].getEmpID() == empID) {

                Employee removed = empList[i];

                for (int j = i; j < count - 1; j++) {
                    empList[j] = empList[j + 1];
                }

                empList[count - 1] = null;
                count--;

                return removed;
            }
        }

        return null;
    }

    public Employee searchEmployee(int empID) {

        for (int i = 0; i < count; i++) {

            if (empList[i].getEmpID() == empID) {
                return empList[i];
            }
        }

        return null;
    }

    public int countHE() {

        int total = 0;

        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) {
                total++;
            }
        }

        return total;
    }

    public int countPWE() {

        int total = 0;

        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) {
                total++;
            }
        }

        return total;
    }

    public int countCE() {

        int total = 0;

        for (int i = 0; i < count; i++) {

            if (empList[i].getClass() == CommissionEmployee.class) {
                total++;
            }
        }

        return total;
    }

    public int countBPCE() {

        int total = 0;

        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) {
                total++;
            }
        }

        return total;
    }

    public void displayHE() {

        for (int i = 0; i < count; i++) {

            if (empList[i] instanceof HourlyEmployee) {

                HourlyEmployee emp = (HourlyEmployee) empList[i];

                emp.displayHourlyEmployee();
            }
        }
    }

    public void displayPWE() {

        for (int i = 0; i < count; i++) {

            if (empList[i] instanceof PieceWorkerEmployee) {

                PieceWorkerEmployee emp = (PieceWorkerEmployee) empList[i];

                emp.displayPieceWorkerEmployee();
            }
        }
    }

    public void displayCE() {

        for (int i = 0; i < count; i++) {

            if (empList[i].getClass() == CommissionEmployee.class) {

                CommissionEmployee emp = (CommissionEmployee) empList[i];

                emp.displayCommissionEmployee();
            }
        }
    }

    public void displayBPCE() {

        for (int i = 0; i < count; i++) {

            if (empList[i] instanceof BasePlusCommissionEmployee) {

                BasePlusCommissionEmployee emp = (BasePlusCommissionEmployee) empList[i];

                emp.displayBasePlusCommissionEmployee();
            }
        }
    }

    public void displayAllEmployees() {

        for (int i = 0; i < count; i++) {

            Employee emp = empList[i];

            System.out.printf("%d. ID: %d | Name: %s | Type: %s%n", i + 1, emp.getEmpID(), emp.getEmpName(), emp.getClass().getSimpleName());
        }
    }

    public void displayPayroll(int currentMonth) {

        for (int i = 0; i < count; i++) {

            Employee emp = empList[i];

            double salary = 0;
            String type = "";

            if (emp instanceof BasePlusCommissionEmployee) {

                BasePlusCommissionEmployee e = (BasePlusCommissionEmployee) emp;

                salary = e.computeSalary(currentMonth);
                type = "Base Plus Commission";

            } else if (emp instanceof CommissionEmployee) {

                CommissionEmployee e = (CommissionEmployee) emp;

                salary = e.computeSalary(currentMonth);
                type = "Commission";

            } else if (emp instanceof PieceWorkerEmployee) {

                PieceWorkerEmployee e = (PieceWorkerEmployee) emp;

                salary = e.computeSalary(currentMonth);
                type = "Piece Worker";

            } else if (emp instanceof HourlyEmployee) {

                HourlyEmployee e = (HourlyEmployee) emp;

                salary = e.computeSalary(currentMonth);
                type = "Hourly";
            }

            boolean birthday = emp.getBirthDate().getMonth() == currentMonth;

            System.out.printf("[%s] ID: %d | Name: %s | Salary: ₱%.2f%s%n", type, emp.getEmpID(), emp.getEmpName(), salary, birthday ? " (Birthday Bonus Applied)" : ""
            );
        }
    }
}