package com.formacion.nttdata.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.formacion.nttdata.crud.dao.EmployeeMapper;
import com.formacion.nttdata.crud.dto.Employee;
import com.formacion.nttdata.crud.service.EditionDate;
import com.formacion.nttdata.crud.service.ValidationService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	EditionDate editionDate;
	
	@Autowired
	ValidationService validationService;

	private static final String EMPLOYEE = "Employee";
	private static final String EMPLOYEELIST = "ListEmployees";

	@RequestMapping("/listOfEmployee")
	public String showListOfEmployees(Model model) {
		model.addAttribute("employeeList", employeeMapper.getAllEmployees());
		return EMPLOYEELIST;
	}

	@RequestMapping("/showFormForAdd")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return EMPLOYEE;
	}

	@RequestMapping("/saveProcess")

	public String saveEmployee(@ModelAttribute("employee") Employee employee, Model model) {
		
		if(!validationService.validationFullName(employee.getFullname())) {
			model.addAttribute("messageErrorFullName", "Campo Full Name vacio o formato erroneo. Por favor introduzca su Nombre y apellidos.");
			return EMPLOYEE;
		}
		
		if(!validationService.validationEmail(employee.getEmail())) {
			model.addAttribute("messageErrorEmail", "Campo email vacio o formato erroneo. Por favor introduzca un email valido.");
			return EMPLOYEE;
		} 
		
		if(employee.getHobbies() == null){
			employee.setHobbies("Ningún hobbie seleccionado.");
		}
		
	
		if (employee.getId() == null) {
			employee.setEdition(editionDate.fechaActual());
			employeeMapper.saveEmployee(employee);
		} else {
			employee.setEdition(editionDate.fechaActual());
			employeeMapper.updateEmployee(employee);
		}

		return "redirect:/employee/listOfEmployee";
	}

	@RequestMapping("/displayUpdateForm")
	public String showUpdateForm(@RequestParam("employeeId") int employeeId, Model model) {
		model.addAttribute("employee", employeeMapper.findById(employeeId));
		return EMPLOYEE;
	}

	@RequestMapping("/displayDeleteForm")
	public String deleteEmployee(@RequestParam("employeeId") int employeeId) {
		employeeMapper.deleteEmployee(employeeId);
		return "redirect:/employee/listOfEmployee";
	}
}
