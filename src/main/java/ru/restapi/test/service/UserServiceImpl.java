package ru.restapi.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.restapi.test.model.User;
import ru.restapi.test.repository.UserRepository;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User getById(long id) {
        return this.userRepository.getById(id);
    }

    @Override
    public User saveUser(User user) {
        this.userRepository.save(user);
        return user;
    }

    @Override
    public void delete(long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public List<User> getLists() {
        return this.userRepository.findAll();
    }

}
