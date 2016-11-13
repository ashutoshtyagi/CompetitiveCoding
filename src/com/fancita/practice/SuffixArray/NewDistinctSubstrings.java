package com.fancita.practice.SuffixArray;

import com.fancita.utils.FastIO;

import java.util.Arrays;

/**
 * Created by fancita on 9/11/16.
 * http://www.spoj.com/problems/SUBST1/
 * http://www.spoj.com/problems/DISUBSTR/
 */
public class NewDistinctSubstrings extends FastIO{

    public static void main(String[] args) {
        int t = reader.readInt();
        while (t-- > 0) {
            String str = reader.readString();
            writer.printLine(new NewDistinctSubstrings(str).getNumberOfDistinctSubstrings());
        }
        writer.flush();
        writer.close();
    }

    private String text;
    private int N;
    private ArrayObject[] suffixArr;
    private int[] lcp;

    public NewDistinctSubstrings(String text) {
        this.text = text;
        this.N = text.length();

        /*ArrayObject[] suffixArr = new ArrayObject[N];*/
        suffixArr = new ArrayObject[N];
        for (int i = 0; i < N; i++) {
            suffixArr[i] = new ArrayObject(i, text.charAt(i) - 'a',
                    i + 1 < N ? text.charAt(i + 1) - 'a' : -1);
        }

        Arrays.sort(suffixArr);

        int[] index = new int[N];

        for (int k = 4; k < 2*N; k = 2*k) {

            int rank = 0;
            int prevRank = suffixArr[0].rank;
            suffixArr[0].rank = rank;
            /*index[0] = suffixArr[0].index;*/
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
                int nextIndex = suffixArr[i].index + k/2;
                suffixArr[i].nextRank = nextIndex < N ? suffixArr[index[nextIndex]].rank : -1;
            }
            Arrays.sort(suffixArr);
        }

        /*this.suffixArr = new int[N];
        for (int i = 0; i < N; i++) {
            this.suffixArr[i] = suffixArr[i].index;
        }*/
    }

    public String getText() {
        return text;
    }

    public int getLength() {
        return N;
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

    public int[] getSuffixIndexes() {
        int[] suffixIndexes = new int[N];
        for (int i = 0; i < N; i++) {
            suffixIndexes[i] = suffixArr[i].index;
        }
        return suffixIndexes;
    }

    public int getLowestIndex() {
        return suffixArr[0].index;
    }

    public String getLexicographicallyFirstString() {
        return text.substring(suffixArr[0].index);
    }

    public String getLongestRepeatedSubstring() {
        String ret = "";
        int retLength = 0;
        for (int i = 1; i < N; i++) {
            int longestAtI = 0;
            int j = suffixArr[i - 1].index;
            int k = suffixArr[i].index;
            while (j < N && k < N && text.charAt(j) == text.charAt(k)) {
                longestAtI++;
                j++;
                k++;
            }
            retLength = Integer.max(retLength, longestAtI);
            if (retLength == longestAtI) {
                ret = text.substring(suffixArr[i].index, suffixArr[i].index + longestAtI);
            }
        }

        return ret;
    }

    public String getLongestNonOverlappingRepeatedSubstring() {
        String ret = "";
        int retLength = 0;
        for (int i = 1; i < N; i++) {
            int longestAtI = 0;
            int j = suffixArr[i - 1].index;
            int k = suffixArr[i].index;
            while (j < N && k < N && text.charAt(j) == text.charAt(k) &&
                    j < k ? j < suffixArr[i].index : k < suffixArr[i-1].index) {
                longestAtI++;
                j++;
                k++;
            }
            retLength = Integer.max(retLength, longestAtI);
            if (retLength == longestAtI) {
                ret = text.substring(suffixArr[i].index, suffixArr[i].index + longestAtI);
            }
        }

        return ret;
    }

    public String getCommonPrefixAtGivenSuffixIndex(int indexInSuffixArr) {
        if (indexInSuffixArr > 0) {
            int i = suffixArr[indexInSuffixArr - 1].index;
            int j = suffixArr[indexInSuffixArr].index;
            while (i < N && j < N && text.charAt(i) == text.charAt(j)) {
                i++;
                j++;
            }
            return text.substring(suffixArr[indexInSuffixArr].index, j);
        } else return null;
    }

    public int getCommonPrefixLengthAtGivenSuffixIndex(int indexInSuffixArr) {
        if (indexInSuffixArr > 0) {
            int i = suffixArr[indexInSuffixArr - 1].index;
            int j = suffixArr[indexInSuffixArr].index;
            while (i < N && j < N && text.charAt(i) == text.charAt(j)) {
                i++;
                j++;
            }
            return j - suffixArr[indexInSuffixArr].index;
        } else return 0;
    }

    public int[] getLcpArray() {
        if (lcp != null) {
            return lcp;
        } else {

        }
        return null;
    }

    public int getLengthOfSuffixAtGivenSuffixIndex(int indexInSuffixArr) {
        return N - suffixArr[indexInSuffixArr].index;
    }

    public long getNumberOfDistinctSubstrings() {
        long ret = 0;
        for (int i = 0; i < N; i++) {
            ret += getLengthOfSuffixAtGivenSuffixIndex(i) - getCommonPrefixLengthAtGivenSuffixIndex(i);
        }
        return ret;
    }

    private class ArrayObject implements Comparable<ArrayObject>{
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
            return (this.rank == o.rank) ?  ((this.nextRank < o.nextRank) ? -1 : 0) :
                    (this.rank < o.rank) ? -1 : 1;
        }
    }
}
