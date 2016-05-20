/*
* by Huy Nguyen
* 5/2016
* Hope you enjoy it! :)
* for more information: www.mhuy.xyz
* */

import java.util.Calendar;

public class DateCalc {

    public static final String[] WEEKDAYS       = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public static final String[] WEEKDAYS_SHORT = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    public static final String[] CAN            = {"Giap", "At", "Binh", "Dinh", "Mau", "Ky", "Canh", "Tan", "Nham", "Quy"};
    public static final String[] CHI            = {"Ti", "Suu", "Dan", "Mao", "Thin", "Ty", "Ngo", "Mui", "Than", "Dau", "Tuat", "Hoi"};
    public static final String[] THANG          = {"Giêng", "Hai", "Ba", "Tư", "Năm", "Sáu", "Bảy", "Tám", "Chín", "Mười", "Mười một", "Chạp"};

    public static final String[] TIETKHI        = {
            "Xuân phân", "Thanh minh", "Cốc vũ", "Lập hạ", "Tiểu mãn", "Mang chủng", "Hạ chí",
            "Tiểu thử", "Đại thử", "Lập thu", "Xử thử", "Bạch lộ", "Thu phân", "Hàn lộ",
            "Sương giáng", "Lập đông", "Tiểu tuyết", "Đại tuyết", "Đông chí", "Tiểu hàn",
            "Đại hàn", "Lập xuân", "Vũ Thủy", "Kinh trập"};


    public static final double PI = 3.141592653589793D; // or Math.PI
    private static final double TIMEZONE = 7.0; // Hanoi, Jakarta timezone..

    // attributes
    private int day;
    private int month;
    private int year;


    // default constructor
    public DateCalc() {}

    // constructor with parameters.
    public DateCalc(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }


    public int getCentury() {
        return (int)Math.floor(this.year / 100) + 1;
    }

    public static double getCentury(int year) {
        return Math.floor(year / 100) + 1;
    }

    public int getMonth4Zeller(int month) {
        if (month < 3)
            return (month + 10);
        return (month - 2);
    }

    public int year4Zeller(int year) {
        return (year % 100);
    }

    public double _zeller(int day, int month, int year, double century) {
        return ((13 * month - 1) / 5 + year / 4 + century/4 + day + year - 2 * century) % 7;
    }

    // get the day of week.
    public String getWeekDay() {
        double i = _zeller(this.day, getMonth4Zeller(this.month), year4Zeller(this.year), getCentury(this.year));
        return WEEKDAYS[(int)i];
    }


    // check if a specific year is Leap or NOT.
    public boolean isLeapYear() {
        return ((this.year % 4 == 0) && (this.year % 100 != 0)) || (this.year % 400 == 0);
    }

    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    // get hour in CAN CHI.
    public static String getHourCAN(int h) {
        return "Giờ " + CAN[(2 * (h - 1) % 10)] + " " + CHI[0];
    }

    public static String getLunarDayCanChiName(int d) {
        return "Ngày " + CAN[((d + 9) % 10)] + " " + CHI[((d + 1) % 12)];
    }


    public static String getLunarMonthCanChiName(int y, int m) {
        return "Tháng " + CAN[((3 + (m + y * 12)) % 10)] + " " + CHI[((m + 1) % 12)];
    }

    public static String getLunarMonthName(int paramInt) {
        return "Tháng " + THANG[paramInt];
    }


    // without parameters. Use specified attributes of this class.
        public int getDayInMonth() {
        return ((this.month == 2) ? (28 + (isLeapYear() ? 1 : 0)) : 31 - (this.month - 1) % 7 % 2);
    }



    private static int getDaysInMonth(int year, int month) {
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            }
            return 28;
        }
        return 31;
    }


    // with parameter: int year, int month
