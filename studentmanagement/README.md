# Student Management System - Java Swing Application

**Student Management System** is a Java desktop application that allows users to enter, store, and manage student information through a graphical interface. The application supports saving data to a text file (`master.txt`) and also persists the full dataset using Java object serialization (`master.dat`).

---

##  Features

###  Student Data Entry
- **Fields**:
  - Name (required)
  - Address
  - Mobile
  - Email (required)
  - Gender (Male/Female)
  - Semester (dropdown menu: 1 to 8)
- **Validation**:
  - Required fields are checked before submission.
- **Gender Prefix**:
  - Male → "Κος"
  - Female → "Κα"

###  Save Options
- **Save to Text File**:
  - Each student is written to `master.txt` in formatted Greek output.
- **Save to Binary File**:
  - All students are saved as an `ArrayList<Student>` to `master.dat` on exit.
- **Load on Start**:
  - If `master.dat` exists, previously saved students are loaded into memory.

###  File Menu
- **New**:
  - Opens a new entry form for input.
- **Print**:
  - Reads and prints contents of `master.txt` to the console.
- **Exit**:
  - Saves the current student list to `master.dat` and closes the app.

---

##  Additional Features

- **Clear Button**:
  - Clears all input fields without saving.
- **Layout**:
  - Uses `BorderLayout`, `GridLayout`, and `FlowLayout` for structured form input.
- **Data Storage**:
  - `master.txt` for human-readable student records
  - `master.dat` for binary persistence
    
---

##  Technologies

- Java SE
- Java Swing (GUI)
- Java I/O (`FileWriter`, `BufferedReader`, `ObjectOutputStream`, etc.)
- Object-Oriented Programming (OOP)

---

##  How It Works

1. Run `Main.java` to start the application.
2. Fill in the student form and click **SAVE**:
   - Data is written to `master.txt` (text file).
   - Student object is added to in-memory `ArrayList`.
3. On **Exit**, all student records are saved to `master.dat`.
4. On next launch, if `master.dat` exists, it is automatically loaded.
