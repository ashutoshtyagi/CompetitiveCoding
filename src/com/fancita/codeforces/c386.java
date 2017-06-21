package com.fancita.codeforces;

import java.io.*;
import java.util.InputMismatchException;

/**
 * Created by ashutosh on 18/12/16.
 */
public class c386 extends FastIO {
    public static void main(String[] args) {
        int s = reader.readInt();
        int x1 = reader.readInt();
        int x2 = reader.readInt();

        int t1 = reader.readInt(); //tram passes 1 meter per t1 sec
        int t2 = reader.readInt(); //Igor passes 1 meter per t2 sec

        int p = reader.readInt(); // position of tram
        int d = reader.readInt(); // direction of tram -1 or 1

        if (x1 == x2) {
            writer.printLine("0");
            writer.flush();
            writer.close();
            return;
        }

        if (x1 < x2) {
            int distanceIgor = x2 - x1;
            int timeIgor = distanceIgor * t2;
            if (p <= x1) {
                if (d == -1) {
                    int distanceTram = p + x2;
                    int timeTram = distanceTram * t1;
                    writer.printLine((timeIgor < timeTram ? timeIgor : timeTram));
                } else if (d == 1) {
                    int distanceTram = x2 - p;
                    int timeTram = distanceTram * t1;
                    writer.printLine((timeIgor < timeTram ? timeIgor : timeTram));
                }
            } else if (p > x1 && p < x2) {
                if (d == -1) {
                    int distanceTram = p + x2;
                    int timeTram = distanceTram * t1;
                    writer.printLine((timeIgor < timeTram ? timeIgor : timeTram));
                } else if (d == 1) {
                    int distanceTram = s - p + s + x2;
                    int timeTram = distanceTram * t1;
                    writer.printLine((timeIgor < timeTram ? timeIgor : timeTram));
                }
            } else if (p >= x2) {
                if (d == -1) {
                    int distanceTram = p + x2;
                    int timeTram = distanceTram * t1;
                    writer.printLine((timeIgor < timeTram ? timeIgor : timeTram));
                } else if (d == 1) {
                    int distanceTram = s - p + s + x2;
                    int timeTram = distanceTram * t1;
                    writer.printLine((timeIgor < timeTram ? timeIgor : timeTram));
                }
            }
        } else {  // x2 < x1
            int distanceIgor = x1 - x2;
            int timeIgor = distanceIgor * t2;
            if (p <= x2) {
                if (d == -1) {
                    int distanceTram = p + s + s - x2;
                    int timeTram = distanceTram * t1;
                    writer.printLine((timeIgor < timeTram ? timeIgor : timeTram));
                } else if (d == 1) {
                    int distanceTram = s - p + s - x2;
                    int timeTram = distanceTram * t1;
                    writer.printLine((timeIgor < timeTram ? timeIgor : timeTram));
                }
            } else if (p > x2 && p < x1) {
                if (d == -1) {
                    int distanceTram = p + s + s - x2;
                    int timeTram = distanceTram * t1;
                    writer.printLine((timeIgor < timeTram ? timeIgor : timeTram));
                } else if (d == 1) {
                    int distanceTram = s - p + s - x2;
                    int timeTram = distanceTram * t1;
                    writer.printLine((timeIgor < timeTram ? timeIgor : timeTram));
                }
            } else if (p >= x1) {
                if (d == -1) {
                    int distanceTram = p - x2;
                    int timeTram = distanceTram * t1;
                    writer.printLine((timeIgor < timeTram ? timeIgor : timeTram));
                } else if (d == 1) {
                    int distanceTram = s - p + s - x2;
                    int timeTram = distanceTram * t1;
                    writer.printLine((timeIgor < timeTram ? timeIgor : timeTram));
                }
            }
        }

        writer.flush();
        writer.close();
    }
}
