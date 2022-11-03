package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.Users;
import org.example.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    @Override
    public Users add(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public List<Users> get(String Users) {
        return usersRepository.findByActiveTrue();
    }

    @Override
    public Users get(Long id) throws Exception {
        return usersRepository.findById(id).orElseThrow(() -> new Exception("Group not found"));
    }

    @Override
    public void delete(Long id) throws Exception {
        var user = get(id);
        user.setActive(false);
        usersRepository.save(user);
    }

    @Override
    public Users update(Users users) throws Exception {
        get(users.getId());
        return usersRepository.save(users);
    }
}
