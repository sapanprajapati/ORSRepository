package com.bhagat.hritu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bhagat.hritu.dto.UserDTO;
import com.bhagat.hritu.service.UserService;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String displayLogin() {
        return "login";
    }

    @RequestMapping(
            value = "/login.do", method = RequestMethod.POST)
    public String authenticateUser(@ModelAttribute UserDTO user, Model model) {
        UserDTO userDto = userService.authenticateUser(user);
        if(null !=userDto){
            model.addAttribute("fname", userDto.getFname());
            model.addAttribute("lname", userDto.getLname());
            return "welcome";
        }
        model.addAttribute("errorMessage", "User Not Found!!");
        return "login";
    }
}
