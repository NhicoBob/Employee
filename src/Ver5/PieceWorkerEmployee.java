package Ver5;

public class PieceWorkerEmployee extends Employee {
    private int piecesProduced;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        this.piecesProduced = 0;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, int piecesProduced, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setPiecesProduced(piecesProduced);
        setRatePerPiece(ratePerPiece);
    }

    public int getPiecesProduced() {
        return piecesProduced;
    }

    public void setPiecesProduced(int piecesProduced) {
        if (piecesProduced < 0) {
            throw new IllegalArgumentException("Pieces produced cannot be negative.");
        }

        this.piecesProduced = piecesProduced;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece < 0) {
            throw new IllegalArgumentException("Rate per piece cannot be negative.");
        }

        this.ratePerPiece = ratePerPiece;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double salary = piecesProduced * ratePerPiece;

        // 10 additional pieces for every 100 pieces
        int bonusPieces = (piecesProduced / 100) * 10;
        salary += bonusPieces * ratePerPiece;

        if (currentMonth > 0 &&
                getBirthDate().getMonth() == currentMonth) {
            salary += 5000.00;
        }

        return salary;
    }

    public void displayPieceWorkerEmployee() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("PieceWorkerEmployee [ID: %d, Name: %s, Pieces: %d, Rate: ₱%,.2f, Total Salary: ₱%,.2f]", getEmpID(), getEmpName(), piecesProduced, ratePerPiece, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;

        if (!(obj instanceof PieceWorkerEmployee))
            return false;

        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;

        return piecesProduced == other.piecesProduced
                && Double.compare(ratePerPiece, other.ratePerPiece) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp = Double.doubleToLongBits(ratePerPiece);

        result = 31 * result + piecesProduced;
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    @Override
    public PieceWorkerEmployee clone() {
        return (PieceWorkerEmployee) super.clone();
    }
}