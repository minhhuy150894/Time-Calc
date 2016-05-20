import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class LunarCalendar {

    private boolean isToday, isWeekend;
    private int year, month, day;


    LunarCalendar(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }


    void setIsToday(boolean isToday) {
        this.isToday = isToday;
    }

    void setIsWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    public Date getDate() {
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        return calendar.getTime();
    }

    public long getMillis() {
        return getDate().getTime();
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public boolean isToday() {
        return isToday;
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

}
