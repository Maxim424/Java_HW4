CREATE TABLE dish (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(100) NOT NULL,
                      description TEXT,
                      price DECIMAL(10, 2) NOT NULL,
                      quantity INT NOT NULL,
                      is_available BOOLEAN NOT NULL,
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE orders (
                       id SERIAL PRIMARY KEY,
                       user_id INT NOT NULL,
                       status VARCHAR(50) NOT NULL,
                       special_requests TEXT,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE order_dish (
                            id SERIAL PRIMARY KEY,
                            order_id INT NOT NULL,
                            dish_id INT NOT NULL,
                            quantity INT NOT NULL,
                            price DECIMAL(10, 2) NOT NULL,
                            FOREIGN KEY (order_id) REFERENCES orders(id),
                            FOREIGN KEY (dish_id) REFERENCES dish(id)
);
