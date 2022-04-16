package com.formacion.nttdata.crud.service;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service
public class EditionDate {
	
	public String fechaActual() {
		java.util.Date fecha = new Date();
		return fecha.toLocaleString();
	}

}
