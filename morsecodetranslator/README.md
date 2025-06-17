# Online Survey System - Java Swing Application

**Online Survey System** is a Java desktop application that allows users to answer a series of predefined questions through a graphical interface. At the end of the survey, users can export their answers to a `.txt` file using a save dialog.

---

##  Features

###  Survey Functionality
- **Predefined Questions**:
  - 10 questions about Java programming concepts are added by default.
- **Step-by-Step Input**:
  - Questions are presented one at a time.
  - User enters their answer in a text field and clicks "Next" to proceed.

###  Summary & Export
- **Summary Generation**:
  - After all questions are answered, a summary of all questions and their corresponding answers is prepared.
- **Save to File**:
  - The summary can be saved in a `.txt` file using a `JFileChooser` save dialog.
  - File format includes each question followed by its answer.

---

##  Additional Features

- **Input Validation**:
  - User must provide a non-empty answer before proceeding to the next question.
- **Swing-based GUI**:
  - Clear layout with `BorderLayout`, `JLabel`, `JTextField`, and `JButton`.
- **User Feedback**:
  - Dialogs notify the user about empty input and file save success or errors.

---

##  File Structure

- `Main.java`: Initializes the survey and launches the GUI.
- `Survey.java`: Holds the list of questions and collected answers.
- `SurveyGUI.java`: The main Swing interface, manages interaction, input, and saving.
- `Question.java`: Represents a single survey question.
- `Answer.java`: Represents an answer and links it to its corresponding question.

---

##  Technologies

- Java SE
- Java Swing for GUI
- OOP principles (Encapsulation, Composition)
- File I/O for saving results

---

##  How It Works

1. Run `Main.java`.
2. A window opens displaying the first question.
3. The user:
   - Types an answer
   - Clicks **Next**
   - Repeats until all 10 questions are answered
4. When complete:
   - The application shows a summary internally.
   - A file save dialog allows the user to save all answers as text.

---

