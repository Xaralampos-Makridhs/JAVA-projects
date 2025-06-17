# Pizza Ordering System - Java Swing Application

**Pizza Ordering System** is a Java Swing-based desktop application that allows users to place pizza orders, calculate prices based on selected types and toppings, and display full order summaries. The interface is interactive and allows customers to select pizza types, add toppings, calculate costs, and review their orders in real time.

---

##  Features

###  Pizza Selection
- **Pizza Types**:
  - Pan Pizza
  - Stuffed Crust
  - Regular Pizza
- **Rates**:
  - Pan Pizza: €5.00  
  - Stuffed Crust: €6.00  
  - Regular: €4.00  

###  Toppings Selection
- Optional toppings with additional cost:
  - Onion: €0.50
  - Cheese: €1.00
  - Tomato: €0.50
  - Baby Crust: €0.75

###  Order Form
- Input Fields:
  - Order number
  - Customer name
  - Quantity
- Calculations:
  - Calculates **rate**, **topping cost**, and **total amount** based on selected items and quantity.
  - Displays result in the respective fields.

###  Order Summary
- **Show Order** button:
  - Creates a new `Order` object.
  - Shows a formatted summary including:
    - Order number
    - Customer name
    - Pizza type
    - Selected toppings
    - Quantity
    - Rate, topping cost, total amount

- **View Multiple Orders**:
  - Summaries are appended to a scrollable `JTextArea`.

---

##  Additional Features

- **Clear Form**:
  - Clears all fields and selections with a single click.
- **Input Validation**:
  - Displays error dialogs if fields are missing or incorrect.
- **Modular Design**:
  - Code is organized using OOP principles: `Order`, `Topping`, `PizzaType` enum.
    
---

##  Technologies

- Java SE
- Java Swing (GUI)
- Object-Oriented Programming (OOP)

---

##  How It Works

1. Run `Main.java` to launch the GUI.
2. Fill in:
   - Order number
   - Customer name
   - Quantity
   - Select pizza type and toppings
3. Click **Calculate RATE** to see pizza base and topping costs.
4. Click **Calculate TOTAL** to compute final price.
5. Click **Show Orders** to generate and display a full order summary.
6. Optionally, click **Clear** to reset all fields.

---

