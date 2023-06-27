package com.revature.SpringBootRefresher.repos;

import com.revature.SpringBootRefresher.models.Flashcard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FlashcardRepoTests {

    @Autowired
    public FlashcardRepo fr;

    @BeforeAll
    void setUpTestData() {
        Flashcard flashcard = new Flashcard(0, "What is Spring MVC?", "Spring MVC is an integrated version of the Spring framework and Model, View, Controller", Flashcard.Category.SPRING);
        flashcard = fr.save(flashcard);
    }
    @Test
    void createFlashcard() {
        Flashcard flashcard = new Flashcard(0, "What is SpringBoot?", "Open-source Java based framework", Flashcard.Category.SPRING);
        flashcard = fr.save(flashcard);

        System.out.println(flashcard.getId());

        Assertions.assertNotEquals(0, flashcard.getId());
    }
    @Test
    void getAllFlashcards() {
        List<Flashcard> flashcards = fr.findAll();
        System.out.println(flashcards);
        Assertions.assertFalse(flashcards.isEmpty());
    }
}
