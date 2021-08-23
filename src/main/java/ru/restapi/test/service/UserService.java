package ru.restapi.test.service;

import ru.restapi.test.model.User;

import java.util.List;

public interface UserService {

    public User getById(long id);

    public User saveUser(User user);

    public void delete(long id);

    public List<User> getLists();

}
