package util;

import java.io.PrintWriter;
import java.util.GregorianCalendar;
import java.util.Calendar;
import static java.lang.System.out;

public class UTIL {

    public static void printDate(PrintWriter PR) {
        Calendar c = new GregorianCalendar();
        PR.printf("Date: %d-%02d-%02d Time: %02d:%02d:%02d\n", c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1,
                c.get(Calendar.DATE), c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), c.get(Calendar.SECOND));
        PR.flush();
    }

    public static void errorMsg(String message) {
        out.println("=== Error: " + message);
        System.exit(1);
    }

    public static int direction(String s) {
        if (s.equals("x")) return 1;
        else if (s.equals("y")) return 2;
        else if (s.equals("z")) return 3;
        else if (s.equals("n")) return 0;
        else return -1;
    }
}
