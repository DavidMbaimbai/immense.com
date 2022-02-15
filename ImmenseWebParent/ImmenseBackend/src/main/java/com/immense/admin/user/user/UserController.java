package com.immense.admin.user.user;

import com.immense.admin.user.UserService;
import com.immense.common.entity.Role;
import com.immense.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public String listAllUsers(Model model){
        List<User> listUsers=userService.listAllUsers();

        model.addAttribute("listUsers", listUsers);
        return "users";
    }

    @GetMapping("/users/new")
    public String newUser(Model model){
        List<Role> listRoles = userService.listRoles();
        User user = new User();
        user.setEnabled(true);
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "user_form";
    }
    @PostMapping("/users/save")
    public String saveUser(User user){
        System.out.println(user);
        userService.save(user);
        return "redirect:/users";
    }

}
