import static java.lang.System.out;
import model.*;
import util.*;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;


public class testing {
    public static void main (String[] args) throws Exception {
        // test model.Dof
        Dof Dof_test = new Dof(2, 36.1);
        out.println(Dof_test.value);

        // test util.UTIL
        var pr1 = new FePrintWriter();
        UTIL.printDate(pr1.getPrinter("test.txt")); // checks calendar write to test.txt
        out.println(UTIL.direction("xc")); // checks directions method

        // test util.FeScanner
        FeScanner feScanner1 = new FeScanner("f.fem");
        out.println(feScanner1.hasNext());
//        out.println(feScanner1.readInt());
//        out.println(feScanner1.readDouble());
        feScanner1.moveAfterLineWithWord("material");
        out.println(feScanner1.next());
    }
}
