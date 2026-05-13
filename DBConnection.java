CREATE DATABASE desktop_notifier;

USE desktop_notifier;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100),
    password VARCHAR(100)
);

CREATE TABLE notifications (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200),
    message VARCHAR(500),
    notify_date DATE,
    notify_time TIME
);