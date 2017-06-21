package com.fancita.codeforces;

import com.fancita.utils.FastIO;

import java.io.*;
import java.util.*;

/**
 * Created by ashutosh on 19/11/16.
 */
public class d158 extends FastIO {
    public static void main(String[] args) {
        int n = reader.readInt();
        int[] arr = new int[n+1];
        IOUtils.readIntArray(reader, arr, 1);
        run(arr,n);
        writer.flush();
        writer.close();
    }

    public static void run(int[] arr, int n) {
        List<Integer> allFactors = findAllFactorsOfN(n);
        HashMap<Integer, Integer> map = new HashMap<>();
        int totalSum = 0;

        for (int i = 1; i < arr.length; i++) {
            totalSum += arr[i];
            for (Integer factor : allFactors) {
                int key = getKey(factor, i % factor);
                map.put(key, map.containsKey(key) ? map.get(key) + arr[i] : arr[i]);
            }
        }


        Iterator it = map.entrySet().iterator();
        int min = Integer.MAX_VALUE;
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> pair = (Map.Entry)it.next();
            min = Integer.min(min, pair.getValue());
        }
        writer.print(min < 0 ? totalSum - min : totalSum);
    }

    private static int getKey(int factor, int offset) {
        return factor * (maxFactor + 1) + offset;
    }

    private static int maxFactor = Integer.MIN_VALUE;

    public static List<Integer> findAllFactorsOfN(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i * 2 <= n; i++) {
            if (n % i == 0 && (n - (n / i) > 2) && (n - (n / i)) % 2 == 0) {
                list.add(i);
                maxFactor = Integer.max(maxFactor, i);
            }
        }
        return list;
    }
}
