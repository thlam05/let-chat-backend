package com.thlam05.letChat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thlam05.letChat.models.UserFriend;
import com.thlam05.letChat.models.UserFriendId;

@Repository
public interface UserFriendRepository extends JpaRepository<UserFriend, UserFriendId> {

}
