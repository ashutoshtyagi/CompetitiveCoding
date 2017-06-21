package com.fancita.leetcode.NoTag;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ashutosh on 24/5/17.
 */
public class AddDaysToDate {
    public static void main(String[] args) {
        String presentDate = "13-2-2013";
        int numberOfDaysToAdd = 1;

        AddDaysToDate obj = new AddDaysToDate();

        System.out.println(obj.getDate(presentDate, numberOfDaysToAdd));
        obj.printUsingLibrary(presentDate, numberOfDaysToAdd);
    }

    private void printUsingLibrary(String date, int numberOfDaysToAdd) {
        String[] dateArr = date.split("-");
        int presentMonth = Integer.valueOf(dateArr[1]),
                presentDayOfMonth = Integer.valueOf(dateArr[0]),
                presentYear = Integer.valueOf(dateArr[2]);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, presentDayOfMonth);
        c.set(Calendar.MONTH, presentMonth);
        c.set(Calendar.YEAR, presentYear);

        c.add(Calendar.DAY_OF_MONTH, numberOfDaysToAdd); // Adding 5 days
        String output = sdf.format(c.getTime());
        System.out.println(output);
    }

    private String getDate(String date, int numberOfDaysToAdd) {
        String[] dateArr = date.split("-");
        int presentMonth = Integer.valueOf(dateArr[1]),
                presentDayOfMonth = Integer.valueOf(dateArr[0]),
                presentYear = Integer.valueOf(dateArr[2]);
        int[] daysInMonthArr = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30};

        int numberOfDaysRemaining = numberOfDaysToAdd + presentDayOfMonth;
        int monthIterator = presentMonth;
        int yearIterator = presentYear;

        while (true) {
            if(numberOfDaysRemaining <= daysInMonthArr[monthIterator]) {
                return numberOfDaysRemaining + "-" + monthIterator + "-" + yearIterator;
            }
            numberOfDaysRemaining -= daysInMonthArr[monthIterator];
            monthIterator += 1;
            if(monthIterator == 13) {
                monthIterator = 1;
                yearIterator += 1;
            }
        }

        //return "";
    }
}
