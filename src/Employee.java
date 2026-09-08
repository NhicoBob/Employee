public class Employee {
    private int empID;
    private string empName;
    private float totalHourswork;
    private double ratePerHour;

    public Employee() {
        empID = 0;
        empName= "N/A";
        totalHourswork = 0;
        ratePerHour = 0;
    }

    public Employee(int empID, string empName) {
        this.empID = empID;
        this.empName = empName;
        totalHourswork = 0;
        ratePerHour = 0;
    }

    public Employee(int empID, string empName, float totalHourswork, double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.ratePerHour = ratePerHour;
        this.totalHourswork = totalHourswork;
    }

    public int getEmpID() {
        return empID;
    }

    public float getTotalHourswork() {
        return totalHourswork;
    }

    public string getEmpName() {
        return empName;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public void setEmpName(string empName) {
        this.empName = empName;
    }

    public void setTotalHourswork(float totalHourswork) {
        this.totalHourswork = totalHourswork;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }
}
