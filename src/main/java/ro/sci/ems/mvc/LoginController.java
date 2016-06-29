package ro.sci.ems.mvc;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import ro.sci.ems.domain.User;
import ro.sci.ems.service.EmployeeService;

@Controller
@RequestMapping("/login")
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping("")
	public ModelAndView login() {
		LOGGER.debug("in login");
		ModelAndView modelAndView = new ModelAndView("employee/login");
		
		return modelAndView;
	}
	
	
	@RequestMapping("/save")
	public ModelAndView onLogin(String userName, String pass, 
			HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		///use UserService to check the login
		boolean loginWithSuccess =  true;
		if (loginWithSuccess) {
			User user = new User();
			user.setUserName(userName);
			
			request.getSession().setAttribute("currentUser", user);
			modelAndView.setView(new RedirectView("/employee"));
		}
		
		return modelAndView;
	}
}
