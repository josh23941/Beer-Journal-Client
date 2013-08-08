package com.jmiller.brewjournal.util;

import java.util.Calendar;

public class CalendarUtils {
	
	public static String getCurrentDateFormatted(){
		Calendar now = Calendar.getInstance();
		String formattedDate = (now.get(Calendar.MONTH) + "/" + now.get(Calendar.DAY_OF_MONTH) + "/" + now.get(Calendar.YEAR));
		return formattedDate;
	}

	public static void main(String[] args){
		System.out.println(CalendarUtils.getCurrentDateFormatted());
	}
}