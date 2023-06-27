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

    public Flashcard updateFlashcard(Flashcard flashcard, int id) {
        Flashcard updatedFlashcard = flashcardRepo.findById(id).get();
        updatedFlashcard.setQuestion(flashcard.getQuestion());
        updatedFlashcard.setAnswer(flashcard.getAnswer());
        updatedFlashcard.setCategory(flashcard.getCategory());
        return flashcardRepo.save(updatedFlashcard);
    }

    public Flashcard patchFlashcard(Flashcard flashcard, int id) {
        Flashcard patchedFlashcard = flashcardRepo.findById(id).get();
        patchedFlashcard.setQuestion(flashcard.getQuestion());
        patchedFlashcard.setAnswer(flashcard.getAnswer());
        patchedFlashcard.setCategory(flashcard.getCategory());
        return flashcardRepo.save(patchedFlashcard);
    }
}
