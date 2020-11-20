package app.web;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.model.User;
import app.service.user.UserService;

@Controller
public class ShiroController {
	@Autowired
	UserService userService;

	@PostMapping("/login")
	public String onSubmit(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              Model model) throws Exception {

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            SecurityUtils.getSubject().login(token);
        } catch (AuthenticationException e) {
            model.addAttribute("errorInvalidLogin", "The username or password was not correct.");

            return "/login";
        }
        token.setRememberMe(true);
//        Subject s = SecurityUtils.getSubject();
//        System.out.println(s.getPrincipal());
        return "redirect:/";
    }
	
	@PostMapping("/registration")
	public String getRegistration(@RequestParam String Username, @RequestParam String email, @RequestParam String password,
            Model model) {
		@SuppressWarnings("unused")
		User user = null;
		Username = Username.trim();
		email = email.trim();
		password = password.trim();
		List<User> users = userService.getAllUsers();
		for (User userDb : users) {
			if(userDb.getUsername().equals(Username)) {
				user = userDb;
				break;
			}
		}
		if(!Username.trim().isBlank() || !email.trim().isBlank() || !password.trim().isBlank()) {
			user = userService.create(Username, email, password);
		}
		UsernamePasswordToken token = new UsernamePasswordToken(Username, password);
		try {
            SecurityUtils.getSubject().login(token);
        } catch (AuthenticationException e) {
            model.addAttribute("errorInvalidLogin", "The username or password was not correct.");

            return "/registration";
        }
        token.setRememberMe(true);
		
        return "redirect:/";
	}
	

	@GetMapping("/login")
	public String getLogin(){
		
		Subject s = SecurityUtils.getSubject();
		System.out.println("---------------------------" + s.getPrincipal());
		
		return "login";
	}
	
	@GetMapping("/registration")
	public String getRegistration(){
		
		return "registration";
	}
	
	@GetMapping("/logout")
	public String getSecure(){
		SecurityUtils.getSubject().logout();
		return "login";
	}
	
	
	
	
}
