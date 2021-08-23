package ru.restapi.test.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.restapi.test.model.User;
import ru.restapi.test.service.UserServiceImpl;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping({"/"})
    public String getAll(Model model){
        List<User> users = userService.getLists();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping({"/create"})
    public String index(Model model){
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping({"/add"})
    public String add(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteById(@PathVariable (value = "id") long id){
        this.userService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/updateUser/{id}")
    public String updateById(@PathVariable(value = "id") long id, Model model){
        User user = this.userService.getById(id);
        model.addAttribute("user", user);
        return "update";
    }

    @PostMapping({"/update"})
    public String update(@ModelAttribute("user") User user){
        this.userService.saveUser(user);
        return "redirect:/";
    }
    
}
