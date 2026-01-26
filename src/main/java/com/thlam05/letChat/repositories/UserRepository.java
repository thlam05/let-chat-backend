package com.thlam05.letChat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thlam05.letChat.models.User;

@Repository
public interface UserRepository extends JpaRepository<String, User> {
}
