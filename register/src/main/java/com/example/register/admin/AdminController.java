package com.example.register.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.register.user.User;
import com.example.register.user.UserRepository;


@Controller
public class AdminController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/admin")
    public String showLoginForm() {
        return "admin";
    }
    @PostMapping("/admin")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if(username.equals("admin") && password.equals("admin123")) {
            List<User> users = userRepository.findAll();
            model.addAttribute("users", users);
            return "success";
        }    
        else { 
            return "error";
        }
    }
}
