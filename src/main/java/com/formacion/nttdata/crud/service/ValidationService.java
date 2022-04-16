package com.formacion.nttdata.crud.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.formacion.nttdata.crud.dto.Employee;

@Service
public class ValidationService {

	public boolean validationEmail(String email) {

		 // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher mather = pattern.matcher(email);
 
        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
	}

	public boolean validationFullName(String fullName){
		
		Pattern pattern = Pattern
                .compile("[a-zA-z]+([ ][a-zA-Z]+)");
 
        Matcher mather = pattern.matcher(fullName);
 
        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }

		
	}
	
	public void extracted(Employee employee) {
		if(employee.getHobbies() == null){
			employee.setHobbies("Ningun hobbie seleccionado");
		}
	}
}
