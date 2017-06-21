package com.fancita.leetcode.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashutosh on 28/3/17.
 */
public class LexicographicalNumbers {

    public static void main(String[] args) {

    }

    public List<Integer> lexicalOrder(int n) {
        // 1. find max number of digits
        int maxDigits = getDigits(n);

        // 2. make indexed integer array
        IndexedInteger[] indexedIntegers = new IndexedInteger[n];
        for (int i = 0; i < n; i++) {
            indexedIntegers[i]= new IndexedInteger(convertToMaxDigits(n, maxDigits), i + 1);
        }

        // 3. radix sort loop for indexedInteger
        for (int exp = 10 * maxDigits; exp >= 1; exp /= 10) {
            countSort(indexedIntegers, exp);
        }

        // 4. return another int array formed using inxedinteger array
        List<Integer> ret = new ArrayList<>(n);
        for (int i = 0; i < indexedIntegers.length; i++) {
            ret.add(indexedIntegers[i].originalNum);
        }

        return ret;
    }

    private void countSort(IndexedInteger[] indexedIntegers, int exp) {

    }

    private int getDigits(int n) {
        int ret = 0;
        while (n > 0) {
            n = n / 10;
            ret++;
        }
        return ret;
    }

    private int convertToMaxDigits(int n, int maxDigits) {
        int presentDigits = getDigits(n);
        int ret = n;
        while (presentDigits <= maxDigits) {
            n = n * 10;
            presentDigits++;
        }
        return ret;
    }

    class IndexedInteger {
        int num, originalNum;

        public IndexedInteger(int num, int originalNum) {
            this.num = num;
            this.originalNum = originalNum;
        }
    }
}
