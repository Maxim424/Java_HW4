CREATE TABLE users
(
    id            SERIAL PRIMARY KEY,
    username      VARCHAR(50)  UNIQUE NOT NULL,
    email         VARCHAR(100) UNIQUE NOT NULL,
    password_hash VARCHAR(255)        NOT NULL,
    role          VARCHAR(10)         NOT NULL CHECK (role IN ('CUSTOMER', 'CHEF', 'MANAGER')),
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE session (
                         id SERIAL PRIMARY KEY,
                         user_id INT NOT NULL,
                         session_token VARCHAR(255) NOT NULL,
                         expires_at TIMESTAMP NOT NULL,
                         FOREIGN KEY (user_id) REFERENCES users(id)
);

