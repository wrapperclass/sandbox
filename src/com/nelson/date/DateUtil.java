package com.nelson.date;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateUtil {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int year = 2011;
        int month = 11;

        Calendar start = GregorianCalendar.getInstance();
        start.set(Calendar.YEAR, year);
        start.set(Calendar.MONTH, (month - 1));
        start.set(Calendar.DAY_OF_MONTH, 1);
        start.set(Calendar.MILLISECOND, 0);

        Calendar end = GregorianCalendar.getInstance();
        end.set(Calendar.YEAR, year);
        end.set(Calendar.MONTH, (month - 1));
        end.set(Calendar.DAY_OF_MONTH, start.getActualMaximum(Calendar.DAY_OF_MONTH));
        end.set(Calendar.MILLISECOND, 0);

        System.out.println("");
        System.out.println("startDate: " + start.getTime());
        System.out.println("endDate:   " + end.getTime());
    }

}
