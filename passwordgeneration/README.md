# Password Generator - Java Swing Application

**Password Generator** is a Java desktop application that allows users to generate strong random passwords based on customizable options (length, characters used, etc.). The application includes a graphical user interface (GUI) and supports saving the generated password to a `.txt` file for later use.

---

##  Features

###  Password Generation
- **Customizable Length**:
  - User can choose how many characters the password should have.
- **Character Options**:
  - Include uppercase letters (A–Z)
  - Include lowercase letters (a–z)
  - Include digits (0–9)
  - Include symbols (e.g., `!@#$%&*`)
- **Random and Secure**:
  - The password is generated randomly based on the selected criteria.

###  Save to File
- **Save Option**:
  - Users can save the generated password to a file.
  - The default file used is: `passwords.txt`.

---

##  Additional Features

- **Swing-based GUI**:
  - User-friendly interface with text fields, checkboxes, and buttons.
- **Clipboard Copy** *(if implemented)*:
  - Easily copy the password for quick use (optional to add).
- **Input Validation**:
  - Ensures at least one character set is selected before generation.

---

##  File Structure

- `Main.java`: Launches the application window.
- `GenerationGui.java`: The main GUI frame that handles user interaction and layout.
- `PasswordGeneration.java`: Contains the logic for generating passwords based on user selections.

---

##  Technologies

- Java SE
- Java Swing for GUI
- Random utilities (`Random`, `SecureRandom`)
- File I/O for saving generated passwords

---

##  How It Works

1. Run `Main.java`.
2. A window opens with:
   - Length input
   - Checkboxes for characters (uppercase, lowercase, digits, symbols)
   - Buttons to generate or save password
3. Click **Generate Password** to create one.
4. Click **Save to File** to save the result to `passwords.txt`.

---

