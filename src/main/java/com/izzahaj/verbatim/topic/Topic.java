package com.izzahaj.verbatim.topic;

import java.util.ArrayList;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.izzahaj.verbatim.user.User;

@Entity
public class Topic {
    @Id
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String title;
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

}
