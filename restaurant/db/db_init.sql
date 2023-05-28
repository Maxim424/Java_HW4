CREATE TABLE users
(
    id            SERIAL PRIMARY KEY,
    username      VARCHAR(50)         NOT NULL,
    email         VARCHAR(100)        NOT NULL,
    password_hash VARCHAR(255)        NOT NULL,
    role          VARCHAR(10)         NOT NULL,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
