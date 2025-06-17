# Task Manager - Java Desktop App

This is a simple desktop Task Manager application built with **Java Swing** and connected to a **MySQL** database.

## Description

The program allows the user to:

- Add new tasks with a title and category
- Delete a selected task from the list
- Mark a task as completed or not completed (toggle)
- All tasks are saved in a MySQL database and reloaded when the app opens

## Features

###  Add Task
- You type a title and a category
- Click the **Insert** button
- The task is saved in the database and shown in the list

###  Delete Task
- Select a task from the list
- Click the **Delete** button
- The task is removed from the database and the list

###  Toggle Task Status
- Select a task from the list
- Click the **Toggle** button
- The task’s completion status changes (from completed to not completed or vice versa)

###  Save to Database
- Tasks are saved to the `task_table` table in MySQL
- The table is created automatically if it doesn’t exist

###  Load Tasks
- When the app starts, all tasks are loaded from the database and displayed in the list

## How to Run

1. Make sure you have MySQL running and create a database named `tasks`
2. Change the username and password in `DBHelper.java` to match your MySQL login
3. Compile and run the program using your IDE or the terminal
