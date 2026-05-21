# StockEx

Enterprise Inventory Management Platform built with Java Spring Boot and Oracle Database.

## Overview

StockEx is a backend inventory management system designed to help businesses efficiently manage products, suppliers, inventory levels, and stock transactions. The platform focuses on real-world software engineering practices including REST API development, database integration, layered backend architecture, and software testing.

This project was created to strengthen backend development skills using Java, Spring Boot, and Oracle Database while simulating the functionality of a modern enterprise inventory tracking platform.

---

## Features

### Product Management
- Add new products
- Update product information
- Delete products
- View all products
- Search products by name or category

### Inventory Tracking
- Track inventory quantities
- Monitor low-stock items
- Restock inventory
- Record outgoing inventory transactions

### Supplier Management
- Add and manage suppliers
- Associate suppliers with products
- Store supplier contact information

### Inventory Transactions
- Maintain transaction history
- Record inventory updates
- Log incoming and outgoing stock activity

### User Roles *(Planned)*
- Admin access
- Employee access
- Read-only viewer access

---

## Technologies Used

- Java
- Spring Boot
- Oracle Database
- Oracle SQL Developer
- Spring Data JPA
- Maven
- JUnit
- Git
- GitHub
- Postman

---

## Architecture

StockEx follows a layered backend architecture to separate business logic, database operations, and API handling.

```text
src/
 ├── main/
 │    ├── java/
 │    │    ├── controller/
 │    │    ├── service/
 │    │    ├── repository/
 │    │    ├── model/
 │    │    ├── dto/
 │    │    ├── config/
 │    │    └── exception/
 │    └── resources/
 └── test/
```

---

## Core Modules

### Products
Stores product details including:
- Product name
- SKU
- Price
- Quantity
- Category
- Supplier information

### Suppliers
Tracks supplier data including:
- Supplier name
- Contact information
- Associated products

### Inventory Transactions
Records:
- Inventory restocks
- Product sales
- Quantity adjustments
- Transaction timestamps

---

## API Endpoints *(Planned)*

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /products | Retrieve all products |
| GET | /products/{id} | Retrieve product by ID |
| POST | /products | Create new product |
| PUT | /products/{id} | Update product |
| DELETE | /products/{id} | Delete product |
| GET | /suppliers | Retrieve suppliers |
| POST | /transactions | Record inventory transaction |

---

## Testing

StockEx uses JUnit for unit and integration testing to ensure reliable inventory operations, API functionality, and database interaction.

Planned testing includes:
- Service layer testing
- Repository testing
- API endpoint testing
- Validation testing

---

## Future Improvements

- User authentication with JWT
- Frontend dashboard using React
- Barcode scanning support
- CSV/PDF report exporting
- Docker containerization
- CI/CD pipeline using GitHub Actions
- Role-based authorization
- Inventory analytics dashboard
- Email notifications for low-stock items

---

## Installation

### Clone Repository

```bash
git clone https://github.com/yourusername/stockex.git
```

### Navigate to Project Directory

```bash
cd stockex
```

### Configure Oracle Database

Update the `application.properties` file with your Oracle database credentials and connection settings.

Example:

```properties
spring.datasource.url=jdbc:oracle:thin:@localhost:1521/XEPDB1
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Run Application

```bash
./mvnw spring-boot:run
```

---

## Goals of This Project

This project was built to practice:
- Backend software engineering
- RESTful API development
- Database design and integration
- Oracle database connectivity
- Software testing
- Clean code architecture
- Version control using Git and GitHub

---

## Author

Maurice Murray  
Software Engineering Student at Drexel University
