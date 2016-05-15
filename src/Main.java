public class Main {

    public static void main(String[] args) {

        //System.out.println(new Date(14, 5, 2016).getWeekDay());
        //System.out.println(new Date(14, 2, 2016).getDayInMonth());

        //new Date(14, 10, 2016).printCalendar();
        //System.out.println(new Date().countDaysBetweenTwoDate(2016, 5, 15, 2016, 1, 1));

//        System.out.println(new Date(15, 5, 2016).CANCHI());
//        int[] res = new Date(15, 5, 2016).getSolar(9, 4, 2016, 0);
//        for (int i : res) {
//            System.out.print(i + " / ");
//        }

        //System.out.println(new Date(15, 5, 2016).getCentury());



        long seconds = new Time().getSecondsBetweenTwoDay(new Date(15, 5, 2016), new Date(13, 5, 2016));
        long minutes = new Time().getMinutesBetweenTwoDay(new Date(15, 5, 2016), new Date(13, 5, 2016));
        long hours = new Time().getHoursBetweenTwoDay(new Date(15, 5, 2016), new Date(13, 5, 2016));






    }
}
