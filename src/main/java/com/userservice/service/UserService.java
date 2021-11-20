package com.userservice.service;

import java.util.List;

import com.userservice.domain.Role;
import com.userservice.domain.User;

public interface UserService {
    User saveUser(Role role);

    Role saveRole(Role role);

    void addRoleToUser(String username, String rolename);

    User getUser(String username);

    List<User> getUser();
}
