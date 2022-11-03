package org.example.repository;

import org.example.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findByActiveTrue();
}
