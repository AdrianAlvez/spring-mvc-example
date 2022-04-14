package com.formacion.nttdata.hello.service;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


//@Service

public class HomeService {
	public String normalDate(Locale locale) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		return formattedDate;
		
	}
	
	public String calculateDate(Locale locale, int number) {
		Date date=new Date();
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, number);
		Date fecha=c.getTime();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(fecha);
		return formattedDate;


	}

}

