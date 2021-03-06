package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/loggedInHome")
    public String home(Model model) {
        model.addAttribute("name", "Payal");
        model.addAttribute("balance", "100,000");

        return "loggedInHome";
    }
}
