package com.thlam05.letChat.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "user_friends")
@Getter
@Setter
@AllArgsConstructor
public class UserFriend {
    @Id
    private UserFriendId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("friendId")
    @JoinColumn(name = "friend_id")
    private User friend;

    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}

@Embeddable
@Getter
@Setter
@AllArgsConstructor
class UserFriendId implements Serializable {
    private String userId;
    private String friendId;
}