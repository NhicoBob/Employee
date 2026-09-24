package Ver5;

public class Main5 {

    public static void main(String[] args) {

        EmployeeRoster roster = new EmployeeRoster();

        System.out.println(
                "======================================================================"
        );
        System.out.println(
                "DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)"
        );
        System.out.println(
                "======================================================================"
        );

        Employee hourly = new HourlyEmployee(101, new Name("Alice", "Smith", "M", ""), new MyDate(15, 9, 1995), new MyDate(10, 1, 2020), 40, 237.50);

        Employee pieceWorker = new PieceWorkerEmployee(201, new Name("Bob", "Jones", "C", "Jr."), new MyDate(20, 5, 1998), new MyDate(15, 2, 2021), 90, 45.00);

        Employee commission = new CommissionEmployee(301, new Name("Maria", "Reyes", "L", ""), new MyDate(8, 9, 1990), new MyDate(1, 3, 2019), 150000.00);

        Employee basePlusCommission = new BasePlusCommissionEmployee(401, new Name("Kevin", "Tan", "S", ""), new MyDate(12, 7, 1993), new MyDate(5, 6, 2018), 150000.00, 17000.00);

        roster.addEmployee(hourly);
        System.out.println("Enrolled: " + hourly.getEmpName() + " (Hourly)");

        roster.addEmployee(pieceWorker);
        System.out.println("Enrolled: " + pieceWorker.getEmpName()
                + " (Piece Worker)");

        roster.addEmployee(commission);
        System.out.println("Enrolled: " + commission.getEmpName()
                + " (Commission)");

        roster.addEmployee(basePlusCommission);
        System.out.println("Enrolled: " + basePlusCommission.getEmpName()
                + " (Base Plus Commission)");

        System.out.println(
                "Total Roster Size: "
                        + roster.countEmployees()
                        + " employees"
        );

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("PURE POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println("[No downcasting; dynamic dispatch via Employee.computeSalary()]");
        System.out.println("======================================================================");

        roster.displayPayroll(9);

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("EMPLOYEE CATEGORY COUNTS");
        System.out.println("======================================================================");

        System.out.println("Hourly Employees: " + roster.countHE());

        System.out.println("Piece Workers: " + roster.countPWE());

        System.out.println("Commission Employees: " + roster.countCE());

        System.out.println("Base Plus Commission Employees: " + roster.countBPCE());

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("COLLECTION REMOVAL TEST");
        System.out.println("======================================================================");

        System.out.print("Removing Employee ID 201... ");

        Employee removed = roster.removeEmployee(201);

        if (removed != null) {
            System.out.println("Successfully removed.");
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("Updated Roster Size: " + roster.countEmployees());

        System.out.println();
        System.out.println("Current Active Employees:");

        int number = 1;

        for (Employee emp : roster.getEmpList()) {
            System.out.println(number + ". " + emp);
            number++;
        }

        System.out.println("======================================================================");
    }
}
