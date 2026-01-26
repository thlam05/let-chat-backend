create database let_chat;

use let_chat;

CREATE TABLE users(
	id CHAR(36) PRIMARY KEY DEFAULT (UUID()),
    username VARCHAR(64) NOT NULL,
    password VARCHAR(64) NOT NULL,
    description VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE conversations(
	id CHAR(36) PRIMARY KEY DEFAULT(UUID()),
    is_group BOOLEAN NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE messages(
	id CHAR(36) PRIMARY KEY DEFAULT(UUID()),
    conversation_id CHAR(36) NOT NULL,
    content VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (conversation_id) REFERENCES conversations(id)
);

CREATE TABLE notifications (
	id CHAR(36) PRIMARY KEY DEFAULT(UUID()),
    user_id CHAR(36) NOT NULL,
    title VARCHAR(64) NOT NULL,
    content VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE user_friends(
	user_id CHAR(36) NOT NULL,
    friend_id CHAR(36) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    PRIMARY KEY (user_id, friend_id),
    
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (friend_id) REFERENCES users(id)
);

CREATE TABLE conversation_members(
	user_id CHAR(36) NOT NULL,
    conversation_id CHAR(36) NOT NULL,
    
    PRIMARY KEY (user_id, conversation_id),
    
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (conversation_id) REFERENCES conversations(id)
);

SHOW tables;