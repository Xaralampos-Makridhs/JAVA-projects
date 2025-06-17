# Production Inventory Manager - Java Swing Application

**Production Inventory Manager** is a desktop application developed in Java Swing for managing product inventory. It allows users to add products, execute restock or purchase orders, and visually track stock levels in real time through a graphical interface.

---

##  Features

###  Product Management
- **Add New Product**: Enter a product name and initial stock.
- **View Product List**: All products appear in a selectable list with their current stock.
- **Real-Time Updates**: The list updates instantly after any order.

###  Order Management
- **Execute Orders**:
  - **Restock**: Adds stock to a product.
  - **Purchase**: Deducts quantity from stock if available.
- **Order Input**:
  - Select quantity and order type (RESTOCK or PURCHASE).
  - Affected product must be selected from the list.

---

##  Additional Features

- **Validation**:
  - Quantity must be a positive number.
  - Stock cannot fall below 0 (checked during PURCHASE).
- **Order Timestamp**:
  - Each order records the time it was placed (internally used for logs).
- **Clean Interface**:
  - Divided GUI: top (add products), center (product list), bottom (order actions).

---

##  File Structure

- `Main.java`: Starts the application by launching the GUI frame.
- `Frame.java`: Main Swing window containing the interface logic.
- `Product.java`: Represents a product with a name and stock level.
- `Order.java`: Represents an order, including order type (RESTOCK or PURCHASE), quantity, timestamp, and logic to update product stock.

---

##  Technologies

- Java SE
- Swing (for building GUI)
- Object-Oriented Design (Encapsulation, Composition)
- Java Collections (e.g. `List`, `ArrayList`, `DefaultListModel`)

---

##  How It Works

1. Run `Main.java`.
2. The window opens with:
   - A form to add new products (name + stock).
   - A list showing all added products.
   - A panel to place orders (select quantity and type).
3. When a RESTOCK or PURCHASE order is placed:
   - The product stock is updated internally.
   - The product list refreshes to reflect changes.

---

##  Notes

- Orders are processed **in-memory only** — no data is saved to disk.
- No external database or file I/O is used.
- If a PURCHASE exceeds available stock, an error message appears and stock remains unchanged.
- Products are listed in the form: `ProductName (Απόθεμα: currentStock)`.

---



