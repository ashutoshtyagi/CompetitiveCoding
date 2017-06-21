package com.fancita.practice.NumberTheory;

import com.fancita.utils.FastIO;

import java.util.Random;

/**
 * Created by ashutosh on 14/12/16.
 */
public class Hackerrank_closest_number extends FastIO {

    public static void main(String[] args) {

        Random random = new Random();
        while (true) {
            int a = random.nextInt(100000);
            int b = random.nextInt(100000);
            double aTob = Math.pow(a, b);
            if (aTob > 1E9) {
                continue;
            }

            int x = random.nextInt((int)1E9);

            System.out.println("a = " + a + ", b = " + b + ", x = " + x);
            /*writer.printLine("a = " + a + ", b = " + b + ", x = " + x);*/

            int retBf = retBF(a,b,x);
            int retMine = ret(a,b,x);
            if (retBf != retMine) {
                System.out.println("Mine = " + retMine);
                System.out.println("BF = " + retBf);
                System.out.println("FAILED");
                /*writer.printLine("FAILED");*/
                break;
            } else {
                System.out.println("SUCCESS");
                /*writer.printLine("SUCCESS");*/
            }


        }

        /*writer.flush();
        writer.close();*/

        /*int t = reader.readInt();
        while (t-- > 0) {
            int a = reader.readInt();
            int b = reader.readInt();
            int x = reader.readInt();

            int ret = f(a,b,x);


            writer.printLine(ans);
        }
        writer.flush();
        writer.close();*/
    }

    private static int retBF(int a, int b, int x) {
        int number = (int) Math.pow(a, b);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i * x >= number; i++) {
            min = number > i*x ? Integer.min(min, number - i*x) : Integer.min(min, i*x - number);
        }

        return min;
    }

    private static int ret(int a, int b, int x) {
        int ans = -1;

        if (b < 0) {
            if (a == 1) {
                ans = 1;
            } else {
                /*ans = 0;*/
            }
            return ans;
        }

        int number = (int) Math.pow(a, b);

        int rem = number % x;
        int mod = x;

        if (rem > mod / 2) {
            ans = number + mod - rem;
        } else {
            ans = number - rem;
        }
        return ans;
    }
}
