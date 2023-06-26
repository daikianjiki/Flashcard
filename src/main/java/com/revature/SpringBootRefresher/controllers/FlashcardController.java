package com.revature.SpringBootRefresher.controllers;

import com.revature.SpringBootRefresher.services.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlashcardController {
    FlashcardService flashcardService;

    @Autowired
    FlashcardController(FlashcardService flashcardService) {
        this.flashcardService = flashcardService;
    }
}
