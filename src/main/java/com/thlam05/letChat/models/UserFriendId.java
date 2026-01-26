package com.thlam05.letChat.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
public class UserFriendId implements Serializable {
    private String userId;
    private String friendId;
}