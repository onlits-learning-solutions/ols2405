package ols2405.mlm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import ols2405.mlm.form.LoginForm;
import ols2405.mlm.service.UserService;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/login")
    public String getLogin() {
        return "user/login";
    }

    @PostMapping(path = "/authenticate")
    public String authenticate(@Valid @ModelAttribute LoginForm loginForm, BindingResult result,
            HttpSession httpSession) {
        if (result.hasErrors()) {
            return "user/login";
        }

        if (userService.authenticate(loginForm)) {
            httpSession.setAttribute("userId", loginForm.getUserId());
            return "redirect:/dashboard";
        } else {
            return "redirect:/user/login";
        }
    }

    @GetMapping(path = "/seedadmin")
    public String seedAdmin() {
        userService.seedAdmin();
        System.out.println("Admin Seeding Successful!");
        return "redirect:/user/login";
    }
}
