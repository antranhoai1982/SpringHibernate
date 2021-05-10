package WebMvcController;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    Logger log = Logger.getLogger(HomeController.class.getName());
    
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcomePage() {
        log.info("INTO welcomePage");
        return "welcome";
    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        log.info("INTO index");
        return "index";
    }
}