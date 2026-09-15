
package Ver3;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {

    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        totalPiecesFinished = 0;
        ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName,
                               MyDate birthDate, MyDate dateHired,
                               int totalPiecesFinished,
                               double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished < 0) {
            throw new IllegalArgumentException(
                    "Pieces cannot be negative.");
        }
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece < 0) {
            throw new IllegalArgumentException(
                    "Piece rate cannot be negative.");
        }
        this.ratePerPiece = ratePerPiece;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double basePay = totalPiecesFinished * ratePerPiece;

        int completeHundreds = totalPiecesFinished / 100;

        double productionBonus =
                completeHundreds * 10 * ratePerPiece;

        return basePay + productionBonus
                + super.computeSalary(currentMonth);
    }

    @Override
    public double computeSalary() {
        double basePay = totalPiecesFinished * ratePerPiece;

        int completeHundreds = totalPiecesFinished / 100;

        double productionBonus =
                completeHundreds * 10 * ratePerPiece;

        return basePay + productionBonus;
    }

    public void displayPieceWorkerEmployee() {
        displayEmployee();

        System.out.printf(
                "Pieces: %d | Rate per Piece: ₱%.2f%n",
                totalPiecesFinished, ratePerPiece
        );
    }

    @Override
    public String toString() {
        return String.format(
                "PieceWorkerEmployee [%s, Pieces: %d, "
                        + "Rate per Piece: ₱%.2f, Total Salary: ₱%.2f]",
                super.toString(),
                totalPiecesFinished,
                ratePerPiece,
                computeSalary()
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;

        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;

        return totalPiecesFinished == other.totalPiecesFinished
                && Double.compare(ratePerPiece,
                other.ratePerPiece) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(), totalPiecesFinished, ratePerPiece
        );
    }

    @Override
    public PieceWorkerEmployee clone() {
        return (PieceWorkerEmployee) super.clone();
    }
}
