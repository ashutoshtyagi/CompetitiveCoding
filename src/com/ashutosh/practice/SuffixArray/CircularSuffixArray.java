package com.ashutosh.practice.SuffixArray;

import com.ashutosh.utils.FastIO;

import java.util.Arrays;

/**
 * Created by ashutosh on 8/11/16.
 * http://www.spoj.com/problems/BEADS/
 * test case 1 :
 *      4
 *      helloworld
 *      amandamanda
 *      dontcallmebfu
 *      aaabaaa
 *
 *      6
 *      aab
 *      aaba
 *      aabaa
 *      aabaaa
 *      aabaaaa
 *      aabaaaaa
 */
public class CircularSuffixArray extends FastIO {

    public static void main(String[] args) {
        int t = reader.readInt();
        while (t-- != 0) {
            String text = reader.readString();
            int retIndex = new CircularSuffixArray(text).getLowestIndex() /*+ 1*/;
            writer.printLine(retIndex);
        }

        writer.flush();
        writer.close();
    }

    private String text;
    private ArrayObject[] suffixArr;
    private int N;

    public CircularSuffixArray(String text) {
        this.text = text;
        this.N = text.length();

        suffixArr = new ArrayObject[N];
        for (int i = 0; i < N; i++) {
            suffixArr[i] = new ArrayObject(i, text.charAt(getIndex(i)) - 'a', text.charAt(getIndex(i + 1)) - 'a');
        }

        Arrays.sort(suffixArr);

        int index[] = new int[N];
        for (int k = 4; k < 2*N; k = 2*k) {

            int rank = 0;
            int prevRank = suffixArr[0].rank;
            suffixArr[0].rank = rank;
            index[suffixArr[0].index] = 0;

            for (int i = 1; i < N; i++) {
                if (suffixArr[i].rank == prevRank && suffixArr[i].nextRank == suffixArr[i-1].nextRank) {
                    prevRank = suffixArr[i].rank;
                    suffixArr[i].rank = rank;
                } else {
                    prevRank = suffixArr[i].rank;
                    suffixArr[i].rank = ++rank;
                }
                index[suffixArr[i].index] = i;
            }

            for (int i = 0; i < N; i++) {
                int nextIndex = getIndex(suffixArr[i].index + k/2);
                suffixArr[i].nextRank = suffixArr[index[nextIndex]].rank;
            }

            Arrays.sort(suffixArr);
        }
    }

    private int getIndex(int n) {
        return n % N;
    }

    public int getLowestIndex() {
        return suffixArr[0].index;
    }

    public String getLexicographicallyFirstString() {
        return text.substring(suffixArr[0].index);
    }

    public int[] getSuffixIndexes() {
        int[] suffixIndexes = new int[N];
        for (int i = 0; i < N; i++) {
            suffixIndexes[i] = suffixArr[i].index;
        }
        return suffixIndexes;
    }

    public String getStringAtPositionInSuffixArray(int positionInSuffixArray) {
        return text.substring(suffixArr[positionInSuffixArray].index);
    }

    public int getRankOfSubstringAtGivenPositionInText(int positionInText) {
        int ret = -1;
        for (int i = 0; i < N; i++) {
            if (suffixArr[i].index == positionInText) {
                ret = i;
                break;
            }
        }
        return ret;
    }

    public int getIndexInTextOfSubstringAtGivenPositionInSuffixArray(int positionInSuffixArray) {
        return suffixArr[positionInSuffixArray].index;
    }



    private class ArrayObject implements Comparable<ArrayObject> {
        public int index;
        public int rank;
        public int nextRank;

        public ArrayObject(int index, int rank, int nextRank) {
            this.index = index;
            this.rank = rank;
            this.nextRank = nextRank;
        }

        @Override
        public int compareTo(ArrayObject o) {
            return this.rank == o.rank ? this.nextRank - o.nextRank : this.rank - o.rank;
        }
    }
}
