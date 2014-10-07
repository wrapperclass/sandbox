package org.lds.drps.ws;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TestDate {
	public static void main(String[] args) throws ParseException {

		String test = "29-APR-14 10.49.04.084064000 AM AMERICA/DENVER";
		TestDate testDate = new TestDate();
		Calendar calendar = new GregorianCalendar();

		// Split the String Date into its parts.
		String[] parts = test.split("\\s+");

		// Set the day of the calendar
		calendar.set(testDate.getYear(parts[0]), testDate.getMonth(parts[0]), testDate.getDay(parts[0]));
		calendar.setTimeZone(TimeZone.getTimeZone(parts[3]));

		System.out.println("Date: " + calendar.get(Calendar.APRIL));
	}

	private int getMonth(String date) {
		String[] month = date.split("-");
		int monthInt = 0;
		switch (month[1]) {
		case "JAN":
			monthInt = 0;
			break;
		case "FEB":
			monthInt = 1;
			break;
		case "MAR":
			monthInt = 2;
			break;
		case "APR":
			monthInt = 3;
			break;
		case "MAY":
			monthInt = 4;
			break;
		case "JUN":
			monthInt = 5;
			break;
		case "JUL":
			monthInt = 6;
			break;
		case "AUG":
			monthInt = 7;
			break;
		case "SEP":
			monthInt = 8;
			break;
		case "OCT":
			monthInt = 9;
			break;
		case "NOV":
			monthInt = 10;
			break;
		case "DEC":
			monthInt = 11;
			break;
		}
		return monthInt;
	}

	private int getDay(String date) {
		String[] day = date.split("-");
		return Integer.valueOf(day[0]);
	}

	private int getYear(String date) {
		String[] year = date.split("-");
		return Integer.valueOf(year[2]);
	}
}
