package com.izzahaj.verbatim.deck;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.izzahaj.verbatim.card.Card;
import com.izzahaj.verbatim.user.User;

@Entity
public class Deck {
    @Id
    @SequenceGenerator(name = "deck_sequence",
            sequenceName = "deck_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "deck_sequence")
    private Long id;

    private String title;
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "deck")
    private List<Card> cards = new ArrayList();

    public Deck(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
    }
}
