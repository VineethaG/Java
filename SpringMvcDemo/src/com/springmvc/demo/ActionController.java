package com.springmvc.demo;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/show")
public class ActionController {

	@RequestMapping("/showFormData")
	public String showName() {
		return "show-name";
	}

	@RequestMapping("/requestName")
	public String requestName() {
		return "request-name";
	}

	// Read the form data
	// Add data to the model
	@RequestMapping("/showForm2Data")
	public String showFormData(HttpServletRequest request, Model model) {

		// read the request parameter from jsp
		String studentName = request.getParameter("stuName");

		// convert the data to all caps
		studentName = studentName.toUpperCase();

		// create a message
		String result = "Hi, " + studentName;

		// add message to model
		model.addAttribute("greetings", result);

		return "show-name";
	}

	@RequestMapping("/showForm3Data")
	public String showForm3Data(@RequestParam("stuName") String studentName, Model model) {

		// read the request parameter from jsp
		//String studentName = request.getParameter("stuName");

		// convert the data to all caps
		studentName = studentName.toUpperCase();

		// create a message
		String result = "Hi, " + studentName + " using Request Parameter";

		// add message to model
		model.addAttribute("greetings", result);

		return "show-name";
	}
}
