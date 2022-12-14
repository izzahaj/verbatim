package com.izzahaj.verbatim.topic;

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

import com.izzahaj.verbatim.deck.Deck;
import com.izzahaj.verbatim.user.User;

@Entity
public class Topic {
    @Id
    @SequenceGenerator(name = "topic_sequence",
            sequenceName = "topic_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "topic_sequence")
    private Long id;

    private String title;
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "topic")
    private List<Deck> decks = new ArrayList();

    public Topic(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
    }
}
