package util;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;

public class FePrintWriter {
    PrintWriter PR;
    public PrintWriter getPrinter(String fileOut) {
        try {
            this.PR = new PrintWriter(new BufferedWriter(new FileWriter(fileOut)));
        } catch (Exception e) {
            UTIL.errorMsg("cannot open output file: " + fileOut);
        }
        return this.PR;
    }
}
