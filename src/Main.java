/*
* by Huy Nguyen
* 5/2016
* Hope you enjoy it! :)
* for more information: www.mhuy.xyz
* */

public class Main {

    public static void main(String[] args) {

        System.out.println(new DateCalc(14, 5, 2016).getWeekDay());
        System.out.println(new DateCalc(14, 2, 2016).getDayInMonth());

        new DateCalc(14, 10, 2016).printCalendar();
        System.out.println();
        System.out.println("So ngay: " + new DateCalc().countDaysBetweenTwoDate(2016, 5, 15, 2016, 1, 1));

        System.out.println(new DateCalc(15, 5, 2016).CANCHI());

        System.out.println("The ky: " + new DateCalc(15, 5, 2016).getCentury());



        long seconds = new TimeCalc().getSecondsBetweenTwoDay(new DateCalc(15, 5, 2016), new DateCalc(13, 5, 2016));
        long minutes = new TimeCalc().getMinutesBetweenTwoDay(new DateCalc(15, 5, 2016), new DateCalc(13, 5, 2016));
        long hours = new TimeCalc().getHoursBetweenTwoDay(new DateCalc(15, 5, 2016), new DateCalc(13, 5, 2016));
        System.out.println("Seconds: " + seconds);
        System.out.println("Minutes: " + minutes);
        System.out.println("Hours: " + hours);

        System.out.println(new DateCalc(4, 4, 2016).getTIETKHI());


        // Lunar to solar.
        DateCalc l = new DateCalc(4, 4, 2015);
        int[] solar = l.getSolar();
        System.out.println(l.toString() + " to solar is: " + solar[0] + "/" + solar[1] + "/" + solar[2]);

        // Solar to lunar.
        System.out.println();
        DateCalc s = new DateCalc(4, 4, 2015);
        int[] lunar = s.getLunar();
        System.out.println(s.toString() + " to lunar is: " + lunar[0] + "/" + lunar[1] + "/" + lunar[2]);




    }
}
