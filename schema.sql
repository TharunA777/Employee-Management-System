
CREATE TABLE users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    designation VARCHAR(50),
    city VARCHAR(50),
    country VARCHAR(50)
);
