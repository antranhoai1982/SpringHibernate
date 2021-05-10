package WebMvcController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String onload() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String userName, @RequestParam String password) {
		if ("admin".equalsIgnoreCase(userName) && "admin".equalsIgnoreCase(password))
			return "index";
		return "login";
	}
}