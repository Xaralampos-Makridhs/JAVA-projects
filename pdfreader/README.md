# PDF Reader - Java Swing + Apache PDFBox

**PDF Reader** is a simple desktop application built in Java using the Swing framework. It allows users to open and read the textual content of `.pdf` files via a graphical user interface (GUI). The application uses the **Apache PDFBox** library to extract text from PDF documents.

---

##  Features

###  PDF Viewing
- **Open PDF File**:
  - Use a file chooser (`JFileChooser`) to select a `.pdf` file.
- **Text Extraction**:
  - Uses `PDFTextStripper` from Apache PDFBox to extract all readable text.
- **Editable Text Area**:
  - Displays the extracted content in a scrollable, editable `JTextArea`.

---

##  Additional Features

- **GUI Components**:
  - Built entirely with Java Swing (`JFrame`, `JTextArea`, `JScrollPane`, `JButton`).
- **Error Handling**:
  - If the file is not a valid PDF or can't be read, the user is notified with a dialog.
- **Cross-platform Support**:
  - As a Java application, it can run on Windows, macOS, and Linux.

---

##  File Structure

- `Main.java`: Launches the Swing interface on the Event Dispatch Thread.
- `PDFGUI.java`: The main application window. Handles:
  - GUI layout
  - File selection
  - PDF parsing using `Apache PDFBox`

---

##  Technologies

- Java SE
- Java Swing for GUI
  
---

##  How It Works

1. Run `Main.java`.
2. The GUI window appears with a button labeled **"Open PDF"**.
3. Click the button to open a file chooser and select a `.pdf` file.
4. The extracted text is shown in the central text area.
5. The user can scroll, read, and even edit the displayed content.

---

