package com.formacion.nttdata.hello.service;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Service;


@Service
public class HomeService {

	public String calculoFecha(Locale locale) {

		Date date = new Date();

		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		return formattedDate;
		
	}
	
}

