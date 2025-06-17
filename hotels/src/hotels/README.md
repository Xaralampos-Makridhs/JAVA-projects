# Hotel Reservation System - Java Swing + Serialization

**Hotel Reservation System** is a desktop application built with Java Swing that allows users to manage hotel reservations. The application supports two types of reservations (Simple and All-Inclusive), and stores all hotel data and bookings in a serialized `.ser` file.

---

##  Features

###  Hotel Management
- **Predefined Hotel List**: The application starts with a predefined list of hotels (e.g. *Bellevue*, *Hermes*, etc.).
- **Hotel Sorting**: Hotels are automatically sorted alphabetically before being displayed in the GUI.
- **Hotel Selection**: Users select a hotel from a list to make or view reservations.
  
###  Reservation Management
- **Simple Reservation**:
  - Input: Days of stay
  - Cost: `120€ * days`
- **All-Inclusive Reservation**:
  - Input: Days of stay + Number of meals (1–3)
  - Cost: `days * (120€ + meals * 30€)`
- **Add Reservation**: Adds a reservation (of either type) to the selected hotel.
- **Calculate Total Cost**: Displays the total cost of all reservations for the selected hotel.
- **Store Data**: All reservation data is saved to `hotels.ser`.

---

##  Additional Features

- **GUI Interface**:
  - Built with Java Swing.
  - Includes fields, labels, buttons, and panels for interaction.
- **Data Persistence**:
  - Uses Java Object Serialization to save and load hotel data (`ArrayList<Hotel>`).

---

##  File Structure

- `Main.java`: Initializes hotels and writes them to `hotels.ser`. Then starts the main GUI.
- `InputFrame.java`: Main application window (JFrame) where users can create and manage reservations.
- `Hotel.java`: Represents a hotel with a name and a list of reservations. Implements `Serializable` and `Comparable`.
- `Reservation.java`: Represents a simple reservation based on days of stay.
- `AllInclusiveRes.java`: Subclass of `Reservation`, adds number of meals and modifies cost accordingly.

---

##  Technologies

- Java SE
- Swing for the graphical user interface
- Java Serialization (Object I/O)
- Object-Oriented Programming (OOP)

---

## How It Works

1. Run `Main.java`:
   - Creates 4 default hotels.
   - Serializes them to the file `hotels.ser`.
   - Launches the main application window.
2. Use the GUI to:
   - Select a hotel.
   - Fill in days (and meals if needed).
   - Add reservation or calculate total cost.
3. Reservations are saved in-memory and persist to the file automatically via serialization.

---
