# Expense Tracker - Java Swing + MySQL

**Expense Tracker** is a desktop application built with Java Swing that allows you to track your daily expenses and save them to a MySQL database. The program offers a simple GUI to insert, view, and summarize expenses by amount, description, category, and date.

---

## 📦 Features

### 💰 Expense Management
- **Add Expense**: Fill in amount, description, and category — today's date is added automatically.
- **Display Expenses**: Shows all expenses in a sortable table.
- **Total Expenses**: Displays the total amount of all recorded expenses.
- **Auto Refresh**: After inserting a new expense, the table updates automatically.
- **Save to Database**: All expense entries are saved to a MySQL table named `expenses`.

---

## 📊 Additional Features

- **Date Handling**: The application uses the current date as the default date of entry.
- **Input Validation**: If the amount is not valid, an error message appears.
- **Automatic Table Creation**: If the `expenses` table doesn’t exist, it is created at startup.

---

## 📁 File Structure

- `Main.java`: Application entry point; initializes database table and starts the GUI.
- `ExpenseTracker.java`: Main window; contains form, table, and logic for inserting and loading expenses.
- `CreateTable.java`: Contains the SQL logic to create the `expenses` table if it doesn’t exist.
- `DBHelper.java`: Provides the database connection (`jdbc:mysql://localhost:3306/expenses_java`).

---

## 🧪 Technologies

- Java SE
- Swing for the graphical user interface
- JDBC for MySQL connection
- MySQL database
- Object-oriented design (OOP)

---

## 🔄 How It Works

1. Run `Main.java`.
2. The application will:
   - Create the `expenses` table if it does not exist.
   - Load all previous expenses into the table.
3. Use the form to insert new expenses (amount, description, category).
4. Expenses are inserted into the MySQL database and displayed in the table immediately.

---
