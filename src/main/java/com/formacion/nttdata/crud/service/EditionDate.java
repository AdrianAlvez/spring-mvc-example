package com.formacion.nttdata.crud.service;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service
public class EditionDate {
	public String editionDate(Locale locale) {

		Date date = new Date();

		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		return formattedDate;
		
	}
	
	public String fechaActual() {
		java.util.Date fecha = new Date();
		return fecha.toLocaleString();
	}

}