//    public static int getDaysInMonth(int year, int month) {
//        int i = year % 100 % 4;
//        int j = 0;
//        if (i == 0) {
//            j = 1;
//        }
//        if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {
//            return 31;
//        }
//        if ((month == 4) || (month == 6) || (month == 8) || (month == 11)) {
//            return 30;
//        }
//        if (j != 0) {
//            return 29;
//        }
//        return 28;
//    }


    public int[] getCalendarTable() {
        int[] res = new int[42];
        int start = (int)(_zeller(1, getMonth4Zeller(this.month), year4Zeller(this.year), getCentury(this.year)));
        int end = getDayInMonth();
        for (int i = start; i < (end + start); i++) {
            res[i] = (i - start) + 1;
        }

        return res;
    }

    public void printCalendar() {
        int[] arr = getCalendarTable();

        for (String i : WEEKDAYS_SHORT) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            if (i % 7 == 0) {
                System.out.println();
            }
            System.out.print(arr[i] + " ");
        }
    }

    public static int thisIsMagic(int y, int m, int d) {
        if (m < 3) {
            y--;
            m += 12;
        }
        return 365*y + y/4 - y/100 + y/400 + (153*m - 457)/5 + d - 306;
    }

    public int countDaysBetweenTwoDate(int year, int month, int day, int y, int m, int d) {
        return Math.abs(thisIsMagic(year, month, day) - thisIsMagic(y, m, d));
    }

    public String CANCHI() {
        return CAN[(this.year + 6) % 10] + " " + CHI[(this.year + 8) % 12];
    }

    public static int INT(double d) {
        return (int)Math.floor(d);
    }

    public static int MOD(int x, int y) {
        int z = x - (int)(y * Math.floor(((double)x / y)));
        if (z == 0) {
            z = y;
        }
        return z;
    }

    public static String formatDate(DateCalc date) {
        if (date == null) {
            return null;
        }
        return date.toString();
    }

    public double getJulius() {
        double res;
        if (this.year > 1582 || (this.year == 1582 && this.month > 10) || (this.year == 1582 && this.month == 10 && this.day > 14)) {
            res = 367 * this.year
                    - INT(7 * (this.year + INT((this.month + 9) / 12)) / 4)
                    - INT(3 * (INT((this.year + (this.month - 9) / 7) / 100) + 1) / 4)
                    + INT(275 * this.month / 9) + this.day + 1721028.5;
        } else {
            res = 367 * this.year
                    - INT(7 * (this.year + 5001 + INT((this.month - 9) / 7)) / 4)
                    + INT(275 * this.month / 9) + this.day + 1729776.5;
        }
        return res;
    }

    public static int[] UniversalFromJulius(double JD) {
        int Z, A, alpha, B, C, D, E, dd, mm, yyyy;
        double F;
        Z = INT(JD + 0.5);
        F = (JD + 0.5) - Z;
        if (Z < 2299161) {
            A = Z;
        } else {
            alpha = INT((Z - 1867216.25) / 36524.25);
            A = Z + 1 + alpha - INT(alpha / 4);
        }
        B = A + 1524;
        C = INT( (B - 122.1) / 365.25);
        D = INT( 365.25 * C );
        E = INT( (B - D) / 30.6001 );
        dd = INT(B - D - INT(30.6001 * E) + F);
        if (E < 14) {
            mm = E - 1;
        } else {
            mm = E - 13;
        }
        if (mm < 3) {
            yyyy = C - 4715;
        } else {
            yyyy = C - 4716;
        }
        return new int[]{dd, mm, yyyy};
    }

    

    public static double SunLongitude(double jdn) {
        double T = (jdn - 2451545.0 ) / 36525;
        double T2 = T * T;
        double dr = PI / 180;
        double M = 357.52910 + 35999.05030 * T - 0.0001559 * T2 - 0.00000048 * T * T2;
        double L0 = 280.46645 + 36000.76983 * T + 0.0003032 * T2;
        double DL = (1.914600 - 0.004817 * T - 0.000014 * T2) * Math.sin(dr * M);
        DL = DL + (0.019993 - 0.000101 * T) * Math.sin(dr * 2 * M) + 0.000290 * Math.sin(dr * 3 * M);
        double L = L0 + DL;
        L = L * dr;
        L = L - PI * 2 * (INT(L / (PI * 2)));
        return L;
    }

    public static int[] LunarMonth11(int Y) {
        double off = LocalToJD(31, 12, Y) - 2415021.076998695;
        int k = INT(off / 29.530588853);
        double jd = NewMoon(k);
        int[] ret = LocalFromJD(jd);
        double sunLong = SunLongitude(LocalToJD(ret[0], ret[1], ret[2])); // sun longitude at local midnight
        if (sunLong > 3 * PI / 2) {
            jd = NewMoon(k-1);
        }
        return LocalFromJD(jd);
    }

    public static int[] UniversalFromJD(double JD) {
        int Z, A, alpha, B, C, D, E, dd, mm, yyyy;
        double F;
        Z = INT(JD + 0.5);
        F = (JD + 0.5) - Z;
        if (Z < 2299161) {
            A = Z;
        } else {
            alpha = INT((Z - 1867216.25) / 36524.25);
            A = Z + 1 + alpha - INT(alpha / 4);
        }
        B = A + 1524;
        C = INT( (B - 122.1) / 365.25);
        D = INT(365.25 * C);
        E = INT((B - D) / 30.6001);
        dd = INT(B - D - INT(30.6001 * E) + F);
        if (E < 14) {
            mm = E - 1;
        } else {
            mm = E - 13;
        }
        if (mm < 3) {
            yyyy = C - 4715;
        } else {
            yyyy = C - 4716;
        }
        return new int[]{dd, mm, yyyy};
    }

    public static int[] LocalFromJD(double JD) {
        return UniversalFromJD(JD + TIMEZONE / 24.0);
    }

    public static double NewMoon(int k) {
        double T = k / 1236.85;
        double T2 = T * T;
        double T3 = T2 * T;
        double dr = PI / 180;
        double Jd1 = 2415020.75933 + 29.53058868 * k + 0.0001178 * T2 - 0.000000155 * T3;
        Jd1 = Jd1 + 0.00033 * Math.sin((166.56 + 132.87 * T - 0.009173 * T2) * dr);
        double M = 359.2242 + 29.10535608 * k - 0.0000333 * T2 - 0.00000347 * T3;
        double Mpr = 306.0253 + 385.81691806 * k + 0.0107306*T2 + 0.00001236 * T3;
        double F = 21.2964 + 390.67050646 * k - 0.0016528 * T2 - 0.00000239 * T3;
        double C1=(0.1734 - 0.000393 * T) * Math.sin(M * dr) + 0.0021 * Math.sin(2 * dr * M);
        C1 = C1 - 0.4068 * Math.sin(Mpr * dr) + 0.0161 * Math.sin(dr * 2 * Mpr);
        C1 = C1 - 0.0004 * Math.sin(dr * 3 * Mpr);
        C1 = C1 + 0.0104 * Math.sin(dr * 2 * F) - 0.0051*Math.sin(dr*(M+Mpr));
        C1 = C1 - 0.0074 * Math.sin(dr * (M - Mpr)) + 0.0004 * Math.sin(dr * (2 * F + M));
        C1 = C1 - 0.0004 * Math.sin(dr * (2 * F - M)) - 0.0006 * Math.sin(dr*(2 * F + Mpr));
        C1 = C1 + 0.0010 * Math.sin(dr*(2*F-Mpr)) + 0.0005 * Math.sin(dr * (2 * Mpr + M));
        double deltat;
        if (T < -11) {
            deltat= 0.001 + 0.000839*T + 0.0002261*T2 - 0.00000845*T3 - 0.000000081*T*T3;
        } else {
            deltat= -0.000278 + 0.000265*T + 0.000262*T2;
        }
        return Jd1 + C1 - deltat;
    }

    public static int[][] LunarYear(int Y) {
        int[][] ret;
        int[] month11A = LunarMonth11(Y-1);
        double jdMonth11A = LocalToJD(month11A[0], month11A[1], month11A[2]);
        int k = (int)Math.floor(0.5 + (jdMonth11A - 2415021.076998695) / 29.530588853);
        int[] month11B = LunarMonth11(Y);
        double off = LocalToJD(month11B[0], month11B[1], month11B[2]) - jdMonth11A;
        boolean leap = off > 365.0;
        if (!leap) {
            ret = new int[13][5];
        } else {
            ret = new int[14][5];
        }
        ret[0] = new int[]{month11A[0], month11A[1], month11A[2], 0, 0};
        ret[ret.length - 1] = new int[]{month11B[0], month11B[1], month11B[2], 0, 0};
        for (int i = 1; i < ret.length - 1; i++) {
            double nm = NewMoon(k + i);
            int[] a = LocalFromJD(nm);
            ret[i] = new int[]{a[0], a[1], a[2], 0, 0};
        }
        for (int i = 0; i < ret.length; i++) {
            ret[i][3] = MOD(i + 11, 12);
        }
        if (leap) {
            initLeapYear(ret);
        }
        return ret;
    }


    static void initLeapYear(int[][] ret) {
        double[] sunLongitudes = new double[ret.length];
        for (int i = 0; i < ret.length; i++) {
            int[] a = ret[i];
            double jdAtMonthBegin = LocalToJD(a[0], a[1], a[2]);
            sunLongitudes[i] = SunLongitude(jdAtMonthBegin);
        }
        boolean found = false;
        for (int i = 0; i < ret.length; i++) {
            if (found) {
                ret[i][3] = MOD(i + 10, 12);
                continue;
            }
            double sl1 = sunLongitudes[i];
            double sl2 = sunLongitudes[i + 1];
            boolean hasMajorTerm = Math.floor(sl1 / PI * 6) != Math.floor(sl2 / PI * 6);
            if (!hasMajorTerm) {
                found = true;
                ret[i][4] = 1;
                ret[i][3] = MOD(i + 10, 12);
            }
        }
    }

    public static double UniversalToJD(int D, int M, int Y) {
        double JD;
        if (Y > 1582 || (Y == 1582 && M > 10) || (Y == 1582 && M == 10 && D > 14)) {
            JD = 367 * Y
                    - INT(7 * (Y + INT((M + 9) / 12)) / 4)
                    - INT(3 * (INT((Y + (M - 9) / 7) / 100) + 1) / 4)
                    + INT(275 * M / 9) + D + 1721028.5;
        } else {
            JD = 367 * Y
                    - INT(7 * (Y + 5001
                    + INT((M - 9) / 7)) / 4)
                    + INT(275 * M / 9) + D + 1729776.5;
        }
        return JD;
    }

    public static double LocalToJD(int D, int M, int Y) {
        return UniversalToJD(D, M, Y) - TIMEZONE/24.0;
    }

    public static double SunLongitudeAstronomical(double d)
    {
        double d1 = (d - 2451545.0D) / 36525.0D;
        double d2 = d1 * d1;
        double d3 = 357.52910000000003D + 35999.050300000003D * d1 - 0.0001559D * d2 - d2 * (4.8E-007D * d1);
        double d4 = 280.46645000000001D + 36000.769829999997D * d1 + 0.0003032D * d2 + ((1.9146D - 0.004817D * d1 - 1.4E-005D * d2) * Math.sin(0.0174532925199433D * d3) + (0.019993D - 0.000101D * d1) * Math.sin(d3 * (2.0D * 0.0174532925199433D)) + 0.00029D * Math.sin(d3 * (3.0D * 0.0174532925199433D)));
        double d5 = 125.04000000000001D - 1934.136D * d1;
        double d6 = 0.0174532925199433D * (d4 - 0.00569D - 0.00478D * Math.sin(d5 * 0.0174532925199433D));
        return d6 - 6.283185307179586D * INT(d6 / 6.283185307179586D);
    }

    public static int getSolarTerm(int paramInt1, int paramInt2)
    {
        return INT(12.0D * (SunLongitudeAstronomical(paramInt1 - 0.5D - paramInt2 / 24.0D) / 3.141592653589793D));
    }


    // chuyen doi duong lich sang am lich.
    public int[] getLunar() {
        int yy = this.year;
        int[][] ly = LunarYear(this.year);
        int[] month11 = ly[ly.length - 1];
        double jdToday = LocalToJD(this.day, this.month, this.year);
        double jdMonth11 = LocalToJD(month11[0], month11[1], month11[2]);
        if (jdToday >= jdMonth11) {
            ly = LunarYear(this.year + 1);
            yy = this.year + 1;
        }
        int i = ly.length - 1;
        while (jdToday < LocalToJD(ly[i][0], ly[i][1], ly[i][2])) {
            i--;
        }
        int dd = (int)(jdToday - LocalToJD(ly[i][0], ly[i][1], ly[i][2])) + 1;
        int mm = ly[i][3];
        if (mm >= 11) {
            yy--;
        }
        return new int[] {dd, mm, yy, ly[i][4]};
    }


    // chuyen doi am lich sang duong lich.
    public int[] getSolar() {
        int D = this.day;
        int M = this.month;
        int Y = this.year;
        int leap = isLeapYear(Y) ? 1 : 0;

        int yy = Y;
        if (M >= 11) {
            yy = Y+1;
        }
        int[][] lunarYear = LunarYear(yy);
        int[] lunarMonth = null;
        for (int i = 0; i < lunarYear.length; i++) {
            int[] lm = lunarYear[i];
            if (lm[3] == M && lm[4] == leap) {
                lunarMonth = lm;
                break;
            }
        }
        if (lunarMonth != null) {
            double jd = LocalToJD(lunarMonth[0], lunarMonth[1], lunarMonth[2]);
            return LocalFromJD(jd + D - 1);
        } else {
            throw new RuntimeException("Incorrect input!");
        }
    }

    public String getTIETKHI() {
        return "Tiết: " + TIETKHI[getSolarTerm(this.day + 1, 7)];
    }

    public static String getTIETKHI(int d) {
        return "Tiết: " + TIETKHI[getSolarTerm(d + 1, 7)];
    }

    static boolean isToday(LunarCalendar day) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.set(day.getYear(), day.getMonth() - 1, day.getDay());
        return (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)) &&
                (c1.get(Calendar.MONTH) == (c2.get(Calendar.MONTH))) &&
                (c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public String toString() {
        return this.day + "/" + this.month + "/" + this.year;
    }
}