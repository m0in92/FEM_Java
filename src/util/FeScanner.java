package util;

import java.util.Scanner;
import java.io.File;
import java.util.ListIterator;
import model.*;

public class FeScanner {

    private Scanner es;

    //Constructor
    public FeScanner(String fileIn) {
        try {
            this.es = new Scanner(new File(fileIn)); // create scanner for the input file.
        } catch (Exception e) {
            UTIL.errorMsg("Input file not found: " + fileIn);
        }
        this.es.useDelimiter("\\s*=\\s*|\\s+"); // sets blanks and equal signs as delimiters
    }

    // check if next token is available
    public boolean hasNext() {
        return this.es.hasNext();
    }

    // check if next is double
    public boolean hasNextDouble() {
        return this.es.hasNextDouble();
    }

    // gives the next string
    public String next() {
        return this.es.next();
    }

    //reads the next double from this scanner.
    public double nextDouble() {
        return this.es.nextDouble();
    }

    //reads the next integer
    public int readInt() {
        if (!this.es.hasNextInt()) {
            UTIL.errorMsg("Expected integer. Instead " + es.next());
        }
        return this.es.nextInt();
    }

    // reads the next double.
    public double readDouble() {
        if (!es.hasNextDouble()) UTIL.errorMsg("Expected double. Instead " + es.next());
        return this.es.nextDouble();
    }

    //Advances to the next line
    public void nextLine() {
        this.es.nextLine();
    }

    // Moves to a line after the line with the word.
    public void moveAfterLineWithWord(String word) {
        while (this.es.hasNext()) {
            String varname = this.es.next().toLowerCase();
            if (varname.equals("#")) {
                this.es.nextLine();
            }
            else {
                if (varname.equals(word)) {
                    this.es.nextLine();
                    return;
                }
                continue;
            }
        }
        UTIL.errorMsg("moveAfterLineWithWord cannot find: " + word);
    }

    public ListIterator readNumberList(final ListIterator listIterator, final int n, final int n2, final double n3) {
        final int int1 = this.readInt();
        int int3;
        int int2 = int3 = this.readInt();
        for (int i = 1; i < int1; ++i) {
            int2 = this.readInt();
            if (int2 > 0 && int3 >= 0) {
                if (int3 > 0) {
                    listIterator.add(new Dof(n2 * (int3 - 1) + n, n3));
                }
                int3 = int2;
            }
            else if (int2 < 0) {
                for (int j = int3; j <= -int2; ++j) {
                    listIterator.add(new Dof(n2 * (j - 1) + n, n3));
                }
                int3 = 0;
                int2 = 0;
            }
        }
        if (int2 > 0) {
            listIterator.add(new Dof(n2 * (int2 - 1) + n, n3));
        }
        return listIterator;
    }

    // close the scanner
    public void close() { es.close(); }
}
