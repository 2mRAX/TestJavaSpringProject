package by.bsuir.leshnevsky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/admin")
    public String viewAdminPanel() {
        return "admin";
    }
    @GetMapping("")
    public String viewIndex() {
        return "index";
    }
}
