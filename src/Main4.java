
package Ver4;

public class Main4 {

    public static void main(String[] args) {

        System.out.println("======================================================================");
        System.out.println("EMPLOYEE ROSTER INITIALIZATION & ENROLLMENT");
        System.out.println("======================================================================");

        EmployeeRoster roster = new EmployeeRoster(6);

        Employee e1 = new HourlyEmployee(101, new Name("Alice", "Marie", "Smith"), new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45, 200);

        Employee e2 = new PieceWorkerEmployee(201, new Name("Bob", "Carlos", "Jones", "Jr."), new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 250, 15);

        Employee e3 = new CommissionEmployee(301, new Name("Maria", "Lopez", "Reyes"), new MyDate(18, 9, 1995), new MyDate(1, 1, 2022), 200000);

        Employee e4 = new BasePlusCommissionEmployee(401, new Name("Kevin", "Santos", "Tan"), new MyDate(15, 8, 2000), new MyDate(1, 1, 2023), 150000, 10000);

        Employee e5 = new HourlyEmployee(102, new Name("David", "Anderson", "White"), new MyDate(10, 5, 1999), new MyDate(1, 1, 2023), 40, 200);

        Employee e6 = new CommissionEmployee(302, new Name("Jane", "Garcia"), new MyDate(12, 10, 2001), new MyDate(1, 1, 2024), 50000);

        Employee e7 = new HourlyEmployee(103, new Name("Extra", "Employee"), new MyDate(1, 1, 2000), new MyDate(1, 1, 2024), 40, 100);

        System.out.println("Added: " + e1.getEmpName()
                + " -> " + roster.addEmployee(e1));

        System.out.println("Added: " + e2.getEmpName()
                + " -> " + roster.addEmployee(e2));

        System.out.println("Added: " + e3.getEmpName()
                + " -> " + roster.addEmployee(e3));

        System.out.println("Added: " + e4.getEmpName()
                + " -> " + roster.addEmployee(e4));

        System.out.println("Added: " + e5.getEmpName()
                + " -> " + roster.addEmployee(e5));

        System.out.println("Added: " + e6.getEmpName()
                + " -> " + roster.addEmployee(e6));

        System.out.println("Attempting to add beyond capacity: "
                + roster.addEmployee(e7));

        System.out.println("\n--- ROSTER COMPOSITION COUNTS ---");

        System.out.println("Total Employees: "
                + roster.getCount() + " / " + roster.getMax());

        System.out.println("Hourly Employees: " + roster.countHE());
        System.out.println("Piece Worker Employees: " + roster.countPWE());
        System.out.println("Commission Employees (Pure): " + roster.countCE());
        System.out.println("Base Plus Commission Employees: " + roster.countBPCE());

        System.out.println("\n--- HOURLY EMPLOYEES ---");
        roster.displayHE();

        System.out.println("\n--- PIECE WORKER EMPLOYEES ---");
        roster.displayPWE();

        System.out.println("\n--- COMMISSION EMPLOYEES ---");
        roster.displayCE();

        System.out.println("\n--- BASE PLUS COMMISSION EMPLOYEES ---");
        roster.displayBPCE();

        System.out.println("\n======================================================================");
        System.out.println("ROSTER PAYROLL REPORT (Target Month: Sep)");
        System.out.println("======================================================================");

        roster.displayPayroll(9);

        System.out.println("\n--- SEARCH TEST ---");

        Employee found = roster.searchEmployee(301);

        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\n======================================================================");
        System.out.println("TESTING EMPLOYEE REMOVAL & ARRAY COMPACTION");
        System.out.println("======================================================================");

        System.out.println("Removing Employee ID 201...");

        Employee removed = roster.removeEmployee(201);

        if (removed != null) {
            System.out.println("Successfully removed: "
                    + removed.getEmpName());
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("Current Employee Count: " + roster.getCount());

        System.out.println("\nRemaining Employees in Roster:");
        roster.displayAllEmployees();
    }
}
