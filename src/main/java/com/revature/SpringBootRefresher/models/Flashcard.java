package com.revature.SpringBootRefresher.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "flashcards")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@NotNull
    @Column(unique = true, nullable = false)
    private String question;
    @NotNull
    private String answer;

    @Enumerated
    private Category category;
    public enum Category {
        JAVA,SPRING,WEB,ANGULAR
    }

    /**
     * TODO: Add an author variable for field to the flashcard that is type user.
     *
     */
//    @ManyToOne
//    public User author;
}
