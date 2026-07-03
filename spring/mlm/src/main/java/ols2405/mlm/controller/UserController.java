package ols2405.mlm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ols2405.mlm.repository.UserRepository;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/login")
    public String getLogin() {
        return "user/login";
    }

    @PostMapping(path = "/authenticate")
    public String authenticate() {

        return "";
    }
}
