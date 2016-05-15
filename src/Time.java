public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time() {
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public long getSecondsBetweenTwoDay(Date from, Date to) {
        int days = new Date().countDaysBetweenTwoDate(
                from.getYear(), from.getMonth(), from.getDay(), to.getYear(), to.getMonth(), to.getDay()
        );
        return days * 86400;
    }

    public long getMinutesBetweenTwoDay(Date from, Date to) {
        int days = new Date().countDaysBetweenTwoDate(
                from.getYear(), from.getMonth(), from.getDay(), to.getYear(), to.getMonth(), to.getDay()
        );
        return days * 1440;
    }

    public long getHoursBetweenTwoDay(Date from, Date to) {
        int days = new Date().countDaysBetweenTwoDate(
                from.getYear(), from.getMonth(), from.getDay(), to.getYear(), to.getMonth(), to.getDay()
        );
        return days * 24;
    }

}
