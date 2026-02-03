package com.thlam05.letchat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thlam05.letchat.models.Message;

@Repository
public interface MesageRepository extends JpaRepository<Message, String> {

}
