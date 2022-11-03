package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Users;
import org.example.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @GetMapping
    public List<Users> get(String users) {
        return usersService.get(users);
    }

    @PostMapping
    public ResponseEntity<Users> add(@RequestBody Users users) {
        Users Users = usersService.add(users);
        return ResponseEntity.status(201).body(Users);
    }

    @PutMapping("{id}")
    public ResponseEntity<Users> update(@PathVariable Long id,
                                        @RequestBody Users users) {
        try {
            users.setId(id);
            Users dbUsers = usersService.update(users);
            return ResponseEntity.ok(dbUsers);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            usersService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Users> get(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(usersService.get(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
