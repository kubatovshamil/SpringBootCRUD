package ru.restapi.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import ru.restapi.test.model.User;
import ru.restapi.test.service.UserServiceImpl;
import java.util.List;

@RestController
@RequestMapping(path ="api/v1/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping
    public List<User> getUsers(){
        return userService.getLists();
    }

	@PostMapping
    public void add(@RequestBody User user){
        userService.saveUser(user);
    }

 	@GetMapping("/{id}")
    public User getUser(@PathVariable long id){
    	return userService.getById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody User userDetails){
        User user = userService.getById(id);
        user.setSurname(user.getSurname());
        user.setLastname(user.getLastname());
        user.setAge(user.getAge());

        User updateData = userService.saveUser(user);
    }

    @DeleteMapping("/{id}")    
    public void deleteUser(@PathVariable long id){
        userService.delete(id);
    }

}

