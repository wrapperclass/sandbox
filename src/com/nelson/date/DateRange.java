package com.nelson.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * User: tjnelson
 * Date: 9/7/12
 * Time: 3:55 PM
 */

public class DateRange {

    private Calendar start;
    private Calendar end;

    public DateRange(Calendar start, Calendar end) {
        this.start = start;
        this.end = end;
    }

    public DateRange(Date start, Date end) {
        this(new GregorianCalendar(), new GregorianCalendar());
        this.start.setTime(start);
        this.end.setTime(end);
    }

    public DateRange(int year) {
        start = GregorianCalendar.getInstance();
        start.set(year, Calendar.JANUARY, 1, 0, 0, 0);
        start.set(Calendar.MILLISECOND, 0);

        end = GregorianCalendar.getInstance();
        end.set(year, Calendar.DECEMBER, 31, 0, 0, 0);
        end.set(Calendar.MILLISECOND, 0);
    }

    public DateRange(int year, int month) {
        start = GregorianCalendar.getInstance();
        start.set(year, month, 1, 0, 0, 0);
        start.set(Calendar.MILLISECOND, 0);

        end = GregorianCalendar.getInstance();
        end.set(year, month, start.getActualMaximum(Calendar.DAY_OF_MONTH), 0, 0, 0);
        end.set(Calendar.MILLISECOND, 0);
    }

    /**
     * This constructor will create a month DateRange given the DATE_KEY from the database in the form YYYYMMDD.
     *
     * @param dateKey Date_key
     */
    public DateRange(String dateKey) {

        int year = Integer.valueOf(dateKey.substring(0, 4));
        int month = Integer.valueOf(dateKey.substring(4, 6)) - 1; //prepare for Calendar month range 0..11

        start = GregorianCalendar.getInstance();
        start.set(Calendar.YEAR, year);
        start.set(Calendar.MONTH, (month - 1));
        start.set(Calendar.DAY_OF_MONTH, 1);
        start.set(Calendar.MILLISECOND, 0);

        end = GregorianCalendar.getInstance();
        end.set(Calendar.YEAR, year);
        end.set(Calendar.MONTH, (month - 1));
        end.set(Calendar.DAY_OF_MONTH, start.getActualMaximum(Calendar.DAY_OF_MONTH));
        end.set(Calendar.MILLISECOND, 0);
    }

    public static DateRange yearToDate(int year, int month) {
        Calendar start = new GregorianCalendar();
        start.set(Calendar.YEAR, year);
        start.set(Calendar.MONTH, Calendar.JANUARY);
        start.set(Calendar.DATE, 1);

        Calendar end = new GregorianCalendar();
        end.set(Calendar.YEAR, year);
        end.set(Calendar.MONTH, month);
        end.set(Calendar.DAY_OF_MONTH, end.getActualMaximum(Calendar.DAY_OF_MONTH));

        return new DateRange(start, end);
    }

    public static DateRange yearToDate(int year) {
        Calendar start = new GregorianCalendar();
        start.set(Calendar.YEAR, year);
        start.set(Calendar.MONTH, Calendar.JANUARY);
        start.set(Calendar.DATE, 1);

        Calendar end = new GregorianCalendar();
        end.set(Calendar.YEAR, year);
        return new DateRange(start, end);
    }

    public static DateRange yearToDate(int year, boolean excludeCurrentMonth) {
        Calendar start = new GregorianCalendar();
        start.set(Calendar.YEAR, year);
        start.set(Calendar.MONTH, Calendar.JANUARY);
        start.set(Calendar.DATE, 1);

        Calendar end = new GregorianCalendar();
        end.set(Calendar.YEAR, year);

        if (excludeCurrentMonth) {
            end.add(Calendar.MONTH, -1);
            end.set(Calendar.DAY_OF_MONTH, end.getActualMaximum(Calendar.DAY_OF_MONTH));
        }

        return new DateRange(start, end);
    }

    public static DateRange monthToDate() {
        Calendar start = new GregorianCalendar();
        start.set(Calendar.MONTH, Calendar.JANUARY);
        start.set(Calendar.DATE, 1);

        Calendar end = new GregorianCalendar();
        return new DateRange(start, end);
    }

    public static Date makeConsistent(Date date) {
        Calendar temp = GregorianCalendar.getInstance();
        temp.setTimeInMillis(date.getTime());
        return temp.getTime();
    }

    public static DateRange createYearToDateRange(int offset) {
        DateRange range = DateRange.createYearRange(offset);
        Calendar today = Calendar.getInstance();
        Calendar end = range.getEndCal();
        end.set(Calendar.DAY_OF_MONTH, today.get(Calendar.MONTH));
        end.set(Calendar.MONTH, today.get(Calendar.MONTH));
        range.end = end;
        return range;
    }

    public static DateRange createYearRange(int offset) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.YEAR, offset);
        return new DateRange(cal.get(Calendar.YEAR));
    }

    public static DateRange createMonthRange(int offset) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.MONTH, offset);
        return new DateRange(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH));
    }

    public static DateRange currentMonthToDate(int year) {
        Calendar start = new GregorianCalendar();
        start.set(Calendar.YEAR, year);
        start.set(Calendar.DATE, 1);

        Calendar end = new GregorianCalendar();
        end.set(Calendar.YEAR, year);
        return new DateRange(start, end);
    }

    public static DateRange lastTwelveFullMonths() {
        Date start, end;
        GregorianCalendar cal = new GregorianCalendar();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        end = cal.getTime();

        cal.add(Calendar.YEAR, -1);
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        start = cal.getTime();
        return new DateRange(start, end);
    }

    public Date getStartDate() {
        return start.getTime();
    }

    public Date getEndDate() {
        return end.getTime();
    }

    public Calendar getStartCal() {
        return copy(start);
    }

    public Calendar getEndCal() {
        return copy(end);
    }

    public java.sql.Date getStartSqlDate() {
        return new java.sql.Date(start.getTimeInMillis());
    }

    public java.sql.Date getEndSqlDate() {
        return new java.sql.Date(end.getTimeInMillis());
    }

    private Calendar copy(Calendar cal) {
        Calendar temp = GregorianCalendar.getInstance();
        temp.setTimeInMillis(cal.getTimeInMillis());
        return temp;
    }

    @Override
    public String toString() {
        return start.getTime() + " - " + end.getTime();
    }
}

