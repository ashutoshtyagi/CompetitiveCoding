package com.fancita.codeforces;

import java.io.*;
import java.util.*;


/**
 * Created by ashutosh on 31/12/16.
 */
public class c416 extends FastIO {
    public static void main(String[] args) {

        int noOfGuestGroups = reader.readInt();
        List<GuestGroup> guestList = new ArrayList<>(noOfGuestGroups);
        for (int i = 0; i < noOfGuestGroups; i++) {
            guestList.add(new GuestGroup(reader.readInt(), reader.readInt(), i + 1));
        }

        int noOfTables = reader.readInt();
        Table[] tablesArr =  new Table[noOfTables];
        for (int i = 0; i < noOfTables; i++) {
            tablesArr[i] = new Table(i, reader.readInt(), false);
        }

        Arrays.sort(tablesArr);
        Collections.sort(guestList);

        StringBuilder restOfAnswerString = new StringBuilder();
        int acceptedRequests = 0, totalMoney = 0;
        for (GuestGroup guestGroup : guestList) {
            int indexInTablesArr = search(tablesArr, guestGroup.c);
            if (indexInTablesArr >= 0 && indexInTablesArr < tablesArr.length) {
                Table table = tablesArr[indexInTablesArr];
                table.occupied = true;
                acceptedRequests += 1;
                totalMoney += guestGroup.p;
                restOfAnswerString.append(guestGroup.originalIndex + " "  + (table.initialPosition + 1) + "\n");
            }
        }

        writer.printLine(acceptedRequests + " " + totalMoney);
        writer.printLine(restOfAnswerString);
        writer.flush();
        writer.close();
    }

    private static int search(Table[] tablesArr, int guestGroupCapacity) {
        int start = 0, end = tablesArr.length - 1, middle = -1;
        while (start < end) {
            middle = (start + end) / 2;
            int middleCapacity = tablesArr[middle].capacity;
            if (middleCapacity < guestGroupCapacity) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }

        if (start == end && start == tablesArr.length - 1 && tablesArr[start].capacity < guestGroupCapacity) {
            return -1;
        }
        middle = start == end ? start: -1;
        if (middle == -1) {
            return -1;
        }

        int ret = middle;
        for (ret = middle; ret < tablesArr.length; ret++) {
            if (!tablesArr[ret].occupied) {
                break;
            }
        }

        return ret;
    }

    private static class Table implements Comparable<Table>{
        private int initialPosition;
        private int capacity;
        private boolean occupied;

        public Table(int initialPosition, int capacity, boolean occupied) {
            this.initialPosition = initialPosition;
            this.capacity = capacity;
            this.occupied = occupied;
        }

        @Override
        public int compareTo(Table o) {
            return this.capacity - o.capacity;
        }
    }

    private static class GuestGroup implements Comparable<GuestGroup> {
        int c;
        int p;
        int originalIndex;

        public GuestGroup(int c, int p, int originalIndex) {
            this.c = c;
            this.p = p;
            this.originalIndex = originalIndex;
        }

        @Override
        public int compareTo(GuestGroup o) {
            return o.p - this.p;
        }
    }
}
