package com.immense.admin.user.user;

import com.immense.admin.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    public String listAllUsers(){
        return "users";
    }

}
