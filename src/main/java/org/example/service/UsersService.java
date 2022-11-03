package org.example.service;

import org.example.model.Users;

import java.util.List;

public interface UsersService {
    Users add(Users users);

    List<Users> get(String Users);

    Users get(Long id) throws Exception;

    void delete(Long id) throws Exception;

    Users update(Users users) throws Exception;
}
