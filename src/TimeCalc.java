/*
* by Huy Nguyen
* 5/2016
* Hope you enjoy it! :)
* for more information: www.mhuy.xyz
* */

public class TimeCalc {
    private int hour;
    private int minute;
    private int second;

    public TimeCalc() {
    }

    public TimeCalc(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public long getSecondsBetweenTwoDay(DateCalc from, DateCalc to) {
        int days = new DateCalc().countDaysBetweenTwoDate(
                from.getYear(), from.getMonth(), from.getDay(), to.getYear(), to.getMonth(), to.getDay()
        );
        return days * 86400;
    }

    public long getMinutesBetweenTwoDay(DateCalc from, DateCalc to) {
        int days = new DateCalc().countDaysBetweenTwoDate(
                from.getYear(), from.getMonth(), from.getDay(), to.getYear(), to.getMonth(), to.getDay()
        );
        return days * 1440;
    }

    public long getHoursBetweenTwoDay(DateCalc from, DateCalc to) {
        int days = new DateCalc().countDaysBetweenTwoDate(
                from.getYear(), from.getMonth(), from.getDay(), to.getYear(), to.getMonth(), to.getDay()
        );
        return days * 24;
    }

}
