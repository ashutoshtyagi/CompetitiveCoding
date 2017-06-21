package com.fancita.geeksforgeeks;

/**
 * Created by ashutosh on 1/6/17.
 */
public class FormMinNumberFromGivenSeq {

    public static void main(String[] args) {
        String sequence = "IIDDD";
        System.out.println(go(sequence));
    }

    public static String go(String sequence) {
        if (sequence.length() == 0) return "INVALID";

        boolean[] used = new boolean[10];
        StringBuilder ret = new StringBuilder(sequence.length() + 1);
        for (int i = 1; i <= 9; i++) {
            ret.append(i);
            used[i] = true;
            boolean valid = recurse(sequence, 0, ret, used);
            if (valid) return ret.toString();
            ret.setLength(0);
            used[i] = false;
        }

        return "INVALID";
    }

    private static boolean recurse(String sequence, int index, StringBuilder stringBuilder, boolean[] used) {
        if (index == sequence.length()) return true;

        if (sequence.charAt(index) == 'D') {
            int lastDigit = Character.getNumericValue(stringBuilder.charAt(stringBuilder.length() - 1));
            for (int i = lastDigit - 1; i >= 1; i--) {
                if (!used[i]) {
                    used[i] = true;
                    stringBuilder.append(i);
                    boolean valid = recurse(sequence, index + 1, stringBuilder, used);
                    if (valid) return valid;
                    used[i] = false;
                    stringBuilder.setLength(stringBuilder.length() - 1);
                }
            }
            return false;
        }

        if (sequence.charAt(index) == 'I') {
            int lastDigit = Character.getNumericValue(stringBuilder.charAt(stringBuilder.length() - 1));
            for (int i = lastDigit + 1; i <= 9; i++) {
                if (!used[i]) {
                    used[i] = true;
                    stringBuilder.append(i);
                    boolean valid = recurse(sequence, index + 1, stringBuilder, used);
                    if (valid) return valid;
                    used[i] = false;
                    stringBuilder.setLength(stringBuilder.length() - 1);
                }
            }
            return false;
        }

        return false;
    }



}
