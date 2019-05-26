package spring.web.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.domain.User;

@Controller
public class UserController {
	
	public UserController() {
		System.out.println("user controller default constructor call");
	}
	
	@RequestMapping("/logonViewModelAndView.do")
	public ModelAndView logonViewModelAndView() {
		
		System.out.println("::== logonViewModelAndView() start...");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user/logonView.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping("/login01.do")
	public ModelAndView logon01(HttpServletRequest request) {
		
		System.out.println("::== logon01() start...");
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("passwordd");
		
		request.setAttribute("userId", userId);
		request.setAttribute("password", password);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("message", "controller 구현 연습");
		
		modelAndView.setViewName("/user/logonResult.jsp");
		
		return modelAndView;
		
	}
	
	@RequestMapping("/login02.do")
	public ModelAndView logon02(HttpServletRequest request, HttpSession session) {
		
		System.out.println("::== logon02() start...");
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		request.setAttribute("userId", userId);
		request.setAttribute("password", password);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("message", "controller 구현 연습");
		
		modelAndView.setViewName("/user/logonResult.jsp");
		
		return modelAndView;
		
	}
	
	@RequestMapping("/login03.do")
	public ModelAndView logon03(@RequestParam("userId") String userId,
								@RequestParam("password") String password,
								HttpServletRequest request, HttpSession session) {
		
		System.out.println("::== logon02() start...");
		
		//String userId = request.getParameter("userId");
		//String password = request.getParameter("passwordd");
		
		request.setAttribute("userId", userId);
		//request.setAttribute("password", password);
		
		session.setAttribute("password", password);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("message", "controller 구현 연습");
		
		modelAndView.setViewName("/user/logonResult.jsp");
		
		return modelAndView;
		
	}
	
	@RequestMapping("/login04.do")
	public ModelAndView logon04(@ModelAttribute("user") User user,
								HttpServletRequest request, HttpSession session) {
		
		System.out.println("::== logon02() start...");
		
		//String userId = request.getParameter("userId");
		//String password = request.getParameter("passwordd");
		
		request.setAttribute("userId", user.getUserId());
		//request.setAttribute("password", password);
		
		session.setAttribute("password", user.getPassword());
		
		System.out.println("===");
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("message", "controller 구현 연습");
		
		modelAndView.setViewName("/user/logonResult.jsp");
		
		return modelAndView;
		
	}
	
	
	@RequestMapping("/login05.do")
	public ModelAndView logon05(@ModelAttribute("user") User user) {
		
		System.out.println("::== logon05() start...");
	
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("message", "controller 구현 연습");
		
		modelAndView.setViewName("/user/logonResult.jsp");
		
		return modelAndView;
		
	}
	
	@RequestMapping("/logonViewString.do")
	public String loginViewString() {
		System.out.println(":: == loginViewString() start....");
		
		return "/user/logonView.jsp";
	}
	
	@RequestMapping("/login06.do")
	public String logon06(@ModelAttribute("user") User user ,HttpServletRequest request, HttpSession session, Map<String,String> map) {
		
		request.setAttribute("userId", user.getUserId());
		request.setAttribute("password", user.getPassword());
		
		map.put("message", "controller 구현연습");
		
		return "/user/logonResult.jsp";//forward
		
		// return "redirect:/user/logonResult.jsp";
		
	}
	
	@RequestMapping("/login07.do")
	public String logon07(@RequestParam("userId") String userId,
								@RequestParam("password") String password,
								Model model) {
		
		System.out.println("::== logon02() start...");
		
		User user = new User();
		user.setUserId(userId);
		user.setPassword(password);
		
		model.addAttribute("user", user);
		model.addAttribute("userId", userId);
		model.addAttribute("password", password);
	
		model.addAttribute("message","controller 구현 연습");
		
		return "/user/logonResult.jsp";
		
	}
	

}
