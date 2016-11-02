package com.ashutosh.hackerrank.utils;

import java.io.*;

/**
 * Created by ashutosh on 21/10/16.
 */
public class CompareOutputFiles {

    public static void main(String[] args) {
        try {
            PrintStream out = new PrintStream(new FileOutputStream(Constants.OUTPUT_COMPARISON_FILE));
            System.setOut(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        File hackerrankOutputFile = new File(Constants.HACKERRANK_OUTPUT_FILE);
        File myOutputFile = new File(Constants.MY_OUTPUT_FILE);

        try {
            BufferedReader hackerrankBufferedReader = new BufferedReader(new FileReader(hackerrankOutputFile));
            BufferedReader myBufferedReader = new BufferedReader(new FileReader(myOutputFile));

            String hackerrankLine = null, myLine = null;
            int lineNo = 1;
            while ((hackerrankLine = hackerrankBufferedReader.readLine()) != null &&
                    (myLine = myBufferedReader.readLine()) != null) {
                if (!hackerrankLine.equals(myLine)) {
                    System.out.println("HACKERRANK = " + hackerrankLine + " ; "
                            + "MINE = " + myLine + " ; "
                            + "AT LINE NO = " + lineNo);
                }
                lineNo++;
            }

            if (hackerrankLine == null && myLine != null) {
                System.out.println("MY LINE NOT NULL AND HACKERRANK LINE NULL " + "AT LINE NO = " + lineNo);
            } else if (hackerrankLine != null && myLine == null) {
                System.out.println("HACKERRANK LINE NOT NULL AND MY LINE NULL " + "AT LINE NO = " + lineNo);
            }

            System.out.println("*************END OF FILE**************** " + "AT LINE NO = " + lineNo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
