package com.memorynotfound.spring.security.web.rest.users;

import com.memorynotfound.spring.security.model.User;
import com.memorynotfound.spring.security.repository.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api-rest/users")
@Api(value="Users Api", description="Operations pertaining to users")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/findByLastName")
    public List<User> findByLastName(){
        return userRepository.findByLastName("Not Found");
    }

}
