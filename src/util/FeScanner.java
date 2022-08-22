package util;

import java.util.Scanner;
import java.io.File;

public class FeScanner {

    private Scanner es;

    //Constructor
    public FeScanner(String fileIn) {
        try {
            es = new Scanner(new File(fileIn)); // create scanner for the input file.
        } catch (Exception e) {
            UTIL.errorMsg("Input file not found: " + fileIn);
        }
        es.useDelimiter("\\s*=\\s*|\\s+"); // sets blanks and equal signs as delimiters
    }

    // check if next token is available
    public boolean hasNext() {return es.hasNext();}

    // check if next is double
    public boolean hasNextDouble() {return es.hasNextDouble();}

    // gives the next string
    public String next() {return es.next();}

    //reads the next double from this scanner.
    public double nextDouble() {return es.nextDouble();}

    //reads the next integer
    public int readInt() {
        if (!es.hasNextInt()) UTIL.errorMsg("Expected integer. Instead " + es.next());
        return es.nextInt();
    }

    // reads the next double.
    public double readDouble() {
        if (!es.hasNextDouble()) UTIL.errorMsg("Expected double. Instead " + es.next());
        return es.nextDouble();
    }

    //Advances to the next line
    public void nextLine() {es.nextLine();}

    // Moves to a line after the line with the word.
    public void moveAfterLineWithWord(String word) {
        while (es.hasNext()) {
            String varname = es.next().toLowerCase();
            if (varname.equals("#")) {
                es.nextLine();
                continue;
            }
            if (varname.equals(word)) {
                es.nextLine();
                return;
            }
        }
        UTIL.errorMsg("moveAfterLineWithWord cannot find: " + word);
    }
}
