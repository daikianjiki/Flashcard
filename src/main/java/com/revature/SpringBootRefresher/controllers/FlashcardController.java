package com.revature.SpringBootRefresher.controllers;

import com.revature.SpringBootRefresher.models.Flashcard;
import com.revature.SpringBootRefresher.repos.FlashcardRepo;
import com.revature.SpringBootRefresher.services.FlashcardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("flashcards")
@RequiredArgsConstructor
public class FlashcardController {
    private final FlashcardService flashcardService;

    @GetMapping("{id}")
    public Flashcard getFlashcard(@PathVariable int id) {
        return flashcardService.getFlashcard(id);
    }

    @GetMapping("all")
    public List<Flashcard> getAllFlashcards() {
        return flashcardService.getAllFlashcards();
    }

    @PostMapping
    public Flashcard createFlashcard(@RequestBody Flashcard flashcard) {
        return flashcardService.createFlashcard(flashcard);
    }

    @DeleteMapping("{id}")
    public void deleteFlashcard(@PathVariable int id) {
        flashcardService.deleteFlashcard(id);
    }

    @PutMapping("{id}")
    public Flashcard updateFlashcard(@RequestBody Flashcard flashcard, @PathVariable int id) {
        return flashcardService.updateFlashcard(flashcard, id);
    }

    @PatchMapping("{id}")
    public Flashcard patchFlashcard(@RequestBody Flashcard flashcard, @PathVariable int id) {
        return flashcardService.patchFlashcard(flashcard, id);
    }

    @GetMapping
    @ResponseBody
    public Flashcard findByCategory(@RequestParam Flashcard.Category category) {
        return flashcardService.findByCategory(category);
    }

    //if I didn't want to create so many getMapping, (with different added uri ("/someEndpoint")
    // I could create a helper method that would use the uri to execute the proper method.

}
