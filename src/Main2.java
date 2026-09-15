package Ver2;

public class Main2 {

    public static void main(String[] args) {
        System.out.println("Name & Date Output Verification");

        Name name = new Name("Alice", "Marie", "Smith");
        MyDate date = new MyDate(18, 9, 2026);

        name.displayName();
        date.displayDate();

        System.out.println("\n Hourly Employee Payroll Test ");

        Name alice = new Name("Alice", "Marie", "Smith");
        MyDate aliceBirth = new MyDate(18, 9, 2000);
        MyDate aliceHired = new MyDate(1, 6, 2022);

        HourlyEmployee hourly1 = new HourlyEmployee(101, alice, aliceBirth, aliceHired);

        hourly1.setTotalHoursWorked(45);
        hourly1.setRatePerHour(200);

        HourlyEmployee hourly2 = new HourlyEmployee(102, new Name("John", "Doe"), new MyDate(10, 5, 1999), new MyDate(1, 1, 2023), 35, 180);

        hourly1.displayHourlyEmployee();
        hourly2.displayHourlyEmployee();

        System.out.println(hourly1);
        System.out.println(hourly2);

        System.out.printf(
                "Regular Month (Oct) Salary: ₱%.2f%n",
                hourly1.computeSalary(10));

        System.out.printf(
                "Birth Month (Sep) Salary (+₱5,000.00): ₱%.2f%n",
                hourly1.computeSalary(9));

        System.out.println("\nPiece Worker Employee Test");

        PieceWorkerEmployee piece1 = new PieceWorkerEmployee(201, new Name("Bob", "Carlos", "Jones"), new MyDate(12, 3, 2001), new MyDate(1, 2, 2024));

        piece1.setTotalPiecesFinished(250);
        piece1.setRatePerPiece(15);

        PieceWorkerEmployee piece2 = new PieceWorkerEmployee(202, new Name("Mary", "Santos"), new MyDate(5, 7, 2000), new MyDate(1, 1, 2023), 150, 20);

        piece1.displayPieceWorkerEmployee();
        piece2.displayPieceWorkerEmployee();

        System.out.println(piece1);
        System.out.println(piece2);

        System.out.printf("Regular Salary: ₱%.2f%n", piece1.computeSalary());

        System.out.printf("Birthday Month Salary (+₱5,000.00): ₱%.2f%n", piece1.computeSalary(3));

        System.out.println("\nCommission Employee Test");

        CommissionEmployee commission1 =
                new CommissionEmployee(301, new Name("Charlie", "Brown"), new MyDate(20, 4, 1998), new MyDate(1, 1, 2022));

        commission1.setTotalSale(75000);

        CommissionEmployee commission2 =
                new CommissionEmployee(302, new Name("Diana", "Cruz"), new MyDate(15, 8, 2000), new MyDate(1, 1, 2023), 150000);

        commission1.displayCommissionEmployee();
        commission2.displayCommissionEmployee();

        System.out.println(commission1);
        System.out.println(commission2);

        System.out.printf("Regular Salary: ₱%.2f%n", commission1.computeSalary());

        System.out.printf("Birthday Month Salary (+₱5,000.00): ₱%.2f%n", commission1.computeSalary(4));

        System.out.println("\nBase Plus Commission Employee Test");

        BasePlusCommissionEmployee base1 = new BasePlusCommissionEmployee(401, new Name("Edward", "Lee"), new MyDate(25, 6, 1997), new MyDate(1, 1, 2022));

        base1.setTotalSale(120000);
        base1.setBaseSalary(25000);

        BasePlusCommissionEmployee base2 = new BasePlusCommissionEmployee(402, new Name("Fiona", "Garcia"), new MyDate(8, 11, 1999), new MyDate(1, 1, 2023), 600000, 30000);

        base1.displayBasePlusCommissionEmployee();
        base2.displayBasePlusCommissionEmployee();

        System.out.println(base1);
        System.out.println(base2);

        System.out.printf("Regular Salary: ₱%.2f%n", base1.computeSalary());

        System.out.printf("Birthday Month Salary (+₱5,000.00): ₱%.2f%n", base1.computeSalary(6));
    }
}