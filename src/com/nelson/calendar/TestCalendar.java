package com.nelson.calendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCalendar {

    /**
     * Method to test calendar options.
     *
     * @param args Commandline arguments.
     */
    public static void main(final String[] args) {

        Calendar calendar = GregorianCalendar.getInstance();
        // Set date to first day of the current year
        calendar.set(Calendar.DAY_OF_YEAR, 1);

        Date thisYearStartDate = calendar.getTime();
        calendar.add(Calendar.YEAR, -1);
        Date lastYearStartDate = calendar.getTime();

        // Roll day of year to end of last year
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        calendar.add(Calendar.YEAR, 1);

        Date lastYearEndDate = calendar.getTime();
        calendar.add(Calendar.YEAR, 1);
        Date thisYearEndDate = calendar.getTime();

        // Data for the this month
        calendar = GregorianCalendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date thisMonthStartDate = calendar.getTime();
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date thisMonthEndDate = calendar.getTime();

        System.out.println("thisYearStartDate: " + thisYearStartDate);
        System.out.println("thisYearEndDate: " + thisYearEndDate);

        System.out.println("");

        System.out.println("lastYearStartDate: " + lastYearStartDate);
        System.out.println("lastYearStartDate: " + lastYearEndDate);

        System.out.println("");

        System.out.println("thisMonthStartDate: " + thisMonthStartDate);
        System.out.println("thisMonthEndDate: " + thisMonthEndDate);
    }

}
