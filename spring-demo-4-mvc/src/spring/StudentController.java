package spring;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showform")
	public String showform(Model theModel) {
		
//		create a student object
		Student theStudent = new Student();
		
//		add student object to the model
		theModel.addAttribute("student",theStudent);
		
		return "student-form";
	}
	
	@RequestMapping("/processform")
	public String processform(@ModelAttribute("student") Student theStudent) {
		
		System.out.println("The student: " + theStudent.getFirstName() + " " + theStudent.getLastName());
		
		return "student-confirmation";
	}

}
