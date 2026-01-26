package com.thlam05.letChat.models;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "users")
@Getter
@Setter
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String username;
    private String password;
    private String description;

    @OneToMany(mappedBy = "user")
    private List<Notification> notifications;

    @ManyToMany(mappedBy = "members")
    private Set<Conversation> conversations;

    @OneToMany(mappedBy = "user")
    private Set<Message> messages;
}
