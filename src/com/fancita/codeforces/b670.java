package com.fancita.codeforces;

import com.fancita.utils.FastIO;

/**
 * Created by fancita on 12/11/16.
 */
public class b670 extends FastIO {

    public static void main(String[] args) {
        int noOfRobots = reader.readInt();
        int k = reader.readInt();
        int arr[] = new int[noOfRobots + 1];
        IOUtils.readIntArray(reader, arr, 1);
        writer.print(getKthNumber(arr, k));
        writer.flush();
        writer.close();
    }

    public static int getKthNumber(int[] arr, int k) {
        int retIndex = 0;
        int readTillNow = 0;
        for (int i = 1; i < arr.length; i++) {
            int nextMarker = readTillNow + i;
            if (k > readTillNow && k <= nextMarker) {
                retIndex = (k - readTillNow) % i;
                if (retIndex == 0) {
                    retIndex = i;
                }
                break;
            }
            readTillNow = nextMarker;
        }

        if (retIndex == 0) {
            return -1;
        } else {
            return arr[retIndex];
        }
    }
}
