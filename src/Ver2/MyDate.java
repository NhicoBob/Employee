package Ver2;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MyDate {

    private int day;
    private int month;
    private int year;

    public MyDate() {
        day = 1;
        month = 1;
        year = 2000;
    }

    public MyDate(int day, int month, int year) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        if (day >= 1 && day <= 31) {
            this.day = day;
        } else {
            this.day = 1;
        }
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            this.month = 1;
        }
    }

    public void setYear(int year) {
        if (year > 0) {
            this.year = year;
        } else {
            this.year = 2000;
        }
    }

    public void displayDate() {
        System.out.println("Date: " + toString());
    }

    @Override
    public String toString() {

        try {
            LocalDate date = LocalDate.of(year, month, day);

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);

            return date.format(formatter);

        } catch (DateTimeException e) {
            return String.format("%02d/%02d/%04d", day, month, year);
        }
    }
}


