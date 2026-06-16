package com.example.secondShelf.controller;

import com.example.secondShelf.controller.models.Posting;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class RibbonController {

    /**
     * Получить список вещей из ленты с параметрами
     */
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/postings")
    public ResponseEntity<List<Posting>> getPostings(
            @RequestParam(required=false) String status,
            @RequestParam(required=false) String page,
            @RequestParam(required=false) String limit) {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(List.of(new Posting(1), new Posting(2)));
    }


    /**
     * Создать новое объявление
     */
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/postings")
    public ResponseEntity<Posting> createPosting() {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new Posting(Math.abs(new Random().nextLong())));
    }


    /**
     * Изменить свое объявление
     */
    @PreAuthorize("hasAuthority('USER')")
    @PutMapping("/postings/{id}")
    public ResponseEntity<Posting> changePosting(
            @PathVariable String id
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new Posting(Long.parseLong(id)));
    }


    /**
     * Удалить свое объявление
     */
    @PreAuthorize("hasAuthority('USER')")
    @DeleteMapping("/postings/{id}")
    public ResponseEntity<Posting> deletePosting(
            @PathVariable String id
    ) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(new Posting(Long.parseLong(id)));
    }

    /**
     * Добавить объявление в закладки
     */
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/postings/{id}/favorite")
    public ResponseEntity<String> favoritePosting(@PathVariable String id) {
        return ResponseEntity.ok("add a posting to favorites");
    }
}