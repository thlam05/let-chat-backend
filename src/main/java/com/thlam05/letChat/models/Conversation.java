package com.thlam05.letChat.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Conversation {
    @Id
    private String id;

    @Column(name = "is_group")
    private boolean isGroup;

    @ManyToMany
    @JoinTable(name = "conversation_members", joinColumns = @JoinColumn(name = "conversation_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> members;

    @OneToMany(mappedBy = "conversation")
    private Set<Message> messages;
}
