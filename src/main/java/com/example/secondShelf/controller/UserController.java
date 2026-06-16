package com.example.secondShelf.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class UserController {


    /**
     * Изменить данные текущего юзера
     */
    @PreAuthorize("hasAuthority('USER')")
    @PatchMapping("/users/me")
    public ResponseEntity<String> patchUser() {
        return ResponseEntity.ok(" me request answer");
    }

    /**
     * Получить данные текущего юзера
     *
     * @return
     */
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/users/me")
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok(" me request answer");
    }
}


















