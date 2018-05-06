package task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Pavel Smokorovskiy on 03.05.18
 */

@Controller
public class WelcomeController {

    @GetMapping(value = "/")
    public String showWelcomePage() {
        return "index";
    }

}
