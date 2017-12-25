package com.memorynotfound.spring.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping(value = "/userpage")
    public String userPage() {
        return "/users/userpage";
    }

}
