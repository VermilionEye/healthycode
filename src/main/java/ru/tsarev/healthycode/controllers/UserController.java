package ru.tsarev.healthycode.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.tsarev.healthycode.entities.User;
import ru.tsarev.healthycode.security.CustomUserDetails;
import ru.tsarev.healthycode.services.UserService;

@Controller
@AllArgsConstructor
public class UserController {
    private UserService userService;
    @GetMapping("login")
    public String getRegistration(Model model) {
        model.addAttribute("userReg", new User());
        return "enter";
    }

    @PostMapping("reg")
    public String addNewUser(@ModelAttribute("userReg") User user) {
        userService.addUser(user);
        return "redirect:login";
    }

    @GetMapping("/account")
    public String getAccount(Model model , @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        Long id = customUserDetails.getUser().getId();
        model.addAttribute("user", userService.findUserById(id));
        return "account";
    }
}

