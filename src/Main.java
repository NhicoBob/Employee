//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package Ver1;

public class Main {

    public static void main(String[] args) {

        System.out.println("Employee Test");

        HourlyEmployee hourly1 =
                new HourlyEmployee(101, "Bayot Dev");

        hourly1.setTotalHoursWorked(45);
        hourly1.setRatePerHour(200);

        HourlyEmployee hourly2 =
                new HourlyEmployee(102, "John Doe", 35, 180);

        System.out.println("[displayHourlyEmployee()]");

        hourly1.displayHourlyEmployee();
        hourly2.displayHourlyEmployee();

        System.out.println("[toString()]");

        System.out.println(hourly1);
        System.out.println(hourly2);

        System.out.println("\nPiece Worker");

        PieceWorkerEmployee piece1 =
                new PieceWorkerEmployee(201, "Bob Jones");

        piece1.setTotalPiecesFinished(250);
        piece1.setRatePerPiece(15);

        PieceWorkerEmployee piece2 =
                new PieceWorkerEmployee(677, "John Dev", 150, 20);

        System.out.println("[displayPieceWorkerEmployee()]");

        piece1.displayPieceWorkerEmployee();
        piece2.displayPieceWorkerEmployee();

        System.out.println("[toString()]");

        System.out.println(piece1);
        System.out.println(piece2);

        System.out.println("\nCommission Employee");

        CommissionEmployee commission1 =
                new CommissionEmployee(767, "Bayot Dev");

        commission1.setTotalSale(75000);

        CommissionEmployee commission2 =
                new CommissionEmployee(776, "Pisut Dev", 150000);

        System.out.println("[displayCommissionEmployee()]");

        commission1.displayCommissionEmployee();
        commission2.displayCommissionEmployee();

        System.out.println("[toString()]");

        System.out.println(commission1);
        System.out.println(commission2);

        System.out.println("\nBase Plus Commission");

        BasePlusCommissionEmployee base1 =
                new BasePlusCommissionEmployee (401, "Liam Lawson");

        base1.setTotalSale(120000);
        base1.setBaseSalary(25000);

        BasePlusCommissionEmployee base2 =
                new BasePlusCommissionEmployee(402, "Kawaii Dev", 600000, 30000);

        System.out.println("[displayBasePlusCommissionEmployee()]");

        base1.displayBasePlusCommissionEmployee();
        base2.displayBasePlusCommissionEmployee();

        System.out.println("[toString()]");

        System.out.println(base1);
        System.out.println(base2);
    }
}
