package app.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
public class ShiroController {

	@PostMapping("/login")
    protected String onSubmit(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              Model model) throws Exception {

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            SecurityUtils.getSubject().login(token);
        } catch (AuthenticationException e) {
            model.addAttribute("errorInvalidLogin", "The username or password was not correct.");

            return "/hangman/login";
        }

        return "redirect:/hangman/secure";
    }
	
	
	@GetMapping("/secure")
    public String secure(ModelMap modelMap) {

        Subject currentUser = SecurityUtils.getSubject();
        String role = "", permission = "";

        if(currentUser.hasRole("admin")) {
            role = role  + "You are an Admin";
        }
        else if(currentUser.hasRole("editor")) {
            role = role + "You are an Editor";
        }
        else if(currentUser.hasRole("guest")) {
            role = role + "You are an guest";
        }

        modelMap.addAttribute("username", currentUser.getPrincipal());
        modelMap.addAttribute("permission", permission);
        modelMap.addAttribute("role", role);

        return "secure";
    }
	
}
