package com.thlam05.letchat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thlam05.letchat.models.UserFriend;
import com.thlam05.letchat.models.UserFriendId;

@Repository
public interface UserFriendRepository extends JpaRepository<UserFriend, UserFriendId> {

}
