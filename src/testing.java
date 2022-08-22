import static java.lang.System.out;
import model.*;
import util.*;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;


public class testing {
    public static void main (String[] args) throws Exception {
        Dof Dof_test = new Dof(2, 36.1);

        out.println(Dof_test.value);

        FileWriter testFile = new FileWriter("test.txt");
        PrintWriter pr1 = new PrintWriter(testFile);
        UTIL.printDate(pr1);

        out.println(UTIL.direction("xc"));
    }
}
