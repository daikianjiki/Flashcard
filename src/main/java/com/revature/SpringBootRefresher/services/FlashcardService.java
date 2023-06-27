package com.revature.SpringBootRefresher.services;


import com.revature.SpringBootRefresher.models.Flashcard;
import com.revature.SpringBootRefresher.repos.FlashcardRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlashcardService {
    FlashcardRepo flashcardRepo;

    public FlashcardService(FlashcardRepo flashcardRepo) {
        this.flashcardRepo = flashcardRepo;
    }


    public Optional<Flashcard> getFlashcard(int id) {
        return flashcardRepo.findById(id);
    }

    public List<Flashcard> getAllFlashcards() {
        return flashcardRepo.findAll();
    }

    public Flashcard createFlashcard(Flashcard flashcard) {
        return flashcardRepo.save(flashcard);
    }

    public void deleteFlashcard(int id) {
        flashcardRepo.deleteById(id);
    }

    public Flashcard updateFlashcard(int id) {
        Flashcard flashcard = flashcardRepo.findById(id).get();
        flashcard.setQuestion(flashcard.getQuestion());
        flashcard.setAnswer(flashcard.getAnswer());
        flashcard.setCategory(flashcard.getCategory());
        return flashcardRepo.save(flashcard);
    }

    public Flashcard patchFlashcard(int id) {
        Flashcard flashcard = flashcardRepo.findById(id).get();
        return flashcardRepo.save(flashcard);
    }
}
