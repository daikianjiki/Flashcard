package com.revature.SpringBootRefresher.services;


import com.revature.SpringBootRefresher.repos.FlashcardRepo;
import org.springframework.stereotype.Service;

@Service
public class FlashcardService {
    FlashcardRepo flashcardRepo;

    public FlashcardService(FlashcardRepo flashcardRepo) {
        this.flashcardRepo = flashcardRepo;
    }
}
