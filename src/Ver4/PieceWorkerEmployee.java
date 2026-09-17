
package Ver4;

public class PieceWorkerEmployee extends Employee {

    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        totalPiecesFinished = 0;
        ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, int totalPiecesFinished, double ratePerPiece) {

        super(empID, empName, birthDate, dateHired);

        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished < 0) {
            throw new IllegalArgumentException("Pieces cannot be negative.");
        }
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece < 0) {
            throw new IllegalArgumentException("Rate cannot be negative.");
        }
        this.ratePerPiece = ratePerPiece;
    }

    public double computeSalary(int currentMonth) {

        double salary = totalPiecesFinished * ratePerPiece;

        int completeHundreds = totalPiecesFinished / 100;

        salary += completeHundreds * 10 * ratePerPiece;

        if (getBirthDate().getMonth() == currentMonth) {
            salary += 5000;
        }

        return salary;
    }

    public void displayPieceWorkerEmployee() {
        displayEmployee();

        System.out.printf("Pieces: %d | Rate per Piece: ₱%.2f%n", totalPiecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        return String.format("PieceWorkerEmployee [%s, Pieces: %d, Rate: ₱%.2f]", super.toString(), totalPiecesFinished, ratePerPiece);
    }
}