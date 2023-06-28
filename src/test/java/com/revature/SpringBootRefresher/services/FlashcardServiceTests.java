package com.revature.SpringBootRefresher.services;

import com.revature.SpringBootRefresher.models.Flashcard;
import com.revature.SpringBootRefresher.repos.FlashcardRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FlashcardServiceTests {

    @Autowired
    FlashcardService fs;

    @MockBean
    FlashcardRepo fr;

//    @BeforeAll
//    public void setUpTestData() {
//        List<Flashcard> flashcards = new ArrayList<>();
//        Flashcard flashcard = new Flashcard(0, "What is Spring MVC?", "Spring MVC is an integrated version of the Spring framework and Model, View, Controller", Flashcard.Category.SPRING);
//        fr.save(flashcard);
//    }

    @Test
    public void createFlashcard(){
        Flashcard flashcard = new Flashcard(0, "What is SpringBoot?", "Open-source Java based framework", Flashcard.Category.SPRING);

        Mockito.when(fr.save(flashcard)).thenReturn(new Flashcard(1, flashcard.getQuestion(), flashcard.getAnswer(), flashcard.getCategory()));

        flashcard = fs.createFlashcard(flashcard);

        System.out.println(flashcard);

        Assertions.assertNotEquals(0, flashcard.getId());
        Assertions.assertEquals("What is SpringBoot?", flashcard.getQuestion());
    }

    @Test
    public void getAllFlashcards() {
        List<Flashcard> flashcards = new ArrayList<>();
        Flashcard flashcard = new Flashcard(0, "What is Spring MVC?", "Spring MVC is an integrated version of the Spring framework and Model, View, Controller", Flashcard.Category.SPRING);

        flashcards.add(flashcard);

        Mockito.when(fr.findAll()).thenReturn(flashcards);

        flashcards = fs.getAllFlashcards();

        System.out.println(flashcards);
        Assertions.assertNotEquals(0, flashcards.size());
        Assertions.assertEquals(1, flashcards.get(0).getId());
    }
}
