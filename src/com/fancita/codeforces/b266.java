package com.fancita.codeforces;

import com.fancita.utils.FastIO;

/**
 * Created by fancita on 13/11/16.
 */
public class b266 extends FastIO {

    public static void main(String[] args) {
        int n = reader.readInt();
        int iterations = reader.readInt();
        String sequence = reader.readString();
        bubbleSort(sequence, iterations);
        writer.flush();
        writer.close();
    }

    public static void bubbleSort(String sequence, int iterations) {
        boolean swapped = true;
        int it = 0;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < sequence.length() - 1;) {
                if (sequence.charAt(i) == 'B' && sequence.charAt(i+1) == 'G') {
                    sequence = /*Utils.*/swipe(sequence, i, i + 1);
                    i += 2;
                    swapped = true;
                } else i++;
            }
            if (swapped) {
                it++;
                if (it == iterations) {
                    writer.printLine(sequence);
                    break;
                }
            }
        }

        if (it < iterations) {
            writer.printLine(sequence);
        }
    }

    public static String swipe(String string, int i, int j) {
        char[] chars = string.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}