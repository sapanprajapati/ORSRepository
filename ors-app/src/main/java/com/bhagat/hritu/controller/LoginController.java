package com.bhagat.hritu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    
    private static Logger LOG= LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("/")
    public String displayLogin() {
        LOG.info("diplay login method start");
        return "login";
    }

    @RequestMapping(
            value = "/login.do", method = RequestMethod.POST)
    public String authenticate(@ModelAttribute UserDTO user, Model model) {
        LOG.info("authenticate method start");
        UserDTO userDto = userService.authenticateUser(user);
        if(null !=userDto){
            model.addAttribute("fname", userDto.getFname());
            model.addAttribute("lname", userDto.getLname());
            return "welcome";
        }
        model.addAttribute("errorMessage", "User Not Found!!");
        LOG.info("authenticate method end");
        return "login";
    }
}
