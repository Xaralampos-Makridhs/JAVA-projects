# Morse Code Translator - Java Swing Application

**Morse Code Translator** is a desktop application written in Java that allows users to convert text between English and Morse code. It uses a graphical user interface (GUI) built with Swing and supports both directions of translation.

---

##  Features

###  Translation
- **English to Morse**:
  - Converts alphabetic letters (A–Z) and numbers (0–9) into Morse code.
  - Words are separated by 3 spaces in Morse.
- **Morse to English**:
  - Translates Morse code back into English text.
  - Recognizes individual letters and word spacing.

---

##  Additional Features

- **Bidirectional Dictionary**:
  - Uses two `HashMap`s:
    - `toMorse`: English → Morse
    - `toEnglish`: Morse → English
- **Case Insensitive**:
  - Input is converted to uppercase internally.
- **Whitespace Handling**:
  - English words become Morse with `   ` (3 spaces).
  - Morse with 3 spaces becomes an English word separator.
---

##  Technologies

- Java SE
- Swing for the GUI (assumed in `MorseCodeGUI`)
- HashMap for fast dictionary lookup
- Object-Oriented Design

---

##  How It Works

1. Run `Main.java`.
2. The GUI window appears (from `MorseCodeGUI`).
3. Enter text in English or Morse and click the appropriate button.
4. The result is shown in a text area or output label.

---

##  Notes

- Only letters A–Z and digits 0–9 are supported.
- Punctuation marks are **not supported** in the current version.
- Multiple spaces in Morse input are interpreted as word boundaries.
