#  Java Projects Collection

Welcome to my **Java Projects Repository** – a curated collection of Java desktop applications and educational programs developed using **Java SE**, **Swing GUI**, **file I/O**, and **MySQL integration**. Each project is self-contained and demonstrates specific programming techniques, from user interfaces to database handling and data persistence.

---

##  Project List

### 1.  Task Manager (with MySQL)
A full-featured task management app with:
- Add/Delete/Toggle completion status
- MySQL database connection
- GUI using Swing
- Table creation with SQL

 Folder: `task_manager/`  
 Uses `MySQL` and `JDBC`

---

### 2.  To-Do List App
Simple task tracker that supports:
- Add/Remove/Save/Load tasks
- Stores tasks in `tasks.txt`
- Built with Java Swing

 Folder: `todoapp/`  
 Uses local file `src/tasks.txt`

---

### 3.  Pizza Ordering System
A restaurant GUI app for managing pizza orders:
- Select pizza type and toppings
- Auto-calculate price and total
- View formatted order summary

 Folder: `pizzaordering/`  
 Uses enums and Swing GUI

---

### 4.  Student Management System
A student record GUI with:
- Form input with validation
- Stores records in `master.txt` and `master.dat`
- Supports binary and text file saving

 Folder: `studentmanagement/`  
 Saves data to `master.txt` and `master.dat`

---

### 5.  Password Generator App
Generate and display random passwords:
- Swing GUI with character settings
- Stores generated password in `passwords.txt`

 Folder: `passwordgenerator/`  
 Saves to `passwords.txt`

---

### 6.  PDF Reader GUI
Simple PDF reader using Apache PDFBox:
- Select and open PDF files
- View content in a scrollable JTextArea

 Folder: `pdfreader/`  
 Requires `Apache PDFBox` library

---

### 7.  Restaurant Order System
Terminal and GUI-based app for managing orders:
- Enter product name, quantity, table number
- Calculates total cost
- Displays orders in GUI

 Folder: `ordersmanagement/`  
 Internal memory (no file/database)

---

### 8.  ERP System (File-Based)
Manage customers and products:
- Add/search/edit/delete entities
- Save/load data to:
  - `customers.txt` (only names)
  - `products.txt` (name + price)

 Folder: `erpfile/`  
 Text-based persistence

---

##  Technologies Used

-  Java SE 8+
-  Swing GUI
-  File I/O (Text & Binary)
-  MySQL + JDBC
-  Apache PDFBox (for PDF reader)

---

##  How to Run

Each project includes:
- A `Main.java` file as entry point
- Java Swing-based graphical interface
- In some cases: database setup or file paths

Use an IDE like **IntelliJ IDEA**, **Eclipse**, or **NetBeans**:
