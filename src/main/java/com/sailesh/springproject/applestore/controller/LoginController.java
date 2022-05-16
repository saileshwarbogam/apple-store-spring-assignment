package com.sailesh.springproject.applestore.controller;


import com.sailesh.springproject.applestore.dao.RoleRepository;
import com.sailesh.springproject.applestore.dao.UserRepository;
import com.sailesh.springproject.applestore.entity.Role;
import com.sailesh.springproject.applestore.entity.User;
import com.sailesh.springproject.applestore.global.GlobalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class LoginController {

    private Logger myLogger = Logger.getLogger(getClass().getName());


    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    public LoginController(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private   RoleRepository roleRepository;

    @GetMapping("/login")
    public String login(){
        GlobalData.cart.clear();
        return "log-in";
    }

    @GetMapping("/register")
    public String registerGet(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "register-view";
    }


    @PostMapping("/register")
    public String registerPost(@Valid @ModelAttribute("user") User user, BindingResult errors){

        if(errors.hasErrors()){
            myLogger.info(errors.toString());
            return "register-view";
        }

        else{
            String password = user.getPassword();

            user.setPassword(bCryptPasswordEncoder.encode(password));

            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findById(2).get());


            user.setRoles(roles);

            userRepository.save(user);

            return "redirect:/log-in";
        }
    }
}
