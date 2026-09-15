
package Ver3;

public class Main3 {

    public static void main(String[] args) {

        System.out.println("======================================================================");
        System.out.println("POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println("======================================================================");

        Employee[] employees = {

                new HourlyEmployee(101, new Name("Alice", "Marie", "Smith"), new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45, 200),

                new PieceWorkerEmployee(201, new Name("Bob", "Carlos", "Jones", "Jr."), new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 250, 15),

                new CommissionEmployee(301, new Name("Charlie", "Brown"), new MyDate(20, 4, 1997), new MyDate(1, 1, 2022), 75000),

                new BasePlusCommissionEmployee(401, new Name("Diana", "Cruz"), new MyDate(15, 8, 2000), new MyDate(1, 1, 2023), 150000, 25000)
        };

        int targetMonth = 9;

        for (int i = 0; i < employees.length; i++) {

            Employee emp = employees[i];

            double basePay = emp.computeSalary();
            double totalPayout = emp.computeSalary(targetMonth);
            double birthdayBonus = totalPayout - basePay;

            System.out.println("\n" + (i + 1) + ". " + emp);

            System.out.printf("Base Pay: ₱%.2f%n", basePay);

            System.out.printf("Birthday Bonus: ₱%.2f (%s)%n", birthdayBonus, birthdayBonus > 0 ? "Eligible" : "Ineligible");

            System.out.printf("Total Payout: ₱%.2f%n", totalPayout);
        }

        System.out.println("\n======================================================================");
        System.out.println("OBJECT CONTRACT TESTS (equals & hashCode)");
        System.out.println("======================================================================");

        HourlyEmployee empA = new HourlyEmployee(101, new Name("Alice", "Marie", "Smith"), new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45, 200);

        HourlyEmployee empB = new HourlyEmployee(101, new Name("Alice", "Marie", "Smith"), new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45, 200);

        HourlyEmployee empC = new HourlyEmployee(102, new Name("John", "Doe"), new MyDate(10, 5, 1999), new MyDate(1, 1, 2023), 35, 180);

        System.out.println("empA equals empB: " + empA.equals(empB));

        System.out.println("empA hashCode: " + empA.hashCode());
        System.out.println("empB hashCode: " + empB.hashCode());

        System.out.println("Hash codes match: " + (empA.hashCode() == empB.hashCode()));

        System.out.println("empA equals empC: " + empA.equals(empC));
        System.out.println("\n======================================================================");
        System.out.println("DEEP CLONE VERIFICATION");
        System.out.println("======================================================================");

        HourlyEmployee original = new HourlyEmployee(101, new Name("Alice", "Marie", "Smith"), new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45, 200);

        HourlyEmployee clone = original.clone();

        System.out.println("Original Name before modification: " + original.getEmpName());

        clone.getEmpName().setFirstName("Taylor");

        System.out.println("Clone Name changed to: " + clone.getEmpName());

        System.out.println("Original Name after modification: " + original.getEmpName());

        System.out.println("Deep copy successful: " + !original.getEmpName().equals(clone.getEmpName()));

        clone.getBirthDate().setMonth(12);

        System.out.println("Original birth date: " + original.getBirthDate());

        System.out.println("Clone birth date: " + clone.getBirthDate());
    }
}