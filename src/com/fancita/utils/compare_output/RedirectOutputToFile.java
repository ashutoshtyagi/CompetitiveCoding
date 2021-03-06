package com.fancita.utils.compare_output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by fancita on 21/10/16.
 */
public abstract class RedirectOutputToFile {
    public void redirectOutputToFile() {
        try {
            PrintStream out = new PrintStream(new FileOutputStream(Constants.MY_OUTPUT_FILE));
            System.setOut(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
