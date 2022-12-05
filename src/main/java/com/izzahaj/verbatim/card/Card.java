package com.izzahaj.verbatim.card;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.izzahaj.verbatim.deck.Deck;

@Entity
public class Card {
    @Id
    @SequenceGenerator(name = "card_sequence",
            sequenceName = "card_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "card")
    private Long id;

    private String front;
    private String back;
    private LocalDateTime lastReviewedAt;
    private LocalDateTime scheduledAt;
    private int repetitions = 0;
    private double interval = 0;
    private double easeFactor = 2.5;

    @ManyToOne(optional = false)
    @JoinColumn(name="deck_id", nullable = false)
    private Deck deck;

    public Card(String front, String back, Deck deck) {
        this.front = front;
        this.back = back;
        this.deck = deck;
    }

}
