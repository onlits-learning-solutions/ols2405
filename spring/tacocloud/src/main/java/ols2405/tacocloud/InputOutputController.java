package ols2405.tacocloud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/io")

public class InputOutputController {
    @GetMapping
    public String showInputForm() {
        return "input";
    }

    @PostMapping
    public String showPostData(Output output) {
        log.info(output.toString());
        return "output";
    }
}