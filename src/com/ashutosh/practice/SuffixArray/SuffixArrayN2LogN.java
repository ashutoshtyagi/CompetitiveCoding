package com.ashutosh.practice.SuffixArray;

import com.ashutosh.utils.FastIO;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ashutosh on 9/11/16.
 * http://www.spoj.com/problems/SUBST1/
 * http://www.spoj.com/problems/DISUBSTR/
 */
public class SuffixArrayN2LogN extends FastIO {

    public static void main(String[] args) {
        int t = reader.readInt();
        while (t-- > 0) {
            String str = reader.readString();
            SuffixArrayN2LogN suffixArrayN2LogN = new SuffixArrayN2LogN(str);
            suffixArrayN2LogN.createLcp();
            writer.printLine(suffixArrayN2LogN.getNumberOfDistinctSubstrings());
        }
        writer.flush();
        writer.close();
    }

    private String text;
    private int N;
    private Integer[] suffixArr;
    private int[] lcp;

    public SuffixArrayN2LogN(String text) {
        this.text = text;
        this.N = text.length();

        suffixArr = new Integer[N];
        for (int i = 0; i < N; i++) {
            suffixArr[i] = i;
        }

        Arrays.sort(suffixArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                while (i < N && j < N && text.charAt(i++) == text.charAt(j++)) {}
                return text.charAt(i - 1) - text.charAt(j - 1);
            }
        });
    }

    public long getNumberOfDistinctSubstrings() {
        long ret = 0;
        for (int i = 0; i < N; i++) {
            ret += getLengthOfSuffixAtGivenSuffixIndex(i) - lcp[i];
        }
        return ret;
    }

    public void createLcp() {
        lcp = new int[N];
        lcp[0] = 0;
        for (int i = 1; i < N; i++) {
            int j = suffixArr[i-1];
            int k = suffixArr[i];
            int maxLength = 0;
            while (j < N && k < N && text.charAt(j++) == text.charAt(k++)) {
                maxLength++;
            }
            lcp[i] = maxLength;
        }
    }

    public int getLengthOfSuffixAtGivenSuffixIndex(int indexInSuffixArr) {
        return N - suffixArr[indexInSuffixArr];
    }

    public Integer[] getSuffixArr() {
        return suffixArr;
    }
}
