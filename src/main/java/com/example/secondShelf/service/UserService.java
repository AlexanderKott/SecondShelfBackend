package com.example.secondShelf.service;

import com.example.secondShelf.domain.model.Role;
import com.example.secondShelf.domain.model.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final List<User> users;

    public UserService() {
        this.users = List.of(
                new User("Alex",
                        "1234",
                        "Alex",
                        "Kotman",
                        Collections.singleton(Role.USER)),
                new User("Anzor",
                        "1234",
                        "Anzor",
                        "Hutov",
                        Collections.singleton(Role.ADMIN))
        );
    }

    public Optional<User> getByLogin(@NonNull String login) {
        return users.stream()
                .filter(user -> login.equals(user.getLogin()))
                .findFirst();
    }

}
