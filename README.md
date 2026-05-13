# Desktop Notifier using Java Swing & MySQL

Desktop Notifier is a Java-based desktop application developed using Java Swing and JDBC. The project allows users to register, log in, and schedule reminder notifications with specific dates and times. The system continuously monitors scheduled reminders and displays popup notifications on the desktop when the specified time is reached.

## Features

* User Registration and Login
* Add Desktop Notifications
* Schedule Date and Time Reminders
* Popup Alert Notifications
* MySQL Database Connectivity
* Simple and User-Friendly GUI
* Real-Time Notification Scheduler

## Technologies Used

* Java
* Java Swing
* JDBC
* MySQL
* Timer & TimerTask

## Modules

1. Registration Module
2. Login Module
3. Dashboard Module
4. Notification Scheduler
5. Database Connectivity

## Software Requirements

* Java JDK 8 or above
* MySQL Server
* NetBeans / Eclipse / IntelliJ IDEA
* MySQL Connector JAR

## Database

The project uses MySQL database with two tables:

* users
* notifications

## How to Run

1. Create the MySQL database using the provided SQL file.
2. Add MySQL Connector JAR to the project library.
3. Update database username and password in `DBConnection.java`.
4. Run `Main.java`.

## Future Enhancements

* System Tray Notifications
* Sound Alerts
* Email Reminder Integration
* Dark Mode UI
* Edit/Delete Notifications
* Cloud Synchronization

## Project Objective

The main objective of this project is to provide a simple desktop reminder system that helps users manage tasks, schedules, and important notifications efficiently.

## Author

Developed as a Java Mini Project for learning GUI development, JDBC connectivity, and desktop-based application development.
