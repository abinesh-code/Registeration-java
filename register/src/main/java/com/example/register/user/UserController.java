package com.example.register.user;

import java.lang.reflect.Field;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.register.mail.EmailService;


@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @GetMapping("/register")
    public String userForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user) throws EmailException {

        Field[] fields = User.class.getDeclaredFields();

        StringBuilder messageBuilder = new StringBuilder("Thank you for registering. Your details:\n");

        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();

            if("id".equals(fieldName)) {
                continue;
            }

            try {
                Object value = field.get(user);
                messageBuilder.append(fieldName).append(": ").append(value).append("\n");
            } catch (IllegalAccessException e) {
                e.printStackTrace(); // Handle the exception appropriately
            }
        }

        String to = ""; // Replace with the recipient's email
        String subject = "Registration Confirmation";
        String message = messageBuilder.toString();
        emailService.sendRegistrationEmail(to, subject, message,user.getEmail());

        userRepository.save(user);
        return "thankyou";
    }
}
