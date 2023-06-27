package com.revature.SpringBootRefresher.services;


import com.revature.SpringBootRefresher.models.Flashcard;
import com.revature.SpringBootRefresher.repos.FlashcardRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlashcardService {
    private final FlashcardRepo flashcardRepo;

    public Flashcard getFlashcard(int id) {
        return flashcardRepo.findById(id).get();
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

    public Flashcard findByCategory(Flashcard.Category category) {
        return flashcardRepo.findByCategory(category);
    }
}
