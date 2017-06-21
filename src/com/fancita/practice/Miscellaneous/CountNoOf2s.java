package com.fancita.practice.Miscellaneous;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashutosh on 29/4/17.
 */
public class CountNoOf2s {
    public static void main(String[] args) {
        int num = 1000562;
        System.out.println(new CountNoOf2s().countBruteForce(num));
        System.out.println(new CountNoOf2s().count(num));
    }

    private int countBruteForce(int number) {
        int ret = 0;
        for(int i = 2; i <= number; i++) {
            ret += getOccurancesInGivenNumber(i);
        }
        return ret;
    }

    private int getOccurancesInGivenNumber(int num) {
        int ret = 0;
        while (num > 0) {
            int digit = num % 10;
            ret += digit == 2 ? 1 : 0;
            num /= 10;
        }
        return ret;
    }

    private int count(int num) {
        int numberOfDigits = getNumberOfDigits(num);
        List<Integer> countVsDigits = getCountVsDigits(numberOfDigits);
        return recurse(num, countVsDigits);
    }

    private int recurse(int num, List<Integer> countVsDigits) {
        int numberOfDigits = getNumberOfDigits(num);

        if(numberOfDigits == 1 || num == 0) return num >= 2 ? 1 : 0;

        int ret = 0;
        int highestDigit = highestDigit(num);
        ret += highestDigit * countVsDigits.get(numberOfDigits - 2);
        if (highestDigit >= 3) {
            ret += (int) Math.pow(10, numberOfDigits - 1);
        }
        int forwardNum = removeHighestDigit(num);
        if(highestDigit == 2) {
            ret += forwardNum + 1;
        }
        return ret + recurse(forwardNum, countVsDigits);
    }

    private int removeHighestDigit(int num) {
        return num % (highestDigit(num) * (int) Math.pow(10, getNumberOfDigits(num) - 1));
    }

    private int highestDigit(int num) {
        while (num >= 10) num = num / 10;
        return num;
    }

    private List<Integer> getCountVsDigits(int maxNoOfDigits) {
        List<Integer> ret = new ArrayList<>(maxNoOfDigits);
        ret.add(1);
        for(int i = 2; i <= maxNoOfDigits; i++) {
            ret.add(ret.get(ret.size() - 1) * 10 + (int) Math.pow(10, i - 1));
        }
        return ret;
    }

    private int getNumberOfDigits(int num) {
        int ret = 0;
        while (num != 0) {
            ret++;
            num /= 10;
        }
        return ret;
    }
}
