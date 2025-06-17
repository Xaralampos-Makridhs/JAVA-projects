# ERPApp - Mini ERP System in Java

**ERPApp** is a simple desktop ERP system built with Java Swing for managing customers and products. All operations are performed through a graphical interface, and data can be saved/loaded from `.txt` files.

---

##  Features

###  Customer Management
- **Add Customer**: Insert a new customer using just their name.
- **Display Customers**: View a list of all registered customer names.
- **Search Customer**: Find customers by name.
- **Edit Customer**: Modify a customer's name.
- **Delete Customer**: Remove a customer from the list.
- **Save to file**: All customers are saved to `customers.txt`.
- **Load from file**: On startup, customers are loaded from `customers.txt`.

###  Product Management
- **Add Product**: Insert a new product with name and price.
- **Display Products**: Show all product names with prices.
- **Search Product**: Find a product by name.
- **Edit Product**: Change product name or price.
- **Delete Product**: Remove a product from the list.
- **Save to file**: All products are saved to `products.txt`.
- **Load from file**: On startup, products are loaded from `products.txt`.

---

##  Additional Features

- **Statistics**:
  - Total number of customers
  - Total number of products
  - Average price of all products

- **Data Models**:
  - `Customer` class: Stores customer name.
  - `Product` class: Stores product name and price.

---

##  File Structure

- `Main.java`: Launches the application.
- `ErpApp.java`: Main GUI window with all menu options.
- `Customer.java`: Defines the customer class.
- `Product.java`: Defines the product class.
- `customers.txt`: Stores customer names.
- `products.txt`: Stores product names and prices.

---

##  Technologies

- Java SE
- Java Swing for GUI
- File I/O (read/write)
- Object-Oriented Programming

---

##  How It Works

1. Run `Main.java`.
2. The main GUI will open with customer and product management options.
3. Any changes are saved to `.txt` files via Save buttons.
4. When the app starts, it auto-loads data from those files.

---

## ⚠ Notes

- `customers.txt` and `products.txt` should be in the same directory as the app.
- If the files do not exist, they are automatically created.
- File format is simple text, one record per line.
---

