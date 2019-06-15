package spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/form")
public class FormController {
	
	@RequestMapping("/showform")
	public String ShowPage() {
		return "showform";
	}
	
	@RequestMapping("/processform")
	public String ProcessPage() {
		return "processform";
	}
	
	@RequestMapping("/processformtwo")
	public String ProcessPageTwo(HttpServletRequest request, Model model) {
		String name = request.getParameter("studentName");
		name = name.toUpperCase();
		String result = "Yo! " + name ;
		model.addAttribute("studentName",result);
		return "processform";
	}
	
	@RequestMapping("/processformthree")
	public String ProcessPageThree(@RequestParam("studentName") String name, Model model) {
		name = name.toUpperCase();
		String result = "Yo! " + name ;
		model.addAttribute("studentName",result);
		return "processform";
	}
}
