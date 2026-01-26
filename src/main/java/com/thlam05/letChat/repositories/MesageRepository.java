package com.thlam05.letChat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thlam05.letChat.models.Message;

@Repository
public interface MesageRepository extends JpaRepository<Message, String> {

}
