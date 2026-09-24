package Ver5;

public class MyDate implements Cloneable {
    private int day;
    private int month;
    private int year;

    private static final String[] MONTH_NAMES = {
            "",
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    public MyDate() {
        this(1, 1, 2000);
    }

    public MyDate(int day, int month, int year) {
        setDay(day);
        setMonth(month);
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Day must be between 1 and 31.");
        }

        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12.");
        }

        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%02d %s %04d", day, MONTH_NAMES[month], year);
    }

    public void displayDate() {
        System.out.println(toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof MyDate))
            return false;

        MyDate other = (MyDate) obj;

        return day == other.day && month == other.month && year == other.year;
    }

    @Override
    public int hashCode() {
        int result = day;
        result = 31 * result + month;
        result = 31 * result + year;
        return result;
    }

    @Override
    public MyDate clone() {
        try {
            return (MyDate) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}