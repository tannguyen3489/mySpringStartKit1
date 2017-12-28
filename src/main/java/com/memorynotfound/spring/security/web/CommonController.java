package com.memorynotfound.spring.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
    @GetMapping(value = "/home")
    public String home() {
        return "/home";
    }

    @GetMapping(value = "/")
    public String index() {
        return "/home";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "/login";
    }
}
