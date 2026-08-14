package ols2405.mlm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/dashboard")
public class DashboardController {
    @GetMapping
    public String getDashboard(HttpSession httpSession) {
        String userId = (String) httpSession.getAttribute("userId");

        // if (userId == null)
        //     return "redirect:/user/login";
        return "dashboard";
    }
}
