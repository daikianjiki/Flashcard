package com.revature.SpringBootRefresher.controllers;

import com.revature.SpringBootRefresher.models.Flashcard;
import com.revature.SpringBootRefresher.repos.FlashcardRepo;
import com.revature.SpringBootRefresher.services.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FlashcardController {
    FlashcardService flashcardService;

    @Autowired
    public FlashcardController(FlashcardService flashcardService) {
        this.flashcardService = flashcardService;
    }

    @GetMapping("flashcard/{id}")
    public Optional<Flashcard> getFlashcard(@PathVariable int id) {
        return flashcardService.getFlashcard(id);
    }

    @GetMapping("flashcards")
    public List<Flashcard> getAllFlashcards() {
        return flashcardService.getAllFlashcards();
    }

    @PostMapping("flashcard")
    public Flashcard createFlashcard(@RequestBody Flashcard flashcard) {
        return flashcardService.createFlashcard(flashcard);
    }

    @DeleteMapping("flashcard/{id}")
    public void deleteFlashcard(@PathVariable int id) {
        flashcardService.deleteFlashcard(id);
    }

    @PutMapping("flashcard/{id}")
    public Flashcard updateFlashcard(@PathVariable int id) {
        return flashcardService.updateFlashcard(id);
    }

    @PatchMapping("flashcard/{id}")
    public Flashcard patchFlashcard(@PathVariable int id) {
        return flashcardService.patchFlashcard(id);
    }

}
