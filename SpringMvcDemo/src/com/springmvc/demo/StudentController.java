package com.springmvc.demo;

import javax.validation.Valid;
import javax.xml.bind.Binder;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	// Add an initbinder,
	// trim input strings and remove the leading and trailing whitespaces
	@InitBinder
	public void initBinder(WebDataBinder databinder) {
		StringTrimmerEditor stringTimmerEditor = new StringTrimmerEditor(true);
		databinder.registerCustomEditor(String.class, stringTimmerEditor);
	}

	@RequestMapping("showForm")
	public String showForm(Model myModel) {
		Student student = new Student();
		myModel.addAttribute("student", student);
		return "student-form";
	}

	@RequestMapping("processForm")
	public String processForm(@Valid @ModelAttribute("student") Student student, BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			System.out.println(student.getFirstName() + " ||" + student.getLastName() + "|| " + student.getCountry());
			return "student-form";
		} else {
			System.out.println(student.getFirstName() + "||" + student.getLastName() + "||" + student.getCountry());
			return "student-confirmation";
		}
	}
}
