package spring.web.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	public TestController() {
		System.out.println(":: TestController default Constructor call");
	}

	@RequestMapping("/testView01.do")//서버가 실행됬을때  spring이제공하는  handlermapping에 등록
	public ModelAndView testView01() {
		System.out.println("[testView01() start......]");

		return new ModelAndView("/test/testView.jsp");
	}

	@RequestMapping("/testView02.do")
	public String testView02() {
		System.out.println("[testView02() start......]");

		return "/test/testView.jsp";		
	}


	@RequestMapping("/testView03.do")
	public String testView03(@RequestParam("abc") int no,
			@RequestParam("def") String name) {
		
		// int no = Integer.parseInt(request.getParameter("abc"));

		System.out.println("[testView03() start......]");	

		System.out.println("no : "+no+"------- name : "+name);

		return "/test/testView.jsp";

	}

	@RequestMapping("/testView04.do")
	public String testView04(@RequestParam(value="abc") int no,
			@RequestParam(value="def", required=false) String name) {

		System.out.println("[testView04() start......]");
		System.out.println("no : "+no+"------- name : "+name);

		return "/test/testView.jsp";		

	}

	@RequestMapping("/testView05.do")
	public String testView05(@RequestParam(value="abc", defaultValue="1") int no,
			@RequestParam(value="def", required=false) String name) {

		System.out.println("[testView05() start......]");
		System.out.println("no : "+no+"------- name : "+name);

		return "/test/testView.jsp";		
	}	

}
