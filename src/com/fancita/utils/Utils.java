package com.fancita.utils;

/**
 * Created by fancita on 11/11/16.
 */
public class Utils {

    /*
    swipe characters in string
     */
    public static String swipe(String string, int i, int j) {
        char[] chars = string.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

    public static String convertIntArrToString(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : arr) {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }

    public static int[] convertStringToIntArr(String string) {
        int[] newGuess = new int[string.length()];
        for (int i = 0; i < string.length(); i++)
        {
            newGuess[i] = string.charAt(i) - '0';
        }
        return newGuess;
    }

    public static void swipe(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
